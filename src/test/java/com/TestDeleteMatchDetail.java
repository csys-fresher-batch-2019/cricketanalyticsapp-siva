package com;

import java.util.Scanner;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.exception.infoMessages;
import com.csys.util.Logger;

public class TestDeleteMatchDetail {

	public static void main(String[] args) throws Exception {

		Logger logger = new Logger();
		MatchDataDaoImp obj = new MatchDataDaoImp();
		Scanner sc = new Scanner(System.in);
		String status = sc.next();
		sc.close();
		obj.deleteMatchDetail(status);
		logger.info(infoMessages.Delete_Match_Detail);

	}

}
