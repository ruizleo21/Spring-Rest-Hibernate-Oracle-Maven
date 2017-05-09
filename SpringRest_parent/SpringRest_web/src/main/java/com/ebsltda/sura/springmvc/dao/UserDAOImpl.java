package com.ebsltda.sura.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebsltda.sura.springmvc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
	getCurrentSession().save(user);		
	}
	
	@Override
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setAge(user.getAge());
		userToUpdate.setSalary(user.getSalary());
		getCurrentSession().update(userToUpdate);
	}
	
	@Override
	public User getUser(long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}
	
	@Override
	public void deleteUser(long id) {
		User user =getUser(id);
		if (user!=null)
			getCurrentSession().delete(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}
}
