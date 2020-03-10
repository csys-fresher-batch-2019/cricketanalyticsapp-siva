package com.csys.model;

public class formatruns {

	 private String playerName;
	
	private int runs;
	
	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	
	public int getRuns() {
		return runs;
	}


	public void setRuns(int runs) {
		this.runs = runs;
	}


	public String toString() {
		return "formatruns [playerName=" + playerName + ", runs=" + runs + "]";
	}
	
	
	
}
