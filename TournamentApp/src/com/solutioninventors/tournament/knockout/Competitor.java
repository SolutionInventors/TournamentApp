/** 1 Aug. 2017 Competitor.java 8:51:29 pm */
package com.solutioninventors.tournament.knockout;

/** @author ChineduKnight */
public class Competitor {
	private String name;
	private int currentScore;
	private int totalScore;
	private boolean eliminate = false;

	public Competitor() {
		name = "noName";
		currentScore = totalScore = 0;
	}

	public Competitor(String Cname) {
		name = Cname;
		currentScore = totalScore = 0;
	}

	public String getName() {
		return name;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public boolean isEliminate() {
		return eliminate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public void setEliminate(boolean eliminate) {
		this.eliminate = eliminate;
	}
}
