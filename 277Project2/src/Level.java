import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 * level the character is in
 * @author Kelvin
 */
public class Level {
	/**
	 * the type of rooms in the level
	 */
	private char level[][];

	/**
	 * constructor for the level
	 */
	public Level() {
		level = new char[4][4];
	}

	/**
	 * method reads the level and creates it
	 * @param levelNum the level number to be created
	 */
	public void generateLevel(int levelNum) {
		Scanner read;
			try {
				read = new Scanner(new File("Level"+levelNum+".txt"));
				int i = 0;
				do {
					String maze = read.nextLine();
					for (int j = 0; j < 4; j++) {
						level[i][j] = maze.charAt(j);
					}
					i = i + 1;
				} while (read.hasNextLine());
				read.close();
			} catch (FileNotFoundException fnf) {
				System.out.println("File not found.");
			}
		}

	/**
	 * gets the current room the player is at
	 * @param p the point of the room
 	 * @return the type of room the player is at
 	 */
	public char getRoom(Point p) {
		int x = (int) p.getX();
		int y = (int) p.getY();
		if(x < 0 || x > 3 || y < 0 || y > 3) {
			System.out.println("Error you hit a wall");
			if(x < 0 ){
				x = x + 1;
			}
			else if (x > 3){
				x = x - 1;
			}
			else if (y < 0){
			y = y + 1;
			}
			else if(y > 3){
			y = y - 1;
			}
			p.setLocation(new Point(x , y));
			p = p.getLocation();
		}
		return level[y][x];
	}

	/**
	 * displays the map for the player
	 * @param p the point where the character is
	 */
	public void displayMap(Point p) {
		int x = (int) p.getX();
		int y = (int) p.getY();
		char playerLocation = '*';
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level.length; j++) {
				if (j == x && i == y) {
					System.out.print(playerLocation + " ");
				} else {
					System.out.print(level[i][j] + " ");

				}
			}
			System.out.println(" ");

		}
	}

	/**
	 * method finds the starting location of the level
	 * @return start starting position
	 */
	public Point findStartLocation() {
		Point start = new Point(0, 0);
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level[0].length; j++) {
				if (level[i][j] == 's') {
					start.setLocation(j, i);
				}
			}
		}
		return start;
	}
}
