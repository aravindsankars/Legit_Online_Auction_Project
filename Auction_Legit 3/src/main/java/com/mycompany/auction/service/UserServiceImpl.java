package com.mycompany.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.auction.dao.UserDao;
import com.mycompany.auction.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public List<User> get() {
		return userDao.get();
	}

	@Transactional
	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Transactional
	@Override
	public void save(User user) {
		 userDao.save(user);
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		userDao.delete(id);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}

}
