package com.mycompany.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {
	

	@GetMapping("/")
	public String hello() {
		return "This is Home page";
	}
	
//	@GetMapping("/save-user")
//	public String saveUser(@RequestParam String username,@RequestParam String password,@RequestParam String email) {
//
////		User user = new User(username,password,email);
////		userService.save(user);
//		return "User Saved";
//	}
	
}
