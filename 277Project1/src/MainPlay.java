import java.util.Scanner;
import java.util.Random;

/**
 * class is the main that runs the program
 * @author Kelvin
 *
 */
public class MainPlay {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Entity[] rebelTeam = new Entity [ 8 ];
		Entity[] empire = new Entity [ 6 ];

		System.out.println( "What name do you wish to be called" );
		String name = input.next();
		System.out.println( "Enter your catchphrase do you want" );
		String quip = input.next();
		rebelTeam[ 0 ] = new Jedi ( name, quip, "Blue lightsaber" );
		rebelTeam[ 1 ] = new Rebel ( "Ghost", "Their reckoning is upon them" );
		rebelTeam[ 2 ] = new Rebel ( "Gaz", "Now I'm a little motivated" );
		rebelTeam[ 3 ] = new Rebel ( "Price", "Keep it up they can't sustain this" );
		rebelTeam[ 4 ] = new Rebel ( "Atlas", "You're going down" );
		rebelTeam[ 5 ] = new Rebel ( "Roach", "Get Wrecked!" );
		rebelTeam[ 6 ] = new Astromech ( "R2D2" );
		rebelTeam[ 7 ] = new Medical ( "Healbot", 20 );

		empire[ 0 ] = new SithLord( "Vader", "You will not forget the "
				+ "dark side's Power", "Red lightsaber" );
		empire[ 1 ] = new Stormtrooper( "Troop1", "Scurry Weakling" );
		empire[ 2 ] = new Stormtrooper( "Troop2", "Witness true strength" );
		empire[ 3] = new Stormtrooper( "Troop3",
				"You're not worthy as my opponent " );
		empire[ 4 ] = new Stormtrooper( "Troop4", "You shall die" );
		empire[ 5 ] = new Stormtrooper( "Troop5",
				"I'll show you the meaning of killshot" );
		System.out.println( "Choose your mission" );
		System.out.println( "1) Fight the sith lord" );
		System.out.println( "2) Deactivate the Deathstar" );
		int option;
		option = checkInput( 1, 2 );
		switch ( option ) {
		case 1:
			fightTheDarthOne( rebelTeam, empire ) ;
			break ;
		case 2:
			deactivateDeathStar( rebelTeam, empire ) ;
			break ;
		}
	}
/**
 * mission 1 in which the rebels fight the empire
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 */
	public static void fightTheDarthOne( Entity[] rebelTeam, Entity[] empire ) {
		Scanner input = new Scanner( System.in );
		boolean on = false;
		while ( on == false ) {
			if ( rebelTeam [ 0 ].getActive() == true ) {
				if ( empire [ 0 ].getActive() == true ) {
				System.out.println( "Your team's stats \n _____________" );
				for ( int i = 0; i < rebelTeam.length; i++ ) {
					System.out.println( i + ") " + rebelTeam[ i ].getName() + "\t"
							+ rebelTeam[ i ].getHp() );
				}

				System.out.println( "Bad Guys Stats \n _____________" );
				for ( int j = 0 ; j < empire.length ; j++ ) {
					System.out.println( j + ") " + empire[j].getName() + "\t"
							+ empire[ j ].getHp() );
				}
				System.out.println( "What do you wish to do" );
				System.out.println( "1) Attack with lightsaber" );
				System.out.println( "2) Heal ally" );
				System.out.println( "3) Use the force" );
				int option = checkInput( 1, 3 );
				switch ( option ) {

				case 1:
					System.out.println( "Choose who you want to attack" );
					System.out.println( "0) Sithlord " );
					System.out.println( "1) Stormtrooper1 " );
					System.out.println( "2) Stormtrooper2 " );
					System.out.println( "3) Stormtrooper3 " );
					System.out.println( "4) Stormtrooper4 " );
					System.out.println( "5) Stormtrooper5 " );
					int attackChoice = checkInput( 0, 5 );
					if ( empire[attackChoice].getActive() == false ) {
						System.out.println( "That character is already dead" );
						fightTheDarthOne( rebelTeam, empire );
					}
					useLightSaber( rebelTeam, empire, attackChoice );
					break ;
				case 2:
					healAlly( rebelTeam, empire ) ;
					break ;
				case 3:
					System.out.println( "Choose who you want to attack" );
					System.out.println( "0) Sithlord \t" + empire[ 0 ].getHp() );
					System.out.println( "1) Stormtrooper1 \t"
							+ empire[ 1 ].getHp() );
					System.out.println( "2) Stormtrooper2 \t"
							+ empire[ 2 ].getHp() );
					System.out.println( "3) Stormtrooper3 \t"
							+ empire[ 3 ].getHp() );
					System.out.println( "4) Stormtrooper4 \t"
							+ empire[ 4 ].getHp() );
					System.out.println( "5) Stormtrooper5 \t"
							+ empire[ 5 ].getHp() );
					attackChoice = checkInput( 0, 5 );
					if ( empire[attackChoice].getActive() == false ) {
						System.out.println( "That character is already dead" );
						fightTheDarthOne( rebelTeam, empire );
					}
					useTheForce( rebelTeam, empire, attackChoice );
					break ;
				}
			}
				else{
					System.out.println( " The Sith lord has fallen. " );
					on = true;
				}
			} 
				else {
				System.out.println( "Game Your character is dead" );
				on = true ;
			}
			
		}
	}
/**
 * teams engage each other with controlling player using a lightsaber
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 * @param attackChoice the target the player is to attack
 */
	public static void useLightSaber( Entity[] rebelTeam, Entity[] empire, int attackChoice ) {
		String task = "lightsaber";
		rebelTeam[ 0 ].setTask(task);
		if ( rebelTeam[ 0 ].getActive() == true ) {
			rebelTeam[ 0 ].doTask(empire[ attackChoice ] );
		}
		teamFight( rebelTeam, empire );
	}
/**
 * method has the nonplayable characters fight
 * @param rebelTeam team on the controlling players team
 * @param empire enemies of the player
 */
	public static void teamFight ( Entity[] rebelTeam, Entity[] empire ) {
		Random number = new Random();
		if( empire[0].getActive() == true){
		for ( int a = 1; a <= 5 ; a++ ) {
			if (rebelTeam[ a ].getActive() == true) {
				int rebelTarget;
				int nonActive;
				rebelTarget = number.nextInt(6);
				do { 
					nonActive = 0;
					rebelTarget = number.nextInt(6);
					for ( int i = 0 ; i < empire.length; i++ ){
					if ( empire [ i ].getActive() == false ){ 
						nonActive++;
					}
					}
				} while (empire[ rebelTarget ].getActive() == false && nonActive < 6);
				rebelTeam[ a ].doTask(empire[ rebelTarget ]);
			}
		}
		for ( int b = 0; b < empire.length; b++ ) {
			int empireTarget;
			int nonActive;
			boolean doneAttacking = false;
			if ( empire[ b ].getActive() == true ) {
				do{
					nonActive = 0;
					empireTarget = number.nextInt(8);
					for ( int i = 0 ; i < 6; i++ ){
						if ( rebelTeam [ i ].getActive() == false ){ 
							nonActive++;
						}
						}
					if ( nonActive != 5 ){
					if ( b == 0 ) {
						int vadersAttack = number.nextInt(2);
						if ( vadersAttack == 0 ) {
							String task = "lightsaber";
							empire[ b ].setTask( task );
							empire[ b ].doTask( rebelTeam[ empireTarget ] );
							 doneAttacking = true;
						} else {
							if ( empireTarget == 0 ) {
								System.out
										.println( "The force does not work on Jedis" );
								 doneAttacking = true;
							} else {
								String task = "force";
								empire[ b ].setTask( task );
								 empire[ b ]
										.doTask( rebelTeam[ empireTarget ] );
								 doneAttacking = true;
							}
						}
					} else {
						empire[ b ].doTask(rebelTeam[ empireTarget ]);
						 doneAttacking = true;
						
						}
					}
				} while ( rebelTeam[ empireTarget ].getActive() == false && doneAttacking == false);
			}
		}
	}
	}
/**
 * allows player to heal any character that is derived from person
 * @param rebelTeam
 * @param empire
 */
	public static void healAlly( Entity[] rebelTeam, Entity[] empire ) {
		if ( rebelTeam[ 7 ].getActive() == true ) {
			System.out.println( "Choose who you want to heal" );
			System.out.println( "1) " + rebelTeam[ 0 ].getName() + " \t"
					+ rebelTeam[ 0 ].getHp() );
			System.out.println( "2) " + rebelTeam[ 1 ].getName() + " \t"
					+ rebelTeam[ 1 ].getHp() );
			System.out.println( "3) " + rebelTeam[2].getName() + " \t"
					+ rebelTeam[ 2 ].getHp() );
			System.out.println( "4) " + rebelTeam[ 3 ].getName() + " \t"
					+ rebelTeam[ 3 ].getHp() );
			System.out.println( "5) " + rebelTeam[ 4 ].getName() + " \t"
					+ rebelTeam[4].getHp() );
			System.out.println( "6) " + rebelTeam[ 5 ].getName() + " \t"
					+ rebelTeam[5].getHp() );
			int option = checkInput( 1, 6 );
			
			if ( rebelTeam[ option - 1 ].getActive() == true ) {
			if ( option == 1 ) {	
				rebelTeam[ 7 ].doTask( rebelTeam[ 0 ] );
				
			} 
			else {
				rebelTeam[ 7 ].doTask( rebelTeam[ option - 1 ] );
			}
		
			teamFight( rebelTeam, empire );
			}
			else{
				System.out.println("Character is alread dead");
			}
		} 
		
		else {
			System.out.println( "Error: your healbot is destroyed" );
		}
	}
/**
 * has the teams fight each other with the player using the force to attack
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 * @param i enemy the player wants to attack
 */
	public static void useTheForce( Entity[] rebelTeam, Entity[] empire, int attackChoice ) {
		String task = "force";
		rebelTeam[ 0 ].setTask( task ); 
		if ( rebelTeam[0].getActive() == true ) {
			if ( attackChoice == 0 ) {
				System.out
						.println( "The force does not work against the sith lord" );
			} 
			else {
				 rebelTeam[ 0 ].doTask( empire[ attackChoice ] );
			}
		}
		teamFight( rebelTeam, empire );
	}
/**
 * mission 2 in which player attempts to deactivate the death star
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 */
	public static void deactivateDeathStar( Entity[] rebelTeam, Entity[] empire ) {
		Entity[] doors = new Entity[ 3 ];
		Entity[] computers = new Entity[ 2 ];
		doors[ 0 ] = new Door( "Security Room Door" );
		doors[ 1 ] = new Door( "Control Room Door" );
		doors[ 2 ] = new Door( "Door to ship" );

		computers[ 0 ] = new Computer( "Security controls" );
		computers[ 1 ] = new Computer( "DeathStar controls");
		System.out.println( "Your team has embarked on a mission to"
				+ " destroy the death star" );

		System.out.println( "Choose what to do first" );
		System.out
				.println( "1) Disable security systems before going to control room " );
		System.out.println( "2) Rush to the control room" );
		int option = checkInput( 1, 2 );

		switch ( option ) {
		case 1:
			disableSecurity( rebelTeam, empire, doors, computers );
			controlRoom( rebelTeam, empire, doors, computers );
			break;
		case 2:
			controlRoom( rebelTeam, empire, doors, computers );
			break;
		}
		if( rebelTeam[ 0 ].getActive() == true ){
		Random numbers = new Random();
		int c = 1;
		int guard = 1;
		while (empire[guard].getActive() == false && c < empire.length ){
		 guard = guard + 1;
	if( guard > 5 ) {
		guard = 5;
	}
		c++;
		}
		boolean win = true;
		if( c <= empire.length && empire[ guard ].getActive() == true ) {
			int patrol = numbers.nextInt( (100) + 1);
			if ( patrol <= 50 ) {
				System.out.println( "You were spotted trying to escape " );
				System.out.println( "How do you want to attack? " );
				System.out.println( "1) lightsaber" );
				System.out.println( "2) Force" );
				option = checkInput( 1, 2 );
				switch ( option ) {
				case 1:
					String task = "lightsaber";
					rebelTeam[ 0 ].setTask( task );
					rebelTeam[ 0 ].doTask( empire[ guard ] );
					break;
				case 2:
					 task = "force";
					rebelTeam[ 0 ].setTask(task);
					 rebelTeam[ 0 ].doTask( empire[ guard ] );
				}
				for ( int i = 1; i < 6; i++ ) {
					rebelTeam[ i ].doTask(empire[ guard ] );
				}
				if ( empire[ guard ].getActive() == true ) {
					
					win = false;
				} 
			}  
		if ( rebelTeam[6].getActive() == true ) {
			rebelTeam[ 6 ].doTask(doors[ 2 ] );
		} else {
			for ( int i = 0; i < 6; i++ ) {
				rebelTeam[ i ].doTask(doors[ 2 ] );
			}
		}
		if ( win == true ) {
			System.out
					.println( "Congradulations you made it back to your ship in time" );
		}
		else{
			System.out
			.println( "Game Over: "
					+ "the stormtrooper survived and destroyed your escape" );
		}
		}
	}
	}
/**
 * the player chooses to disable security in mission 2
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 * @param doors array of entities that are needed to be disabled to access certain parts
 * @param computers array of entities that are needed to be disabled to win
 */
	public static void disableSecurity( Entity[] rebelTeam, Entity[] empire,
			Entity[] doors, Entity[] computers ) {
		Random numbers = new Random();
		System.out
				.println( "At the entrance to the security system you see a guard" );
		int guard = numbers.nextInt( 5 ) + 1;
		boolean decision = false;
		do {
			System.out.println( "Select strategy" );
			System.out.println( "1) Wait and see if he leaves" );
			System.out.println( "2) Have your team Engage" );
			int option = checkInput( 1, 2 );
			switch ( option ) {
			case 1:
				int leave = numbers.nextInt((100) + 1);
				if ( leave <= 50 ) {
					System.out.println("Stormtrooper has moved away");
					if ( rebelTeam[ 6 ].getActive() == true ) {
						rebelTeam[ 6 ].doTask(doors[ 0 ] );
						rebelTeam[ 6 ].doTask(computers[ 0 ] );
					} else {
						for ( int a = 0; a < 5; a++ ) {
							if ( rebelTeam[ a ].getActive() == true ) {
								rebelTeam[ a ].doTask(doors[ 0 ] );
							}
						}

						for ( int a = 0; a < rebelTeam.length; a++ ) {
							rebelTeam[ a ].doTask( computers[ 0 ] );
						}
					}
					decision = true;
					int spotted = numbers.nextInt((100) + 1);
					if ( spotted <= 20 ) {
						System.out.println( "Your team has been spotted" );
						engage( rebelTeam, empire, guard );
					}

					decision = true;
					break;
				} else {
					System.out.println( "stormtrooper is still there" );
					break;
				}
			case 2:
				engage( rebelTeam, empire, guard );
				if ( rebelTeam[ 6 ].getActive() == true ) {
					rebelTeam[ 6 ].doTask(doors[ 0 ] );
					rebelTeam[ 6 ].doTask(computers[ 0 ] );
				} else {
					for ( int a = 0; a < 5; a++ ) {
						if ( rebelTeam[ a ].getActive() == true ) {
							rebelTeam[ a ].doTask(doors[ 0 ] );
						}
					}

					for ( int a = 0; a < rebelTeam.length; a++ ) {
						rebelTeam[ a ].doTask( computers[ 0 ] );
					}
				}
				decision = true;
				break;
			}
		} while ( decision == false );
	}
/**
 * the player decides to attack the guard
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 * @param guard the stormtrooper who is waiting
 */
	public static void engage(Entity[] rebelTeam, Entity[] empire, int guard) {
		System.out.println("How do you want to attack? ");
		System.out.println("1) lightsaber");
		System.out.println("2) Force");
		int option = checkInput( 1,2 );
		switch ( option ) {
		case 1:
			String task = "lightsaber";
			rebelTeam[ 0 ].setTask(task);
			rebelTeam[ 0 ].doTask( empire[ guard ] );
			break;
		case 2:
			 task = "force";
			 rebelTeam[ 0 ].setTask(task);
			 rebelTeam[0].doTask(empire[guard]);
		}
		
		
		for (int i = 1; i < 5; i++) {
			rebelTeam[ i ].doTask( empire[ guard ] );
		}
		if ( empire[ guard ].getActive() == true ) {
			System.out.println( "Warning the trooper alled reinforcements" );
			fightTheDarthOne( rebelTeam, empire );
		}
	}
/**
 * the room the player needs to access to win the mission
 * @param rebelTeam array of entities on the controlling player's side
 * @param empire array of entities fighting against the player
 * @param doors array of entities that are needed to be disabled to access certain parts
 * @param computers array of entities that are needed to be disabled to win
 */
	public static void controlRoom( Entity[] rebelTeam, Entity[] empire,
			Entity[] doors, Entity[] computers ) {
		if ( rebelTeam[ 6 ].getActive() == true ) {
			rebelTeam[ 6 ].doTask( doors[ 1 ] );
			rebelTeam[ 6 ].doTask(computers[ 1 ] );
			if ( computers[ 0 ].getActive() == true ) {
				System.out.println( "Warning you alerted the Sith lord" );
				fightTheDarthOne( rebelTeam, empire );
			}
		} else {
			rebelTeam[ 0 ].doTask( doors[ 1 ] );
			for ( int a = 0; a < 6; a++ ) {
				rebelTeam[ a ].doTask(doors[ 1 ] );
			}
			for ( int a = 1; a < 6; a++ ) {
				if ( rebelTeam[ a ].getActive() == true ) {
					rebelTeam[ a ].doTask(computers[ 1 ]);
				}
				if ( computers[ 0 ].getActive() == true ) {
					System.out.println( "Warning you alerted the Sith lord" );
					fightTheDarthOne( rebelTeam, empire );
				}
			}
		}

	}
/**
 * checks to see if user input is within the bounds
 * @param low lower bound
 * @param high higher bound
 * @return the option the player selected
 */
	public static int checkInput( int low, int high ) {
		Scanner input = new Scanner(System.in);

		boolean valid = false;
		int option = 0;
		while ( !valid ) {

			if ( input.hasNextInt() ) {
				option = input.nextInt();
				if ( option >= low && option <= high ) {
					valid = true;
				} else {
					System.out.println("Invalid input. Try Again. ");
				}
			}

			else {
				input.next();
				System.out.println("Invalid input. Try Again. ");

			}
		}
		return option;
	}
}
