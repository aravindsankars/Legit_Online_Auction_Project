package com.mycompany.auction.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int item_id;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "starting_bid")
	private int startingBid;
	
	
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    
	@OneToMany(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bid> bidList ;
    

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getStartingBid() {
		return startingBid;
	}

	public void setStartingBid(int startingBid) {
		this.startingBid = startingBid;
	}

	public void setUser(User user2) {
		
		this.user = user2;
		
	}
	
	public User getUser() {
		return user;
	}


	public List<Bid> getBidList() {
		return bidList;
	}


	public void setBidList(List<Bid> bidList) {
		this.bidList = bidList;
	}


}
