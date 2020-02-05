package com.csys;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.formatruns;

public interface PlayerCareerDao {
	
	ArrayList<PlayerCareer> listallPlayersCareer (String format) throws Exception;
	
	void newCareerDetails(String capNo,	String format,int matches,int runs,int fifty,int hundred,int best) throws Exception;
	
	ArrayList<PlayerCareer> getdetails (String capNo) throws Exception;
	
	ArrayList <Integer>getformatdetails(String capNo,String format) throws Exception;
	
	List<PlayerCareer> best  (String format,int r) throws Exception;
	
	List<formatruns> searchbyformatruns (String format,int runs) throws Exception;
	
	void updaterank (String format) throws Exception;
	
	List<PlayerCareer> displaytopbatsman(String format ,int n) throws Exception ;
}
	

