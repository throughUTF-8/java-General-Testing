package RPG;

import java.util.Scanner;
public class basic {
	public static void main( String args[] ) {
		
		class Enemy{
			private double myMaxHealth = 100;
			private double myHealth = 100;
			private double myStrength;
			private double myDefense;
			private double myAgility;
			
			public Enemy( double strength, double defense, double agility ) {
				myStrength = strength;
				myDefense = defense;
				myAgility = agility;
			}
			
			//Calculations for attack sequence.  outputs: ( damage done, dodged?, damage received, dodged? )
			public double[] attack( double myStrength, double myDefense, double myAgility,  double eStrength, double eDefense, double eAgility ) {
				double[] damage = new double[6];
				damage = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
				
				//Calculation of damage done and counter-attack damage... considers critical strike chance
				if( Math.random()*(100 - myAgility) < 5 ) {
					damage[0] = (Math.random()*.75*myStrength + .75*myStrength) - (.125*eDefense + (Math.random()*.125*eDefense));
					damage[2] = 1.0;
				} else {
					damage[0] = (.5*myStrength + Math.random()*.5*myStrength) - (.25*eDefense + Math.random()*.25*eDefense);
				}
				if( Math.random()*(100 - eAgility + myAgility) < 4 ) {
					damage[3] = (.35*eStrength + Math.random()*.35*eStrength) - (.15*myDefense + Math.random()*.15*myDefense);
					damage[5] = 1.0;
				} else {
					damage[3] = (.15*eStrength + Math.random()*.15*eStrength) - (.05*myDefense + Math.random()*.05*myDefense);
				}
				
				//Calculates whether the enemy or you dodges the attack or counter-attack
				if( Math.random()*(100 + myAgility - 2*eAgility) < 5 ) {
					damage[1] = 1.0;
				} else {
					damage[1] = 0.0;
				}
				if( Math.random()*(100 - 5*myAgility + eAgility) < 5 ) {
					damage[4] = 1.0;
				} else {
					damage[4] = 0.0;
				}
				
				return damage;
			}
			
			//Deals damage to enemy
			public void takeDamage( double damage ) {
				myHealth -= damage;
			}
			
			//Access enemy statistics
			public double getStrength() {
				return myStrength;
			}
			public double getDefense() {
				return myDefense;
			}
			public double getAgility() {
				return myAgility;
			}
			public double getHealth() {
				return myHealth;
			}
			public double getMaxHealth() {
				return myMaxHealth;
			}
			
			//Tests whether the enemy is dead
			public boolean deadTest() {
				if( myHealth <= 0 ) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		class Character{
			private double myMaxHealth = 100;
			private double myHealth = 100;
			private double myStrength;
			private double myDefense;
			private double myAgility;
			
			public Character( double strength, double defense, double agility ) {
				myStrength = strength;
				myDefense = defense;
				myAgility = agility;
			}
			
			public boolean fight( Enemy s ) {
				while( !deadTest() && !s.deadTest() ) {	
					double[] duel = attack( myStrength, myDefense, myAgility, s.getStrength(), s.getDefense(), s.getAgility() );
					if( duel[2] == 1.0 ) {
						if( !(duel[1] == 1.0) ) {
							if( ((int)(10*duel[0]))/10 <= 0 ) {
								System.out.println( "You landed a critical hit but didn't deal any damage!" );
							} else {
								System.out.println("You landed a critical hit and dealt " + ((int)(10*duel[0]))/10 + " damage!");
								s.takeDamage( ((int)(10*duel[0]))/10 );
							}
						} else {
							System.out.println("You missed a critical hit and didn't deal any damage.");
						}
					} else {
						if( !(duel[1] == 1.0) ) {
							if( ((int)(10*duel[0]))/10 <= 0) {
								System.out.println( "You lnaded a hit but didn't deal any damage!" );
							} else {
								System.out.println("You landed a hit and dealt " + ((int)(10*duel[0]))/10 + " damage!");
								s.takeDamage( ((int)(10*duel[0]))/10 );
							}
						} else {
							System.out.println("You missed and didn't deal any damage.");
						}
					}
					if( duel[5] == 1.0 ) {
						if( !(duel[4] == 1.0) ) {
							if( ((int)(10*duel[3]))/10 <= 0 ) {
								System.out.println( "Your enemy landed a critical counter-attack but didn't deal any damage!");
							} else {
								System.out.println("Your enemy landed a critical counter-attack and dealt " + ((int)(10*duel[3]))/10 + " damage!");
								takeDamage( ((int)(10*duel[3]))/10 );
							}
						} else {
							System.out.println("Your enemy missed their critical counter-attack and didn't deal any damage.");
						}
					} else {
						if( !(duel[4] == 1.0) ) {
							if( ((int)(10*duel[3]))/10 <= 0 ) {
								System.out.println("Your enemy landed a counter-attack but didn't deal any damage!");
							} else {
								System.out.println("Your enemy landed a counter-attack and dealt " + ((int)(10*duel[3]))/10 + " damage!");
								takeDamage( ((int)(10*duel[3]))/10 );
							}
						} else {
							System.out.println("Your enemy missed their counter-attack and didn't deal any damage.");
						}
					}
					System.out.println("");
					try {
			            Thread.sleep(3000);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
					if( deadTest() ) {
						return false;
					} else if( !deadTest() && s.deadTest() ) {
						return true;
					}
					
					duel = s.attack( s.getStrength(), s.getDefense(), s.getAgility(), myStrength, myDefense, myAgility );
					if( duel[2] == 1.0 ) {
						if( !(duel[1] == 1.0) ) {
							if( (int)(10*duel[0])/10 <= 0.0 ){
								System.out.println("Your enemy landed a critical hit but didn't deal any damage!");
							} else {
								System.out.println("Your enemy landed a critical hit and dealt " + ((int)(10*duel[0]))/10 + " damage!");
								takeDamage( ((int)(10*duel[0]))/10 );
							}
						} else {
							System.out.println("Your enemy missed a critical hit and didn't deal any damage.");
						}
					} else {
						if( !(duel[1] == 1.0) ) {
							if( (int)(10*duel[0])/10 <= 0.0 ){
								System.out.println("Your enemy landed a hit but didn't deal any damage!");
							} else {
								System.out.println("Your enemy landed a hit and dealt " + ((int)(10*duel[0]))/10 + " damage!");
								takeDamage( ((int)(10*duel[0]))/10 );
							}
						} else {
							System.out.println("Your enemy missed and didn't deal any damage.");
						}
					}
					if( duel[5] == 1.0 ) {
						if( !(duel[4] == 1.0) ) {
							if( (int)(10*duel[3])/10 <= 0.0 ){
								System.out.println("You landed a critical counter-attack but didn't deal any damage!");
							} else {
								System.out.println("You landed a critical counter-attack and dealt " + ((int)(10*duel[3]))/10 + " damage!");
								s.takeDamage( ((int)(10*duel[3]))/10 );
							}
						} else {
							System.out.println("You missed your critical counter-attack and didn't deal any damage.");
						}
					} else {
						if( !(duel[4] == 1.0) ) {
							if( (int)(10*duel[3])/10 <= 0.0 ){
								System.out.println("You landed a counter-attack but didn't deal any damage!");
							} else {
								System.out.println("You landed a counter-attack and dealt " + ((int)(10*duel[3]))/10 + " damage!");
								s.takeDamage( ((int)(10*duel[3]))/10 );
							}
						} else {
							System.out.println("You missed your counter-attack and didn't deal any damage.");
						}
					}
					System.out.println("");
					try {
			            Thread.sleep(3000);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
					
				}
				
				if( deadTest() && !s.deadTest() ) {
					return false;
				} else if( !deadTest() && s.deadTest() ) {
					return true;
				} else {
					return false;
				}
			}
			
			//Calculations for attack sequence.  outputs: ( damage done, dodged?, damage received, dodged? )
			public double[] attack( double myStrength, double myDefense, double myAgility,  double eStrength, double eDefense, double eAgility ) {
				double[] damage = new double[6];
				damage = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
				
				//Calculation of damage done and counter-attack damage... considers critical strike chance
				if( Math.random()*(100 - myAgility) < 5 ) {
					damage[0] = (Math.random()*.75*myStrength + .75*myStrength) - (.125*eDefense + (Math.random()*.125*eDefense));
					damage[2] = 1.0;
				} else {
					damage[0] = (.5*myStrength + Math.random()*.5*myStrength) - (.25*eDefense + Math.random()*.25*eDefense);
				}
				if( Math.random()*(100 - eAgility + myAgility) < 4 ) {
					damage[3] = (.35*eStrength + Math.random()*.35*eStrength) - (.15*myDefense + Math.random()*.15*myDefense);
					damage[5] = 1.0;
				} else {
					damage[3] = (.15*eStrength + Math.random()*.15*eStrength) - (.05*myDefense + Math.random()*.05*myDefense);
				}
				
				//Calculates whether the enemy or you dodges the attack or counter-attack
				if( Math.random()*(100 + myAgility - 2*eAgility) < 5 ) {
					damage[1] = 1.0;
				} else {
					damage[1] = 0.0;
				}
				if( Math.random()*(100 - 5*myAgility + eAgility) < 5 ) {
					damage[4] = 1.0;
				} else {
					damage[4] = 0.0;
				}
				
				return damage;
			}
			
			//Deals damage to character
			public void takeDamage( double damage ) {
				myHealth += -damage;
			}
			
			//Access character statistics
			public double getStrength() {
				return myStrength;
			}
			public double getDefense() {
				return myDefense;
			}
			public double getAgility() {
				return myAgility;
			}
			public double getHealth() {
				return myHealth;
			}
			public double getMaxHealth() {
				return myMaxHealth;
			}
			
			//Levels up character statistics
			public void levelMaxHealth() {
				myMaxHealth += 20;
				myHealth = myMaxHealth;
			}
			public void levelStrength() {
				myStrength += (int)(.2*myStrength);
			}
			public void levelDefense() {
				myDefense += (int)(.2*myDefense);
			}
			public void levelAgility() {
				myAgility += (int)(.2*myAgility);
			}
			
			public void setHealth( double n ) {
				myHealth = n;
			}
			public void setStrength( double n ) {
				myStrength = n;
			}
			public void setDefense( double n ) {
				myDefense = n;
			}
			public void setAgility( double n ) {
				myAgility = n;
			}
			public void setMaxHealth( double n ) {
				myMaxHealth = n;
			}
			
			//Tests whether the character is dead
			public boolean deadTest() {
				if( myHealth <= 0 ) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		
		Character hero1;
		
		//Start screen
		System.out.println( "Welcome to your quest!  Please select a character to quest with! (Respond with 'W', 'P', or 'A')" );
		System.out.println();
		System.out.println( "Warrior:                   Paladin:                   Assassin:" );
		System.out.println( "--------------------       --------------------       --------------------" );
		System.out.println( "Strength: 55.0             Strength: 45.0             Strength: 50.0" );
		System.out.println( "Defense: 45.0              Defense: 60.0              Defense: 30.0" );
		System.out.println( "Agility: 30.0              Agility: 25.0              Agility: 50.0" );
		
		Scanner in = new Scanner( System.in );
        String command = in.nextLine();
        
        //Character creation
        while(!((command.toLowerCase()).equals("w") || (command.toLowerCase()).equals("p") || (command.toLowerCase()).equals("a") ||
        	(command.toLowerCase()).equals("warrior") || (command.toLowerCase()).equals("paladin") || (command.toLowerCase()).equals("assassin"))) {
        	System.out.println("Please respond with 'W', 'P', or 'A'");
        	command = in.nextLine();
        }
        if( (command.toLowerCase()).equals("w") || (command.toLowerCase()).equals("warrior") ) {
        	System.out.println( "\nYou have selected warrior!  Please name you character!" );
        	hero1 = new Character( 45, 35, 25 );
        	command = in.nextLine();
        } else if( (command.toLowerCase()).equals("p") || (command.toLowerCase()).equals("paladin") ) {
        	System.out.println( "\nYou have selected paladin!  Please name you character!" );
        	hero1 = new Character( 35, 50, 20 );
        	command = in.nextLine();
        } else {
        	System.out.println( "\nYou have selected assassin!  Please name you character!" );
        	hero1 = new Character( 40, 20, 45 );
        	command = in.nextLine();
        }
        
        while( command.length() <= 1 || command.length() > 36 ) {
        	System.out.println( "Please select a character name with a valid number of characters (2-36)");
        	command = in.nextLine();
        }
        
        System.out.println( "\n" + command + " has been created!" );
		System.out.println( "--------------------" );
		System.out.println( "Strength: " + hero1.getStrength() );
		System.out.println( "Defense: " + hero1.getDefense() );
		System.out.println( "Agility: " +hero1.getAgility() );
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nNow, please select which quest you would like to attend to! (Respond with '1', '2', or '3')");
        System.out.println("1) The Quest for the Dragon's Claw");
        System.out.println("2) The Quest for Gildrethe's Crown");
        System.out.println("3) The Quest for the Silver Sgian-dubh");
        command = in.nextLine();
        
        while( !(command.equals("1") || command.equals("2") || command.equals("3")) ) {
        	System.out.println("Please respond with a valid number! ('1', '2', or '3')");
        	command = in.nextLine();
        }
        
        if( command.equals("1") ) {
        	System.out.println("\nYou have chosen to embark on The Quest for the Dragon's Claw!");
        	
        	try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	System.out.println("\nThere has been a rumor circulating around town that there is a formidable evil to the north." +
        						"\nFarm animals, pets, and even small children have gone missing over the past 3 weeks when" +
        						"\nwandering around to the north of the town.  Whatever it is that lurks there, the king has" + 
        						"\ntasked you to take it out, and if you return with evidence of its defeat, you will surely be" +
        						"\nrewarded handsomely.");
        	
        	try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	System.out.println("\nOne of the king's guards leads you to the northern trail.  From there you must walk alone." +
        					   "\nThe guard wishes you luck, and you head on your way up the trail.");
        	
        	try {
                Thread.sleep(7500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	
        	System.out.println("\nNot before long, you encounter what appears to be one of the ragged goblins that inhabit the" +
        					   "\nnearby cliffside.  Not a particularly difficult combatant, but it is your first true test.");
        	
        	try {
                Thread.sleep(7500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	Enemy goblin = new Enemy( 16.0, 8.0, 2.0 );
        	
        	System.out.println("\nYou have now engaged in combat with a goblin! (100 hit points)\n");
            
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if( hero1.fight( goblin )) {
            	System.out.println("You defeated the goblin!");
            } else {
            	System.out.println("You died!");
            }
            
            System.out.println( "You are now at " + hero1.getHealth() + " hit points!" );
        	
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
        	
        } else if( command.equals("2") ) {
        	System.out.println("\nYou have chosen to embark on The Quest for Gildrethe's Crown!");
        } else if( command.equals("3") ) {
        	System.out.println("\nYou have chosen to embark on The Quest for the Silver Sgian-dubh!");
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        in.close();
	}
}