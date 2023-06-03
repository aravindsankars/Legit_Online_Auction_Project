package com.mycompany.auction.dao;

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
public class SellerDaoImpl implements SellerDao {
	
	@Autowired
	private EntityManager entityManager;
	

	@SuppressWarnings("deprecation")
	@Override
	public void addItem(Items item) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(item);
	}

	@Override
	public List<Items> getItemsBySellerId(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		String hql = "FROM Items si WHERE si.user.user_id = :userId";
		Query<Items> query = session.createQuery(hql,Items.class);
		query.setParameter("userId", id);
		List<Items> items = query.list();
		
		
		return items;
	}

	@Override
	@Transactional
	public void removeItem(int item_id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		String hqlDeleteBids = "DELETE FROM Bid b WHERE b.items.item_id = :itemId";
		Query<?> deleteBidsQuery = session.createQuery(hqlDeleteBids);
		deleteBidsQuery.setParameter("itemId", item_id);
		int numDeletedBids = deleteBidsQuery.executeUpdate();

		// Delete the SellerItem
		String hqlDeleteSellerItem = "DELETE FROM Items si WHERE si.item_id = :itemId";
		Query<?> deleteSellerItemQuery = session.createQuery(hqlDeleteSellerItem);
		deleteSellerItemQuery.setParameter("itemId", item_id);
		int numDeletedSellerItems = deleteSellerItemQuery.executeUpdate();

	}

	@Override
	public Items getItemByName(String itemName) {
		Session currentSession = entityManager.unwrap(Session.class);
	    Query<Items> query = currentSession.createQuery("SELECT i FROM Items i WHERE i.itemName = :itemName", Items.class);
	    query.setParameter("itemName", itemName);
	    
	    List<Items> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
	}

	@Override
	public Items getItemByItemId(int item_id) {
	
		Session session = entityManager.unwrap(Session.class);
		Items item = session.get(Items.class, item_id);
		
		return item;
	}

	@Override
	@Transactional
	public void updateItem(Items item) {
		

		Session session = entityManager.unwrap(Session.class);
		
		String hqlUpdateSellerItem = "UPDATE Items si SET si.itemName = :newItemName, si.startingBid = :newStartingBid WHERE si.item_id = :itemId";
		Query updateSellerItemQuery = session.createQuery(hqlUpdateSellerItem);
		updateSellerItemQuery.setParameter("itemId", item.getItem_id());
		updateSellerItemQuery.setParameter("newItemName", item.getItemName());
		updateSellerItemQuery.setParameter("newStartingBid", item.getStartingBid());
		updateSellerItemQuery.executeUpdate();
	}
	
    public List<Bid> getItemByBidId(int itemId){
        Session session = entityManager.unwrap(Session.class);
        Query<Bid> query = session.createQuery("FROM Bid WHERE bid.items_item_id = :itemId", Bid.class);
        query.setParameter("itemId", itemId);
        return query.getResultList();
    }

}
