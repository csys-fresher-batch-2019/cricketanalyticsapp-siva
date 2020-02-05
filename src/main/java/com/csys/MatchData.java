package com.csys;

public class MatchData {
	
	String capNo ;
	String format ;
	Integer runs ;
	String status ;
	/**
	 * @param capNo
	 * @param format
	 * @param runs
	 * @param status
	 */
	public MatchData(String capNo, String format, Integer runs, String status) {
		super();
		this.capNo = capNo;
		this.format = format;
		this.runs = runs;
		this.status = status;
	}
	@Override
	public String toString() {
		return "MatchData [capNo=" + capNo + ", format=" + format + ", runs=" + runs + ", status=" + status + "]";
	}
	
	
	
}	



	