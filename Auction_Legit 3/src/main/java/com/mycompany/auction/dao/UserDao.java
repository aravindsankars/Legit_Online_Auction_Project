package com.mycompany.auction.dao;



import java.util.List;

import com.mycompany.auction.model.User;

public interface UserDao {

	List<User> get();
	
	User findByUsernameAndPassword(String username, String password);
		
	User get(int id);
	
	void save(User user);
	
	void delete(int id);
}
