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

import com.javaguides.springboot.repositories.TimelineRepo;
import com.javaguides.springboot.domains.Timeline;
import com.javaguides.springboot.domains.Keypoints;
import com.javaguides.springboot.repositories.EventsRepo;
import com.javaguides.springboot.domains.Events;


@RestController
@RequestMapping("/timeline")
public class TimelineController {

	@Autowired	
	private TimelineRepo tRepo;
	@Autowired	
	private EventsRepo eRepo;


	@GetMapping("/all")
	public @ResponseBody Iterable<Timeline> displayDBElements(){
		return tRepo.findAll(); 
	}

	@GetMapping("/{id}")
	public @ResponseBody Timeline displayDBElement(@PathVariable Integer id){
		return tRepo.findById(id).get(); 
	}

	@PostMapping(path="/add")
	public @ResponseBody Timeline addNewTimeline(@RequestParam String EventID, @RequestBody Timeline time){
		//make a temporary timeline obj
		Timeline t = new Timeline();

		//set time variables
		t.setStartTime(time.getStartTime());
		t.setEndTime(time.getEndTime());

		//start a new keypoint list that the timeline owns
		Set<Keypoints> kl = new HashSet<Keypoints>();	

		if(time.getKeypoints() != null){
			for (Keypoints k : time.getKeypoints()){
				//start a temporary keypoint obj based off of the given list of keypoints
				Keypoints tempk = new Keypoints();
				tempk.setTimeline(t);

				tempk.setTimeStart(k.getTimeStart());
				tempk.setTimeEnd(k.getTimeEnd());
				tempk.setDescription(k.getDescription());

				kl.add(tempk);
			}
		}

		//place list in timeline
		t.setKeypoints(kl);

		Events tempe = eRepo.findById(Integer.valueOf(EventID)).orElse(null);
		tempe.setTimeline(t);

		t.setEvent(tempe);

		//save to DB table
		return tRepo.save(t);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTimeline(@PathVariable Integer id){
		Timeline tempt = tRepo.findById(id).orElse(null);
		Events tempe = tempt.getEvent();
		if(tempe != null){
			tempe.setTimeline(null);
			tempt.setEvent(null);
		}

		tRepo.delete(tempt);
		return "successfully deleted Timeline id: " + id;
	}

}
