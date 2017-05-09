package com.ebsltda.sura.springmvc.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ebsltda.sura.springmvc.dao.UserDAO;
import com.ebsltda.sura.springmvc.model.User;

public class SpringHibernateMain {
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDAO userDAO = context.getBean(UserDAO.class);
		User user = new User();
		user.setName("Angelica");
		user.setAge(20);
		user.setSalary(1000);
		userDAO.addUser(user);
		System.out.println("User:: "+user);
		List<User> list= userDAO.getUsers();
		
		for(User u: list){
			System.out.println("User list::" + u);
		}
		
		context.close();
	}

}
