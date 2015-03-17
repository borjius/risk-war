package com.risk.war.backend.service;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.risk.war.backend.bean.PlayerBean;
import com.risk.war.backend.bean.Position;

@Component
public class PlayerGenerator {
	
	private final static String DEFAULT_NAMES = "names.txt";
	private final static String DEFAULT_SURNAMES = "surnames.txt";
	private final static String DEFAULT_COUNTRIES = "countries.txt";
	private static final Integer[]ages = new Integer[]{17,18,19,20,21};
	private static final int MINIMUM_PLAYER_LEVEL = 20;
	private static final Integer[]pricing = new Integer[]{16000,50000,100000,220000,700000,3000000,11000000,22000000,60000000};
	
	private Random rand = new Random();
	
	public PlayerBean generatePlayer(Position pos, int teamLevel) throws IOException {
		PlayerBean player = new PlayerBean();
		player.setName(generateName(DEFAULT_NAMES));
		player.setSurname(generateName(DEFAULT_SURNAMES));
		player.setPosition(pos);
		player.setValue(generateLevel(teamLevel));
		player.setAge(generateAge());
		player.setCountry(generateName(DEFAULT_COUNTRIES));
		player.setContract(generateContract(player.getValue(), player.getPosition().getPositionPrice()));
		player.setSalary(player.getContract()/10);
		return player;
	}

	private int generateContract(int value, double positionPrice) {
		int levelReached = (119 - value)/10;
		int rankDiff = pricing[pricing.length-levelReached+1] - pricing[pricing.length-levelReached];
		int moneyBeforePos = pricing[pricing.length-levelReached] + rankDiff*value/10;
		return new Double(moneyBeforePos*positionPrice).intValue();
	}

	private int generateAge() {
		return ages[rand.nextInt(ages.length)];
	}

	/**
	 * team level represents the status of the team
	 * @param teamLevel from 30 to 80
	 * @return
	 */
	private int generateLevel(int teamLevel) {
		return MINIMUM_PLAYER_LEVEL + rand.nextInt(teamLevel);
	}

	private String generateName(String fileName) throws IOException {
		String[] names = FileUtils.readFileToString(new ClassPathResource(fileName).getFile()).trim().split(",");
		return names[rand.nextInt(names.length)];
	}
	
	public static void main(String[] args) throws IOException {
		PlayerGenerator pg = new PlayerGenerator();
		PlayerBean pb = pg.generatePlayer(Position.D, 30);
		System.out.println(pb.toString());
		System.out.println(pg.generatePlayer(Position.D, 30));
		System.out.println(pg.generatePlayer(Position.D, 30));
		System.out.println(pg.generatePlayer(Position.D, 40));
		System.out.println(pg.generatePlayer(Position.D, 40));
		System.out.println(pg.generatePlayer(Position.D, 50));
		System.out.println(pg.generatePlayer(Position.D, 50));
		System.out.println(pg.generatePlayer(Position.D, 60));
		System.out.println(pg.generatePlayer(Position.D, 60));
		System.out.println(pg.generatePlayer(Position.D, 70));
		System.out.println(pg.generatePlayer(Position.D, 70));
		System.out.println(pg.generatePlayer(Position.D, 80));
		System.out.println(pg.generatePlayer(Position.D, 80));
		
	}

}
