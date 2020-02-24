package com;

import java.util.Scanner;

import com.csys.Logger;
import com.csys.MatchDataDaoImp;
import com.csys.infoMessages;

public class TestDeleteMatchDetail {

	public static void main(String[] args) throws Exception {
	
		Logger logger = new Logger();
		MatchDataDaoImp obj = new MatchDataDaoImp();
		obj.deleteMatchDetail();
		logger.info(infoMessages.Delete_Match_Detail);
		
	}

}
