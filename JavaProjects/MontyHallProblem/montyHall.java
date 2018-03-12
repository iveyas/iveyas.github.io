import java.util.Random;

class montyHall
{
	public static void main(String[] args)	
	{
	
	double dRateOfWinsStay;		//holds the rate of wins with staying
	double dRateOfWinsChange;	//holds the rate of wins with changing
	
	dRateOfWinsStay=stayRateOfWins();
	dRateOfWinsChange=changeRateOfWins();
	System.out.print("\nThe rate of wins for staying is: " + dRateOfWinsStay);
	System.out.println("\nThe rate of wins for changing is: " + dRateOfWinsChange);
	}//end main(String[] args)
	
	/**
	*Method Name: stayRateOfWins()<hr>
	* Method purpose:  This method uses a rondom number generator to calculate the 
	* number of times that a spacific number is selected at random out of three 
	* oportunities
	* 
	* <hr>
	* Date created: 11/10/2015
	* Date Last Modified 11/27/2015 <br>
	* 
	* <hr>
	* @param iDoor int, stores the number of the door
	* @param iPrize int, holds the number of the the door the prize is behind
	* @param iWin int, holds the number of times that the door number and the prize
	* number agree.
	* 
	* *<hr>
	* @return dRateOfWins double, holds the calculated rate of times the door and the
	* prize agree out of 1000 trials. 
	*/
	public static double stayRateOfWins()
	{
		int iDoor;
		int iPrize;
		int iWin;
		double dRateOfWins;
		iWin=0;
		Random Random = new Random();
		for(int i=0; i<=1000; i++)
		{
			iPrize= Random.nextInt(3) + 1;
			iDoor= Random.nextInt(3) + 1;
			
			if(iPrize==iDoor)
			{
				iWin++;
			}//end if
		}//end for
		dRateOfWins=(1.0* iWin)/1000;
		return dRateOfWins;
	}//end stayRateOfWins()
	
	/**
	*Method Name: changeRateOfWins()<hr>
	* Method purpose:  This method uses a rondom number generator to calculate the 
	* number of times that a spacific number is selected at random out of three 
	* oportunities given the Monty Hall perameters for when a person switches doors
	* 
	* <hr>
	* Date created: 11/10/2015
	* Date Last Modified 11/27/2015 <br>
	* 
	* <hr>
	* @param iDoor int, stores the number of the door
	* @param iPrize int, holds the number of the the door the prize is behind
	* @param iWin int, holds the number of times that the door number and the prize
	* number agree.
	* 
	* *<hr>
	* @return dRateOfWins double, holds the calculated rate of times the door and the
	* prize agree out of 1000 trials. 
	*/
	public static double changeRateOfWins()
	{
		int iDoor;
		int iPrize;
		int iWin;
		double dRateOfWins;
		iWin=0;
		Random Random = new Random();
		for(int i=0; i<=1000; i++)
		{
			iPrize= Random.nextInt(3) + 1;
			iDoor= Random.nextInt(3) + 1;
			if(iPrize != iDoor)
			{
				iWin++;
			}//end if
		}//end for 
		dRateOfWins=(1.0*iWin)/1000;
		return dRateOfWins;
	}//end changeRateOfWins()
}
