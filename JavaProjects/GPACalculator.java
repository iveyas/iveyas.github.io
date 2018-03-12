//Program Name:	Quiz7.java
//Programmer:	Allison Ivey
//Class:		CSCI-001
//Lab:			Quiz7
/*Purpose:		The user enteres values specified by the programmer and
				then the program uses different methods to exicute 
				basic calculations and print statements.  It also clears
				the screen before the information is displayed.  
*/

import java.util.Scanner;
class Proj2
{
	public static void main(String[] args)	
	{
		{
			outputHeading();
			pressEnterToContinue();
			clearScreen();
		}
		Scanner kb = new Scanner(System.in);
		
		MathStats ms1 = new MathStats();
		int iMenu;			//stores the menu method
		int iScore1;		//user input score
		int iScore2;		//user input score
		int iScore3;		//user input score
		int iScore4;		//user input score
		int iScore5;		//user input score
		int iAdjustScore;	//Stores the adjusted score for  method
		int iMax;			//stores the max variable for min and max method
		int iMin;			//stores the min variable for min and max method
		double dWeightedAvg;// stores weighted average
		int w1;				//holds user input weights for weighted average method
		int w2;				//holds user input weights for weighted average method
		int w3;				//holds user input weights for weighted average method
		int iScoreNum;		//number of scores used in the average method
		double dAverage;	//stores the average 	
		int iSmallest;		//holds the smallest value for max score input method
		int iLargest;		//holds the largeet value for max score input method
		int i;				//variable defines the number of times program interates
		
		for(i=1;i<=5;i++)
		{
			iMenu= menu();	
			if (iMenu == 1)
			{
				iScore1=ms1.getScore();
				iAdjustScore = ms1.adjustScore(iScore1);
				System.out.println("Your adjusted score is: " + iAdjustScore);
			}

			else
				if (iMenu == 2)
				{
					iScore1=ms1.getScore();
					iScore2=ms1.getScore();
					iScore3=ms1.getScore();
					iScore4=ms1.getScore();
					iScore5=ms1.getScore();
					iMax=ms1.maxScore(iScore1, iScore2, iScore3, iScore4, iScore5);
					iMin=ms1.minScore(iScore1, iScore2, iScore3, iScore4, iScore5);
					System.out.print("\nYour Minimum Score is: " + iMin);
					System.out.println("\nYour Maximum Score is: " + iMax);
				}
			else
				if(iMenu == 3)
				{
					iScore1=ms1.getScore();
					System.out.print("\nEnter its weight: ");
					w1=kb.nextInt();
					iScore2=ms1.getScore();
					System.out.print("\nEnter its weight: ");
					w2=kb.nextInt();
					iScore3=ms1.getScore();
					System.out.print("\nEnter its weight: ");
					w3=kb.nextInt();
					dWeightedAvg=ms1.weightedAvg(iScore1, w1, iScore2, w2, 
						iScore3, w3);
					System.out.println("\nYour weighted Average is: " +
						dWeightedAvg);
				}
				else 
					if(iMenu==4)
					{
						System.out.print("\n\tHow many scores are you "+
							"averaging? ");
						iScoreNum=kb.nextInt();
						dAverage=ms1.scoresAndAverage(iScoreNum);
						System.out.println("\nThe average of those "+
							iScoreNum + " numbers are: " + dAverage);
					}
				else
					if(iMenu==5)
					{
						dAverage=ms1.maxScoreInput();
						System.out.println("\nThe Average of Max and Min is: "+
							dAverage);
					}
				else
					if (iMenu==6)
					{
						System.exit(0);
					}
				else
					if (iMenu>6 || iMenu<1)
					{
						System.out.println("\nYou entered an invalid choice");
					}				
		}
	
	}//end main(String[])
/**
	*Method Name: outputHeading <hr>
	* Method purpose:  prints all of Allison Ivey's personal information for 
	* CSCI 1250
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	*/
	public static void outputHeading()
	{
	
		System.out.print("\n\tProgram Name:	Quiz7.java");
		System.out.print("\n\t  Programmer:   Allison Ivey");
		System.out.print("\n\t       Class:   CSCI-001");
		System.out.print("\n\t         Lab:   Project 1");
		System.out.println("\n\t         Due:   9/23/2015");
	
	}//end outputHeading
/**
	*Method Name: menu <hr>
	* Method purpose:  Propmts the user to enter a number that corresponds to a 
	* menue item.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* *<hr>
	* @return iMenu int, the users numeric menu item choice
	*/	
	public static int menu()
	{
		Scanner kb = new Scanner(System.in);
		int iMenu;
		System.out.print("\n		MENU\n1)\tAdjust a score");
		System.out.print("\n2)\tFind Max and Min for 5 scores");
		System.out.print("\n3)\tFind Weighted Average");
		System.out.print("\n4)\tInput Scores and Average them");
		System.out.print("\n5)\tFind the largest, smallest, and average "+
			"of the largest \n\tand smallest scores");
		System.out.print("\n6)\tExit the program");
		System.out.print("\n\n\tEnter number of your choice between 1-6: ");
		iMenu= kb.nextInt();
		return iMenu;
	}//end menu (int)

/**
	*Method Name: clearScreen <hr>
	* Method purpose:  Clears the screen
	*
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	*
	*/	
	public static void clearScreen()
	{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}//end clearScreen
/**
	*Method Name: pressEnterToContinue <hr>
	* Method purpose:  Pauses the program
	*
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	*
	*/		
	public static void pressEnterToContinue()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Press Enter to Continue");
		kb.nextLine();
		
	}//end pressEnterToContinue
}//end Proj2
