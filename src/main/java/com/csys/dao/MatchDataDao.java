package com.csys.dao;

import java.util.List;

import com.csys.exception.DBexception;
import com.csys.model.MatchData;

public interface MatchDataDao {

	void addMatchDetail(String capNo, String format, int runs) throws DBexception;

	void deleteMatchDetail(String status) throws DBexception;

	void updateCareer(String status) throws DBexception;

	List<MatchData> showMatchDetails(String status) throws DBexception;

}
