import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class Computer implements Serializable {
	/**
	 * public
	 * the HashMap with all the known patterns
	 */
	HashMap<Pattern, Integer> saveMoves; 
	/**
	 * constructor to initialize the computer
	 */
	public Computer(){
		saveMoves = new HashMap<Pattern, Integer>();
	}
/**
 *has the computer make predicions
 * @param playerHistory last four moves the player made
 * @return the computer choice
 */
	public int makePrediction(String playerHistory) {
		int compareValues1 = 0;
		int compareValues2= 0;
		int compareValues3 = 0;
		int computerChoice = 0;
		Random num = new Random();
		if (playerHistory.length() == 4) {
			storePattern(playerHistory);
			playerHistory = playerHistory.substring(1);
			Pattern throwRock = new Pattern(playerHistory + "R");
			Pattern throwPaper = new Pattern(playerHistory + "P");
			Pattern throwScissors = new Pattern(playerHistory + "S");
				if(saveMoves.get(throwRock) != null){
				 compareValues1 = saveMoves.get(throwRock);
				}
				if(saveMoves.get(throwPaper) != null){
				 compareValues2 = saveMoves.get(throwPaper);
				}
				if(saveMoves.get(throwScissors) != null){
				 compareValues3 = saveMoves.get(throwScissors);
				}
				int useOption;
				
				if (compareValues1  > compareValues2) {
					useOption = 1;
				} else if (compareValues1 > compareValues3) {
					useOption = 1;
				} else if (compareValues2 > compareValues1) {
					useOption = 2;
				} else if (compareValues2 > compareValues3) {
					useOption = 2;
				} else if (compareValues3 > compareValues1) {
					useOption = 3;
				} else if (compareValues3 > compareValues2) {
					useOption = 3;
				} else {
					useOption = num.nextInt(3) + 1;
				}
				switch (useOption) {
				case 1:
					computerChoice = 2;
					break;
				case 2:
					computerChoice = 3;
					break;
				case 3:
					computerChoice = 1;
					break;
				}
			}
			else{
				computerChoice = num.nextInt(3) + 1;
			}
		return computerChoice;
	}
/**
 * method stores pattern or increments to value if the pattern already exist
 * @param previousMoves the pattern to be stored
 */
	public void storePattern(String previousMoves) {
		int value = 1;
		Pattern playerHistory = new Pattern(previousMoves);
		if (saveMoves.containsKey(playerHistory)) {
			value = saveMoves.get(playerHistory);
			value++;
			saveMoves.put(playerHistory, value);
		} else {
			saveMoves.put(playerHistory, value);
		}
	}
}
