package com;

import java.util.Scanner;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.exception.infoMessages;
import com.csys.util.Logger;

public class TestAddMatchDetail {

	public static void main(String[] args) throws Exception {
	
		Logger logger = new Logger();
		 MatchDataDaoImp obj = new MatchDataDaoImp();
	     Scanner sr = new Scanner(System.in);
	     logger.info("Enter the capNo");
	     String capNo = sr.next();
	     logger.info("Enter the format");
	     String format = sr.next();
	     logger.info("Enter the runs scored");
	     int runs = sr.nextInt();
	     
	     obj.addMatchDetail(capNo, format, runs);
	     logger.info(infoMessages.Insert_Message);
	     sr.close();
	}
}
