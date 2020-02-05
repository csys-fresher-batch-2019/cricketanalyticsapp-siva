package com;

import com.csys.MatchDataDaoImp;

public class TestAddMatchDetail {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 MatchDataDaoImp obj = new MatchDataDaoImp();
		 obj.addMatchDetail("i200", "t20", 45, "yet to update");
		 obj.addMatchDetail("i278", "odi", 123, "yet to update");
		 obj.addMatchDetail("i177", "odi", 90, "yet to update");
		 obj.addMatchDetail("e227", "test",220, "yet to update");
	}
}
