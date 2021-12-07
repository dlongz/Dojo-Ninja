package com.codingdojo.dojosninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninja.models.Dojo;
import com.codingdojo.dojosninja.models.Ninja;
import com.codingdojo.dojosninja.services.DojoService;
import com.codingdojo.dojosninja.services.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("Dojos", this.dojoService.AllDojos());
		return "dashboard.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojoForm") Dojo dojo) {
		return "dojoForm.jsp";		
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojoForm") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojoForm.jsp";
		} else {
			this.dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninja/new")
	public String ninjaForm(Model model, @ModelAttribute("ninjaForm") Ninja ninja) {
		model.addAttribute("allDojos", this.dojoService.AllDojos());    
		return "ninjaForm.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninjaForm") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos", this.dojoService.AllDojos());
			return "ninjaForm.jsp";
		} else {
			this.ninjaService.createNinja(ninja);
			return "redirect:/dojo/" + ninja.getDojo().getId();
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model, @ModelAttribute("ninjaForm") Ninja ninja) {
		model.addAttribute("dojo", this.dojoService.findDojo(id));
		return "/showDojo.jsp";
	}
	
	
}
