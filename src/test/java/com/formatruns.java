package com;

public class formatruns {

	public String playerName;
	
	public int runs;
	/**
	 * @param playerName
	 * @param runs
	 */

	public formatruns(String playerName, int runs) {
		this.playerName = playerName;
		this.runs = runs;
	}
	public String toString() {
		return "formatruns [playerName=" + playerName + ", runs=" + runs + "]";
	}
	
	
	
}
