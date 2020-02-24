package com;

import java.util.Scanner;

import com.csys.Logger;
import com.csys.MatchDataDaoImp;
import com.csys.infoMessages;

public class TestcheckMatchDataDuringInsertion {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		MatchDataDaoImp mdd = new MatchDataDaoImp();
		Scanner sr = new Scanner(System.in);
		logger.info("Enter the cap number");
		String capNo = sr.next();
		logger.info("Enter the format");
		String format = sr.next();
		logger.info("Enter the runs Scored");
		int runs = sr.nextInt();
		sr.close();
		String status = "yet to update"; 
		boolean res = mdd.checkMatchDataDuringInsertion(capNo, format, runs, status);
		logger.info(res);
		
		if (res) {
			mdd.updateCareer();
			logger.info(infoMessages.Updation);
			
		}
		

	}

}
