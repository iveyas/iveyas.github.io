///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Solution/Project:  Project One Driver     
//	File Name:         CreditCardDriver.cs
//	Description:       Populates the menu and allows the user to select a menu option   
//	Course:            CSCI 2200-201 Data Structures	
//	Author:            Allison Ivey, iveyas@etsu.edu
//	Created:           Monday, September 12, 2016
//	Copyright:         Allison Ivey, 2016
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

using System;
using System.Security.Cryptography.X509Certificates;
using System.Text.RegularExpressions;
using _2200_201_IveyAllison_Project1;

namespace CreditCardProject
{
    /// <summary>
    /// Class CreditCardDriver Deals with all the input and output of the program
    /// Uses various classes to validate the information and populate the values.
    /// </summary>
    class CreditCardDriver
    {
        /// <summary>
        /// Defines the entry point of the application.
        /// </summary>
        static void Main()
        {
            Console.BackgroundColor = ConsoleColor.White;
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Title = "Credit Card Information";

            Menu menu = new Menu("Enter The Number of Your Choice");
            menu = menu + "Enter First Name" + "Enter Last Name" + "Enter Credit Card Number" + "Enter Expiration Date" +
                   "Enter Phone Number" + "Enter Email Address" + "Display Information" + "Quit";

            Boolean ValidationBool = false;
            InputValidation m = new InputValidation();
            SetGetAndShow show = new SetGetAndShow();

            Choices choice = (Choices)menu.GetChoice();
            while (choice != Choices.QUIT)
            {
                switch (choice)
                {
                    case Choices.FIRSTNAME:
                        Console.WriteLine("Enter First Name");
                        while (ValidationBool == false)
                        {
                            String FirstName = Console.ReadLine();
                            ValidationBool = m.NameValidation(FirstName);
                            if (ValidationBool == false)
                            {
                                Console.WriteLine("You did not enter a valid name. \nPlease reenter your first name.");
                            }
                            else
                            {
                                show.setFirstName(FirstName);
                            }
                        }
                        ValidationBool = false;
                        break;

                    case Choices.LASTNAME:
                        Console.WriteLine("Enter Last Name");
                        while (ValidationBool == false)
                        {
                            String LastName = Console.ReadLine();
                            ValidationBool = m.NameValidation(LastName);
                            if (ValidationBool == false)
                            {
                                Console.WriteLine("You did not enter a valid name. \nPlease reenter your Last name.");
                            }
                            else
                            {
                                show.setLastName(LastName);
                            }
                        }
                        ValidationBool = false;
                        break;

                    case Choices.CREDITCARDNUM:
                        Console.WriteLine("Enter Credit Card Number");

                        while (ValidationBool == false)
                        {
                            String CreditCardNumber = Console.ReadLine();
                            CreditCardNumber = Regex.Replace(CreditCardNumber, @"[^\w\d]", "");
                            try
                            {
                                ValidationBool = m.CreditCardValidation(CreditCardNumber);
                            }
                            catch (OverflowException)
                            {

                                Console.WriteLine("That number was too big.");
                            }
                            if (ValidationBool == false)
                            {
                                Console.WriteLine("\nYou did not enter a valid Credit Card Number. \nPlease reenter your Credit Card Number.");

                            }
                            else
                            {
                                show.setCreditCardNumber(CreditCardNumber);
                                String CreditCardType = m.CreditCardType(CreditCardNumber, true);
                                show.setCreditCardType(CreditCardType);
                            }
                        }
                        ValidationBool = false;
                        break;

                    case Choices.EXPERATIONDATE:
                        Console.WriteLine("Enter Expiration month (Example: MM)");
                        String ExporationMonth = Console.ReadLine();
                        ValidationBool = m.ValidDateMonth(ExporationMonth);
                        while (ValidationBool == false)
                        {
                            Console.WriteLine("You did not enter a valid month\nPlease reenter the month (Example MM)");
                            ExporationMonth = Console.ReadLine();
                            ValidationBool = m.ValidDateMonth(ExporationMonth);

                        }
                        Console.WriteLine("Enter the expiration year (Example YYYY)");
                        String ExperationYear = Console.ReadLine();
                        ValidationBool = m.ValidDateYear(ExperationYear);
                        while (ValidationBool == false)
                        {
                            Console.WriteLine("You did not enter a valid year.  \nPlease Enter a Valid year (Example YYYY)");
                            ExperationYear = Console.ReadLine();
                            ValidationBool = m.ValidDateYear(ExperationYear);
                        }
                        ValidationBool = false;
                        while (ValidationBool == false)
                        {

                            ValidationBool = m.ValidCreditCardDate(ExporationMonth, ExperationYear);
                            while (ValidationBool == false)
                            {
                                Console.WriteLine("You did not enter a valid Expiration Date.\nMaybe your card has expired?\nPlease reenter the Expiration Date.");
                                Console.WriteLine("Enter Expiration month (Example MM)");
                                ExporationMonth = Console.ReadLine();
                                ValidationBool = m.ValidDateMonth(ExporationMonth);
                                while (ValidationBool == false)
                                {
                                    Console.WriteLine("You did not enter a valid month\nPlease reenter the month (Example MM)");
                                    ExporationMonth = Console.ReadLine();
                                    ValidationBool = m.ValidDateMonth(ExporationMonth);

                                }
                                Console.WriteLine("Enter the expiration year (Example YYYY)");
                                ExperationYear = Console.ReadLine();
                                ValidationBool = m.ValidDateYear(ExperationYear);
                                while (ValidationBool == false)
                                {
                                    Console.WriteLine("You did not enter a valid year.  \nPlease Enter a Valid year (Example YYYY)");
                                    ExperationYear = Console.ReadLine();
                                    ValidationBool = m.ValidDateYear(ExperationYear);
                                }
                            }
                        }
                        String ExperationDate = ExperationYear + "-" + ExporationMonth;
                        show.setExpirationDate(ExperationDate);
                        ValidationBool = false;
                        break;

                    case Choices.PHONENUM:
                        Console.WriteLine("Enter Your Phone Number");
                        while (ValidationBool == false)
                        {
                            String PhoneNumber = Console.ReadLine();
                            ValidationBool = m.ValidPhoneNumber(PhoneNumber);
                            if (ValidationBool == false)
                            {
                                Console.WriteLine("You did not enter a valid Phone Number. \nPlease reenter the Phone Number.");
                            }
                            else
                            {
                                show.setPhoneNumber(PhoneNumber);
                            }
                        }

                        ValidationBool = false;
                        break;

                    case Choices.EMAIL:
                        Console.WriteLine("Enter Your Email Address");
                        while (ValidationBool == false)
                        {
                            String EmailAddress = Console.ReadLine();
                            ValidationBool = m.ValidEmailAddress(EmailAddress);
                            if (ValidationBool == false)
                            {
                                Console.WriteLine("You did not enter a valid Email Address. \nPlease reenter your Email Address.");

                            }
                            else
                            {
                                show.setEmailAddress(EmailAddress);

                            }
                        }
                        ValidationBool = false;
                        break;

                    case Choices.SHOWINFO:
                        Console.WriteLine(show.ViewInputValues());
                        Console.ReadLine();
                        break;

                    case Choices.QUIT:
                        Console.WriteLine("You selected Quit");
                        Console.ReadLine();
                        break;

                }  // end of switch

                choice = (Choices)menu.GetChoice();

                //Console.WriteLine("Press Enter To Continue");

            }  // end of while

        }  // end of main
    }
}
   
