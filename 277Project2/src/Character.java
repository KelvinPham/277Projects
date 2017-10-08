import java.io.Serializable;
/**
 * Class is the template for hero
 * @author Kelvin
 *
 */
public abstract class Character implements Serializable {
	/**
	 * name of the character
	 */
	private String name;
	/**
	 * the quip of the character
	 */
	private String quip;
	/**
	 * the level of the character
	 */
	private int level;
	/**
	 * the amount of health a character
	 */
	private int hp;
	/**
	 * how much gold you have
	 */
	private int gold;

	/**
	 * method is the constructor that initializes the values
	 * @param n name
	 * @param q quip
	 * @param h health
	 * @param l level
	 * @param g gold
	 */
	public Character(String n, String q, int h, int l, int g) {
		name = n;
		quip = q;
		hp = h ;
		level = l;
		gold = g;
	}
	/**
	 * gives a character the ability to attack
	 * @param C character being attacked
	 */
	public abstract void attack(Character c);
	/**
	* accessor for the character's name
	* @return name the name of character
	*/
	public String getName() {
		return name;
	}
	/**
	* accessor for the quip of the character
	* @return quip the quip of the character
	*/
	public String getQuip() {
		return quip;
	}
	/**
	 * accessor for the hp
	 * @return hp current health value
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * accessor for the level
	 * @return level current level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * accessor for gold a character has
	 * @return gold character has
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * method increases current level by one
	 */
	public void increaseLevel() {
		level = level + 1;
	}
	/**
	 * method heals character
	 * @param h amount of health restored
	 */
	public void heal(int h) {
		hp = hp + h;
	}
	/**
	 * method decreases a characters health based on damage taken
	 * @param h damage taken
	 */
	public void takeDamage(int h) {
		hp = hp - h;
		if (hp < 0) {
			hp = 0;
		}
	}
	/**
	 * method gives character ability to pick up gold
	 * @param g the gold to be added
	 */
	public void collectGold(int g) {
		gold = gold + g;
	}
	/**
	 * displays the stats of a character
	 */
	public void display() {
		System.out.println(name + ", " + hp);
	}
}
