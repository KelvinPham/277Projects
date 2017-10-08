import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * class is the block that draws the different types of land
 * @author Kelvin
 *
 */
public class Block extends Rectangle {
	/**
	 * where to place the block
	 */
	private Point upperLeftCorner;
	/**
	 * width of the block
	 */
	private int width = 40;
	/**
	 * height of the block
	 */
	private int height = 40;
	/**
	 * type of block
	 */
	private int type;

	/**
	 * constructor for block
	 * @param p where to place block
	 * @param t type
	 */
	public Block(Point p, int t) {
		upperLeftCorner = p;
		type = t;
	}

	/**
	 * accessor for the type
	 * @return type of block
	 */
	public int getType() {
		return type;
	}

	/**
	 * draws the block depending on the type
	 * @param g graphics
	 */
	public void drawRectangle(Graphics g) {
		switch (type) {
		case 0:
			g.setColor(Color.GREEN);
			g.fillRect( upperLeftCorner.x, upperLeftCorner.y, width, height);
			break;
		case 1:
			g.setColor(Color.GRAY);
			g.fillRect( upperLeftCorner.x, upperLeftCorner.y, width, height);
			break;
		case 2:
			g.setColor(Color.YELLOW);
			g.fillRect( upperLeftCorner.x, upperLeftCorner.y, width, height);
			break;
		case 3:
			g.setColor(Color.BLUE);
			g.fillRect( upperLeftCorner.x, upperLeftCorner.y, width, height);
			break;
		}
	}
}
