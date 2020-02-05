package com;

import java.util.Scanner;

import com.csys.PlayerProfileDaoImplementation;

public class TestUpdatePlayerProfile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlayerProfileDaoImplementation obj = new PlayerProfileDaoImplementation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capno");
		String capNo = sc.next();
		System.out.println("Enter the Retired Year");
		int year = sc.nextInt();
		obj.updatePlayer(capNo,year);
	}

}
