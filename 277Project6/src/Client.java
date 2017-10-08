import java.net.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class is the client that
 * @author Kelvin
 */
public class Client extends JPanel implements ActionListener {
	/**
	 * a button on the frame for rock
	 */
	private JButton rock;
	/**
	 * button on he frame for paper
	 */
	private JButton paper;
	/**
	 * button on the frame for scissors
	 */
	private JButton scissors;
	/**
	 * group of buttons
	 */
	private ButtonGroup choices;
	/**
	 * button to allow the user to exit
	 */
	private JRadioButton quit;
	/**
	 * score the computer has
	 */
	private int computerScore = 0;
	/**
	 * the option computer choose
	 */
	private String computerChoice = "";
	/**
	 * option player chooses
	 */
	private String choice = "";
	/**
	 * how many tie rounds
	 */
	private int tie = 0;
	/**
	 * score you have
	 */
	private int yourScore = 0;
	/**
	 * message that the client is receiving
	 */
	private BufferedReader in = null;
	/**
	 * message the client is sending
	 */
	private PrintStream out = null;
	/**
	 * picture used for rock
	 */
	private BufferedImage rockPic;
	/**
	 * picture used for paper
	 */
	private BufferedImage paperPic;
	/**
	 * picture used for scissors
	 */
	private BufferedImage scissorPic;

	/**
	 * constructor for the client 
	 */
	public Client() {
		Socket sock;
		try {
			rockPic = ImageIO.read(new File("the_rock_obama.jpg"));
			paperPic = ImageIO.read(new File("paperRoll.jpg"));
			scissorPic = ImageIO.read(new File("edward_scissorhands_prop.jpg"));

		} catch (IOException e) {

		}
		rock = new JButton();
		rock.setIcon(new ImageIcon(rockPic));
		paper = new JButton();
		paper.setIcon(new ImageIcon(paperPic));
		scissors = new JButton();
		scissors.setIcon(new ImageIcon(scissorPic));
		quit = new JRadioButton("Quit");
		choices = new ButtonGroup();
		add(rock);
		add(paper);
		add(scissors);
		add(quit);
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		quit.addActionListener(this);

		try {
			sock = new Socket("localhost", 1235);
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			out = new PrintStream(sock.getOutputStream());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) {
		Frame f = new Frame();
		f.setTitle("RPS");
		f.setBackground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	/**
	 * method determines the results of the user's choice vs the computer's
	 * @param choice the user's choice
	 * @param computerChoice the choice the computer makes
	 * @return the result if its win or lose
	 */
	public static String fightTheComp(String choice, String computerChoice) {
		String result = "";
		if (choice.equals(computerChoice)) {
			result = "Tie";
		} else if (choice.equals("R") && computerChoice.equals("P")) {
			result = "Lose";
		} else if (choice.equals("R") && computerChoice.equals("S")) {
			result = "Win";
		} else if (choice.equals("P") && computerChoice.equals("R")) {
			result = "Win";
		} else if (choice.equals("P") && computerChoice.equals("S")) {
			result = "Lose";
		} else if (choice.equals("S") && computerChoice.equals("R")) {
			result = "Lose";
		} else if (choice.equals("S") && computerChoice.equals("P")) {
			result = "Win";
		}
		return result;
	}

	
	@Override
	/**
	 * method is called whenever an option is chosen on the frame
	 * @param e the event used
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == rock) {
			choice = "R";
		} else if (e.getSource() == paper) {
			choice = "P";
		} else if (e.getSource() == scissors) {
			choice = "S";
		} else {
			System.exit(0);
		}

		out.println(choice);
		out.flush();
		try {
			computerChoice = in.readLine();
		} catch (IOException io) {
		}

		String result = fightTheComp(choice, computerChoice);

		if (result == "Lose") {
			computerScore++;
		} else if (result == "Win") {
			yourScore++;
		} else {
			tie++;
		}
		repaint();
	}

	/**
	 * method paints the frame accordingly
	 * @param g the graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	/**
	 * draws on the frame accordingly
	 * @param g the graphics
	 */
	public void draw(Graphics g) {
		g.drawString("Computer", 200, 550);
		String compScore = "" + computerScore;
		g.drawString(compScore, 205, 565);
		g.drawString("Draw", 300, 550);
		String draw = "" + tie;
		g.drawString(draw, 305, 565);
		g.drawString("Player", 400, 550);
		String playerScore = "" + yourScore;
		g.drawString(playerScore, 400, 565);
		g.drawString("Your choice", 200, 300);
		g.drawString("Computer: Optimal Strategy", 700, 300);
		if (choice.equals("R")) {
			g.drawImage(rockPic, 200, 350, this);
		}
		if (choice.equals("P")) {
			g.drawImage(paperPic, 200, 350, this);
		}
		if (choice.equals("S")) {
			g.drawImage(scissorPic, 200, 350, this);
		}
		if (computerChoice.equals("R")) {
			g.drawImage(rockPic, 700, 350, this);
		}
		if (computerChoice.equals("P")) {
			g.drawImage(paperPic, 700, 350, this);
		}
		if (computerChoice.equals("S")) {
			g.drawImage(scissorPic, 700, 350, this);
		}

	}
}
