package com.mycompany.auction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.auction.model.Bid;
import com.mycompany.auction.model.Items;


@Service
public interface BuyerService {

	public List<Items> searchItems(String keyword);
	
	public void placeBid(Bid bid);
	
	public List<Bid> getBidsByBuyerId(int buyer_id);
	
	public void updateBid(Bid bid,int item_id);
	
	public void withdrawBid(int bidId);
	
	public Items getItemById(int itemId);
	
	public void addBid(int buyer_id, int item_id,int bidAmaount);
	
	public List<Bid> getBidByItemId(int itemId);
}
