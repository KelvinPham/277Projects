/**
 * this is the superclass from which all other classes derive from
 * @author Kelvin
 *
 */
public abstract class Entity {
	/**
	 * name of the entity
	 */
private String name;
 /**
  * how much health the entity has
  */
private int hp;
/**
 * tells if entity is alive or dead
 */
private boolean active;
/**
 * the task an entity has
 */
private String task;
/**
 * constructor for entity
 * @param n name
 * @param h health
 */
public Entity ( String n, int h ) {
	name = n;
	hp = h;
	active = true;
	task = "";
}
/**
 * method that gets overridden telling which task to do
 * @param E entity being passed
 */
public abstract void doTask ( Entity E );
	/**
	 * accessor for name
	 * @return name
	 */
public String getName() {
	return name;
}
/**
 * accessor for health
 * @return amount of health
 */
public int getHp() {
	return hp;
}
/**
 * mutator for active
 * @param active variable that decides if a character is still in the game
 */

/**
 * accessor for active
 * @return true if character is still in the game false otherwise
 */
public boolean getActive() {
	return active;
}
/**
 * remodifies hp
 * @param h health to be added or subtracted
 */
public void modifyHp ( int h ) {
	hp = hp - h;
	if ( hp <= 0 ) {
		hp = 0;
		active = false;
	}
}
/**
 * accessor for task
 * @return task
 */
public String getTask() {
	return task;
}
/**
 * mutator for the task
 * @param t task being passed in
 */
public void setTask ( String t ) {
	task = t;
}
}
