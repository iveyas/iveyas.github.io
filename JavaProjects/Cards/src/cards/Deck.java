/**
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 4, 2016
 * ---------------------------------------------------------------------------
 */

package cards; 

/**
 * This program contains all the methods that are used to 
 * create a deck of cards.  It shuffles, deals (both a hand
 * and a single card), creates a toString to read the information
 * 
 *
 * <hr>
 * Date created: Feb 4, 2016
 * <hr>
 * @author Allison Ivey
 */
import java.util.Random;	//imports the utility class
public class Deck
{
	private Card[] deck = new Card[52];	//creates an instance of a 
			//a card array and populates it with 52 spaces for the 52 cards
	
	private int iNextCard;	//holds the number of the next card 
	
	
	/**
	 * Default Constructor that creates a deck of 52 unique cards        
	 *
	 * <hr>
	 * Date created: Feb 8, 2016 
	 *
	 * 
	 */
	public Deck()
	{
		int i = 0;	//iterates until all 52 cards are shown.
		for(i=0; i<=51; i++)
		{
			//Card newCard = new Card(i);
			deck[i]= new Card(i);
		}
		this.iNextCard= 0;
	}//end Deck()
	
	
	/**
	 * Copy Constructor copies the deck of a previous deck of unique cards        
	 *
	 * <hr>
	 * Date created: Feb 8, 2016 
	 *
	 * 
	 * @param existingDeck the deck that is to be copied
	 */
	public Deck(Deck existingDeck)
	{
		int i = 0;	//used in the for loop to create 52 card instances
		for(i=0; i<=51; i++)
		{	
			this.deck[i] = new Card(existingDeck.deck[i]);
		}
	}
	
	/**
	 * This method uses random numbers to shuffle the deck of cards 
	 * using the swap method so that it differs from the original 
	 * deck of card's order it also sets the iNextCard attribute to 
	 * zero so that it knows to start at the top of the deck.          
	 *
	 * <hr>
	 * Date created: Feb 8, 2016
	 *
	 * <hr>
	 */
	public void shuffle()
	{
		Random randomGenerator = new Random();	//random numbers to shuffle
		for(int i=0; i<=51; i++)
		{
			int randomInt = randomGenerator.nextInt(52);
			swap(i , randomInt);
		}
		this.iNextCard=0;
	}
	
	/**
	 * This method is passed an index of a card and a random number
	 * it then takes those numbers and uses a card holder to 
	 * swap three cards.           
	 *
	 * <hr>
	 * Date created: Mar 3, 2016
	 *
	 * <hr>
	 * @param passes the index of a given card
	 * @param ranNum a random number that is passed to it
	 */
	public void swap(int cardOne, int ranNum)
	{
			Card cardHolder;	//holds a card so that we can swap two other cards
			cardHolder= deck[ranNum];
			deck[ranNum] = deck[cardOne];
			deck[cardOne]= cardHolder;
	}
	
	/**
	 * This method is used to deal one card from the card class.
	 * it deals the next card that is at the top of the stack. 
	 * It then iterates iNextCard so that the same card is not dealt
	 * again.           
	 *
	 * <hr>
	 * Date created: Feb 8, 2016
	 *
	 * <hr>
	 * @return card the card that is being delt
	 */
	public Card dealACard()
	{
		Card card = deck[iNextCard];	//takes the top card from the given deck
		iNextCard++;	//increased so that the same card is not dealt twice
		return card;	//returns the card that is dealt to the user
	}
	
	/**
	 * This method deals a hand to the user of a given hand size. 
	 *         
	 *
	 * <hr>
	 * Date created: Feb 8, 2016
	 *
	 * <hr>
	 * @param handSize the user inputs the number of cards they would
	 * like to be dealt to them.
	 * @return newHand is returned so that the user is dealt a new hand
	 */
	public Hand dealAHand(int handSize)
	{
		Hand newHand= new Hand(handSize); 
		for(int i =0; i<handSize; i++)
			newHand.addCard(this.dealACard ( ));
		return newHand;
	}
	
	/**
	 * This method displays all 52 cards in the given deck
	 *
	 * <hr>
	 * Date created: Feb 8, 2016 
	 *
	 * <hr>
	 * @return displayCard is returned so that the user can see what card was dealt.
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		int i= 0;	//iterates the for loop
		String displayCard = "";	//holds the display card 
		for(i= 0; i<=51; i++)
		{
			System.out.println(deck[i]);
		}
		return displayCard;  
	}
}
