package com.mycompany.auction.controller;

import com.mycompany.auction.model.Bid;
import com.mycompany.auction.model.Items;
import com.mycompany.auction.service.BuyerService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BuyerController {

	@Autowired
    private BuyerService buyerService;


    @GetMapping("/searchitem")
    public String searchItems(@RequestParam("searchTerm") String keyword, ModelMap model) {
    	System.out.println("In Search Items" + keyword);
    	List<Items> items = buyerService.searchItems(keyword);
        model.addAttribute("items", items);
        return "searchItem";
    }

    @PostMapping("/place-bid")
    public String placeBid(@RequestParam("itemId") int itemId, @RequestParam("bidAmount") int bidAmount, @RequestParam("buyer_id") int buyer_id) {

        System.out.println("Inside placebid");
    	
    	buyerService.addBid(buyer_id,itemId,bidAmount);
        return "login";
    }


    @PostMapping("/update-bid")
    public String updateBid(@RequestParam("itemId") int itemId, @RequestParam("newBidAmount") int bidAmount, @RequestParam("bidId") int id) {
    	
    	Bid bid = new Bid();
    	bid.setAmount(bidAmount);
    	bid.setBidId(id);
    	bid.setBidTime(new Date());
    	
        buyerService.updateBid(bid,itemId);
        return "login";
    }

    @PostMapping("/withdraw-bid")
    public String withdrawBid(@RequestParam("bidId") int bidId) {
        buyerService.withdrawBid(bidId);
        return "login";
    }
    
    
    @GetMapping("/history")
    public String historyBid( @RequestParam("buyer_id") int buyer_id,  ModelMap model) {

        System.out.println("Inside history");
        
        List<Bid> bids = buyerService.getBidsByBuyerId(buyer_id);
        model.addAttribute("bids", bids);
        System.out.println(bids);
        
        return "History";
    }
    
    @GetMapping("/All-Bids")
    public String getBidByItemId(@RequestParam("itemId") int itemId, ModelMap model){
	
        List<Bid> bids = buyerService.getBidByItemId(itemId);
        model.addAttribute("bids", bids);
        System.out.println(bids);
        
        return "AllBids";
    }
  
}
