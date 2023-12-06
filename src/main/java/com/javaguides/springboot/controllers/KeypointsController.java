package com.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import com.javaguides.springboot.repositories.KeypointsRepo;
import com.javaguides.springboot.repositories.TimelineRepo;
import com.javaguides.springboot.domains.Keypoints;
import com.javaguides.springboot.domains.Timeline;


@RestController
@RequestMapping("/keypoints")
public class KeypointsController {

	@Autowired	
	private KeypointsRepo kRepo;

	@Autowired	
	private TimelineRepo tRepo;

	@GetMapping("/all")
	public @ResponseBody Iterable<Keypoints> displayDBElements(){
		return kRepo.findAll(); 
	}

	@GetMapping("/{id}")
	public @ResponseBody Keypoints displayDBElement(@PathVariable Integer id){
		return kRepo.findById(id).get(); 
	}

	@PostMapping(path="/add")
	public @ResponseBody Keypoints addNewKeypoint(@RequestParam String timeline_id, @RequestBody Keypoints keys){
		//make a temporary keypoint obj
		Keypoints k = new Keypoints();
		k.setTimeStart(keys.getTimeStart());
		k.setTimeEnd(keys.getTimeEnd());
		k.setDescription(keys.getDescription());

		//make a temporary timeline obj to set as owner of keypoint
		Timeline tempt = tRepo.getById(Integer.valueOf(timeline_id));

		//make a list of keypoints to add to the keypoints list of the owner
		Set<Keypoints> keyList = tempt.getKeypoints();
		keyList.add(k);
		//set list to the timeline obj
		tempt.setKeypoints(keyList);

		//set timeline as owner of keypoint
		k.setTimeline(tempt);

		return kRepo.save(k);
	}

	@DeleteMapping("{id}")
	public String deleteKeypoint(@PathVariable Integer id){
		kRepo.deleteById(id);
		return "successfully deleted keypoint id:" + id;
	}
}
