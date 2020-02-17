package com.csys;

import java.util.List;

public interface PlayerProfileDao {
	
	void addPlayer(String capNo,String name,String nation,String Style,int debutYear) throws Exception;
	
	void updateRetiredYear(String capNo,int year) throws Exception;
	
	List <PlayerProfile> playerlist (String nation) throws Exception;
	
	List<String> getPlayerName () throws Exception ;
	
	boolean validateplayerprofile(String capno)throws Exception;
	
	
	}
