/**
 * class creates a song
 * @author Kelvin
 */

public class Song implements Comparable<Song> {
	/**
	 * this variable is the name of the song
	 */
	private String songName;
	/**
	 * this variable is the artist of the song
	 */
	private String artist;
	/**
	 * this variable gives the album the song belongs to
	 */
	private String album;
	/**
	 * this variable gives the duration of the song
	 */
	private int rating;

	/**
	 * constructor of the class
	 * @param songName name of the song
	 * @param artist name of the singer
	 * @param album name of the album
	 * @param rating how long the song is
	 */
	public Song(String songName, String artist, String album, int rating) {
		this.songName = songName;
		this.artist = artist;
		this.album = album;
		this.rating = rating;
	}

	/**
	 * accessor of songName
	 * @return songName
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * accessor for artist 
	 * @return artist
	 */
	public String getArtist() {
		return artist;

	}

	/**
	 * Accessor for album
	 * @return album of song
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * Accessor for rating
	 * @return rating of song
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * method formats songs
	 */

	public String toString() {
		String format = songName + "," + artist + "," + album + "," + rating;
		return format;
	}

	/**
	 * compares 2 songs
	 * @param o song to be compared
	 * @return returns an integer to determine if they are in order
	 */

	@Override
	public int compareTo(Song o) {
		if (rating == o.getRating()) {
			return songName.compareToIgnoreCase(o.getSongName());
		} else if (rating > o.getRating()) {
			return -1;
		} else {
			return 1;
		}

	}

}