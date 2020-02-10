package com.csys;

import java.util.ArrayList;
import java.util.List;

import com.csys.formatruns;

public interface PlayerCareerDao {
	
	boolean checkinsertCareerDetailForSpecificFormat(String capNo, String format) throws Exception ;
	
	void createNewCareer(String capNo) throws Exception;
	
	void insertCareerDetailForSpecificFormat(String capNo,String format,int matches,int runs,int fifty,int hundred,int best,float average) throws Exception;
	
	ArrayList<PlayerCareer> getdetails (String capNo) throws Exception;
	
	List<PlayerCareer> best  (String format,int r) throws Exception;
	
	List<formatruns> searchbyformatruns (String format,int runs) throws Exception;
	
	void updaterank (String format) throws Exception;
	
	List<PlayerCareer> displaytopbatsman(String format ,int n) throws Exception ;
	
	
}
	

