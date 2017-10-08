import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;
import java.io.*;
/**
 * class creates the map of game
 * @author Kelvin
 *
 */
public class Map {
	/**
	 * the map
	 */
	private Block[][] map;
	/**
	 * where enemies spawn
	 */
	private Point spawn;
	/**
	 * point to protect
	 */
	private Point home;
	/**
	 * 2D array used to set coordinates of block
	 */
	private int[][] gameBlock;

	/**
	 * constructor of the map
	 */
	public Map() {
		try {
			Scanner read = new Scanner(new File("Map1.txt"));
			int row = read.nextInt();
			int col = read.nextInt();
			map = new Block[row][col];
			gameBlock = new int[row][col];
			int j = 0;
			do {
				for (int i = 0; i < col; i++) {
					gameBlock[j][i] = read.nextInt();
					Block b = new Block(new Point(i * 40, j * 40),
							gameBlock[j][i]);
					map[j][i] = b;
				}
				j++;
			} while (read.hasNext());
			read.close();
			for (int a = 0; a < row; a++) {
				for (int b = 0; b < col; b++) {
					if (gameBlock[a][b] == 2) {
						spawn = new Point(b, a);
					} else if (gameBlock[a][b] == 3) {
						home = new Point(b, a);
					}
				}
				System.out.println(" ");
			}
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found");
		}

	}

	/**
	 * method draws the map
	 * @param g graphics
	 */
	public void drawMap(Graphics g) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 12; j++) {
				map[i][j].drawRectangle(g);
			}
		}
	}

	/**
	 * accessor for the spawn point
	 * @return spawn point
	 */
	public Point getSpawn() {
		return spawn;
	}

	/**
	 * accessor for the home point
	 * @return the home point
	 */
	public Point getHome() {
		return home;
	}

	/**
	 * has the enemy walk through the board until they reach the home point
	 */
	public void walk() {
		Point currentLocation = getSpawn();
		int x = (int) currentLocation.getX();
		int y = (int) currentLocation.getY();
		Point previousLocation = null;
	
			if ((previousLocation.getX() != (currentLocation.getX() - 1) || previousLocation
					.getY() != currentLocation.getY())) {
				if ((gameBlock[y][x - 1] == 1 || gameBlock[y][x - 1] == 3)) {
					currentLocation = new Point(x - 1, y);
				}
			}
			if (previousLocation.getX() != (currentLocation.getX() + 1)
					|| previousLocation.getY() != currentLocation.getY()) {
				if (gameBlock[y][x + 1] == 1 || gameBlock[y][x + 1] == 3) {
					currentLocation = new Point(x + 1, y);
				}
			}
			if (previousLocation.getX() != (currentLocation.getX())
					|| previousLocation.getY() != currentLocation.getY() + 1) {
				if (gameBlock[y - 1][x] == 1 || gameBlock[y - 1][x] == 3) {
					currentLocation = new Point(x, y - 1);
				}
			}
			if (previousLocation.getX() != (currentLocation.getX() - 1)
					|| previousLocation.getY() != currentLocation.getY() + 1) {
				if (gameBlock[y + 1][x] == 1 || gameBlock[y + 1][x] == 3) {
					currentLocation = new Point(x, y + 1);
				}
			}
		}
	
}
