package com;

import java.util.List;

import com.csys.PlayerProfileDaoImplementation;

public class TestGetPlayerName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerProfileDaoImplementation obj = new PlayerProfileDaoImplementation();
		List<String> names =  obj.getPlayerName();
		for (String a : names) {
			String name = a;
		}

	}

}
