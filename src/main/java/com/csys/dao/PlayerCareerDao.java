package com.csys.dao;

import java.util.ArrayList;
import java.util.List;

import com.csys.model.PlayerCareer;
import com.csys.model.formatruns;

public interface PlayerCareerDao {

	boolean checkinsertCareerDetailForSpecificFormat(String capNo, String format) throws Exception;

	void createNewCareer(String capNo) throws Exception;

	void insertCareerDetailForSpecificFormat(String capNo, String format, int matches, int runs, int fifty, int hundred,
			int best, float average) throws Exception;

	ArrayList<PlayerCareer> getdetails(String capNo) throws Exception;

	List<PlayerCareer> listhighScore(String format) throws Exception;

	List<PlayerCareer> listfifties(String format) throws Exception;

	List<PlayerCareer> listhundred(String format) throws Exception;

	List<PlayerCareer> listruns(String format) throws Exception;

	List<formatruns> searchbyformatruns(String format, int runs) throws Exception;

	void updaterank(String format) throws Exception;

	List<PlayerCareer> displaytopbatsman(String format, int n) throws Exception;

}
