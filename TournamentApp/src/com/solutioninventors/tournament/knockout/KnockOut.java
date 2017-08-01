/** 31 Jul. 2017 KnockOuwt.java 8:45:22 pm */
package com.solutioninventors.tournament.knockout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** @author ChineduKnight */
public class KnockOut {

	// variable declaration
	private int noofPlayers;
	private ArrayList<Competitor> competitors;
	
	private int[] scoreofPlayers;
	Scanner input = new Scanner(System.in);

	
	//constructor
	public KnockOut(int howmanyplayers) {
		setNoofPlayers(howmanyplayers);
		inputCompetitorname(howmanyplayers);
		generateFixture(competitors);
		printFixtures(competitors);
		inputScore(competitors);
		System.out.println("All set");

	}// end of constructor
	
	
public void inputCompetitorname(int noofcomp) {
	//competitors = new Competitor[noofcomp];
	competitors = new ArrayList<Competitor>(noofcomp);
	for (int i = 0; i < noofcomp; i++) {
		System.out.printf("Please input the name of player %d: ", i+1);
		competitors.add(new Competitor(input.next()));
	}//end for loop
	
	}//end inputCometitorname

public void generateFixture(ArrayList<Competitor> toShuffle) {
	Collections.shuffle(toShuffle);
	Collections.shuffle(toShuffle);
}
	//setters and getters
	public int getNoofPlayers() {
		return noofPlayers;
	}
	
	public void inputScore(ArrayList<Competitor> toScore) {
		System.out.println("Input the Scores for the following games");
		for (Competitor competitor : toScore) {
		System.out.printf("%s:",competitor.getName());
		competitor.setCurrentScore(input.nextInt());
	}//end score input
		for (int i = 0; i < toScore.size(); i+=2) {
			System.out.printf("%2s %2d Vs %2d %2s",toScore.get(i).getName(),toScore.get(i).getCurrentScore(), toScore.get(i+1).getCurrentScore(), toScore.get(i+1).getName());
			System.out.println();
		}
	}

	public void setNoofPlayers(int noofPlayers) {
		// code to check if no is even
		if (noofPlayers % 4 == 0) {
			this.noofPlayers = noofPlayers;
		} else {
			// this should be an error
			System.out.println("number Must be in power of 2^x and x>1");
			System.exit(1);
		}

	}

/*	public String[] getNameofPlayers() {
		return nameofPlayers;
	}

	public void setNameofPlayers(String[] nameofPlayers) {
		this.nameofPlayers = nameofPlayers;
	}*/

	public int[] getScoreofPlayers() {
		return scoreofPlayers;
	}

	public void setScoreofPlayers(int[] scoreofPlayers) {
		this.scoreofPlayers = scoreofPlayers;
	}

	

	public void printFixtures(ArrayList<Competitor> currentplayers) {
		
		
		for (int i = 0; i < currentplayers.size(); i+=2) {
			System.out.printf("%2s Vs %2s",currentplayers.get(i).getName(),currentplayers.get(i+1).getName());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KnockOut test = new KnockOut(8);
		//String[] arr = {"abc","abc2","abc3","abc4","abc5","abc6",};
		//test.setNameofPlayers(arr);
		//test.printFixtures();
	}// end of main

}// end of class
