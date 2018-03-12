/**
 * ---------------------------------------------------------------------------
 * File name: Boglin.java
 * Project name: Project5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2016
 * ---------------------------------------------------------------------------
 */

package dungeonCrawl;


/**
 * Has the constructor for the Boglin that sets the power level damage 
 * level and hit percentage. 
 *
 * <hr>
 * Date created: Apr 13, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Boglin extends Enemy
{
	
	/**
	 * Sets the strength hit rate and damage rate     
	 *
	 * <hr>
	 * Date created: Apr 13, 2016 
	 *
	 * 
	 */
	public Boglin ( )
	{
		super(20, .2, 5);

	}
}
