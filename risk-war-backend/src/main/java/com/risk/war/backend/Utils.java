package com.risk.war.backend;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.risk.war.backend.bean.LoginBean;

public class Utils {
	
	public static LoginBean mapLoginBean(InputStream input) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		LoginBean loginBean = objectMapper.readValue(input, LoginBean.class);
		return loginBean;
	}

}
