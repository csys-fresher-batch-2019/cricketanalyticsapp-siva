package com;

import java.util.Scanner;

import com.csys.PlayerCareerDaoImp;

public class TestNewCareerDetails {

	public static void main(String[] args) throws Exception {
		
		PlayerCareerDaoImp obj = new  PlayerCareerDaoImp();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	    int matches = 1;
		String capNo = sc.nextLine();
		String format = sc.nextLine();
		int runs = sc.nextInt();
		int fifty=sc.nextInt() ;
		int hundred = sc.nextInt();
		int best = runs;
		obj.newCareerDetails(capNo,format,matches,runs,fifty,hundred,best);
		  // obj.newCareerDetails("i100", "odi", 1, 80, 1, 0, 80);
		   //obj.newCareerDetails("e227", "test", 1, 110, 0, 1, 110);
		   
	}

}
