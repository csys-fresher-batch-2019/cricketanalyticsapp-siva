package com.csys;

import java.util.List;

public interface PlayerProfileDao {
	
	void addPlayer(String capNo,String name,String nation,String Style,int debutYear) throws Exception;
	
	void updatePlayer(String capNo,int year) throws Exception;
	
	List <PlayerProfile> playerlist () throws Exception;
	}
