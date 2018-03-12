//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 1 - Strings and Dates
//	File Name:		2200-201-IveyAllison-Project1.cs
//	Description:	Management and verification of credit card information that are written to a file and read 
//                  from a file
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey, iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Monday, October 4, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

using System;
using System.Collections.Generic;
using System.IO;
using System.Security.Cryptography.X509Certificates;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using _2200_201_IveyAllison_Project1;
using CreditCardProject;

namespace CreditCardProject
{
    /// <summary>
    /// This menu is the new menu that has to do with saving to a file and writing to a file
    /// </summary>
    public class NewCardMenu
    {
        /// <summary>
        /// The valid entery
        /// </summary>
        Boolean ValidEntery = false;
        /// <summary>
        /// The new credit card
        /// </summary>
        CreditCard NewCreditCard = new CreditCard();

        /// <summary>
        /// New credit card menu.
        /// </summary>
        /// <returns></returns>
        public Object NewCreditCardMenu()
        {
            //SaveFileDialog dlg = new SaveFileDialog();
            //dlg.InitialDirectory = Application.StartupPath;
            //dlg.Title = "Saves New Credit Card List";
            //dlg.Filter = "text files|*.txt|all files|*.*";
            Menu menu = new Menu("Enter The Number of Your Choice");
            String FileName = String.Empty;
            menu = menu + "Enter First Name" + "Enter Last Name" + "Enter Credit Card Number" + "Enter Expiration Date" +
                   "Enter Phone Number" + "Enter Email Address" + "Display Information" + "Enter Differnt Card" + "Quit";
            Boolean ValidationBool = false;
            InputValidation m = new InputValidation();
            CreditCard show = new CreditCard();
            

            Choices choice = (Choices) menu.GetChoice();
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
                            Console.WriteLine(
                                "\nYou did not enter a valid Credit Card Number. \nPlease reenter your Credit Card Number.");

                        }
                        else
                        {
                            String CreditCardType = m.CreditCardType(CreditCardNumber, true);
                            show.setCreditCardType(CreditCardType);
                        }
                        show.setCreditCardNumber(CreditCardNumber, ValidationBool);
                        ValidationBool = false;
                        break;

                    case Choices.EXPERATIONDATE:
                        Console.WriteLine("Enter Expiration month (Example: MM)");
                        String ExporationMonth = Console.ReadLine();
                        ValidationBool = m.ValidDateMonth(ExporationMonth);

                        Console.WriteLine("Enter the expiration year (Example YYYY)");
                        String ExperationYear = Console.ReadLine();
                        ValidationBool = m.ValidDateYear(ExperationYear);

                        ValidationBool = false;

                        ValidationBool = m.ValidCreditCardDate(ExporationMonth, ExperationYear);

                        String ExperationDate = ExporationMonth + "/" + ExperationYear;
                        show.setExpirationDate(ExperationDate, ValidationBool);
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
                                Console.WriteLine(
                                    "You did not enter a valid Phone Number. \nPlease reenter the Phone Number.");
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
                                Console.WriteLine(
                                    "You did not enter a valid Email Address. \nPlease reenter your Email Address.");

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
                        
                            break;

                }  // end of switch

                choice = (Choices)menu.GetChoice();

                //Console.WriteLine("Press Enter To Continue");

            }  // end of while

            return show;
        }  // end of NewCreditCardMenu
    }



}

    

