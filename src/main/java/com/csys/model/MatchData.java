package com.csys.model;

public class MatchData {

	private String capNo;
	private String format;
	private Integer runs;
	private String status;

	public String getCapNo() {
		return capNo;
	}

	public void setCapNo(String capNo) {
		this.capNo = capNo;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "MatchData [capNo=" + capNo + ", format=" + format + ", runs=" + runs + ", status=" + status + "]";
	}

}
