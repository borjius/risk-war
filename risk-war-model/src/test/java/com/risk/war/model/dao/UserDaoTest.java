package com.risk.war.model.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.risk.war.model.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/model-context.xml" })
public class UserDaoTest {
	
	private final static Logger log = LoggerFactory.getLogger(UserDaoTest.class);
	
	private final static String USERNAME = "username";
	private final static String PASSWORD = "password";
	private final static String EMAIL = "email@email.com";
	private final static String UPDATED_EMAIL = "testing@testing.com";
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void operationsOverUser(){
		User user = new User();
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setUsername(USERNAME);
		log.info("creating user");
		userDao.create(user);
		log.info("Finding all users");
		Assert.assertTrue("Not correctly inserted", userDao.getAll().size() == 1);
		log.info("Finding user " + USERNAME);
		Assert.assertTrue("Extracted user is not same as the one was trying to insert", user.getEmail().equals(userDao.findElement(USERNAME).getEmail()));
		user.setEmail(UPDATED_EMAIL);
		log.info("Updating user");
		userDao.update(user);
		log.info("Finding updated user " + USERNAME);
		Assert.assertTrue("Updating user did not work", user.getEmail().equals(userDao.findElement(USERNAME).getEmail()));
		log.info("Removing user");
		userDao.remove(USERNAME);
		log.info("Finding all users");
		Assert.assertTrue("User was not removed", userDao.getAll().isEmpty());
	}

}
