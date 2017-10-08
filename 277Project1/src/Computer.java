/**
 * a subclass of the superclass entity
 * @author Kelvin
 */
public class Computer extends Entity {
	/**
	 * constructor
	 * @param n name
	 */
	public Computer( String n ) {
		super ( n, 20 );
	}

	/**
	 * method has entity do the task at hand
	 */
	@Override
	public void doTask( Entity E ) {
		// TODO Auto-generated method stub
		E.modifyHp( E.getHp() );
	}
}
