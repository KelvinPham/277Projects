import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * class generates a random item
 * @author Kelvin 
 */
public class ItemGenerator {
	/**
	 * array to hold list of all possible items
	 */
	private ArrayList<Item> itemList;
	/**
	 * reads the itemlist file and stores all the possible items in an arraylist
	 */
	public ItemGenerator() {
		itemList = new ArrayList<Item>();
		try {
			Scanner read = new Scanner(new File("ItemList.txt"));
			do {
				String in = read.nextLine();
				Scanner readItems = new Scanner(in);
				readItems.useDelimiter(",");
				String itemName = readItems.next();
				int goldValue = readItems.nextInt();
				itemList.add(new Item(itemName, goldValue));
			} while (read.hasNextLine());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not Found");
		}
	}
	/**
	 * generates a random item based on whats in the list
	 * @return the item generated
	 */
	public Item generateItem() {
		Random number = new Random();
		int index = number.nextInt(itemList.size());
		Item randomItem = itemList.get(index);
		 randomItem = new Item(randomItem.getName(), randomItem.getValue());
		return randomItem;
	}
}
