package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDaoImpl;
import com.app.model.User;

@Service
public class UserService {
    
	@Autowired
	UserDaoImpl dao;
	
	public void addUser(User user)
	{
		dao.addUser(user);
	}
	
	public User getUser(String userId)
	{
		return dao.getUser(userId);
	}
	public List<User> getAllMerchants()
	{
		return dao.getMerchantList();
	}	
}
