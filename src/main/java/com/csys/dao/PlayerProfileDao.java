package com.csys.dao;

import java.util.List;

import com.csys.exception.DBexception;
import com.csys.model.PlayerProfile;

public interface PlayerProfileDao {

	void addPlayer(String capNo, String name, String nation, String Style, int debutYear, String format1,
			String format2, String format3) throws DBexception;

	int updateRetiredYear(String capNo, int year) throws DBexception;

	List<PlayerProfile> playerListByNation(String nation) throws DBexception;

	List<String> getPlayerName() throws DBexception;

	boolean validatePlayerProfile(String capno) throws DBexception;

	boolean validateRetiredPlayer(String capno) throws DBexception;
}
