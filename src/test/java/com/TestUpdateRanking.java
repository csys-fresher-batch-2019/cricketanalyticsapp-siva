package com;

import java.util.Scanner;

import com.csys.Logger;
import com.csys.PlayerCareerDaoImp;

public class TestUpdateRanking {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		PlayerCareerDaoImp ns = new PlayerCareerDaoImp();
		logger.info("odi\tt20\ttest");
		logger.info("Enter any one of the above mentioned format");
		Scanner sc = new Scanner(System.in);
		String format = sc.next();
		sc.close();
		ns.updaterank(format);
		
}

}
