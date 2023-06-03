package com.mycompany.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.auction.dao.BuyerDao;
import com.mycompany.auction.dao.SellerDao;
import com.mycompany.auction.dao.UserDao;
import com.mycompany.auction.model.Bid;
import com.mycompany.auction.model.Items;
import com.mycompany.auction.model.User;

@Service(value = "BuyerService")
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private SellerDao sell;

	@Autowired
	UserDao userdao;

	@Override
	public List<Items> searchItems(String keyword) {
		return buyerDao.searchItems(keyword);
	}

	@Override
	public void placeBid(Bid bid) {

		buyerDao.placeBid(bid);
	}

	@Override
	public List<Bid> getBidsByBuyerId(int buyer_id) {
		return buyerDao.getBidsByBuyerId(buyer_id);
	}

	@Override
	public void updateBid(Bid bid, int item_id) {

		Items it = sell.getItemByItemId(item_id);

		bid.setItems(it);

		buyerDao.updateBid(bid);
	}

	@Override
	public void withdrawBid(int bidId) {

		buyerDao.withdrawBid(bidId);
	}

	@Override
	public Items getItemById(int itemId) {
		return buyerDao.getItemById(itemId);
	}

	@Override
	public void addBid(int buyer_id, int item_id, int bidAmaount) {
		Items it = sell.getItemByItemId(item_id);

		User use = userdao.get(buyer_id);

		Bid bid = new Bid();
		bid.setItems(it);
		bid.setAmount(bidAmaount);
		bid.setUser(use);

		buyerDao.placeBid(bid);

	}

	@Override
	public List<Bid> getBidByItemId(int itemId) {

		return buyerDao.getBidByItemId(itemId);
	}

}
