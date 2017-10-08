import java.io.Serializable;
/**
 * class creates the pattern that will be stored in a hashmap
 * @author Kelvin
 *
 */
public class Pattern implements Serializable {
	/**
	 * the pattern the player has used
	 */
	private String pattern;
/**
 * constructor to initialize the patter
 * @param p string to be a pattern
 */
	public Pattern(String p) {
		pattern = p;
	}
/**
 * accessor for pattern
 * @return the pattern
 */
	public String getPattern() {
		return pattern;
	}

	@Override
	/**
	 * determines if an object is hashable
	 */
	public int hashCode() {
		String hashPattern = pattern;
		return hashPattern.hashCode();
	}

	@Override
	/**
	 * checks to make sure that the pattern is the same or different 
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Pattern)) {
			return false;
		}
		Pattern s = (Pattern) o;
		return pattern.equals(s.getPattern());
	}
}