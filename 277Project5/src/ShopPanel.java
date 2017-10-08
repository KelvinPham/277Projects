import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

/**
 * the class is the shop panel 
 * @author Kelvin
 *
 */
public class ShopPanel extends JPanel implements MouseListener {
	/**
	 * the list of towers you can bu
	 */
	private ArrayList<Tower> towers;
	/**
	 * constructor for shop panel
	 */
	public ShopPanel() {
		JButton tower1;
		JButton tower2;
		setLayout(null);
		setPreferredSize(new Dimension(300,300));
		try {
			Scanner read = new Scanner(new File("TowerList.txt"));
			do {
				String towerStats = read.nextLine();
				String[] seperateElements = towerStats.split(",");
				String towerType = seperateElements[0];
				String attack = seperateElements[1];
				String range = seperateElements[2];
				String cost = seperateElements[3];
				towers.add(new Tower( Integer.parseInt(towerType),
						Integer.parseInt(attack),Double.parseDouble(range),
						Integer.parseInt(cost)));
			} while (read.hasNext());
		} catch (FileNotFoundException fnf) {
			System.out.println("File not Found");
		}
	}
	
	/**
	 * method draws towers
	 * @param g graphics
	 */
	public void drawTowers(Graphics g){
		for(int i = 0; i < towers.size(); i++){
			towers.get(i).drawRectangle(g);
		}
	}
	
	@Override
	/**
	 * method is called when a mouse is click under certain events
	 * @param e the event
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * method is called when a mouse is entered under certain events
	 * @param e the event
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * method is called when a mouse is exited under certain events
	 * @param e the event
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * method is called when a mouse is pressed under certain events
	 * @param e the event
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * method is called when a mouse is released under certain events
	 * @param e the event
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
