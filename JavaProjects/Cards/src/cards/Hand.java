/**
 * ---------------------------------------------------------------------------
 * File name: Hand.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 29, 2016
 * ---------------------------------------------------------------------------
 */

package cards;

import java.util.ArrayList;

/**
 * This class uses the cards to create a hand of cards. 
 * It adds a card to the hand and puts those cards together
 * in an array and into a list of player's hands.
 *
 * <hr>
 * Date created: Feb 29, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Hand
{
	int handSize;	//the size of the hand to be dealt
	int cardsInHand;	//number of cards in hand
	Card[] hand;	//hand is an array of cards
	Deck newDeck = new Deck();	//an instance of the deck class
	ArrayList<Hand> playersList = new ArrayList<Hand>();	//an array of hand arrays

	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Mar 3, 2016 
	 *
	 * 
	 */
	Hand()
	{
		handSize = 7;
		cardsInHand = 0;
		hand = new Card[handSize];
	}
	
	
	/**
	 * Constructor that is passed a hand size and sets the hand size
	 * to the passed hand size.  It sets the hand array to and array of 
	 * cards of size of hand and sets the number of cards that are in
	 * hand.        
	 *
	 * <hr>
	 * Date created: Mar 3, 2016 
	 *
	 * 
	 * @param handSize
	 */
	Hand(int handSize)
	{
		this.handSize = handSize;
		hand = new Card[handSize];
		cardsInHand = 0;
	}
	
	
	/**
	 * Copy Constructor       
	 *Copies another instance of the hand class.
	 * <hr>
	 * Date created: Mar 3, 2016 
	 *
	 * 
	 * @param handIn
	 */
	Hand(Hand handIn)
	{
		this.hand = new Card[handIn.handSize];
		this.handSize = handIn.handSize;
		this.cardsInHand = handIn.cardsInHand;
		for(int i=0; i<=handSize; i++)
		this.hand[i] = new Card(handIn.hand[i]);
	}
	
	/**
	 * This method is passed a card and adds a card the the array 
	 * of cards.  The cards in hand iterates every time a card 
	 * is added.         
	 *
	 * <hr>
	 * Date created: Mar 3, 2016
	 *
	 * <hr>
	 * @param card the card that will be added to the array of cards
	 */
	public void addCard(Card card)
	{
		hand[cardsInHand++]= card;
	}
	
	/**
	 * It returns the list of hand arrays each hand represents a player         
	 *
	 * <hr>
	 * Date created: Mar 3, 2016
	 *
	 * <hr>
	 * @return playerList the array list of hands
	 */
	public ArrayList <Hand> getPlayersList()
	{
		return playersList;
	}

	/**
	 * This toString method displays the hand that each player is dealt         
	 *
	 * <hr>
	 * Date created: Mar 3, 2016 
	 *
	 * <hr>
	 * @return handOutput the string of hands that each player has
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		String handOutput;
		handOutput= "";
		for(Card f : hand)
		{
			handOutput += f + " \n";
		}
		return handOutput;
	}
}

