/**
 * a subclass of the superclass entity
 * @author Kelvin
 */
public class Door extends Entity {
	/**
	 * construtor for the door
	 * @param n name of the door
	 */
	public Door( String n ) {
		super ( n, 20 );
	}

	/**
	 * has the entity do the task at hand
	 */
	@Override
	public void doTask( Entity E ) {
		// TODO Auto-generated method stub
		E.modifyHp( E.getHp() );
	}
}
