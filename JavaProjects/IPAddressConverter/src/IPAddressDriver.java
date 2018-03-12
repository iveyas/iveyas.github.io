/**
 * ---------------------------------------------------------------------------
 * File name: IPAddressDriver.java
 * Project name: IPAddressConverter
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 7, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Feb 7, 2016
 * <hr>
 * @author Allison Ivey
 */
public class IPAddressDriver
{

	/**
	 * The main method will handle all of the computations 
	 * that will result in the displaying of the 
	 * class, default subnet mask, number of network bits
	 * number of host bits, size of the network, network 
	 * address and the broadcast address given a user input
	 * IP address.          
	 *
	 * <hr>
	 * Date created: Feb 5, 2016
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		IPAddressConverter userInput= new IPAddressConverter();	
		userInput.IPAddressConverterNoError ( );
		
	}

}
