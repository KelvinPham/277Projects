/**
 * a subclass of entity that gives a template for droids
 * @author Kelvin
 */
public abstract class Droid extends Entity {
	/**
	 * the number of task a droid has
	 */
	private int numTask;

	/**
	 * construtor for the droid
	 * @param n name
	 * @param h health
	 */
	public Droid( String n, int h ) {
		super ( n, h );
	}

	/**
	 * accessor for number of task
	 * @return number of task
	 */
	public int getNumTask() {
		return numTask;
	}

	/**
	 * tells which task to do
	 */
	public void useTask() {

	}
}
