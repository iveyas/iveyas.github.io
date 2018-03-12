/**
 * ---------------------------------------------------------------------------
 * File name: Squilderdash.java
 * Project name: Project5-Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2016
 * ---------------------------------------------------------------------------
 */

package dungeonCrawl;


/**
 * Sets the intial health of the monster as well as it's miss 
 * percentage and amount of life that it takes from its foe 
 *
 * <hr>
 * Date created: Apr 13, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Squilderdash extends Enemy 
{

	/**
	 * Constructor sets the health level, miss percentage and 
	 * strength of the monster using the super constructor       
	 *
	 * <hr>
	 * Date created: Apr 13, 2016 
	 *
	 * 
	 */
	public Squilderdash ( )
	{
		super(20, .25, 7);

	}

}
