import java.text.DecimalFormat;		//imports package for text formatting 
public class BookOrder
{
	private String author;	//holds the name of the author
	private String title;	//holds the title of the book
	private int quantity;	//holds the number of books 
	private double costPerBook;	//holds the cost per book
	private String orderDate;	//holds the address of the order date
	private double weight;		//holds the weight of the book
	private char type;			//holds the title of the book
	
	/**
	*Method Name: setAuthor(String)<hr>
	* Method purpose:  This method validates that the user input name is greater than 
	* zero characters. If the name has more than zero characters it will assign the
	* name. If it is not more than zero characters it will not assign it anything.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param iNumLetters int, stores the amount of characters in the string
	*/
	
	public void setAuthor(String author)
	{
		int iNumLetters;
		iNumLetters = author.length();
		if(iNumLetters>0)
		{
			this.author=author.toUpperCase();
		}//end if
	}//end setAuthor(String)
	
	/**
	*Method Name: setTitle(String)<hr>
	* Method purpose: This method validates that the user input title is greater than 
	* zero characters. If the name has more than zero characters it will assign the
	* title. If it is not more than zero characters it will not assign it anything.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param iNumLetters int, stores the amount of characters in the string
	* 
	*/
	
	public void setTitle(String title)
	{
		
		int iNumLetters;
		iNumLetters = title.length();
		if(iNumLetters>0)
		{
			this.title=title.toUpperCase();
		}//end if
		
	}//end setTitle(String)
	
	/**
	*Method Name: setQuantity(int)<hr>
	* Method purpose:  This method validates that the user input int is greater than 
	* zero characters. If the int is more than zero it will assign the
	* value to quantity. If it is not more than zero it will not assign it anything.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br> 
	*/
	public void setQuantity(int quantity)
	{
		
		if(quantity>0)
		{
			this.quantity=quantity;
		}//end if
	}//end setQuantity(int)
	
	/**
	*Method Name: setCost(double)<hr>
	* Method purpose:  This method validates that the user input int is greater than 
	* zero characters. If the int is more than zero it will assign the
	* value to costPerBook. If it is not more than zero it will not assign it 
	* anything.
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br> 
	*/
	public void setCost(double costPerBook)
	{
		if(costPerBook>0)
		{
			this.costPerBook= costPerBook;
		}//end if
	}//end setCost(double)
	
	/**
	*Method Name: setDate(String)<hr>
	* Method purpose:  This method validates that the user input date is greater than 
	* zero characters. If the name has more than zero characters it will assign the
	* name. If it is not more than zero characters it will not assign it anything.
	* It also make the date upper case.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param iNumLetters int, stores the amount of characters in the string
	*/
	public void setDate(String orderDate)
	{
		
		int iNumLetters;
		iNumLetters = orderDate.length();
		if(iNumLetters>0)
		{
			this.orderDate=orderDate.toUpperCase();
		}//end if
	}//end setDate(String)
	
	/**
	*Method Name: setWeight(double)<hr>
	* Method purpose:  This method validates that the user input double is greater 
	* than zero characters. If the double is more than zero it will assign the
	* value to weight. If it is not more than zero it will not assign it anything.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br> 
	*/
	public void setWeight(double weight)
	{
		if(weight>0)
		{
			this.weight = weight;
		}//end if
	}//end setWeight(double)
	
	/**
	*Method Name: setQuantity(int)<hr>
	* Method purpose:  This method validates that the user input character is 
	* one of the given types. If it is not it will default to n.  It also changes 
	* all the characters to upper case.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br> 
	*/
	public void setType(char type)
	{
		switch(type)
		{
			case 'r':
			case 'R':
				this.type='R';
				break;
			case 'O':
			case 'o':
				this.type='O';
				break;
			case 'P':
			case 'p':
				this.type='P';
				break;
			case 'F':
			case 'f':
				this.type='F';
				break;
			case 'u':
			case 'U':
				this.type='U';
				break;
			default:
				this.type='N';
		}//end switch
		
	}//end setType(char)
	
	public BookOrder()
	{
		setAuthor("Author");
		setTitle("Title");
		setQuantity(0);
		setCost(0);
		setDate("00-00-0000");
		setWeight(0);
		setType('N');
	}//end BookOrder()
	
	public BookOrder(String author, String title)
	{
		this.author=author;
		this.title=title;
	}//end BookOrder(String, String)
	
	public BookOrder(String author, String title, int quantity, double costPerBook, 
	String orderDate, double weight, char type)
	{
		setAuthor(author);
		setTitle(title);
		setQuantity(quantity);
		setCost(costPerBook);
		setDate(orderDate);
		setWeight(weight);
		setType(type);
	}//end BookOrder(String, String, int, double, String, double, char)
	
	public BookOrder(BookOrder order1)
	{
		setAuthor(order1.author);
		setTitle(order1.title);
		setQuantity(order1.quantity);
		setCost(order1.costPerBook);
		setDate(order1.orderDate);
		setWeight(order1.weight);
		setType(order1.type);
	}//end BookOrder(BookOrder)
	
	/**
	*Method Name: assignValues(int, double, String, double, char)<hr>
	* Method purpose:  This method passes given values to other methods in order to 
	* assign values to a given instance. 
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br> 
	*/
	public void assignValues(int quantity, double costPerBook, String orderDate, 
	double weight, char type)
	{
		setQuantity(quantity);
		setCost(costPerBook);
		setDate(orderDate);
		setWeight(weight);
		setType(type);
	}//end assignValues(int, double, String, double, char)
	
	/**
	*Method Name: adjustQuantity(int)<hr>
	* Method purpose:  This method validates that the user input quantity is greater
	* than zero. If the quantity is more than zero characters it will assign the
	* value. If it is not more than zero it will return a -1.
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param iValue int, stores the value of the quantity so that if it does not 
	* pass all the if statements the quantity can be adjusted to its original number.
	* 
	* *<hr>
	* @return iAdjustQuantity int, returns the quantity of books that the person 
	* wants to adjust them to.  
	*/
	public int adjustQuantity(int iAdjustQuantity)
	{
		int iValue;
		iValue=this.quantity;
		this.quantity= quantity+iAdjustQuantity;
		if(this.quantity<0)
		{
			iAdjustQuantity= -1;
			this.quantity=iValue;
		}
		else
		{
			iAdjustQuantity=this.quantity;
		}//end if
		return iAdjustQuantity;
	}//end adjustQuantity(int)
	
	/**
	*Method Name: totalWeight()<hr>
	* Method purpose:  This method calculates the total weight of the books by 
	* multiplying the weight times the quantity
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param dTotalWeight double, stores the the weight of the books given the 
	* quantity.
	* 
	* *<hr>
	* @return dTotalWeight double, returns the weight of the books given the 
	* quantity. 
	*/
	public double totalWeight()
	{
		double dTotalWeight=this.weight * this.quantity;
		return dTotalWeight;
		
	}//end totalWeight()
	
	/**
	*Method Name: calcCost()<hr>
	* Method purpose:  This method calculates the cost of the order given the 
	* quantity of books sold and the cost per book. 
	* 
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param dCost double, stores the calculated cost of the books given the 
	* quantity and cost per book.
	* 
	* *<hr>
	* @return dCost double, returns the cost of the book(s) given the quantity 
	* and cost per book. 
	*/
	public double calcCost()
	{
		double dCost;
		dCost= (this.quantity * this.costPerBook);
		return dCost;
	}//end calcCost()
	
	/**
	*Method Name: shipping()<hr>
	* Method purpose: This method uses the type entered by the user to apply a 
	* shipping cost to the books given the user input weight and gives a value for
	* the shipping cost. If the user did not put in a valid shipping type it defaults
	* the user input value to n and assigns n's shipping cost.
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param dShippingCost double, stores the calculated shipping cost
	* 
	* *<hr>
	* @return dShippingCost double, returns the cost of shipping given the quantity
	* and user input type of shipping. 
	*/
	public double shipping()
	{
		double dShippingCost;
		double dTotalWeight=totalWeight();
		switch(type)
		{
			case 'R':
				dShippingCost = dTotalWeight * .3;
				break;
			case 'O': 
				dShippingCost = dTotalWeight * .5;
				break;
			case 'P': 
				dShippingCost = dTotalWeight * .1;
				break;
			case 'F': 
				dShippingCost = dTotalWeight * .25;
				break;
			case 'U': 
				dShippingCost = dTotalWeight * .3;
				break;
			case 'N':
				dShippingCost = dTotalWeight * .05;
				break;
			default:
				dShippingCost= .05;
		}//end switch
		return dShippingCost;
	}//end shipping()
	
	/**
	*Method Name: totalCost()<hr>
	* Method purpose:  This method calculates the total cost of the order given the
	* shipping cost and the calculated cost of the order.
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param dTotal double, this stores the total cost of the order given shipping
	* and cost for the books.
	* 
	* *<hr>
	* @return dTotal double, returns the cost of the books given the cost for the 
	* books and the cost of shipping.
	*/
	public double totalCost()
	{
		double dTotal;
		dTotal = shipping() + calcCost();
		return dTotal;
	}//end totalCost()
	
	/**
	*Method Name: invoice()<hr>
	* Method purpose:  This method formats all the values that are dollar amounts to
	* a clean dollar amount display.  It also creates a string that returns the 
	* name of the author, title of the book, quantity of the book, cost per book, 
	* date of order, weight of order, shipping cost, and total cost of the books.  
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param strInvoice String, this stores the string that can be used to display
	* all the user input information.
	* 
	* *<hr>
	* @return strInvoice String, returns the string that can be used to display all 
	* the user input information.
	*/
	public String invoice()
	{
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		String strInvoice;
		strInvoice = ("\nAuthor: " + author + "\nTitle: " + title + "\nQuantity: " + 
		quantity + "\nCost Per Book: " + df.format(costPerBook) + "\nDate of Order: " + 
		orderDate + "\nWeight: " + weight + "\nShipping Cost: " + 
		df.format(shipping()) +"\nTotal Cost: " + df.format(totalCost()) + "\n");
		return strInvoice;
	}//end invoice()
	
	/**
	*Method Name: equals(BookOrder)<hr>
	* Method purpose:  This method validates that two different instances of the 
	* BookOrder are completely equal.  
	* <hr>
	* Date created: 11/20/2015
	* Date Last Modified 11/24/2015 <br>
	* 
	* <hr>
	* @param blnResults boolean, stores true or false depending on if the two 
	* instances are equal or not.  If they are equal it will store true.  If they are
	* not equal they will store false.
	* 
	* *<hr>
	* @return blnResults boolean, returns true if both instances are equal and 
	* returns false if the two instances are not equal.
	*/
	public boolean equals(BookOrder order1)
	{
		boolean blnResult;	//stores true or false depending on if the two instances
							//are equal or not.
		blnResult=true;
		if(!this.author.equals(order1.author))
		{
			blnResult=false;
		}//end if
		if(!this.title.equals(order1.title))
		{
			blnResult=false;
		}//end if
		if(this.quantity!=order1.quantity)
		{
			blnResult=false;
		}//end if
		if(this.costPerBook!=order1.costPerBook)
		{
			blnResult=false;
		}//end if
		if(!this.orderDate.equals(order1.orderDate))
		{
			blnResult=false;
		}//end if
		if(this.weight!=order1.weight)
		{
			blnResult=false;
		}//end if
		if(this.type != order1.type)
		{
			blnResult=false;
		}//end if
		return blnResult;
	}//end equals(Auto car)
	
}//end BookOrder
