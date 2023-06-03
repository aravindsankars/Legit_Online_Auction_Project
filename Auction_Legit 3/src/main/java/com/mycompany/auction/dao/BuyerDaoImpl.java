package com.mycompany.auction.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.auction.model.Bid;
import com.mycompany.auction.model.Items;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class BuyerDaoImpl implements BuyerDao {	    
	    
		@Autowired
		private EntityManager entityManager;

	    public List<Items> searchItems(String keyword) {
	        Session session = entityManager.unwrap(Session.class);
	        Query<Items> query = session.createQuery("FROM Items WHERE itemName LIKE :keyword ", Items.class);
	        query.setParameter("keyword", "%" + keyword + "%");
	        List<Items> items = query.list();
	        return items;
	    }

	    public void placeBid(Bid bid) {
	        Session session = entityManager.unwrap(Session.class);
	        session.saveOrUpdate(bid);
	    }

	    public List<Bid> getBidsByBuyerId(int buyer_id) {
	        Session session = entityManager.unwrap(Session.class);
	        Query<Bid> query = session.createQuery("FROM Bid WHERE user.user_id = :buyerId", Bid.class);
	        query.setParameter("buyerId", buyer_id);
	        return query.getResultList();
	    }
	    
	    
	    @Transactional
	    @Override
	    public void updateBid(Bid bid) {
	        Session session = entityManager.unwrap(Session.class);
	        
	        
	        
	        String hqlUpdateBid = "UPDATE Bid b SET b.amount = :newAmount, b.bidTime = :newBidTime WHERE b.bidId = :bidId";
	        Query updateBidQuery = session.createQuery(hqlUpdateBid);
	        updateBidQuery.setParameter("bidId", bid.getBidId());
	        updateBidQuery.setParameter("newAmount", bid.getAmount());
	        updateBidQuery.setParameter("newBidTime", bid.getBidTime());
	        updateBidQuery.executeUpdate();

	   
	    }

	    
	    @Transactional
	    @Override
	    public void withdrawBid(int bidId) {
	        Session session =entityManager.unwrap(Session.class);
	        Bid bid = session.get(Bid.class, bidId);
	        System.out.println(bid);
	        session.delete(bid);
	    }
	    
	    public Items getItemById(int itemId) {
	        Session session = entityManager.unwrap(Session.class);
	        Query<Items> query = session.createQuery("FROM SellerItem WHERE itemId = :itemId AND auctionEnd > :now", Items.class);
	        query.setParameter("itemId", itemId);
	        query.setParameter("now", new Date());
	        return query.uniqueResult();
	    }
	    
	    public List<Bid> getBidByItemId(int itemId){
	        Session session = entityManager.unwrap(Session.class);
	        Query<Bid> query = session.createQuery("FROM Bid WHERE items.item_id = :itemId", Bid.class);
	        query.setParameter("itemId", itemId);
	        return query.getResultList();
	    }
}
