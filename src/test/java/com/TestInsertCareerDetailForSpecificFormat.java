package com;

import com.csys.dao.imp.PlayerCareerDaoImp;
import com.csys.exceptionmsg.infoMessages;
import com.csys.util.Logger;

import java.util.Scanner;

public class TestInsertCareerDetailForSpecificFormat {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		boolean valid = false;
		PlayerCareerDaoImp use = new PlayerCareerDaoImp();
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the cap number");
		String capNo = sc.next();
		logger.info("Enter the format");
		String format = sc.next();
		valid = use.checkinsertCareerDetailForSpecificFormat(capNo, format);
		if (valid) {

			logger.info(infoMessages.Duplicate_message);
		} else {
			logger.info("Enter matches");
			int matches = sc.nextInt();
			logger.info("Enter Runs");
			int runs = sc.nextInt();
			logger.info("Enter Fifties");
			int fifty = sc.nextInt();
			logger.info("Enter Hundred");
			int hundred = sc.nextInt();
			logger.info("Enter High Score");
			int best = sc.nextInt();
			logger.info("Enter Average");
			float average = sc.nextFloat();
			sc.close();
			use.insertCareerDetailForSpecificFormat(capNo, format, matches, runs, fifty, hundred, best, average);
			logger.info(infoMessages.Insert_Message);
		}

	}

}
