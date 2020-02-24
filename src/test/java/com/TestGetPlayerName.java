package com;

import java.util.List;

import com.csys.Logger;
import com.csys.PlayerProfileDaoImplementation;

public class TestGetPlayerName {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		PlayerProfileDaoImplementation obj = new PlayerProfileDaoImplementation();
		List<String> names =  obj.getPlayerName();
		for (String a : names) {
			
			logger.info(a);
		}

	}

}
