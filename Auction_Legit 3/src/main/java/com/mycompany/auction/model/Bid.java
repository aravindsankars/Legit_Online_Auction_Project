package com.mycompany.auction.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "bids")
public class Bid {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private int bidId;
    
    @Column(name = "amount")
    private int amount;
    
    @Column(name = "bid_time")
    private Date bidTime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Items items;
    
    
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }


    public Items getSellerItem() {
        return items;
    }

    public void setSellerItem(Items items) {
        this.items = items;
    }

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the items
	 */
	public Items getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Items items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", amount=" + amount + ", bidTime=" + bidTime + "]";
	}
	
	
	
	
}
    
    
