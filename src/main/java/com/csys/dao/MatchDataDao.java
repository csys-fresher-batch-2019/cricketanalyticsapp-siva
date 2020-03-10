package com.csys.dao;

import java.util.List;


import com.csys.exceptionmsg.DBexception;
import com.csys.model.MatchData;

public interface MatchDataDao {

	void addMatchDetail(String capNo, String format, int runs) throws DBexception;

	void deleteMatchDetail() throws DBexception;

	void updateCareer() throws DBexception;

	List<MatchData> showMatchDetails(String status) throws DBexception;

}
