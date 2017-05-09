package com.ebsltda.sura.springmvc.dao;

import java.util.List;

import com.ebsltda.sura.springmvc.model.User;

public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public User getUser(long id);
	public void deleteUser(long id);
	public List<User> getUsers();
	

}
