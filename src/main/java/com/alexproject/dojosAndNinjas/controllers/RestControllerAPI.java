package com.alexproject.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexproject.dojosAndNinjas.models.Dojo;
import com.alexproject.dojosAndNinjas.models.Ninja;
import com.alexproject.dojosAndNinjas.services.DojoService;
import com.alexproject.dojosAndNinjas.services.NinjaService;

@RestController
public class RestControllerAPI {

	@Autowired
	DojoService dserv;
	@Autowired
	NinjaService nserv;
	
	// DojosAPI
	// Create
	@PostMapping("/api/dojos/new")
	public Dojo createDojo(Dojo newDojo) {
		return dserv.createDojo(newDojo);
	}
	
	// Read
	@GetMapping("/api/dojos")
	public List<Dojo> viewAllDojos(){
		return dserv.findAllDojos();
	}
	@GetMapping("/api/dojos/{dojoId}")
	public Dojo viewDojo(@PathVariable Long dojoId) {
		return dserv.findDojoById(dojoId);	
	}
	
	// Update
	@PutMapping("/api/dojos/edit/{id}")
	public Dojo editDojo(@PathVariable Long id, Dojo updatedDojo) {
		return dserv.updateDojo(updatedDojo);
	}
	
	// Delete
	@DeleteMapping("/api/dojos/delete/{dojoId}")
	public void deleteDojo(@PathVariable Long dojoId) {
		dserv.deleteDojo(dojoId);
	}
	
	
	
	// NinjasAPI
	// Create
	@PostMapping("/api/ninjas/new")
	public Ninja createNinja(Ninja newNinja) {
		return nserv.createNinja(newNinja);
	}
	
	// Read
	@GetMapping("/api/ninjas")
	public List<Ninja> viewAllNinjas(){
		return nserv.findAllNinjas();
	}
	@GetMapping("/api/ninjas/{ninjaId}")
	public Ninja viewNinja(@PathVariable Long ninjaId) {
		return nserv.findNinjaById(ninjaId);	
	}
	
	// Update
	@PutMapping("/api/ninjas/{id}/edit")
	public Ninja updateNinja(@PathVariable Long id, Ninja updatedNinja) {
		return nserv.updateNinja(updatedNinja);
	}
	
	// Delete
	@DeleteMapping("/api/ninjas/{ninjaId}/delete")
	public void deleteNinja(@PathVariable Long ninjaId) {
		nserv.deleteNinja(ninjaId);
	}
	
	
}
