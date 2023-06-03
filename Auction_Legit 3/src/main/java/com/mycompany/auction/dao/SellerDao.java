package com.mycompany.auction.dao;

import java.util.List;

import com.mycompany.auction.model.Items;

public interface SellerDao {

	void addItem(Items item);

	List<Items> getItemsBySellerId(int id);

	void removeItem(int item_id);
	
	Items getItemByName(String itemName);
	
	Items getItemByItemId(int item_id);
	
	void updateItem(Items item);
		
}
