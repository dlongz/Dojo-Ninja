package com.codingdojo.dojosninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninja.models.Dojo;
import com.codingdojo.dojosninja.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> AllDojos(){
		return this.dojoRepo.findAll();
	}
	// CRUD
	
	//Create
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	// Retrieve
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	// Update
	public Dojo updateDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	// delete
	public void deleteDojo(Long id) {
		this.dojoRepo.deleteById(id);
	}
}
