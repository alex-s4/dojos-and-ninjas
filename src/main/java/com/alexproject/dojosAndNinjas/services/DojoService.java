package com.alexproject.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexproject.dojosAndNinjas.models.Dojo;
import com.alexproject.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository drepo;
	
	// Create
	public Dojo createDojo(Dojo createdDojo) {
		return drepo.save(createdDojo);
	}
	
	// Read
	public List<Dojo> findAllDojos(){
		return drepo.findAll();
	}
	public Dojo findDojoById(Long id) {
		return drepo.findById(id).orElse(null);
	}
	
	// Update
	public Dojo updateDojo(Dojo updatedDojo) {
		return this.drepo.save(updatedDojo);
	}
	
	// Delete
	public void deleteDojo(Long id) {
		drepo.deleteById(id);
	}
}
