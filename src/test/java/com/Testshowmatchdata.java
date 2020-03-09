package com;

import java.util.List;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.model.MatchData;

public class Testshowmatchdata {

	public static void main(String[] args) throws Exception {

		MatchDataDaoImp obj = new MatchDataDaoImp();

		List<MatchData> summ = obj.showmatchdetails("yet to update");

		for (MatchData m : summ) {
			System.out.println(m.getCapNo());
			System.out.println(m.getFormat());
			System.out.println(m.getRuns());
			System.out.println(m.getStatus());
		}

	}

}
