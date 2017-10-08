import java.awt.*;

import javax.swing.*;
/**
 * class is the player panel that gives the players stats
 * @author Kelvin
 *
 */
public class PlayerPanel extends JPanel implements Runnable{
	/**
	 * player of the game
	 */
	Player p = new Player(100, 100, 1, null); 
	
	/**
	 * constructor for the panel
	 */
	public PlayerPanel(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel health = new JLabel("HP" + ": " +p.getHp());
		JLabel coins = new JLabel("Coins" + ": " + p.getCoins());
		JLabel level = new JLabel("Level" + ": " + p.getLevel());
		add(health);
		add(coins);
		add(level);
	}
	@Override
	/**
	 * method is called when using thread start() function
	 */
	public void run() {
		// TODO Auto-generated method stub
	}

}
