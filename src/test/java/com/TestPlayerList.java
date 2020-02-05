package com;

import java.util.List;

import com.csys.PlayerProfile;
import com.csys.PlayerProfileDaoImplementation;

public class TestPlayerList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerProfileDaoImplementation ppdi = new PlayerProfileDaoImplementation();
		List<PlayerProfile> hd = ppdi.playerlist();
		for (PlayerProfile pp : hd) {
			System.out.println(pp);
		}
	}

}
