import java.util.Random;

/**
 * class is a subclass of person
 * @author Kelvin
 */
public class Stormtrooper extends Person {
	/**
	 * constructor for stormtrooper
	 * @param n name
	 * @param q quip
	 */
	public Stormtrooper ( String n, String q ) {
		super ( n, 50, "Blasting rifle", q );
	}

	/**
	 * method calculates damage stormtrooper does to another character
	 */
	@Override
	public void attack ( Entity E ) {
		// TODO Auto-generated method stub
		Random number = new Random();
		int enemyDamage = number.nextInt( 6 ) + 10;
		int miss = number.nextInt( ( 100 ) + 1);
		if ( miss <= 30 ) {

			System.out.println( this.getName() + " missed his attack " );

		} else {
			System.out.println( this.getName() + " used his " + getWeapon()
					+ " on " + E.getName() + " for " + enemyDamage );
			System.out.print( getName() + " yelled out: " );
			sayCatchPhrase();

			E.modifyHp( enemyDamage );
		}
	}

	/**
	 * overriden method that has character do their task
	 */
	@Override
	public void doTask( Entity E ) {
		// TODO Auto-generated method stub
		attack( E );

	}
}
