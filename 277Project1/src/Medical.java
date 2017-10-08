/**
 * class creates the template of a medical droid
 * @author Kelvin
 */
public class Medical extends Droid {
	/**
	 * constructor for the medical droid
	 * @param n name
	 * @param h health
	 */
	public Medical( String n, int h ) {
		super ( n, 20 );
	}

	/**
	 * method tells the droid to do task
	 */
	public void doTask( Entity E ) {
		if( E instanceof Healable ){
			( (Healable) E).heal( 100 );
		}
	}
}
