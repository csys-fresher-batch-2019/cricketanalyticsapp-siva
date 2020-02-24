package com;

import java.util.Scanner;

import com.csys.Logger;
import com.csys.PlayerProfileDaoImplementation;

public class TestUpdatePlayerProfile {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		PlayerProfileDaoImplementation obj = new PlayerProfileDaoImplementation();
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the capno");
		String capNo = sc.next();
		logger.info("Enter the Retired Year");
		int year = sc.nextInt();
		sc.close();
		obj.updateRetiredYear(capNo,year);
		
	}

}
