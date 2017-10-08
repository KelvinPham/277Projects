import java.util.Random;

/**
 * a subclass of person
 * @author Kelvin
 *
 */
public class Jedi extends Person implements Healable, HasForce {
	/**
	 * the color of the lightsaber the jedi uses
	 */
	private String saberColor;

	public Jedi( String n, String q, String c ) {
		super ( n, 100, "Blue lightsaber", q );
	}

	/**
	 * method calculates damage one character does to another
	 */
	@Override
	public void attack( Entity E ) {
		// TODO Auto-generated method stub
		Random number = new Random();
		int jediDamage = number.nextInt( 16 ) + 10;
		int miss = number.nextInt( ( 100 ) + 1);
		if ( miss <= 20 ) {

			System.out.println( "Your attack did not hit" );

		} else {
			System.out.println( this.getName() + " used his " + getWeapon()
					+ " on " + E.getName() + " for " + jediDamage );
			System.out.print( this.getName() + " yelled out: " );
			this.sayCatchPhrase();
			E.modifyHp( jediDamage );
		}
	}

	/**
	 * method has character do the task at hand
	 */
	public void doTask(Entity E) {
		if ( getTask() == "lightsaber" ) {
			attack(E);
		}
			else{
				useForce( E );
			}
		}

	/**
	 * heals the character
	 */
	public void heal( int hp ) {
		this.modifyHp( -100 );
		if ( this.getHp() > 100 ) {
			int fullHeal = this.getHp() - 100;
			this.modifyHp( fullHeal );
		}
	}

	/**
	 * allows character to use the force
	 */
	public void useForce( Entity E ) {
		Random number = new Random();
		int miss = number.nextInt( (100) + 1);
		if ( miss <= 20 ) {

			System.out.println("Your attack did not hit");
		} else {
			System.out.println(this.getName() + " used the force on "
					+ E.getName() + " for half of " + E.getName() + " hp ");
		}
		int half;
		if ( E.getHp() % 2 == 0 ) {
			half = ( E.getHp() / 2 );
			E.modifyHp(half);
		} else {
			half = ( (E.getHp() - 1) / 2);
			E.modifyHp( half );
		}
	}
}
