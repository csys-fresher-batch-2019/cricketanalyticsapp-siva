package com.csys.dao;

import java.util.List;

import com.csys.model.PlayerProfile;

public interface PlayerProfileDao {
	
	void addPlayer(String capNo,String name,String nation,String Style,int debutYear) throws Exception;
	
	int updateRetiredYear(String capNo,int year) throws Exception;
	
	List <PlayerProfile> playerlist (String nation) throws Exception;
	
	List<String> getPlayerName () throws Exception ;
	
	boolean validateplayerprofile(String capno)throws Exception;
	
	boolean validateretiredplayer(String capno)throws Exception;
	}
