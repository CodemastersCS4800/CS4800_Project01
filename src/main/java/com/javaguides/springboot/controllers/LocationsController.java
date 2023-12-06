package com.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaguides.springboot.repositories.LocationsRepo;
import com.javaguides.springboot.domains.Locations;
import com.javaguides.springboot.repositories.EventsRepo;
import com.javaguides.springboot.domains.Events;


@RestController
@RequestMapping("/locations")
public class LocationsController {
	
	@Autowired	
	private LocationsRepo lRepo;

	@Autowired	
	private EventsRepo eRepo;


	@GetMapping("/all")
	public @ResponseBody Iterable<Locations> displayDBElements(){
		return lRepo.findAll(); 
	}

	@GetMapping("/{id}")
	public @ResponseBody Locations displayDBElement(@PathVariable Integer id){
		return lRepo.findById(id).get(); 
	}
	
	@PostMapping(path="/add")
	public @ResponseBody Locations addNewLocation(@RequestParam String EventID, @RequestBody Locations location){
		Locations l = new Locations();
		l.setAddress(location.getAddress());
		l.setSize(location.getSize());
		l.setMaxCapacity(location.getMaxCapacity());

		Events tempe = eRepo.findById(Integer.valueOf(EventID)).orElse(null);	
		tempe.setLocation(l);
		l.setEvent(tempe);

		return lRepo.save(l);
	}

	@DeleteMapping("/{id}")
	public String deleteLocation(@PathVariable Integer id){
		Locations templ = lRepo.findById(id).orElse(null);
		Events tempe = templ.getEvent();
		if(tempe != null){
			tempe.setLocation(null);
			templ.setEvent(null);
		}

		lRepo.delete(templ);
		return "successfully deleted location id: " + id;
	}

}
