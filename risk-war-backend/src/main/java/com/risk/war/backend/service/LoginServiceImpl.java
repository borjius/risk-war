package com.risk.war.backend.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.risk.war.backend.bean.LoginBean;

@Path("/login")
@Service
public class LoginServiceImpl{

	private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void login(LoginBean loginBean) {
		log.info("Trying to log with username: " + loginBean.getUsername());
	}

}
