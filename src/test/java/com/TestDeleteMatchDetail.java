package com;

import java.util.Scanner;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.exception.infoMessages;
import com.csys.util.Logger;

public class TestDeleteMatchDetail {

	public static void main(String[] args) throws Exception {
	
		Logger logger = new Logger();
		MatchDataDaoImp obj = new MatchDataDaoImp();
		obj.deleteMatchDetail();
		logger.info(infoMessages.Delete_Match_Detail);
		
	}

}
