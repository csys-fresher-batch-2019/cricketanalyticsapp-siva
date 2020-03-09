package com;



import java.util.Scanner;

import com.csys.dao.imp.PlayerProfileDaoImplementation;
import com.csys.util.Logger;

public class TestAddPlayer {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		PlayerProfileDaoImplementation add1 = new PlayerProfileDaoImplementation();
		
		Scanner sc = new Scanner(System.in);
		logger.info("Enter cap number");
		String capNo= sc.nextLine(); 
		logger.info("Enter Player Name");
		String name= sc.nextLine();
		logger.info("Enter Nation");
		String nation= sc.nextLine(); 
        logger.info("Enter Batting Style");
		String style= sc.nextLine(); 
		logger.info("Enter Debut Year");
		int debutYear= sc.nextInt();
		sc.close();
		 add1.addPlayer(capNo,name,nation,style,debutYear);
	}}	
		












	

