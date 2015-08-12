package edu.umkc.laughlina;

import java.util.ArrayList;

public class Storage {
	private static ArrayList<Match> matchHistory = new ArrayList<Match>();
	
	public Match getMatch(int i) {
		assert matchHistory.isEmpty() == false;
		return matchHistory.get(i);
	}
	
	public void addMatch(Match match) {
		matchHistory.add(match);
		}
}
