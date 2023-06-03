package com.mycompany.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.auction.model.User;
import com.mycompany.auction.service.UserService;

@Controller
public class AdminController {

//	 @Autowired
//	  private ItemDao itemDao;
	  
	  @Autowired
	  private UserService userService;
	  
	  @GetMapping("/admin")
	  public String admin(Model model) {
//	    List<Item> items = itemDao.getAllItems();
	    List<User> users = userService.get();
//	    model.addAttribute("items", items);
	    model.addAttribute("users", users);
	    return "Admin";
	  }
	  
//	  @PostMapping("/addItem")
//	  public String addItem(@ModelAttribute Item item) {
//	    itemDao.addItem(item);
//	    return "redirect:/admin";
//	  }
	  
//	  @GetMapping("/editItem")
//	  public String editItem(Model model, @RequestParam int id) {
//	    Item item = itemDao.getItemById(id);
//	    model.addAttribute("item", item);
//	    return "editItem";
//	  }
	  
//	  @PostMapping("/updateItem")
//	  public String updateItem(@ModelAttribute Item item) {
//	    itemDao.updateItem(item);
//	    return "redirect:/admin";
//	  }
	  
//	  @GetMapping("/deleteItem")
//	  public String deleteItem(@RequestParam int id) {
//	    itemDao.deleteItem(id);
//	    return "redirect:/admin";
//	  }
	  
	  @PostMapping("/addUser")
	  public String save(@ModelAttribute User user) {
		userService.save(user);
	    return "redirect:/Admin";
	  }
	  
	  @GetMapping("/editUser")
	  public String editUser(Model model, @RequestParam int id) {
	    User user = userService.get(id);
	    model.addAttribute("user", user);
	    return "redirect:/Admin";
	  }
	  
	  @PostMapping("/updateUser")
	  public String updateUser(@ModelAttribute User user) {
		userService.save(user);
	    return "redirect:/admin";
	  }
	  
	  @GetMapping("/deleteUser")
	  public String delete(@RequestParam int id) {
		userService.delete(id);
	    return "redirect:/Admin";
	  }
}
