package com;

import java.util.Scanner;

import com.csys.MatchDataDaoImp;
import com.csys.infoMessages;

public class TestcheckMatchDataDuringInsertion {

	public static void main(String[] args) throws Exception {
		MatchDataDaoImp mdd = new MatchDataDaoImp();
		Scanner sr = new Scanner(System.in);
		System.out.println("Enter the cap number");
		String capNo = sr.next();
		System.out.println("Enter the format");
		String format = sr.next();
		System.out.println("Enter the runs Scored");
		int runs = sr.nextInt();
		String status = "yet to update"; 
		boolean res = mdd.checkMatchDataDuringInsertion(capNo, format, runs, status);
		System.out.println(res);
		
		if (res) {
			mdd.updateCareer();
			System.out.println(infoMessages.Updation);
			
		}
		

	}

}
