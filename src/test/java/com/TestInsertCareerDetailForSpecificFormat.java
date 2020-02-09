package com;

import com.csys.PlayerCareerDaoImp;
import com.csys.infoMessages;

import java.util.Scanner;

public class TestInsertCareerDetailForSpecificFormat {

	public static void main(String[] args) throws Exception {
		boolean valid = false ;
		PlayerCareerDaoImp use = new PlayerCareerDaoImp();
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the cap number");
		String capNo = sc.next();
		System.out.println("Enter the format");
		String format = sc.next();
		use.checkinsertCareerDetailForSpecificFormat(capNo, format);
		if(valid) {
			
			System.out.println(infoMessages.Duplicate_message);
		}
		else {
			System.out.println("Enter matches");
			int matches = sc.nextInt();
			System.out.println("Enter Runs");
			int runs = sc.nextInt();
			System.out.println("Enter Fifties");
			int fifty = sc.nextInt();
			System.out.println("Enter Hundred");
			int hundred = sc.nextInt();
			System.out.println("Enter High Score");
			int best = sc.nextInt();
			System.out.println("Enter Average");
			float average = sc.nextFloat();
			use.insertCareerDetailForSpecificFormat(capNo, format, matches, runs, fifty, hundred, best, average);
		    System.out.println(infoMessages.Insert_Message); 
		}

	}

}
