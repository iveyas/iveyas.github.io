/**
 * ---------------------------------------------------------------------------
 * File name: Ragdon.java
 * Project name: Project5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2016
 * ---------------------------------------------------------------------------
 */

package dungeonCrawl;


/**
 * Inherits from enemy and sets the unique value of the ragdon's 
 * initial  health miss percentage and strength 
 *
 * <hr>
 * Date created: Apr 13, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Ragdon extends Enemy 
{

	/**
	 * Constructor sets the health miss percentage and power that
	 * it takes away from the enemy        
	 *
	 * <hr>
	 * Date created: Apr 13, 2016 
	 *
	 * 
	 */
	public Ragdon ( )
	{
		super(20, .15, 2);

	}

}
