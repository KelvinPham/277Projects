import java.util.Random;

/**
 * a subclass of person
 * @author Kelvin
 */
public class SithLord extends Person implements HasForce {
	private String saberColor;

	/**
	 * constructor that initializes the values
	 * @param n name
	 * @param q quip
	 * @param c weapon
	 */
	public SithLord( String n, String q, String c ) {
		super ( n, 100, "Red LightSaber", q );
	}

	/**
	 * method calculates damage a character does to another
	 */
	@Override
	public void attack( Entity E ) {
		// TODO Auto-generated method stub
		Random number = new Random();
		int sithDamage = number.nextInt( 21 ) + 10;
		int miss = number.nextInt( ( 100 ) + 1);
		if ( miss <= 20 ) {

			System.out.println(getName() + " attack did not hit");

		} else {
			System.out.println(this.getName() + " used his " + getWeapon()
					+ " on " + E.getName() + " for " + sithDamage);
			System.out.print(getName() + " yelled out: ");
			sayCatchPhrase();
			E.modifyHp( sithDamage );
		}
	}

	/**
	 * has the character do his task
	 */
	public void doTask( Entity E ) {
		if ( this.getTask() == "lightsaber" ){
		attack( E );
	}
		else{
			useForce( E );
		}
	}

	/**
	 * gives character ability to use force
	 */
	public void useForce( Entity E ) {
		Random number = new Random();
		int miss = number.nextInt( (100) + 1);
		if (miss <= 20) {

			System.out.println( "Sith missed his attack " );
			this.sayCatchPhrase();
		} else {
			System.out.println( this.getName() + " used the force on "
					+ E.getName() + " for half of " + E.getName() + " hp " );
		}
		int half;
		if ( E.getHp() % 2 == 0) {
			half = ( E.getHp() / 2 );
			E.modifyHp( half );
		} else {
			half = ( ( E.getHp() - 1 ) / 2 );
			E.modifyHp( half );
		}
	}
}
