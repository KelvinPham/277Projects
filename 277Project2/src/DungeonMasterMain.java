import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 * The program lets the user play a game of dungeon crawlers
 * @author Kelvin
 *
 */
public class DungeonMasterMain {
	public static void main(String args[]) {
		Level l = new Level();
		int levelNum = 1;
		Character playable = null;
		File save = new File("hero.dat"); // Do we have a save file?
		if (save.exists()) {
			try {
				ObjectInputStream objectIn = new ObjectInputStream(
						new FileInputStream(save));
				playable = (Hero) objectIn.readObject();
				objectIn.close();
				System.out.println("Welcome Back " + playable.getName());
			} catch (IOException e) {
				System.out.println("Error processing file.");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find class.");
			}
		} else {
			System.out.println("Welcome adventurer");
			System.out.println("What would you liked to be called");
			Scanner input = new Scanner(System.in);
			String name = input.next();
			System.out.println("Enter a catchphrase");
			String catchphrase = input.next();
			l.generateLevel(levelNum);
			Point youAreHere = l.findStartLocation();
			playable = new Hero(name, catchphrase, youAreHere);
			playable.display();
		}
		if(playable.getLevel() < 4 ){
		l.generateLevel(playable.getLevel());
		Point youAreHere = l.findStartLocation();
		((Hero)playable).setLocation(youAreHere);
		boolean alive = true;
		boolean endingReached = false;
		l.displayMap(youAreHere);
		do {
			if (l.getRoom(youAreHere) != 'f') {
				if (playable.getHp() != 0) {
					System.out.println("Choose a direction");
					System.out.println("1) North");
					System.out.println("2) South");
					System.out.println("3) East");
					System.out.println("4) West");

					int option = checkInput(1, 4);
					endingReached = goToRoom(playable, option, youAreHere, l,endingReached);
				} else {
					System.out.println("Game Over ");
					alive = false;
					System.exit(0);
				}
			}
			else {
				endingReached = true;
			}
		} while (endingReached == false && alive == true);
		playable.increaseLevel();
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(save));
			out.writeObject(playable);
			out.close();
		} catch (IOException e) {
			System.out.println("Error processing file.");
		}
		}
		else{
		System.out.println("Congrats, you have beaten all challenges ");
		}
	}
	/**
	 * has the player go to the room of their choosing
	 * @param playable the character the player controls
	 * @param option the room they want to enter
	 * @param youAreHere the coordinates of the user
	 * @param l level user s playing
	 * @return true if the ending is reached otherwise it returns false
	 */
	public static boolean goToRoom(Character playable, int option,
			Point youAreHere, Level l,boolean endingReached) {
		char typeOfRoom = 0;
		Point ranToWall = ((Hero) playable).getLocation();
		switch (option) {
		case 1:
			typeOfRoom = ((Hero) playable).goNorth(l);
			youAreHere = ((Hero) playable).getLocation();
			l.displayMap(youAreHere);
			break;
		case 2:
			typeOfRoom = ((Hero) playable).goSouth(l);
			youAreHere = ((Hero) playable).getLocation();
			l.displayMap(youAreHere);
			break;

		case 3:
			typeOfRoom = ((Hero) playable).goEast(l);
			youAreHere = ((Hero) playable).getLocation();
			l.displayMap(youAreHere);
			break;
		case 4:
			typeOfRoom = ((Hero) playable).goWest(l);
			youAreHere = ((Hero) playable).getLocation();
			l.displayMap(youAreHere);
			break;
		}
		if (ranToWall != youAreHere) {
			if (typeOfRoom == 'm') {
				typeOfRoom = battle(playable, l, youAreHere,endingReached);
				if(typeOfRoom == 'f'){
					endingReached = true;
				}
			} else if (typeOfRoom == 'i') {
				pickUpItems(playable);
				l.displayMap(youAreHere);
			} else if (typeOfRoom == 's') {
				sellItems(playable);
				l.displayMap(youAreHere);
			} else if (typeOfRoom == 'f') {
				System.out.println("You have beaten this level");

				endingReached = true;
			}
		}
		return endingReached;
	}

	/**
	 * method allows the player to pickup item 
	 * @param playable the character the player controls
	 */
	public static void pickUpItems(Character playable) {
		ItemGenerator ig = new ItemGenerator();
		Item randomItem = ig.generateItem();
		System.out.println("Current items in inventory are ");
		for (int i = 0; i < ((Hero) playable).getItems().size(); i++) {
			System.out.println(i + ") "
					+ ((Hero) playable).getItems().get(i).getName());
		}

		System.out.println("You find a " + randomItem.getName());
		System.out.println("Do you wish to pick up? ");
		System.out.println("1) Pick Up");
		System.out.println("2) Sell ");
		int takeItem = checkInput(1, 2);
		switch (takeItem) {
		case 1:
			if (randomItem.getName().equals("Bag o' Gold")) {
				playable.collectGold(randomItem.getValue());
			}
			else{
			((Hero) playable).pickupItem(randomItem);
			}
			break;
		case 2:
			playable.collectGold(randomItem.getValue());
		}
	}
	/**
	 * allows the player to sell the items they have
	 * @param playable the character the user plays as
	 */
	public static void sellItems(Character playable) {
		for (int i = 0; i < ((Hero) playable).getItems().size(); i++) {
			System.out.println(i + ") "
					+ ((Hero) playable).getItems().get(i).getName());
		}
		System.out.println("Do you wish to sell items? ");
		System.out.println("1) Yes");
		System.out.println("2) No");

		Scanner input = new Scanner(System.in);
		int option = checkInput(1, 2);
		switch (option) {
		case 1:
			if (((Hero) playable).getItems().size() != 0) {
				boolean allDone = false;
				do {
					System.out.println("Which do you want to sell");
					for (int i = 0; i < ((Hero) playable).getItems().size(); i++) {
						System.out.println(i + ") "
								+ ((Hero) playable).getItems().get(i).getName());
					}
					int choice = checkInput(0, ((Hero) playable).getItems()
							.size());
					playable.collectGold(((Hero) playable).getItems()
							.get(choice).getValue());
					((Hero) playable).removeItem(choice);
					if(((Hero) playable).getItems().size() > 0){
					System.out.println("Done selling?");
					System.out.println("1) Yes");
					System.out.println("2) No");
					}
					int selling = checkInput(1, 2);
					
					switch (selling) {
					case 1:
						allDone = true;
						break;
					case 2:
						allDone = false;
						break;
					}
				} while (allDone == false);
			} else {
				System.out.println("You have no items to sell");
			}
			break;
		case 2:
			System.out.println("You chose not to sell items");
			break;
		}
	}
	/**
	 * has the character start a fight with an enemy
	 * @param playable the character the player plays as
	 * @param l the level the user is playing
	 * @param youAreHere the point where the user currently is
	 * @return the character based on the type of room the user landed on
	 */
	public static char battle(Character playable, Level l, Point youAreHere, boolean endingReached) {
		EnemyGenerator eg = new EnemyGenerator();
		Enemy monster = eg.generateEnemy(playable.getLevel());
		char typeOfRoom = 0;
		System.out.println(monster.getName() + " has appeared ");
		System.out.println("It has " + monster.getHp() + " health");
		System.out.println("Your Hp left is : " + playable.getHp());
		boolean haveHpPot = false;
		boolean engage = true;
		do {
			System.out.println("Which option");
			System.out.println("1) Fight the monster");
			System.out.println("2) Run ");
			int option;
			for (int i = 0; i < ((Hero) playable).getItems().size(); i++) {
				if (((Hero) playable).getItems().get(i).getName()
						.equals("Health Potion")) {
					haveHpPot = true;

				}
			}
			if (haveHpPot == true) {
				System.out.println("3) Heal");
				option = checkInput(1, 3);
			} else {
				option = checkInput(1, 2);
			}
			if (playable.getHp() != 0) {
				switch (option) {
				case 1:
					fight(playable, monster);
					if (monster.getHp() == 0) {
						engage = false;
					}
					break;
				case 2:
					System.out.println("During your escape: ");
					((Enemy) monster).attack(playable);
					System.out.println("Your current hp is: "
							+ playable.getHp());
					youAreHere = run(playable, monster, l, youAreHere, endingReached);
					typeOfRoom = l.getRoom(youAreHere);
					if(typeOfRoom == 'f' ){
						endingReached = true;
					}
					engage = false;
					break;
				case 3:
					heal(playable);
					break;
				}

			} else {
				System.out.println("GG You have died");
				engage = false;
			}
		} while (engage == true);
		System.out.println("\n");
		l.displayMap(youAreHere);
		return typeOfRoom;
	}
	/**
	 * method has the player heal
	 * @param playable the character the user plays as
	 */
	public static void heal(Character playable) {
		for (int i = 0; i < ((Hero) playable).getItems().size(); i++) {
			if ((((Hero) playable).getItems().get(i).getName()
					.equals("Health Potion"))) {
				((Hero) playable).heal(15 * playable.getLevel());
				if (playable.getHp() > 15 * playable.getLevel()) {
					int fullHeal = playable.getHp() - 15 * playable.getLevel();
					playable.takeDamage(fullHeal);
					((Hero) playable).getItems().remove(
							((Hero) playable).getItems().get(i));
					i = ((Hero) playable).getItems().size();
					System.out.println("You are back at full hp");
				}

			}
		}
	}
	/**
	 * has the hero and the enemy engage in a fight
	 * @param playable the player the user controls
	 * @param monster the enemy to be slain 
	 */
	public static void fight(Character playable, Character monster) {
		Scanner input = new Scanner(System.in);
		((Hero) playable).attack(monster);
		((Enemy) monster).attack(playable);
		System.out.println("Your current hp is: " + playable.getHp());
		System.out.println("Enemy hp is: " + monster.getHp());
		if (monster.getHp() == 0) {
			playable.collectGold(monster.getGold());
			System.out.println("What do you wish to do with the item "
					+ ((Enemy) monster).getItem().getName());

			System.out.println("1) Pick up");
			System.out.println("2) Sell");
			int option = checkInput(1, 2);
			switch (option) {
			case 1:
				if (((Enemy) monster).getItem().getName().equals("Bag o' Gold")) {
					playable.collectGold(((Enemy) monster).getItem().getValue());
				} 
				else {
					if (((Hero) playable).pickupItem(((Enemy) monster)
							.getItem()) == true) {
						System.out.println("Item has been added to inventory");

					} 
					else {
						System.out.println("Not enough room");
						System.out
								.println("Do you wish to sell it instead? \n y/n");
						String sell = input.next();
						if (sell == "y") {
							playable.collectGold(((Enemy) monster).getItem()
									.getValue());
						}

					}
				}
				break;
			case 2:
				playable.collectGold(((Enemy) monster).getItem().getValue());
				break;
			}
		}
	}
	/**
	 * has the user run away into a random room
	 * @param playable the character the user plays as
	 * @param monster the enemy
	 * @param l level the user is in
	 * @param youAreHere the point where the player is
	 * @return the point in which the character ran to
	 */
	public static Point run(Character playable, Character monster, Level l,
			Point youAreHere, boolean endingReached) {
		Random number = new Random();
		int runToUnknownDoor = number.nextInt(4) + 1;
		Point preMoveLocation = ((Hero) playable).getLocation();
		char typeOfRoom = 0;
		do {
			switch (runToUnknownDoor) {
			case 1:
				typeOfRoom = ((Hero) playable).goNorth(l);
				runToUnknownDoor = number.nextInt(4) + 1;
				break;
			case 2:
				typeOfRoom = ((Hero) playable).goSouth(l);
				runToUnknownDoor = number.nextInt(4) + 1;
				break;
			case 3:
				typeOfRoom = ((Hero) playable).goEast(l);
				runToUnknownDoor = number.nextInt(4) + 1;
				break;
			case 4:
				typeOfRoom = ((Hero) playable).goWest(l);
				runToUnknownDoor = number.nextInt(4) + 1;
				break;
			}
			youAreHere = ((Hero) playable).getLocation();
		} while (((Hero) playable).getLocation() == preMoveLocation);
		if (typeOfRoom == 'm') {
			battle(playable, l, youAreHere, endingReached);
		} else if (typeOfRoom == 's') {
			sellItems(playable);
		} else if (typeOfRoom == 'i') {
			pickUpItems(playable);
		} else if (typeOfRoom == 'f') {
			endingReached = true;
		}
		return ((Hero) playable).getLocation();
	}
	/**
	 * method checks for a valid input
	 * @param low the lower bound
	 * @param high upper bound
	 * @return the value
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
