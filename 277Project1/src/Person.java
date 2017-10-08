/**
 * class creates the template for a person
 * @author Kelvin
 */
public abstract class Person extends Entity {
	/**
	 * weapon the person has
	 */
	private String weapon;
	/**
	 * the person's catchphrase
	 */
	private String quip;

	/**
	 * constructor
	 * @param n name of person
	 * @param h health of person
	 * @param w the weapon 
	 * @param q the catchphrase
	 */
	public Person ( String n, int h, String w, String q ) {
		super ( n, h ) ;
		weapon = w;
		quip = q;
	}

	/**
	 * method prints out the catch phrase
	 */
	public void sayCatchPhrase() {
		System.out.println( quip );
	}

	/**
	 * method gives character ability to attack
	 * 
	 * @param E entity being passed in
	 */
	public abstract void attack ( Entity E );

	/**
	 * accessor for the weapon
	 * @return weapon
	 */
	public String getWeapon() {
		return weapon;
	}
}
