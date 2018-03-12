/**
 * ---------------------------------------------------------------------------
 * File name: Card.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jan 28, 2016
 * ---------------------------------------------------------------------------
 */

package cards;


/**
 * Models a single card out of an ordinary deck of playing cards.
 *
 * <hr>
 * Date created: Jan 28, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Card
{
	private Face face;	//creates variable Face of the enumerated type Face
	private Suit suit;	//creates a variable Suit of the enumerated type Suit
	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jan 28, 2016 
	 *
	 * 
	 */
	public Card ( )
	{
		face = Face.TWO;	//Sets the default face value to two
		suit = Suit.HEARTS; //Sets the default suit value to hearts
	}//end Card()
	
	/**
	 * Copy Constructor initializes a new card as a duplicate of an existing
	 * card.  It copies the attributes of an existingCard into their counterparts
	 * in the Card being initialized.         
	 *
	 * <hr>
	 * Date created: Jan 28, 2016 
	 *
	 * 
	 */
	public Card (Card existingCard)
	{
		this.face= existingCard.face;
		this.suit= existingCard.suit;	// TODO Auto-generated constructor stub
	}//end Card(Card)
	
	/**
	 * Parameterized Constructor takes an integer parameter and converts it to 
	 * appropriate subscripts using the mod operator.        
	 *
	 * <hr>
	 * Date created: Jan 28, 2016 
	 *
	 * 
	 */
	public Card (int n)
	{
		this.face = Face.values ( )[n % 13];	// takes the int and converts it to an
										//appropriate subscript
		this.suit = Suit.values ( )[n % 4];	// takes the int and converts it to an
										//appropriate subscript
	}//end Card(int)
	
	/**
	 * Returns a String representing an appropriate display phrase identifying
	 * a particular card.         
	 *
	 * <hr>
	 * Date created: Jan 28, 2016 
	 *
	 *@return "the " + Face + " of " + Suit;
	 */
	public String toString()
	{
		return "the " + face + " of " + suit;  
	}//end toString()

}
