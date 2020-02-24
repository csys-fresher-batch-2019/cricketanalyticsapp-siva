package com;

import java.util.List;
import java.util.Scanner;

import com.csys.Logger;
import com.csys.PlayerCareer;
import com.csys.PlayerCareerDaoImp;

public class TestHundred {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		 logger.info("Choose the following format\n odi/t20/test");
			
			Scanner sc = new Scanner(System.in);
			
			String Format = sc.next();
			sc.close();
			PlayerCareerDaoImp wen = new PlayerCareerDaoImp();
			
	        List<PlayerCareer> get = wen.listhundred(Format);
	        
	        for (PlayerCareer playerCareer : get) {
	        	String name = playerCareer.getplayerName();
	        	int hundred =playerCareer.getHundred();
	        	
				logger.info(name +"\t"+ hundred);

	}
	}
}
