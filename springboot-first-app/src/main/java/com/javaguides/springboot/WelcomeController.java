package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import com.javaguides.springboot.repositories.LocationsRepo;
import com.javaguides.springboot.domains.Locations;


@RestController
public class WelcomeController {

	@Autowired	
	private LocationsRepo lRepo;

	@GetMapping ("/welcome")
	public String welcome(){
		return "Welcome to Team Code Masters!!!";
	}

	@GetMapping ("/list")
	public String displayList(){
		Map items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);
		String itemsList = Joiner.on(",")
			.withKeyValueSeparator(" -> ")
			.join(items);

		List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi",
				"mandarin", "date", "quince");

		String fruitsList = Joiner.on(", ")
			.join(fruits);

		return itemsList + " " + fruitsList;
	}

	@GetMapping("/DBAll")
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
