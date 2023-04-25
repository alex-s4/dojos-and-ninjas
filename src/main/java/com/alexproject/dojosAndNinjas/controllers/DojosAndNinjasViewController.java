package com.alexproject.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexproject.dojosAndNinjas.models.Dojo;
import com.alexproject.dojosAndNinjas.models.Ninja;
import com.alexproject.dojosAndNinjas.services.DojoService;
import com.alexproject.dojosAndNinjas.services.NinjaService;

@Controller
public class DojosAndNinjasViewController {

	@Autowired
	DojoService dserv;
	@Autowired
	NinjaService nserv;
	
	@GetMapping("dojos/{dojoId}")
	public String viewNinjas(@PathVariable("dojoId") Long id,
							Model mv)
	{
		Dojo dojo = dserv.findDojoById(id);
		List<Ninja> ninjas = dojo.getNinjas();
		
		mv.addAttribute("dojo", dojo);
		mv.addAttribute("ninjas", ninjas);
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(Model mv) {
		mv.addAttribute("dojo", new Dojo());
		return "dojoNew.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model mv) {
		List<Dojo> allDojos = dserv.findAllDojos();
		mv.addAttribute("ninja", new Ninja());
		mv.addAttribute("dojos", allDojos);
//		System.out.println(dserv.findAllDojos());
		return "ninjaNew.jsp";
	}
	
	@PostMapping("/create/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo newDojo,
							BindingResult result,
							Model mv) {
		if(result.hasErrors())
		{
			return "index.jsp";
		}
		else
		{
			dserv.createDojo(newDojo);
			return "redirect:/dojos/new";
		}
	}
	
	@PostMapping("/create/ninja")
	public String createDojo(@Valid @ModelAttribute("ninja") Ninja newNinja,
							BindingResult result,
							Model mv) {
		List<Dojo> allDojos = dserv.findAllDojos();
		if(result.hasErrors())
		{
			System.out.println(result.getFieldError());
			mv.addAttribute("dojos", allDojos);
			return "ninjaNew.jsp";
		}
		else
		{	
			mv.addAttribute("dojos", allDojos);
			nserv.createNinja(newNinja);
			return "redirect:/ninjas/new";
		}
	}
	
}
