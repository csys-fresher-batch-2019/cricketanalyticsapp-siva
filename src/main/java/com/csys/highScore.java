package com.csys;

public class highScore {
	
 String Playername;
	int hScore;
	/**
	 * @param playername
	 * @param hScore
	 */
	public highScore(String playername, int hScore) {
		super();
		Playername = playername;
		this.hScore = hScore;
	}
	@Override
	public String toString() {
		return "highScore [Playername=" + Playername + ", hScore=" + hScore + "]";
	}

	
	}
	
