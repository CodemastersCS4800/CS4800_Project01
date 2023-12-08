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
import com.javaguides.springboot.repositories.CustomerRepo;
import com.javaguides.springboot.domains.Customer;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerRepo cRepo;

	@Autowired	
	private EventsRepo eRepo;

	@GetMapping("/all")
	public @ResponseBody Iterable<Customer> displayDBElements(){
		return cRepo.findAll(); 
	}

	@GetMapping("/{id}")
	public @ResponseBody Customer displayDBElement(@PathVariable Integer id){
		return cRepo.findById(id).get(); 
	}

	@PostMapping(path="/add")
	public @ResponseBody Customer addNewCustomer(@RequestBody Customer customer){
		//setup new event object
		Customer c = new Customer(customer.getName(), customer.getEmail());

		//start a new list that the  owns
		Set<Events> elist = new HashSet<Events>();	

		if(customer.getEvents() != null){
			for (Events e : customer.getEvents()){

				Events tempe = new Events();
				
				tempe.setName(e.getName());
				tempe.setDate(e.getDate());
				
				tempe.setCustomer(c);
			}
		}

		//place list in customer
		c.setEvents(elist);	

		//save to DB table
		return cRepo.save(c);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEvent(@PathVariable Integer id){
		cRepo.deleteById(id);
		return "successfully deleted Timeline id: " + id;
	}

}
