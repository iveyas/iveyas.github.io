/**
 * ---------------------------------------------------------------------------
 /**
* ---------------------------------------------------------------------------
 * File name: Enemy.java
 * Project name: Project5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2016
 * ---------------------------------------------------------------------------
 */
package dungeonCrawl;

import java.util.Random;



/**
 * The class of enemies that extends participants.  It sets up  
 * the constructor for the enemy as well as sets if the enemy has
 * a potions or not. 
 *
 * <hr>
 * Date created: Apr 13, 2016
 * <hr>
 * @author Allison Ivey
 */

public class Enemy extends Participants
{
	protected boolean hasPotion; //hold the of if the monster has potion or not
	
	/**
	 * Constructor that takes a max health miss pct and strength 
	 * variables and randomly sets the monster as having a potion or not        
	 *
	 * <hr>
	 * Date created: Apr 13, 2016 
	 *
	 * 
	 */
	public Enemy (int maxHealth, double missPct, int strength )
	{
		super(maxHealth, missPct, strength);
		Random ranNum = new Random();
		setHasPotion(ranNum.nextBoolean ( ));
	}

	/**
	 * sets if the monster has a potion or not      
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param hasPotion
	 */
	public void setHasPotion(boolean hasPotion)
	{
		this.hasPotion = hasPotion;
	}

	/**
	 * Returns a true if the monster has a potion and false if they do not        
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public boolean getHasPotion()
	{
		return hasPotion;
	}
}

