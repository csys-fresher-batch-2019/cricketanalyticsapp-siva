package com.csys.dao;

import java.util.ArrayList;
import java.util.List;

import com.csys.exception.DBexception;
import com.csys.model.PlayerCareer;
import com.csys.model.formatRuns;

public interface PlayerCareerDao {

	void createNewCareer(String capNo, String format1, String format2, String format3) throws DBexception;

	ArrayList<PlayerCareer> getDetails(String capNo) throws DBexception;

	List<PlayerCareer> listHighScore(String format) throws DBexception;

	List<PlayerCareer> listFifties(String format) throws DBexception;

	List<PlayerCareer> listHundred(String format) throws DBexception;

	List<PlayerCareer> listRuns(String format) throws DBexception;

	List<formatRuns> searchByFormatRuns(String format, int runs) throws DBexception;

	void updateRank(String format) throws DBexception;

	List<PlayerCareer> displayTopBatsman(String format, int n) throws DBexception;

}
