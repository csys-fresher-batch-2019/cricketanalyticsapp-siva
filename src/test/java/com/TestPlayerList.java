package com;

import java.util.List;
import java.util.Scanner;

import com.csys.dao.imp.PlayerProfileDaoImplementation;
import com.csys.model.PlayerProfile;
import com.csys.util.Logger;

public class TestPlayerList {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the nation");
		String nation = sc.next();
		PlayerProfileDaoImplementation ppdi = new PlayerProfileDaoImplementation();
		List<PlayerProfile> hd = ppdi.playerlist(nation);
		for (PlayerProfile pp : hd) {
			logger.info(pp);
		}
		sc.close();
	}

}
