package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WelcomeController {
	
	@GetMapping ("/")
	public String home(){
		return "homepage.html";
	}
	
	@GetMapping ("/welcome")
	public String welcome(){
		return "Welcome to Team Code Masters!!!";
	}
}
