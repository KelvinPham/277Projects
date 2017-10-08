import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

//work in progress
/**
 * class creates the enemies of the game
 * @author Kelvin
 *
 */
public class Enemy extends Rectangle {
	/**
	 * name of the enemy
	 */
	private String name;
	/**
	 * amount of hp enemy has
	 */
	private int hp;
	/**
	 * how much coins they drop
	 */
	private int coins;
	/**
	 * how fast the enemies are
	 */
	private int speed;

	/**
	 * constructor of the enemy
	 * @param n name
	 * @param h hp
	 * @param c coins
	 * @param s speed
	 */
	public Enemy(String n, int h, int c, int s) {
		name = n;
		hp = h;
		coins = c;
		speed = s;
	}
	
	/**
	 *accessor for enemy name 
	 * @return name of enemy
	 */
	public String getName() {
		return name;
	}

	/**
	 * accessor for enemy hp
	 * @return amount of enemy hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * accessor for how much gold an enemy is worth
	 * @return amount of gold
	 */
	public int getCoins() {
		return coins;
	}

	/**
	 * accessor for speed of enemy
	 * @return speed of enemy
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * method subtracts health from enemy
	 * @param damage damage done to enemy
	 * @return amount of hp an enemy has leftover
	 */
	public int takeDamage(int damage) {
		hp = (hp - damage);
		return hp;
	}

	/**
	 * method draws the enemy
	 * @param g the graphics
	 * @param start where to place the enemy
	 */
	public void drawEnemy(Graphics g, Point start) {
		g.setColor(Color.BLUE);
		g.fillOval(start.x, start.y, 25, 25);
	}
}
