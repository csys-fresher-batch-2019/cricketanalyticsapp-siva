package com.csys;

public interface MatchDataDao {
	
	void addMatchDetail(String capNo,String format,int runs,String status) throws Exception;
	
	void deleteMatchDetail(String status) throws Exception;
	
	void updateCareer(String capNo,String format,int runs) throws Exception;
	
	
}
