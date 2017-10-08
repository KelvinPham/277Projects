import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * class generates a random enemy
 * @author Kelvin
 *
 */
public class EnemyGenerator {
	/**
	 * arraylist of all possible enemies
	 */
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

	/**
	 * constructor that reads the enemylist and stores it in the arraylist full
	 * of possible enemies
	 */
	public EnemyGenerator() {
		try {
			Scanner read = new Scanner(new File("EnemyList.txt"));
			do {
				String in = read.nextLine();
				Scanner readEnemies = new Scanner(in);
				readEnemies.useDelimiter(",");
				String name = readEnemies.next();
				int health = readEnemies.nextInt();
				int level = readEnemies.nextInt();
				int gold = readEnemies.nextInt();
				int speed = readEnemies.nextInt();
				enemyList.add(new Enemy(name, health, gold, speed));
			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not Found");
		}
	}

	/**
	 * methods generates a random enemy based on whats in the arraylist
	 * 
	 * @param level
	 *            current level of the enemy
	 * @return the enemy generated
	 */
	public Enemy generateEnemy(int level) {
		Random number = new Random();
		int index = number.nextInt(enemyList.size());
		Enemy randomEnemy = enemyList.get(index);
		randomEnemy = new Enemy(randomEnemy.getName(), randomEnemy.getHp() + level,
				randomEnemy.getCoins() + 2*level, randomEnemy.getSpeed() + level);
		return randomEnemy;
	}
}