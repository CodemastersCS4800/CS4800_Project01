package com.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaguides.springboot.repositories.LocationsRepo;
import com.javaguides.springboot.domains.Locations;


@RestController
public class LocationsController {
	@Autowired	
	private LocationsRepo lRepo;


	@GetMapping("/allLocs")
	public @ResponseBody Iterable<Locations> displayDBElements(){
		return lRepo.findAll(); 
	}
	
	@PostMapping(path="/add")
	public @ResponseBody Locations addNewLocation(@RequestParam String address, @RequestParam String size, @RequestParam Integer maxCap){
		Locations l = new Locations();
		l.setAddress(address);
		l.setSize(size);
		l.setMaxCapacity(maxCap);

		return lRepo.save(l);
	}
}
