package edu.umkc.laughlina;

public class Match {

	private int you_set1 = 0;
	private int you_set2 = 0;
	private int you_set3 = 0;
	private int you_set4 = 0;
	private int you_set5 = 0;
	
	private int opp_set1 = 0;
	private int opp_set2 = 0;
	private int opp_set3 = 0;
	private int opp_set4 = 0;
	private int opp_set5 = 0;
	
	private int numSetsWon = 0;
	private int numSetsLost = 0;
	private int numSetsToPlay = 0;
	
	private int setsPlayed = 0;
	
	private int you_game_score = 0;
	private int opp_game_score = 0;
	
	private boolean game_win = false;
	
	public int pointWon() {
		int matchFinished = 0;
		
		if (you_game_score == 0)
			you_game_score = 15;
		else if (you_game_score == 15)
			you_game_score = 30;
		else if (you_game_score == 30)
			you_game_score = 40;
		else if (you_game_score == 40 && opp_game_score < 40) {
			you_game_score = 0;
			opp_game_score = 0;
			game_win = true;
			return matchFinished = updateSetsWin();
		}
		else if (you_game_score == 40 && opp_game_score > 40)
			opp_game_score = 40;
		else if (you_game_score == 40 && opp_game_score == 40)
			you_game_score = 405;
		else {
			you_game_score = 0;
			opp_game_score = 0;
			game_win = true;
			return matchFinished = updateSetsWin();
		}
		return matchFinished;
	}
	
	public int pointLost() {
		int matchFinished = 0;
		
		if (opp_game_score == 0)
			opp_game_score = 15;
		else if (opp_game_score == 15)
			opp_game_score = 30;
		else if (opp_game_score == 30)
			opp_game_score = 40;
		else if (opp_game_score == 40 && you_game_score < 40) {
			you_game_score = 0;
			opp_game_score = 0;
			game_win = false;
			return matchFinished = updateSetsLost();
		}
		else if (opp_game_score == 40 && you_game_score > 40)
			you_game_score = 40;
		else if (opp_game_score == 40 && you_game_score == 40)
			opp_game_score = 405;
		else {
			you_game_score = 0;
			opp_game_score = 0;
			game_win = false;
			return matchFinished = updateSetsLost();
		}
		return matchFinished;
	}
	
	private int updateSetsWin() {
		// If 0 is returned, the game is still in progress
		// If 1 is returned, you won the match
		// If 2 is returned, you lost the match
		
		if (you_set1 < 6 && opp_set1 < 6) {
			you_set1++; 
			if (you_set1 == 6 && numSetsToPlay == 1) {
				assert numSetsToPlay == 1;
				return 1;
			}
			else
				numSetsWon++;
		}
		else if (you_set2 < 6 && opp_set2 < 6) {
			you_set2++; 
			if (you_set2 == 6)
				numSetsWon++;
		}
		else if (you_set3 < 6 && opp_set3 < 6) {
			you_set3++; 
			if (you_set3 == 6 && numSetsToPlay == 3 && numSetsWon >= 2) {
				assert numSetsWon >= 2;
				return 1;
			}
			else
				numSetsWon++;
		}
		else if (you_set4 < 6 && opp_set4 < 6) {
			you_set4++; 
			if (you_set4 == 6)
				numSetsWon++;
		}
		else if (you_set5 < 5 && opp_set5 < 5) {
			you_set5++; }
		else {
			you_set5++;
			assert numSetsWon >= 3;
			return 1;
		}
		setsPlayed++;
		return 0;
	}
	
	private int updateSetsLost() {
		if (opp_set1 < 6 && you_set1 < 6) {
			opp_set1++; 
			if (opp_set1 == 6 && numSetsToPlay == 1) {
				assert numSetsToPlay == 1;
				return 2;
			}
			else
				numSetsLost++;
		}
		else if (opp_set2 < 6 && you_set2 < 6) {
			opp_set2++; 
			if (opp_set2 == 6)
				numSetsLost++;
		}
		else if (opp_set3 < 6 && you_set3 < 6) {
			opp_set3++; 
			if (opp_set3 == 6 && numSetsToPlay == 3 && numSetsLost >= 2) {
				assert numSetsLost >= 2;
				return 2;
			}
		}
		else if (opp_set4 < 6 && you_set4 < 6) {
			opp_set4++; 
			if (opp_set4 == 6)
				numSetsLost++;
		}
		else if (opp_set5 < 5 && you_set5 < 5) {
			opp_set5++; }
		else {
			opp_set5++;
			assert numSetsLost >= 3;
			return 2;
			}
		setsPlayed++;
		return 0;
		}

	public int getMySetScore(int setNumber) {
		if (setNumber == 1) 
			return you_set1;
		else if (setNumber == 2) 
			return you_set2;
		else if (setNumber == 3) 
			return you_set3;
		else if (setNumber == 4) 
			return you_set4;
		else
			return you_set5;
	}
	
	public int getOppSetScore(int setNumber) {
		if (setNumber == 1) 
			return opp_set1;
		else if (setNumber == 2) 
			return opp_set2;
		else if (setNumber == 3) 
			return opp_set3;
		else if (setNumber == 4) 
			return opp_set4;
		else
			return opp_set5;
	}
	
	public int getMyGameScore() {
		return you_game_score;
	}
	
	public int getOppGameScore() {
		return opp_game_score;
	}
	
	public void setNumSets(String sets) throws InvalidNumberOfSets {
		if (sets == "1") {
			numSetsToPlay = 1;
		}
		else if (sets == "3") {
			numSetsToPlay = 3;
		}
		else if (sets == "5") {
			numSetsToPlay = 5;
		}
		else
			throw new InvalidNumberOfSets("NOT A VALID NUMBER OF SETS!");
	}
	
	public void resetScores() {
		you_set1 = 0;
		you_set2 = 0;
		you_set3 = 0;
		you_set4 = 0;
		you_set5 = 0;
		
		opp_set1 = 0;
		opp_set2 = 0;
		opp_set3 = 0;
		opp_set4 = 0;
		opp_set5 = 0;
		
		you_game_score = 0;
		opp_game_score = 0;
		
		setsPlayed = 0;
		
		numSetsWon = 0;
		numSetsLost = 0;
	}
}
