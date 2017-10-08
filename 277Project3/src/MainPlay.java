import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 * plays rock paper scissors against an A.I.
 * @author Kelvin
 */
public class MainPlay {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Which do you wish to fight");
		System.out.println("1) Veteran");
		System.out.println("2) Novice");
		int option = checkInput(1, 2);
		boolean play = true;
		char playerChoice = 0;
		int i = 0;
		Computer computini = null;
		File computer = new File("computer.dat");
		switch (option) {
		case 1:
			if (computer.exists()) {
				try {
					ObjectInputStream in = new ObjectInputStream(
							new FileInputStream(computer));
					computini = (Computer) in.readObject();
					in.close();
				} catch (IOException e) {
					System.out.println("Error processing file.");
				} catch (ClassNotFoundException e) {
					System.out.println("Could not find class.");
				}
			}
			break;
		case 2:
			computini = new Computer();
			break;
		}
		int computerScore = 0;
		int yourScore = 0;
		int tie = 0;
		String previousMoves = "";
		char computerChoice;
		do {
			System.out.println("Computer: Evaluating options...");
			int computerPrediction = computini.makePrediction(previousMoves);
			computerChoice = chooseOption(computerPrediction);
			System.out.println("Which do you wish to use:");
			System.out.println("1) Rock");
			System.out.println("2) Paper");
			System.out.println("3) Scissors");
			System.out.println("4) Quit");
			option = checkInput(1, 4);
			if (option == 4) {
				System.out.println("Do You Wish to Save?");
				System.out.println("1) Yes");
				System.out.println("2) No ");
				int save = checkInput(1,2);
				switch(save){
				case 1:
				try {
					ObjectOutputStream out = new ObjectOutputStream(
							new FileOutputStream(computer));
					out.writeObject(computini);
					out.close();
				} catch (IOException e) {
					System.out.println("Error processing file.");
				}
				break;
				case 2:
				System.out.println("Computer reset to last known restore point");
				break;
				}
				System.exit(0);
			}
			char chosenOption = chooseOption(option);
			playerChoice = chosenOption;
			System.out.println(chosenOption + "\t" + computerChoice);

			String result = fightTheComp(playerChoice, computini,
					computerChoice);
			if (result == "Lose") {
				computerScore++;
			} else if (result == "Win") {
				yourScore++;
			} else {
				tie++;
			}
			System.out.println(result);
			System.out.println("Your Score \t" + "Tie \t" + "Computer Score");
			System.out.println(yourScore + "\t \t" + tie + "\t \t"
					+ computerScore);
			previousMoves = previousMoves + playerChoice;
			if (previousMoves.length() > 4) {
				previousMoves = previousMoves.substring(1);
			}
		} while (play);

	}

	/**
	 * chooses an option based on the number
	 * @param option the number that selects the choice
	 * @return the choice of Rock paper scissors
	 */
	public static char chooseOption(int option) {
		char chosenOption = 0;
		switch (option) {
		case 1:
			chosenOption = 'R';
			break;
		case 2:
			chosenOption = 'P';
			break;
		case 3:
			chosenOption = 'S';
			break;
		}
		return chosenOption;
	}

	/**
	 * 
	 * @param chosenOption  the option the player choice
	 * @param computini the A.I. the player is playing against
	 * @param computerChoice the choice of the computer
	 * @return results of the battle
	 */
	public static String fightTheComp(char chosenOption, Computer computini,
			char computerChoice) {
		String result = null;
		if (chosenOption == computerChoice) {
			result = "Tie";
		} else if (chosenOption == 'R' && computerChoice == 'P') {
			result = "Lose";
		} else if (chosenOption == 'R' && computerChoice == 'S') {
			result = "Win";
		} else if (chosenOption == 'P' && computerChoice == 'R') {
			result = "Win";
		} else if (chosenOption == 'P' && computerChoice == 'S') {
			result = "Lose";
		} else if (chosenOption == 'S' && computerChoice == 'R') {
			result = "Lose";
		} else if (chosenOption == 'S' && computerChoice == 'P') {
			result = "Win";
		}
		return result;
	}

	/**
	 * checks to see if input is between the bounds 
	 * @param low  lower bound
	 * @param high upper bound
	 * @return user input
	 */
	public static int checkInput(int low, int high) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int option = 0;
		while (!valid) {
			if (input.hasNextInt()) {
				option = input.nextInt();
				if (option >= low && option <= high) {
					valid = true;
				} else {
					System.out.println("Invalid input. Try Again. ");
				}
			}

			else {
				input.next();
				System.out.println("Invalid input. Try Again. ");

			}
		}
		return option;
	}
}
