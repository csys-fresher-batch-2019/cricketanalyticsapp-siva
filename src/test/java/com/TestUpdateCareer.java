package com;

import java.util.Scanner;

import com.csys.Logger;
import com.csys.MatchDataDaoImp;
import com.csys.infoMessages;

public class TestUpdateCareer {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		MatchDataDaoImp obj = new MatchDataDaoImp();
					obj.updateCareer();
			logger.info(infoMessages.Updation);
			
			//}
	                                        
	}

}
