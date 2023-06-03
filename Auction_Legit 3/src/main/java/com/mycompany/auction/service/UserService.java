package com.mycompany.auction.service;

import java.util.List;

import com.mycompany.auction.model.User;

public interface UserService {
	
	List<User> get();
		
	User get(int id);
	
	void save(User user);
	
	void delete(int id);

	User findByUsernameAndPassword(String username, String password);

}
