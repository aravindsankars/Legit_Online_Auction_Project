package com.mycompany.auction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.auction.model.Items;

@Component
public interface SellerService {

	void addItem(Items item, int id);

	List<Items> getItemsBySellerId(int id);

	void removeItem(int item_id);
	
	Items getItemByName(String itemName);
	
	Items editItem(Items it);
	
}
