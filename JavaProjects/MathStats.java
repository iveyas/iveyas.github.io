import java.util.Scanner;
class MathStats
{
/**
	*Method Name: getScore <hr>
	* Method purpose:  Propmt the user to enter a value and return that value
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iScore int, stores the user input value
	* *<hr>
	* @return iScore, the user input score
	*/
	public int getScore()
		{
			Scanner kb = new Scanner(System.in);
			int iScore;
			System.out.print("\nEnter a value: ");
			iScore= kb.nextInt();
			return iScore;
		}//end menu (int)

/**
	*Method Name: adjustScore <hr>
	* Method purpose:  This method takes the user input scores and based on the value
	* of those scores adds addtional points to the score.  It then return the 
	* new adjusted score.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iAdjustScore int, stores the value of the user input score plus the 
	* additonal amount based on the value of iScore
	* @param iScore int, this is the user input score
	* 
	* *<hr>
	* @return iAdjustScore int, the value of the user input score plus the 
	* additonal amount based on the value of iScore
	*/
	public int adjustScore(int iScore)
		{
			int iAdjustScore;
			iAdjustScore=0;
			if (100>=iScore && iScore>=90)
			{
				iAdjustScore= iScore + 2;  
			}
			else 
				if (80 <= iScore && iScore <= 89)
				{
					iAdjustScore= iScore + 4;
				}
				else 
					if (70 <= iScore && iScore <=79)
					{
						iAdjustScore= iScore + 6;
					}
					else 
						if (60 <= iScore && iScore <= 69)
						{
							iAdjustScore= iScore + 8;
						}
						else 
							if (iScore < 60)
							{
								iAdjustScore= iScore + 10; 
							}
							else 
								if (iScore > 100)
								{
									System.out.print("Invalid Score");
								}
								else
								{
								}
		return iAdjustScore;	
		}//end adjustScore(int)

/**
	*Method Name: maxScore <hr>
	* Method purpose:  This method takes 5 user input scores and finds which one of
	* the scores is the highest.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iMaxScore int, Stores the highest user input value
	* @param x int, user input score 1
	* @param y int, user input score 2
	* @param z int, user input score 3
	* @param u int, user input score 4
	* @param v int, user input score 5
	* 
	* *<hr>
	* @return iMaxScore int, Stores the highest user input value
	*/
	public int maxScore(int x, int y, int z, int u, int v)
	{
		int iMaxScore;
		iMaxScore = x;
		if (y>iMaxScore)
		{
			iMaxScore=y;
		}
		if(z>iMaxScore)
		{
			iMaxScore=z;
		}
		if (u>iMaxScore)
		{
			iMaxScore=u;
		}
		if (v>iMaxScore)
		{
			iMaxScore=v;
		}
									
		return iMaxScore;
	}//end maxScore (int, int, int,  int, int)
/**
	*Method Name: minScore <hr>
	* Method purpose:  This method takes 5 user input scores and finds which one of
	* the scores is the lowest.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iMinScore int, Stores the lowest user input value
	* @param x int, user input score 1
	* @param y int, user input score 2
	* @param z int, user input score 3
	* @param u int, user input score 4
	* @param v int, user input score 5
	* 
	* *<hr>
	* @return iMinScore int, Stores the lowest user input value
	*/
	public int minScore(int x, int y, int z, int u, int v)
		
	{	
		int iMinScore;
		iMinScore = x;
		if (y<iMinScore)
		{
			iMinScore=y;
		}
		if(z<iMinScore)
		{
			iMinScore=z;
		}
		if (u<iMinScore)
		{
			iMinScore=u;
		}
		if (v<iMinScore)
		{
			iMinScore=v;
		}
									
		return iMinScore;
	}//end iMinScore (int, int, int, int, int)
/**
	*Method Name: weightedAvg <hr>
	* Method purpose:  to get three test scores and three weights from the user and
	* then return the weighted average of given weights and scores.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param dWeightedAverage double, stores the weighted average of given scores 
	* and weights.
	* @param x1 int, user input score 1
	* @param w1 int, user input weight 1
	* @param x2 int, user input score 2
	* @param w2 int, user input weight 2
	* @param x3 int, user input score 3
	* @param w3 int, user user input weight 3
	* 
	* *<hr>
	* @return dWeightedAverage double, stores the weighted average of given scores 
	* and weights.
	*/
	public double weightedAvg(int x1, int w1, int x2, int w2, int x3, int w3)
	{
		
		double dWeightedAvg;
		dWeightedAvg = 	(x1*(w1/100.0))+(x2*(w2/100.0))+ (x3*(w3/100.0));
		return dWeightedAvg;
	}//end weightedAvg(int, int, int, int, int, int)
/**
	*Method Name: scoresAndAverage <hr>
	* Method purpose:  ask the user for the number of values that they are going to
	* enter, have them put that amount of values in and average those values.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iGrade int, holds the value of the user input grade
	* @param iSum int, holds the value of the sum of iGrade
	* 
	* *<hr>
	* @return dAverage double, stores the average of given scores.
	*/	
	public double scoresAndAverage(int numScores)
		{
			Scanner kb = new Scanner(System.in);
			double dAverage;
			int iGrade;
			int iSum = 0;			
			for(int i=1; i<=numScores; i++)
			{
				iGrade=getScore();
				iSum=iGrade += iSum;
			}
			
			dAverage= 1.0*iSum/numScores;
			return dAverage;
			
		}
/**
	*Method Name: maxScoreInput <hr>
	* Method purpose:  asks the user for an undefined number of grades 
	* takes those grades and finds the smalles and largest number.  It then takes
	* the largest and smallest values and averages them.
	* 
	* <hr>
	* Date created: 10/9/2015
	* Date Last Modified 10/15/2015 <br>
	* 
	* <hr>
	* @param iGrade int, holds the value of the user input grade
	* @param iSmallest int, holds the value of the smallest of iGrade
	* @param iLargest int, holds the value of the largest of iGrade
	* 
	* *<hr>
	* @return dAverage double, stores the average the smallest and largest values.
	*/	
	
	public double maxScoreInput()
	{
		Scanner kb = new Scanner(System.in);
		int iGrade;
		double dAverage;
		int iSmallest;
		int iLargest;
		
		
		System.out.print("\nEnter a grade (-1 if finished): ");
		iGrade=kb.nextInt();
		iSmallest=iGrade;
		iLargest=iGrade;
		
		while (iGrade >=0)	//if the user wants to continue
		{
			System.out.print("\nEnter a grade (-1 if finished): ");
			iGrade=kb.nextInt();		
		
			if (iGrade<iSmallest && iGrade != -1)
			{
				iSmallest=iGrade;
			}
			if (iGrade>iLargest && iGrade != -1)
			{
				iLargest=iGrade;
			}
		}
		dAverage= (iSmallest+iLargest)/2.0;
		System.out.print("\nSmallest: " + iSmallest);
		System.out.print("\tLargest: " + iLargest);
		System.out.println("\tAverage: " + dAverage);
	
		return dAverage;
	}//end maxScoreInput()
}//end MathStats

	
	
