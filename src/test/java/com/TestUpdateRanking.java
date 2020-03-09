package com;

import java.util.Scanner;

import com.csys.dao.imp.PlayerCareerDaoImp;
import com.csys.util.Logger;

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
