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

import com.javaguides.springboot.repositories.KeypointsRepo;
import com.javaguides.springboot.domains.Keypoints;
import com.javaguides.springboot.domains.Timeline;


@RestController
public class KeypointsController {

	@Autowired	
	private KeypointsRepo kRepo;

	@GetMapping("/allKeys")
	public @ResponseBody Iterable<Keypoints> displayDBElements(){
		return kRepo.findAll(); 
	}

	@PostMapping(path="/addKeypoints")
	public @ResponseBody Keypoints addNewKeypoint(@RequestBody Keypoints k){
		/*Keypoints k = new Keypoints();
		k.setTimeStart(start_time);
		k.setTimeEnd(end_time);
		k.setTimeline(timeline);*/

		return kRepo.save(k);
	}
}
