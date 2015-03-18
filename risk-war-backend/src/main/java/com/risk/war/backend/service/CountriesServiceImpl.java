package com.risk.war.backend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Path("/countries")
@Service
public class CountriesServiceImpl {
	
	private final static Logger log = LoggerFactory.getLogger(CountriesServiceImpl.class);
	private final static String DEFAULT_COUNTRIES = "countries.txt";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HashSet<String> countriesList() throws IOException {
		log.debug("Getting countries from countries list");
		HashSet<String> hashList = new HashSet<String>();
		String[] names = FileUtils.readFileToString(new ClassPathResource(DEFAULT_COUNTRIES).getFile()).trim().split(",");
		for (String country : names) {
			hashList.add(country.trim());
		}
		return hashList;
	}

}
