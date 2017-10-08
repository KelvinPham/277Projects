import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * class is the server
 * @author Kelvin
 */
public class Server {

public static void main(String[] args) {
	ServerSocket server;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	Computer computer = new Computer();
	try {
		server = new ServerSocket(1235);
		System.out.println("Waiting...");
		sock = server.accept();
		System.out.println("Connected: ");
		in = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream());
		String playerHistory = "";
		String strategy = "";
		while( true ) {
			System.out.println("Evaluating Options...");
			strategy = computer.makePrediction(playerHistory);
			String playerChoice = in.readLine();
			if(playerHistory.length() == 4){
				playerHistory = playerHistory.substring(1);
			}
			playerHistory = playerHistory + playerChoice;
			System.out.println("Optimal strategy: " + strategy);
			out.println(strategy);
			out.flush();
		}
	}
	catch (Exception e) {
	}
}
}
