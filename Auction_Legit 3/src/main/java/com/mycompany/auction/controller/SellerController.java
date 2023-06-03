package com.mycompany.auction.controller;

import java.util.List;

import com.mycompany.auction.model.Items;
import com.mycompany.auction.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	
	@PostMapping("/seller-items")
	public String getSellerItems(@RequestParam("id") int id, ModelMap model) {
		System.out.println("getSellerItems---------conrtroller");
		List<Items> items = sellerService.getItemsBySellerId(id);
	    model.addAttribute("items", items);
	    System.out.print("Item---------");
	    return "SellerItem";
	}
	
	@GetMapping("/seller-add")
	public String sellerAdd(ModelMap model, @RequestParam("id") int seller_id) {
		
		model.addAttribute("seller_id", seller_id);
		return "addItem";	
		
	}
	
	@PostMapping("/add-item")
	public String addItem(ModelMap model, @RequestParam("itemName") String itemName, @RequestParam("startingBid") int startingBid, @RequestParam("id") int seller_id) {
		System.out.print("ID----------> "+seller_id);
		Items item = new Items();
		item.setItemName(itemName);
		item.setStartingBid(startingBid);
		model.addAttribute("seller_id", seller_id);
		System.out.print(itemName);
		sellerService.addItem(item,seller_id);
		return "login";
	}
	
	@PostMapping("/remove-item")
	public String removeItem(@RequestParam("itemName") String itemName) {
		System.out.print(itemName);
		Items item = sellerService.getItemByName(itemName);
		int itemId = item.getItem_id();
		System.out.print(itemId);
		System.out.print(itemName);
		sellerService.removeItem(itemId);
		return "login";
	}
	
	@PostMapping("/edit-item")
	public String editItem(@RequestParam("itemName") String itemName, @RequestParam("startingBid") int startingBid, @RequestParam("item_id") int item_id) {
		Items item = new Items();
		item.setItemName(itemName);
		item.setStartingBid(startingBid);
		item.setItem_id(item_id);
		sellerService.editItem(item);
		return "login";
	}
	      
}
