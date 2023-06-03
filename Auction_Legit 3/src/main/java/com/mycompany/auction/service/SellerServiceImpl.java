package com.mycompany.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.auction.dao.SellerDao;
import com.mycompany.auction.dao.UserDao;
import com.mycompany.auction.model.Items;
import com.mycompany.auction.model.User;

@Component
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerDao sellerDao;
	
	@Autowired
	private UserDao userdao;
	
	
	@Override
	public void addItem(Items item, int user_id) {
		
		
		User user = userdao.get(user_id);
		
		item.setUser(user);

		sellerDao.addItem(item);
	}

	@Override
	public List<Items> getItemsBySellerId(int id) {

		return sellerDao.getItemsBySellerId(id);
	}

	@Override
	public void removeItem(int item_id) {

		sellerDao.removeItem(item_id);
	}

	@Override
	public Items getItemByName(String itemName) {
		return sellerDao.getItemByName(itemName);
	}

	@Override
	public Items editItem(Items it) {
		
		
		sellerDao.updateItem(it);
		return null;
	}

}
