package com.csys.dao;

import java.util.List;

import com.csys.model.MatchData;

public interface MatchDataDao {

	void addMatchDetail(String capNo, String format, int runs) throws Exception;

	void deleteMatchDetail() throws Exception;

	void updateCareer() throws Exception;

	boolean checkMatchDataDuringInsertion(String capNo, String format, int runs, String status) throws Exception;

	List<MatchData> showmatchdetails(String status) throws Exception;

}
