import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * class is the map panel
 * @author Kelvin
 *
 */
public class MapPanel extends JPanel implements Runnable, MouseListener {
	Map grid = new Map();
	ArrayList<Tower> towers;
	Enemy[] enemy;
	
	/**
	 * constructor for the map Panel
	 */
	public MapPanel(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	/**
	 * method draws the map
	 * @param g the graphics of the map
	 */
	public void paintComponent(Graphics g){
		grid.drawMap(g);
	//	for (int i = 0; i < towers.size(); i++){
		//	towers.get(i).drawRectangle(g);
		//}
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

	@Override
	/**
	 * method is called when using thread start() function
	 */
	public void run() {
		// TODO Auto-generated method stub
		EnemyGenerator eg = new EnemyGenerator();
		Enemy wave = eg.generateEnemy(1);
		enemy = new Enemy[30];
		Point location = grid.getSpawn();
		for(int i = 0; i < enemy.length; i++){
			enemy[i] = wave;
		}
		
	}

}
