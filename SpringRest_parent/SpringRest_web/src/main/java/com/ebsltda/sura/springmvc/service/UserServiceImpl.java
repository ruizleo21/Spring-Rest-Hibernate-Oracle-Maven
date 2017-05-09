package com.ebsltda.sura.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebsltda.sura.springmvc.dao.UserDAO;
import com.ebsltda.sura.springmvc.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	@Override
	public User getUser(long id) {
		return userDAO.getUser(id);
	}
	
	@Override
	public void deleteUser(long id) {
		userDAO.deleteUser(id);	
	}
	
	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	

}
