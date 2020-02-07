package com;

import java.util.List;
import java.util.Scanner;

import com.csys.PlayerProfile;
import com.csys.PlayerProfileDaoImplementation;

public class TestPlayerList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the nation");
		String nation = sc.next();
		PlayerProfileDaoImplementation ppdi = new PlayerProfileDaoImplementation();
		List<PlayerProfile> hd = ppdi.playerlist(nation);
		for (PlayerProfile pp : hd) {
			System.out.println(pp);
		}
	}

}
