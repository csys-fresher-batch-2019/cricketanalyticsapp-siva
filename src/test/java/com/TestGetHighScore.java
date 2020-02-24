package com;

import java.util.List;
import java.util.Scanner;

import com.csys.Logger;
import com.csys.PlayerCareer;
import com.csys.PlayerCareerDaoImp;
import com.csys.errorMessages; 

public class TestGetHighScore {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		logger.info("Choose the following format\n odi/t20/test");
		
		Scanner sc = new Scanner(System.in);
		
		String Format = sc.next();
		sc.close();
		PlayerCareerDaoImp wen = new PlayerCareerDaoImp();
		
        List<PlayerCareer> get = wen.listhighScore(Format);
        
        for (PlayerCareer playerCareer : get) {
        	String name = playerCareer.getplayerName();
        	int Score =playerCareer.getBest();
        	
			logger.info(name +"\t"+ Score);
		}

		
	}
	}	