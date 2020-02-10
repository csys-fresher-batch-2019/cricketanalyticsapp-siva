package com;

import java.util.Scanner;

import com.csys.MatchDataDaoImp;
import com.csys.infoMessages;

public class TestAddMatchDetail {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 MatchDataDaoImp obj = new MatchDataDaoImp();
	     Scanner sr = new Scanner(System.in);
	     System.out.println("Enter the capNo");
	     String capNo = sr.next();
	     System.out.println("Enter the format");
	     String format = sr.next();
	     System.out.println("Enter the runs scored");
	     int runs = sr.nextInt();
	     String status = "yet to update";
	     obj.addMatchDetail(capNo, format, runs, status);
	     System.out.println(infoMessages.Insert_Message);
	     sr.close();
	}
}
