package com.codingdojo.dojosninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninja.models.Dojo;
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
}
