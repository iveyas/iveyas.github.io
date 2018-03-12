//Program Name:	proj1.java
//Programmer:	Allison Ivey
//Class:		CSCI-001
//Lab:			proj1
/*Purpose:		This program gets primitive values from the user and 
				uses constants to do basic time and money convertions
				while displaying the information using different 
				decimal formats.  I also rounds values up to the nearest
				5.  The program ultimately is able to show the user
				how much time they entered in diffent formats and how
				much they should charge for the service. 
*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class proj1

{
	public static void main (String[] args)
	{
		
		
		Scanner kb = new Scanner(System.in);
		double dRateHrs;		//user input hourly rate
		int iHours;				//user input hours 
		int iMins;				//user input minutes
		String strName;			//user input name
		int iPos;				//user input position 
		char cLetter;			//user slected letter
		
		
		
		final double dDAYS_IN_YEAR = 365;
		final double dHOURS_IN_DAY = 24;
		final int iMINUTES_IN_HOUR = 60;
		final int iSECONDS_IN_MINUTES = 60;
		final double dDAYS_IN_WEEK = 7;
		final double dDAYS_IN_MONTH =30.46;
		final double dMONTHS_IN_YEAR = 12;		
		int iRoundMins;		/*user input minutes rounded up to 
							nearest 5*/
		int iTotalMin;		/*user hours converted to min. 
							plus user input mins.*/
		double dTotalHours; /*user input hours plus minutes 	
							converted in parts of an hour*/ 
		double dTotalDays;	//total hours converted to days
		double dTotalWeeks;	//total days converted to weeks
		double dTotalMonths;//total hours converted to months
		double dTotalYears;	//total months converted to years
		double dYearPercent;//years in percent format
		double dTotalSec;	//total minutes converted to seconds
		
		DecimalFormat basicRound = new DecimalFormat ("#,##0.00");
		DecimalFormat dollarRound = new DecimalFormat ("$##,##0.00") ;
		DecimalFormat percent = new DecimalFormat ("##0.00%") ;
		DecimalFormat noDecimal = new DecimalFormat ("###,###");
		DecimalFormat fourDecimal = new DecimalFormat("#,##0.0000");
		
		outputHeading();
		System.out.println("\n\n***********Attorney Billing " +
			 "Service**********");
		System.out.print("\n\nEnter your billable rate/hour: ");
			dRateHrs = kb.nextDouble();
		System.out.print("\nEnter your billable hours and additional" +
			" minutes: ");
			iHours = kb.nextInt();
			iMins = kb.nextInt();
		
		iRoundMins = ((iMins+4)/5)*5; //this rounds the input mins to 5
		iTotalMin = iHours * iMINUTES_IN_HOUR + iRoundMins;
			//converts the hours to minutes and then adds input minutes
		dTotalHours = iHours + (1.0*iRoundMins/iMINUTES_IN_HOUR);
		dTotalDays = dTotalHours/dHOURS_IN_DAY;
		dTotalWeeks = dTotalDays/dDAYS_IN_WEEK;		
		dTotalMonths = dTotalDays/dDAYS_IN_MONTH;	
		dTotalYears = dTotalMonths/dMONTHS_IN_YEAR;		
		dTotalSec = (((dTotalHours*iMINUTES_IN_HOUR) + iMins) * 	
			iSECONDS_IN_MINUTES);			
		
			
		kb.nextLine();
		System.out.print("\nWhat is your name? ");
			strName = kb.nextLine();
		System.out.print("\nWhich letter do you want displayed? ");
			iPos = kb.nextInt();
		cLetter = strName.charAt(iPos);
		System.out.print("\nLetter # " + iPos + " is " + 
			cLetter);
		System.out.print("\n\tEntered Minutes: " + iMins + "  Adjusted " 
			+ "Minutes = " + iRoundMins);
		
		System.out.print("\n\t  Total: " + 
			noDecimal.format(iTotalMin) + " minutes");
		System.out.print("\n\tSeconds: " 
			+noDecimal.format(dTotalSec));
		System.out.print("\n\t  Hours: "+ 
			basicRound.format(dTotalHours));
		System.out.print("\n\t   Days: " + 
			basicRound.format(dTotalDays));
		System.out.print("\n\t  Weeks: "+
			basicRound.format(dTotalWeeks));
		System.out.print("\n\t Months: "+
			fourDecimal.format(dTotalMonths));
		System.out.print("\n\t  Years: " + 
			fourDecimal.format(dTotalYears) + " or " + 
			percent.format(dTotalYears));
		
		System.out.println("\n\n" + strName + ", you should bill your"+ 
			" clients the following: ");
		System.out.print("\n\tRate: " + dollarRound.format(dRateHrs) +
			" /hour");
		System.out.print("\n\tHours: " + iHours + "\t" + 
			dollarRound.format(dRateHrs * iHours));
		System.out.print("\n\tMinutes: " + iRoundMins + "\t" +
			dollarRound.format((dRateHrs/iMINUTES_IN_HOUR)*iRoundMins));
		System.out.println("\n\tTotal: " + 
			dollarRound.format(dTotalHours * dRateHrs));
		
	}//end main (String[])
	public static void outputHeading()
	{
	
		System.out.print("\n\tProgram Name: proj1.java");
		System.out.print("\n\t  Programmer: Allison Ivey");
		System.out.print("\n\t       Class: CSCI-001");
		System.out.print("\n\t         Lab: Project 1");
		System.out.print("\n\t         Due: 9/23/2015");
	
	}
	
}//end proj1
