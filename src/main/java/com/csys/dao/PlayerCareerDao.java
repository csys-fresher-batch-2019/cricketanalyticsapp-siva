package com.csys.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csys.exceptionmsg.DBexception;
import com.csys.model.PlayerCareer;
import com.csys.model.formatruns;

public interface PlayerCareerDao {

	void createNewCareer(String capNo) throws DBexception;

	void createOdiCareer(String capNo) throws DBexception;

	void createTestCareer(String capNo) throws DBexception;

	void createT20Career(String capNo) throws DBexception;

	ArrayList<PlayerCareer> getDetails(String capNo) throws DBexception;

	List<PlayerCareer> listHighScore(String format) throws DBexception;

	List<PlayerCareer> listFifties(String format) throws DBexception;

	List<PlayerCareer> listHundred(String format) throws DBexception;

	List<PlayerCareer> listRuns(String format) throws DBexception;

	List<formatruns> searchByFormatRuns(String format, int runs) throws DBexception;

	void updateRank(String format) throws DBexception;

	List<PlayerCareer> displayTopBatsman(String format, int n) throws DBexception;

}
