import java.awt.*;

import javax.swing.*;
/**
 * Class is the frame
 * @author Kelvin
 *
 */
public class Frame extends JFrame {
	/**
	 * client used to connect to server
	 */
	private Client c = new Client();
	/**
	 * constructor to the frame
	 */
	public Frame() {
		setBounds(100, 100, 1000, 1000);
		getContentPane().add(c,BorderLayout.CENTER);
	}
}


