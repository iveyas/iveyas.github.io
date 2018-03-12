import java.util.Scanner;			//imports package for a Scanner
import java.text.DecimalFormat;		//imports package for text formatting 
import java.util.Random;			//imports package for generating random number
import javax.swing.JOptionPane;
public class Steps
{
	public static void main(String[] args)
	{
			
			Scanner kb = new Scanner(System.in);		//gets input from the user
			DecimalFormat df = new DecimalFormat("#,##0.00");//dollar format
			Random Random = new Random();
			String nameFirst;
			String nameLast;
			double dInches;
			double dSteps;
			int iInchesToFeet; 
			double dInchesPerStride;
			final double INCHES_PER_MILE = 5280 * 12;
			double dDistanceTraveled;
			double dMilesWalked;
			int iInchesOver;
			int iFeetTall;
			final double STRIDE_LENGTH = .413;
			int iMenu;
			int iRandomNum;
			boolean blnWinner;
			double dFTemp;
			double dCTemp;
			double dKTemp;
			String inputString;
			String strReport;
			
			nameFirst = JOptionPane.showInputDialog("Enter your first name: ");
			nameLast = JOptionPane.showInputDialog("Enter your last name: ");
			
			inputString=JOptionPane.showInputDialog("Enter your height in inches: ");
			dInches= Double.parseDouble(inputString);
			
			inputString=JOptionPane.showInputDialog("Enter the number of steps " +
				"you took today:");
			dSteps= Double.parseDouble(inputString);
			
			iInchesToFeet= (int)dInches/12;
			iInchesOver = (int)dInches % 12;
			dInchesPerStride= dInches * STRIDE_LENGTH;
			dDistanceTraveled= dInchesPerStride * dSteps;
			dMilesWalked= dDistanceTraveled/INCHES_PER_MILE;
			
			JOptionPane.showMessageDialog(null, "Exercise Report for " + 
			nameFirst + " " + nameLast + "\nYou are " + iInchesToFeet + " feet, "+
			iInchesOver + " inches tall" + "\nYou walked: " + dMilesWalked +
			" miles today \nbecause you took " + dSteps + " steps");
			 
			 
			 
			for (int i=1; i<=100; i++)
			{
				System.out.print(i);
				int iVal1= i%3;
				int iVal2= i%5;
				if(iVal1==0 && iVal2 !=0)
				{
					System.out.println("FIZZ");
				}//end if for mod 3
				
				if(iVal2==0 && iVal1 !=0 )
				{
					System.out.println("BUZZ");
				}
				
				if(iVal1==0 && iVal2==0)
				{
					System.out.println("FizzBuzz");
				}//end if for mod 5
				else
				{
					System.out.println(" ");
				}//end else for space holder
			}//end for loop
			
			for(int i=0; i<5; i++)
			{
				System.out.print("\n		MENU\n1)\tRock");
				System.out.print("\n2)\tPaper");
				System.out.print("\n3)\tScissors");
				System.out.print("\n4)\tLizard");
				System.out.print("\n5)\tSpock ");
				System.out.print("\n\n\tEnter number of your choice between 1-5: ");
				iMenu= kb.nextInt();
				iRandomNum= randomNumber();
				blnWinner= winner(iRandomNum, iMenu);
				System.out.print("\nThe computer chose: " + iRandomNum);
				if(iMenu==iRandomNum)
				{
					System.out.println("\nIt is a tie! ");
				}
					else
					{
						if(blnWinner==true)
						{
							System.out.println("\nYou lost");
						}
							else
							{
								System.out.println("\nYou Won!");
							}
					}
				
			}
			
			System.out.print("\nWhat is the temperature in Fahrenheit? ");
			dFTemp= kb.nextDouble();
			Temperature temp1 = new Temperature(dFTemp);
			dCTemp= temp1.getCelcius();
			dKTemp= temp1.getKelvin();
			System.out.println("\n\tDegrees in Fahrenheit: " + dFTemp +
				"\n\tDegrees in Celcius: " + dCTemp + "\n\tDegrees in Kelvin" + 
				dKTemp);
	}//end main(String[] args)
	
	public static void pressEnterToContinue()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Press Enter to Continue");
		kb.nextLine();
		
		
	}//end pressEnterToContinue
	
	
	public static int randomNumber()
	{
		Random Random = new Random();
		int iRandomNum;
		iRandomNum= Random.nextInt(5)+1;
		return iRandomNum;
	}
	
	public static boolean winner(int iComputer, int iPerson)
	{
		boolean blnWinner;
		blnWinner = false;
		
		if(iComputer==3 && iPerson==2)
		{
			blnWinner = true;
		}
		
		if(iComputer==2 && iPerson==1)
		{
			blnWinner = true;
		}
		
		if(iComputer==1 && iPerson==4)
		{
			blnWinner = true;
		}
		
		if(iComputer==4 && iPerson==5)
		{
			blnWinner = true;
		}
		
		if(iComputer==5 && iPerson==3)
		{
			blnWinner = true;
		}
		
		if(iComputer==3 && iPerson==4)
		{
			blnWinner = true;
		}
		
		if(iComputer==4 && iPerson==2)
		{
			blnWinner = true;
		}
		
		if(iComputer==2 && iPerson==5)
		{
			blnWinner = true;
		}
		
		if(iComputer==5 && iPerson==1)
		{
			blnWinner = true;
		}
		
		if(iComputer==1 && iPerson==3)
		{
			blnWinner = true;
		}
		
		return blnWinner;
	}//end boolean winner(int, int)
	

	
}//end Steps
