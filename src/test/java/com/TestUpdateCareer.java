package com;

import java.util.Scanner;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.exception.infoMessages;
import com.csys.util.Logger;

public class TestUpdateCareer {

	public static void main(String[] args) throws Exception {
		Logger logger = new Logger();
		MatchDataDaoImp obj = new MatchDataDaoImp();
		Scanner sc = new Scanner(System.in);
		String format = sc.next();
		sc.close();
		obj.updateCareer(format);
		logger.info(infoMessages.Updation);

		// }

	}

}
