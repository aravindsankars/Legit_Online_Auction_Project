package com.mycompany.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.auction.model.User;
import com.mycompany.auction.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> get() {
		return userService.get();
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginVal")
	public String loginVal(ModelMap model, @RequestParam("username") String username,
			               @RequestParam("password") String password) {

		User user = userService.findByUsernameAndPassword(username, password);
		model.addAttribute("user", user);
		
		if(user.getRole().equals("buyer")){
			
			return "Buyer";
		
		}
		else if(user.getRole().equals("seller")){

			return "Seller";
		}
		else if(user.getRole().equals("admin")){
			return "redirect:/admin";
			}
		return "redirect:/login";
	}

	@RequestMapping("/register")
	public String registration() {
		return "Register";
	}

	@PostMapping("/save-user")
	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("role") String role) {

		System.out.print("In save-user");
		User userObj = new User();
		userObj.setName(username);
		userObj.setPassword(password);
		userObj.setEmail(email);
		userObj.setRole(role);
		userService.save(userObj);
		return "login";
	}

	@GetMapping("/show-users")
	public String showUsers(HttpServletRequest request) {
		return "login";
	}

}
