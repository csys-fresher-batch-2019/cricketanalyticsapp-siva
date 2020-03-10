package com.csys.dao;

import java.util.List;

import com.csys.exceptionmsg.DBexception;
import com.csys.model.PlayerProfile;

public interface PlayerProfileDao {
	
	void addPlayer(String capNo,String name,String nation,String Style,int debutYear) throws DBexception;
	
	int updateRetiredYear(String capNo,int year) throws DBexception;
	
	List <PlayerProfile> playerlist (String nation) throws DBexception;
	
	List<String> getPlayerName () throws DBexception ;
	
	boolean validateplayerprofile(String capno)throws DBexception;
	
	boolean validateretiredplayer(String capno)throws DBexception;
	}
