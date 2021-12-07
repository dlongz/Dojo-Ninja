package com.codingdojo.dojosninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninja.models.Ninja;
import com.codingdojo.dojosninja.repositories.NinjaRepository;

@Repository
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> AllNinjas(){
		return this.ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		this.ninjaRepo.deleteById(id);
	}
}
