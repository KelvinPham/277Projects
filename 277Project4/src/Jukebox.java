import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class functions as a jukebox
 * @author Kelvin
 */
public class Jukebox {
	public static void main(String args[]) {
		Heap<Song> songlist = new Heap<Song>();
		try {
			Scanner read = new Scanner(new File("songs.txt"));
			do {
				String in = read.nextLine();
				Scanner splitSong = new Scanner(in);
				splitSong.useDelimiter(",");
				String songTitle = splitSong.next();
				String artist = splitSong.next();
				String album = splitSong.next();
				int rating = splitSong.nextInt();
				Song music = new Song(songTitle, artist, album, rating);
				songlist.add(music);
			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not Found");
		}
		boolean running = true;
		int current = 0;
		Song currentSong = songlist.getTAt(current);
		do {
			System.out.println("What do you want to do? ");
			System.out.println("1) Display all songs");
			System.out.println("2) Display current song ");
			System.out.println("3) Add song");
			System.out.println("4) Play next song ");
			System.out.println("5) Re-Rate Song");
			System.out.println("6) Quit");
			int option = checkInput(1, 6);
			switch (option) {
			case 1:
				printSongs(songlist);
				break;
			case 2:
				printCurrent(currentSong);
				break;
			case 3:
				addSong(songlist);
				currentSong = songlist.getTAt(current);
				break;
			case 4:
				if (!songlist.isEmpty()) {
					currentSong = nextSong(songlist, currentSong);
				}
				if (currentSong == null) {
					System.out.println("Song list is empty");
				} else {
					printCurrent(currentSong);
				}
				break;
			case 5:
				changeRating(songlist);
				break;
			case 6:
				running = false;
				break;
			}
		} while (running);
	}

	/**
	 * displays the songlist after sorting
	 * @param songlist list of songs
	 */
	public static void printSongs(Heap<Song> songlist) {
		songlist.printHeap();
	}

	/**
	 * prints the current song playing
	 * @param currentSong the song that is playing
	 */
	public static void printCurrent(Song currentSong) {
		System.out.println(currentSong);
	}

	/**
	 * adds a new song to the list
	 * @param songlist the list of songs
	 */
	public static void addSong(Heap<Song> songlist) {
		String songTitle;
		String artist;
		String album;
		int defaultRating = 1;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter song Name");
		songTitle = input.next();
		System.out.println("Enter Artist Name");
		artist = input.next();
		System.out.println("Enter Album Name");
		album = input.next();
		System.out
				.println("Do you wish to input rating? Rating is defaulted at 1");
		System.out.println("1)Yes ");
		System.out.println("2)No ");
		int option = checkInput(1, 2);
		switch (option) {
		case 1:
			defaultRating = checkInput(1, 5);
			break;
		case 2:
			break;
		}
		songlist.add(new Song(songTitle, artist, album, defaultRating));
	}

	/**
	 * plays the next song on the jukebox
	 * @param songlist list of songs
	 * @param currentSong song that is currently playing
	 * @return the new song playing
	 */
	public static Song nextSong(Heap<Song> songlist, Song currentSong) {
		songlist.removeMin();
		if (!songlist.isEmpty()) {
			currentSong = songlist.getTAt(0);
			return currentSong;
		}
		return null;
	}

	/**
	 * changes the rating of a song that is playing
	 * @param songlist
	 */
	public static void changeRating(Heap<Song> songlist) {
		printCurrent(songlist.getTAt(0));
		System.out.println("What do you wish to change the rating to");
		int rating = checkInput(1, 5);
		Song song = songlist.getTAt(0);
		String songName = song.getSongName();
		String artist = song.getArtist();
		String album = song.getAlbum();
		songlist.removeMin();
		song = new Song(songName, artist, album, rating);
		songlist.add(song);
		printSongs(songlist);
	}

	/**
	 * checks the validity of the user inputs 
	 * @param low lower bound
	 * @param high upper bound
	 * @return option of the user
	 */
	public static int checkInput(int low, int high) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int option = 0;
		while (!valid) {

			if (input.hasNextInt()) {
				option = input.nextInt();
				if (option >= low && option <= high) {
					valid = true;
				} else {
					System.out.println("Invalid input. Try Again. ");
				}
			}

			else {
				input.next();
				System.out.println("Invalid input. Try Again. ");

			}
		}
		return option;
	}
}
