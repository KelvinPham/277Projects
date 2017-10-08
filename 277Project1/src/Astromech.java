/**
 * class reates the template of an astromech droid
 * @author Kelvin
 */

public class Astromech extends Droid {
	/**
	 * 
	 * @param n
	 */
	public Astromech( String n ) {
		super ( n, 20 );
	}

	@Override
	/**
	 * method has the astromech do his task
	 */
	public void doTask( Entity E ) {
		E.modifyHp( E.getHp() );
		System.out.println( getName() + " has successfully accessed "
				+ E.getName() );
	}
}
