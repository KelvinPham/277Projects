import java.util.ArrayList;

/**
 * class is the template for the player
 * 
 * @author Kelvin
 *
 */
public class Player {
	/**
	 * amount of hp player has
	 */
	private int hp;
	/**
	 * amount of coins player has
	 */
	private int coins;
	/**
	 * the level of the player
	 */
	private int level;
	/**
	 * all the towers the player owns
	 */
	private ArrayList<Tower> towers;
/**
 * constructor for the player
 * @param h starting health
 * @param c starting gold
 * @param l starting level
 * @param t starting towers
 */
	public Player(int h, int c, int l, ArrayList<Tower> t) {
		hp = h;
		coins = c;
		level = l;
		towers = t;
	}
/**
 * accessor for hp
 * @return hp
 */
	public int getHp() {
		return hp;
	}
/**
 * accessor for coins
 * @return coins
 */
	public int getCoins() {
		return coins;
	}
/**
 * accessor for level
 * @return level
 */
	public int getLevel() {
		return level;
	}
/**
 * method adds coins to what player currently has
 * @param increase number of coins
 * @return total number of coins player owns
 */
	public int gainMoney(int increase) {
		return (coins + increase);
	}
/**
 * method subtracts amount of coins spent from the player
 * @param spent amount of gold spent
 * @return the remaining gold player has
 */
	public int spendMoney(int spent) {
		return (coins - spent);
	}
/**
 * method has the player take damage
 * @param damage amount of damage taken
 * @return remaining hp the player has
 */
	public int takeDamage(int damage) {
		return (hp - damage);
	}
/**
 * method increases the level
 * @return the level after increase
 */
	public int increaseLevel() {
		level++;
		return level;
	}
}
