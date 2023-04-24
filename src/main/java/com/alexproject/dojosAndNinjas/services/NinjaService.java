package com.alexproject.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexproject.dojosAndNinjas.models.Ninja;
import com.alexproject.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository nrepo;
	
	// Create
	public Ninja createNinja(Ninja createdNinja) {
		return nrepo.save(createdNinja);
	}
	
	// Read
	public List<Ninja> findAllNinjas(){
		return nrepo.findAll();
	}
	public Ninja findNinjaById(Long id) {
		return nrepo.findById(id).orElse(null);
	}
	
	// Update
	public Ninja updateNinja(Ninja updatedNinja) {
		return nrepo.save(updatedNinja);
	}
	
	// Delete
	public void deleteNinja(Long id) {
		nrepo.deleteById(id);
	}
	
}
