package com.mycompany.auction.model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int user_id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String role;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Items> items = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bid> bidItem = new ArrayList<>();
	
	public int getId() {
		return user_id;
	}
	public void setId(Integer id) {
		this.user_id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", items=" + items + ", bidItem=" + bidItem + "]";
	}
		
	
}
