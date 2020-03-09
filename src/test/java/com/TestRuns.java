package com;

import java.util.List;
import java.util.Scanner;

import com.csys.dao.imp.PlayerCareerDaoImp;
import com.csys.model.PlayerCareer;
import com.csys.util.Logger;

public class TestRuns {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		 logger.info("Choose the following format\n odi/t20/test");
			
			Scanner sc = new Scanner(System.in);
			
			String Format = sc.next();
			sc.close();
			PlayerCareerDaoImp wen = new PlayerCareerDaoImp();
			
	        List<PlayerCareer> get = wen.listruns(Format);
	        
	        for (PlayerCareer playerCareer : get) {
	        	String name = playerCareer.getplayerName();
	        	int runs =playerCareer.getRuns();
	        	
				logger.info(name +"\t"+ runs);

	        }}}


