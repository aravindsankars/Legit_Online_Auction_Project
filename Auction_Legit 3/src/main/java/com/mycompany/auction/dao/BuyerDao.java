package com.mycompany.auction.dao;

import java.util.List;

import com.mycompany.auction.model.Bid;
import com.mycompany.auction.model.Items;

public interface BuyerDao {
	
	public List<Items> searchItems(String keyword);
	
	public void placeBid(Bid bid);
	
	public List<Bid> getBidsByBuyerId(int buyer_id);
	
	public void updateBid(Bid bid);
	
	public void withdrawBid(int bidId);
	
	public Items getItemById(int itemId);
	
	public List<Bid> getBidByItemId(int itemId);

}
