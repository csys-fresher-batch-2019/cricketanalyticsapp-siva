package com.csys;

public class formatruns {

	 private String playerName;
	
	private int runs;
	
	
	
	public String getPlayerName() {
		return playerName;
	}


	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	/**
	 * @return the runs
	 */
	public int getRuns() {
		return runs;
	}


	/**
	 * @param runs the runs to set
	 */
	public void setRuns(int runs) {
		this.runs = runs;
	}


	public String toString() {
		return "formatruns [playerName=" + playerName + ", runs=" + runs + "]";
	}
	
	
	
}
