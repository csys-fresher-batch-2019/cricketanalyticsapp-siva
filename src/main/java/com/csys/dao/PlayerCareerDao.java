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

	ArrayList<PlayerCareer> getdetails(String capNo) throws DBexception;

	List<PlayerCareer> listhighScore(String format) throws DBexception;

	List<PlayerCareer> listfifties(String format) throws DBexception;

	List<PlayerCareer> listhundred(String format) throws DBexception;

	List<PlayerCareer> listruns(String format) throws DBexception;

	List<formatruns> searchbyformatruns(String format, int runs) throws DBexception;

	void updaterank(String format) throws DBexception;

	List<PlayerCareer> displaytopbatsman(String format, int n) throws DBexception;

}
