package com.risk.war.backend.service;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.risk.war.backend.Utils;
import com.risk.war.backend.bean.LoginBean;

@Path("/login")
@Service
public class LoginServiceImpl{

	private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public void login(InputStream data) throws JsonParseException, JsonMappingException, IOException {
		LoginBean loginBean = Utils.mapLoginBean(data);
		log.info("Trying to log with username: " + loginBean.getUsername());
		System.out.println("login: " + loginBean.getUsername());
	}

}
