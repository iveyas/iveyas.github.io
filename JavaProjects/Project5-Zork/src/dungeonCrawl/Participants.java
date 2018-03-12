/**
 * ---------------------------------------------------------------------------
 * File name: participant.java
 * Project name: Project5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2016
 * ---------------------------------------------------------------------------
 */

package dungeonCrawl;


/**
 * Sets up a class of participant that can be used by both the 
 * player and the monster.  It deals with the participant's strength 
 * health, miss percentage, current health, if they are alive, and 
 * if they took damage.
 *
 * <hr>
 * Date created: Apr 13, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Participants
{
	protected int maxHealth;		//the max health the participant has
	protected int currentHealth;	//current health of the participant
	protected double missPct;		//piss percentage of the participant
	protected int strength;			//strength of the participant
	
	
	/**
	 * Constructor that sets the max health miss percentage and strength       
	 *
	 * <hr>
	 * Date created: Apr 20, 2016 
	 *
	 * 
	 * @param maxHealth
	 * @param missPct
	 * @param strength
	 */
	public Participants(int maxHealth, double missPct, int strength)
	{
		setMaxHealth(maxHealth);
		setMissPct(missPct);
		setStrength(strength);
	}
	
	/**
	 * sets the strength of the participant        
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param strength how much damage they inflict on the foe 
	 */
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	
	/**
	 * returns the strength of the participant         
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getStrength()
	{
		return strength;
	}
	
	/**
	 * sets the max health of the participant before play         
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param maxHealth the starting level of health
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	/**
	 * returns the max health of the participant        
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	/**
	 * Sets the miss percentage of the participant        
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param missPct the percent that the participant misses
	 */
	public void setMissPct(double missPct)
	{
		this.missPct = missPct;
	}
	
	/**
	 * returns the miss percentage         
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public double getMissPct()
	{
		return missPct;
	}
	
	/**
	 * Sets the current health of the participant         
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param currentHealth the health of the user at the present moment 
	 */
	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}
	
	/**
	 * returns the current health        
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	/**
	 * Tells if the participant is alive or dead based on their 
	 * current health.         
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @return
	 */
	public boolean isAlive()
	{
		boolean isAlive = true; //tells if the participant is alive or not
		
		if(currentHealth <= 0)
		{
			isAlive = false;
		}
		
		return isAlive; //if false the player is dead
	}
	
	/**
	 * sets the current health of the participant the the value that 
	 * it needs to be after it takes damage          
	 *
	 * <hr>
	 * Date created: Apr 20, 2016
	 *
	 * <hr>
	 * @param damage is the amount of life that is taken away from the player 
	 * when hit
	 */
	public void takeDamage(int damage)
	{
		currentHealth = currentHealth - damage;
	}
}

