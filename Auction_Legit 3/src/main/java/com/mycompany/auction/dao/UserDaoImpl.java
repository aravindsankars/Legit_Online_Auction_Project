package com.mycompany.auction.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.auction.model.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> get() {
		Session currentSession = entityManager.unwrap(Session.class);
	    Query<User> query = currentSession.createQuery("From User", User.class);
	    List<User> list = query.getResultList();
	    return list;
	}
	
	
	 @Override
	 public User findByUsernameAndPassword(String username, String password) {
	     
		Session currentSession = entityManager.unwrap(Session.class);

		 Query<User> query = currentSession.createQuery(
	                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password",
	                User.class);
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        List<User> results = query.getResultList();
	        if (results.isEmpty()) {
	            return null;
	        } else {
	            return results.get(0);
	        }
	    }
	
	@Override
	public User get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User userObj = currentSession.get(User.class, id);
		return userObj;
	}

	@Override
	public void save(User user) {
      		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		User userObj = currentSession.get(User.class, id);
	    currentSession.delete(userObj);
	}

}
