package com;

import java.util.List;

import com.csys.dao.imp.PlayerProfileDaoImplementation;
import com.csys.util.Logger;

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
