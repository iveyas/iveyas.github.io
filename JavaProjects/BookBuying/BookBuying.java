//Program Name:	Proj4.java     
//Programmer:	Allison Ivey
//Class:		CSCI-001
//Project:		4 and 5	
//Purpose: 		Manages invoices for book orders

import java.util.Scanner;			//imports package for a Scanner
import java.text.DecimalFormat;		//imports package for text formatting 
public class Proj4
{
	public static void main(String[] args)
	{
			
			Scanner kb = new Scanner(System.in);		//gets input from the user
			DecimalFormat df = new DecimalFormat("$#,##0.00");//dollar format
			String strAuthor;		//stores the name of the author of the book
			String strTitle;		//stores the name of the book
			int iQuantity;			//stores the number of books
			double dCostPerBook;	//stores the cost per book
			String strOrderDate;	//stores the order date of the book
			double dWeight;			//stores the weight of the book
			char type;				//stores the type of shipping
			String strInvoice;		//stores the tostring of all the information
			double dShippingCost;	//stores the cost of shipping	
			double dCalcCost;		//stores the calculated ammount of just the books
			double dTotalWeight;	//stores the weight given the quantity 
			int iAdjustQuantity;	//stores the adjustment amount for book quantity
			double dTotalCost;		//stores the cost plus shipping cost
			boolean blnResults;		//stores a true or false to show if two are equal
			
			System.out.print("\nAuthor: ");
			strAuthor = kb.nextLine();
			
			System.out.print("\nTitle: ");
			strTitle= kb.nextLine();
			
			System.out.print("\nQuantity of book(s): ");
			iQuantity= kb.nextInt();
			
			System.out.print("\nCost Per Book: ");
			dCostPerBook= kb.nextDouble();
			
			kb.nextLine();
			
			System.out.print("\nOrder Date: ");
			strOrderDate= kb.nextLine();
			
			System.out.print("\nWeight of Book: ");
			dWeight= kb.nextDouble();
			
			System.out.print("What type of shipping would you like to use?" +
			"\nR for rush (1-3 day delivery) \nO for Overnight \nP for parcel post" +
			"\nF for FedEx \nU for UPS \nN for 2-3 weeks: ");
			type= kb.next().charAt(0);
			
			BookOrder order1 = new BookOrder(strAuthor, strTitle, iQuantity, dCostPerBook, strOrderDate, dWeight, type);
			
			BookOrder copyA = new BookOrder(order1);
			BookOrder copyB = new BookOrder(order1);
			blnResults= copyA.equals(copyB);
			System.out.print("\nCopy A and Copy B are Equal: " + blnResults);
			copyA.setQuantity(500);
			
			strInvoice=order1.invoice();
			System.out.print(strInvoice);
			copyB.adjustQuantity(-5);
			strInvoice=copyB.invoice();
			System.out.print(strInvoice);
			strInvoice=copyA.invoice();
			System.out.print(strInvoice);
			blnResults= copyA.equals(copyB);
			System.out.print("\nCopy A and Copy B are Equal: " + blnResults+"\n");
	}//end main(String[] args)
}//end Proj4
