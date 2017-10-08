import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Frame extends JFrame {
	/**
	 * player of the game
	 */
	private Player player;
	/**
	 * map panel on the frame
	 */
	private MapPanel mp;
	/**
	 * player panel on the frame
	 */
	private PlayerPanel pp;

//	 private ShopPanel sp = new ShopPanel();
	
	/**
	 * constructor for the frame
	 */
	public Frame() {
		mp = new MapPanel();
		setBounds(100, 100, 900, 600);
		getContentPane().add(mp, BorderLayout.CENTER);
		pp = new PlayerPanel();
		getContentPane().add(pp, BorderLayout.EAST);
	//	 getContentPane().add(sp, BorderLayout.NORTH);

	}
}
