import java.util.Random;

/**
 * the enemies of the game
 * @author Kelvin
 */

public class Enemy extends Character {
	/**
	 * Item the enemy carries
	 */
	private Item item;

	/**
	 * constructor of the enemy
	 * @param n name
	 * @param q quip
	 * @param h hp
	 * @param l level
	 * @param g gold
	 * @param i item
	 */
	public Enemy(String n, String q, int h, int l, int g, Item i) {
		super(n, q, h, l, g);
		item = i;
	}

	/**
	 * accessor for items
	 * @return items of the enemy
	 */
	public Item getItem() {
		return item;
	}

	@Override
	/**
	 * allows the enemy to attack
	 */
	public void attack(Character c) {
		// TODO Auto-generated method stub
		Random number = new Random();
		if (getHp() != 0) {
			int damage = number.nextInt(5) + 1;
			c.takeDamage(damage * getLevel());
			System.out.println(getName() + " attacked " + c.getName() + " for "
					+ damage * getLevel() + " damage ");
			System.out.println(getName() + " says " + getQuip());
		}
	}
}
