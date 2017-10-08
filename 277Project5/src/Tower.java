import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Tower extends Rectangle {

	/**
	 * the point at which tower is placed
	 */
	private Point upperLeftCorner;
	/**
	 * width of the tower
	 */
	private int width;
	/**
	 * height of tower
	 */
	private int height;
	/**
	 * identifies which type of tower it is
	 */
	private int type;
	/**
	 * a tower's attack power
	 */
	private int attack;
	/**
	 * range of tower
	 */
	private double range;
	/**
	 * cost of tower
	 */
	private int cost;

	/**
	 * constructor for the tower
	 * @param t type
	 * @param a  attack
	 * @param r range
	 * @param c cost
	 */
	public Tower(int t, int a, double r, int c) {
		type = t;
		attack = a;
		range = r;
		cost = c;
	}

	public int getType() {
		return type;
	}

	/**
	 * accessor for the tower's width
	 * @return the width of the tower
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * accessor for the height
	 * @returns height of tower
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * accessor for the attack power of tower
	 * @return the attack power
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * accessor for tower's range
	 * @return range of the tower
	 */
	public double getRange() {
		return range;
	}

	/**
	 * accessor for the cost of tower
	 * @return tower's cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * method has tower attack enemy
	 * @param e enemy being attacked
	 */
	public void fire(Enemy e) {
		e.takeDamage(getAttack());
	}

	/**
	 * method determines if an enemy is in range
	 * @param currentLocation the location of the enemy
	 * @return true if they are in range false otherwise
	 */
	public boolean inRange(Point currentLocation) {
		int x = (int) upperLeftCorner.getX();
		int y = (int) upperLeftCorner.getY();
		if (x - currentLocation.getX() <= getRange()) {
			return true;
		}
		if (y - currentLocation.getY() <= getRange()) {
			return true;
		}
		return false;
	}

	/**
	 * method draws the rectangle of the tower
	 * @param gthe graphics of the tower
	 */
	public void drawRectangle(Graphics g) {
		// g.drawRectangle();
		if (getType() == 1) {
			g.setColor(Color.RED);
			g.fillRect(upperLeftCorner.x, upperLeftCorner.y, width, height);
		} else {
			g.setColor(Color.RED);
			g.fillRect(upperLeftCorner.x, upperLeftCorner.y, width, height);
		}

	}

}
