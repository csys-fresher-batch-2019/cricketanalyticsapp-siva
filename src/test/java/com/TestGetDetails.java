package com;

import java.util.ArrayList;
import java.util.Scanner;

import com.csys.dao.imp.PlayerCareerDaoImp;
import com.csys.model.PlayerCareer;
import com.csys.util.Logger;

public class TestGetDetails {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		Scanner sc =new Scanner(System.in);
		logger.info("Enter the Player name");
		String name = sc.nextLine();
		sc.close();
        PlayerCareerDaoImp p = new PlayerCareerDaoImp();
		ArrayList<PlayerCareer> task1 = new ArrayList<PlayerCareer>();
		task1 = (p.getdetails(name));
       for (PlayerCareer res : task1) {
    	   logger.info(res.getCapNo());
    	   logger.info(res.getFormat());
    	   logger.info(res.getMatches());
    	   logger.info(res.getRuns());
    	   logger.info(res.getFifty());
    	   logger.info(res.getHundred());
    	   logger.info(res.getBest());
    	   logger.info(res.getAverage());
    	   logger.info(res.getRanks());
    	   logger.info("\n");
	}
       
		
		

	}

}
