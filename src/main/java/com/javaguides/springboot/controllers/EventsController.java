package com.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

import com.javaguides.springboot.repositories.EventsRepo;
import com.javaguides.springboot.domains.Events;
import com.javaguides.springboot.repositories.TimelineRepo;
import com.javaguides.springboot.domains.Timeline;
import com.javaguides.springboot.repositories.LocationsRepo;
import com.javaguides.springboot.domains.Locations;
import com.javaguides.springboot.repositories.CustomerRepo;
import com.javaguides.springboot.domains.Customer;


@RestController
@RequestMapping("/api/events")
public class EventsController {

	@Autowired	
	private EventsRepo eRepo;
	@Autowired	
	private CustomerRepo cRepo;


	@GetMapping("/all")
	public @ResponseBody Iterable<Events> displayDBElements(){
		return eRepo.findAll(); 
	}

	@GetMapping("/{id}")
	public @ResponseBody Events displayDBElement(@PathVariable Integer id){
		return eRepo.findById(id).get(); 
	}

	@PostMapping(path="/add")
	public @ResponseBody Events addNewEvent(@RequestParam String CustomerID, @RequestBody Events event){
		//setup new event object
		Events e = new Events();

		//set event variables
		e.setName(event.getName());
		e.setDate(event.getDate());

		Customer tempc = cRepo.findById(Integer.valueOf(CustomerID)).orElse(null);
		e.setCustomer(tempc);

		//save to DB table
		return eRepo.save(e);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEvent(@PathVariable Integer id){
		eRepo.deleteById(id);
		return "successfully deleted Timeline id: " + id;
	}

}
