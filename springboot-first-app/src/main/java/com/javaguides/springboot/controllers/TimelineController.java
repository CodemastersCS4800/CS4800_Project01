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

import com.javaguides.springboot.repositories.TimelineRepo;
import com.javaguides.springboot.domains.Timeline;


@RestController
public class TimelineController {

	@Autowired	
	private TimelineRepo tRepo;


	@GetMapping("/allTime")
	public @ResponseBody Iterable<Timeline> displayDBElements(){
		return tRepo.findAll(); 
	}
	
	@PostMapping(path="/addTimeline")
	public @ResponseBody Timeline addNewTimeline(@RequestParam String start_time, @RequestParam String end_time){
		Timeline t = new Timeline();
		t.setStartTime(start_time);
		t.setEndTime(end_time);

		return tRepo.save(t);
	}
}
