import java.io.Serializable;
/**
 * The class is the items that is located in the game
 * @author Kelvin
 */
public class Item implements Serializable {
	/**
	 * item name
	 */
	private String name;
	/**
	 *  value of the item
	 */
	private int goldValue;
	/**
	 * constructor for the items
	 * @param n name of item
	 * @param v gold value of item
	 */
	public Item(String n, int v) {
		name = n;
		goldValue = v;
	}
	/**
	 * accessor for the name of the item
	 * @return name name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * accessor for gold value of item
	 * @return gold value of the item
	 */
	public int getValue() {
		return goldValue;
	}
}
