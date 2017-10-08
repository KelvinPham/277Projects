import java.util.Random;

/**
 * a subclass of person
 * 
 * @author Kelvin
 *
 */
public class Rebel extends Person implements Healable {
	/**
	 * constructor for rebel
	 * @param n name
	 * @param q quip
	 */
	public Rebel( String n, String q ) {
		super ( n, 50, "Blasting Rifle", q ) ;
	}

	/**
	 * method that calculates damage a character does to another
	 */
	@Override
	public void attack ( Entity E ) {
		// TODO Auto-generated method stub
		Random number = new Random();
		int rebelDamage = number.nextInt(6) + 10;
		int miss = number.nextInt( (100) + 1 );
		if ( miss <= 20 ) {

			System.out.println( getName() + " missed their attack");

		} else {
			System.out.println( this.getName() + " used his " + getWeapon()
					+ " on " + E.getName() + " for " + rebelDamage);
			System.out.print( getName() + " yelled out: ");
			sayCatchPhrase();

			E.modifyHp ( rebelDamage );

		}
	}

	/**
	 * the task the character has to do
	 */
	@Override
	public void doTask ( Entity E ) {
		// TODO Auto-generated method stub
		attack ( E );

	}

	/**
	 * method allows for character to be healed
	 * @param hp health to be restored
	 */
	public void heal ( int hp ) {
		this.modifyHp( -hp );
		if ( this.getHp() > 50 ) {
			int fullHealth = this.getHp() - 50;
			this.modifyHp( fullHealth );
		}
	}
}
