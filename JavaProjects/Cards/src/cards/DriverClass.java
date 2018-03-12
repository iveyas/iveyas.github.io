/**
 * ---------------------------------------------------------------------------
 * File name: DriverClass.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jan 28, 2016
 * ---------------------------------------------------------------------------
 */

package cards;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program creates an instance of the deck class and 
 * then uses this instance to shuffle the cards, and deal
 * those cards in varying ways.  After dealing the cards
 * they are displayed to the user.   
 * <hr>
 * Date created: Jan 28, 2016
 * <hr>
 * @author Allison Ivey
 */
public class DriverClass
{

	/**
	 * This driver creates an instance of the deck class and
	 * then uses that instance to shuffle the cards, deal those 
	 * cards in varying ways.  After dealing the cards they
	 * are displayed to the user.         
	 *
	 * <hr>
	 * Date created: Jan 28, 2016
	 *
	 * <hr>
	 * @param <playersHands>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		@SuppressWarnings ("resource")
		Scanner kb = new Scanner(System.in);	//creates and instance of a scanner
		Deck deck= new Deck(); //creates an instance of the Deck class
		ArrayList<Hand> playersList = new ArrayList<Hand>();	//an array list of hands
		Hand hand;	//the hand that is going to be dealt
		int handSize;	//the number of cards that will be in the hand
		int iPlayers;	//the number of players that are being passed a hand
		boolean validPlayerNum;	//insures that there are enough cards to deal
		
		
		System.out.println("What size hands would you like to deal?");
		handSize = kb.nextInt();
		System.out.println ("How many players do you have? ");
		iPlayers = kb.nextInt ( );
		hand = new Hand(handSize);
		deck.shuffle( );
		validPlayerNum = validPlayerNum (handSize, iPlayers);
		
			
		while (validPlayerNum == false) //insures there are enough cards to deal
		{
			System.out.println ("There are not enough cards to deal " +
							handSize + " to " + iPlayers);
			System.out.println("What size hands would you like to deal?");
			handSize = kb.nextInt();
			System.out.println ("How many players do you have? ");
			iPlayers = kb.nextInt ( );
			hand = new Hand(handSize);
			deck.shuffle( );
			validPlayerNum = validPlayerNum (handSize, iPlayers);
			
		}
		
		//if there are a valid number of players they are each dealt a hand of cards
		if(validPlayerNum == true)
		{
			for(int i = 0; i<iPlayers; i++)
			{					
				hand = deck.dealAHand (handSize);
				playersList.add(hand);
			}
		}
		
		int i= 1;
		for(Hand f: playersList)	//prints the players hands
		System.out.println("Player" + i++ + ":\n" + f);
		
	}//end main(String [ ] args)
	
	
	/**
	 * This method validates that there are enough cards for the number
	 * of players that are selected.         
	 *
	 * <hr>
	 * Date created: Mar 3, 2016
	 *
	 * <hr>
	 * @param handSize the number of cards each player will be dealt
	 * @param iPlayers the number of players that will need a hand
	 * @return validPlayerNum tells if there are enough cards to deal
	 */
	public static boolean validPlayerNum (int handSize, int iPlayers)
	{
		boolean validPlayerNum = false;
		if(52/iPlayers >= handSize)
			validPlayerNum = true;
		
		return validPlayerNum;
	}	

}//end DriverClass




