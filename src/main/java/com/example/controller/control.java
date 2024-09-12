package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class control {
	
	
	@GetMapping("/admin")
	public String admin()
	{
		
		return"admin";
	}

	@GetMapping("/aabout")
	public String aabout()
	{
		
		return"aabout";
	}
	@GetMapping("/avoting")
	public String avoting()
	{
		
		return"avoting";
	}
	@GetMapping("ahome")
	public String ahome()
	{
		return"ahome";
	}
	
	
	@PostMapping("/admin")
	public String admin(@RequestParam("name") String name,@RequestParam("pass") String pass)
	{
		String username="admin";
		String passw="2000";
		if(name.equals(username) && pass.equals(passw))
		{
		return"ahome";
		}
		else {
			return "admin";
		}
	}

	

	
}
