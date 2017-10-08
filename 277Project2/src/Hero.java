import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
/**
 * Class is the hero the user plays as
 * @author Kelvin
 *
 */
public class Hero extends Character implements Serializable {
	/**
	 * items the playable character has
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * location of the player given in coordinates
	 */
	private Point location;
	/**
	 * constructor of the character
	 * @param n name
	 * @param q quip
	 * @param start starting location
	 */
	public Hero(String n, String q, Point start) {
		super(n, q, 15, 1, 10);
		location = start;
	}
	/**
	 * accessor for the items the playable character has
	 * @return items the list of items the character is carrying
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/**
	 * allows the user to pick up items given they have less than  items in hand
	 * @param i item to be picked up
	 * @return true if item can be picked up, false otherwise
	 */
	public boolean pickupItem(Item i) {
		if(getItems().size() <= 5 ){
			items.add(i);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * remove an item based on the index
	 * @param index
	 */
	public void removeItem(int index) {
		items.remove(items.get(index));
	}
	/**
 	* gets the location of the hero
 	* @return the location of the player
 	*/
	public Point getLocation() {
		return location;
	}
	/**
	 * sets location of the player
	 * @param p the point the player is on
	 */
	public void setLocation(Point p) {
		location = p;
	}
	/**
	 * method has the player move north
	 * @param l the level the player is in
	 * @return the type of room the player lands in
	 */
	public char goNorth(Level l) {
		Point p = getLocation();
		int x = (int) p.getX();
		int y = (int) p.getY();
		if (y > 0) {
			setLocation(new Point(x, y - 1));
			p = getLocation();
		} else {
			System.out.println("Error you hit a wall");
		}
		return l.getRoom(p);
	}
	/**
	 * method has the player move south
	 * @param l level the player is in
	 * @return the type of room the player lands in
	 */
	public char goSouth(Level l) {
		Point p = getLocation();
		int x = (int) p.getX();
		int y = (int) p.getY();
		if (y + 1 < 4) {
			setLocation(new Point(x, y + 1));
			p = getLocation();
		} else {
			System.out.println("Error you hit a wall");
		}

		return l.getRoom(p);
	}
	/**
	 * method has the player move east
	 * @param l level the character is in
	 * @return the type of room the character is in
	 */
	public char goEast(Level l) {
		Point p = getLocation();
		int x = (int) p.getX() ;
		int y = (int) p.getY();
		if (x + 1 < 4) {
			setLocation(new Point(x + 1, y));
			p = getLocation();
		} else {
			System.out.println("Error you hit a wall");
		}
		return l.getRoom(p);
	}
	/**
	 * method has the player go west
	 * @param l level current being played
	 * @return the type of room the player enters
	 */
	public char goWest(Level l) {
		Point p = getLocation();
		int x = (int) p.getX();
		int y = (int) p.getY();
		if (x > 0) {
			setLocation(new Point(x - 1, y));
			p = getLocation();
		} else {
			System.out.println("Error you hit a wall");
		}

		return l.getRoom(p);
	}

	@Override
	/**
	 * method has the player attack the enemy
	 * @param C the character the player attacks
	 */
	public void attack(Character c) {
		// TODO Auto-generated method stub
		Random number = new Random();
		int damage = number.nextInt(5) + 1;
		c.takeDamage(damage*getLevel());
		System.out.println(getName() + " attacked " + c.getName() + " for "
				+ damage * getLevel() + " damage ");
		System.out.println(getName() + " says " + getQuip());
	}

}