package com.risk.war.backend.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.risk.war.backend.bean.LoginBean;
import com.risk.war.model.dao.UserDao;
import com.risk.war.model.entities.User;

@Path("/login")
@Service
public class LoginServiceImpl{

	private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Inject
	UserDao userDao;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean login(LoginBean loginBean) {
		log.info("Trying to log with username: " + loginBean.getUsername());
		User user = userDao.findElement(loginBean.getUsername());
		return (user==null) ? false : true;
	}

}
