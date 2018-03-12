//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 1 - Strings and Dates
//	File Name:		2200-201-IveyAllison-Project1.cs
//	Description:	Management and verification of credit card information 
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey, iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Monday, September 12, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

using System;
using System.Linq;
using System.Net.Mail;
using System.Text.RegularExpressions;

namespace CreditCardProject
{
    /// <summary>
    /// This class has algorithms that validate all the user input. 
    /// It returns boolean values for most of the methods if the value is 
    /// validated or not.
    /// </summary>
    public class InputValidation
    {

        /// <summary>
        /// Validates the first and last name with hyphens if the person hyphenates their last name.
        /// </summary>
        /// <param name="InputName">Person's first or last name.</param>
        /// <returns>Boolean.</returns>
        public Boolean NameValidation(String InputName)
        {
            Boolean Valid = false;
            String pattern = @"^([a-zA-Z]+)(((\-){1}([a-zA-Z]+))?)$"; //accounts for a hyphenated name
            if (System.Text.RegularExpressions.Regex.IsMatch(InputName, pattern) == true)
            {
                Valid = true;
            }
            return Valid;
        }

        /// <summary>
        /// Returns the type of card based on the first few numbers of the credit card.
        /// </summary>
        /// <param name="CreditCardNumber">The credit card number.</param>
        /// <param name="Valid">valid or not.</param>
        /// <returns>String.</returns>
        public String CreditCardType(String CreditCardNumber, Boolean Valid)
        {
            CreditCardType Type = (CreditCardType)0;
            try
            {
                char[] array = CreditCardNumber.Take(2).ToArray();
                var LeadingTwoNumbers = array[0].ToString() + array[1].ToString();
               
             if (Int32.Parse(LeadingTwoNumbers) == 34 | Int32.Parse(LeadingTwoNumbers) == 37
                    && Valid == true)
                {
                    Type = CreditCardProject.CreditCardType.AMERICAN_EXPRESS;
                }
                else if (Int32.Parse(array[0].ToString()) == 4 && Valid == true)
                {
                    Type = CreditCardProject.CreditCardType.VISA;
                }
                else if (Int32.Parse(LeadingTwoNumbers) >= 51 && Int32.Parse(LeadingTwoNumbers) <= 55 && Valid == true)
                {
                    Type = CreditCardProject.CreditCardType.MASTERCARD;
                }
                else if (Int32.Parse(LeadingTwoNumbers) == 60 | Int32.Parse(LeadingTwoNumbers) == 64 |
                         Int32.Parse(LeadingTwoNumbers) == 65 && Valid == true)
                {
                    Type = CreditCardProject.CreditCardType.DISCOVER;
                }
                else if (Valid == true)
                {
                    Type = CreditCardProject.CreditCardType.OTHER;
                }
                else
                {
                    Type = CreditCardProject.CreditCardType.INVALID;
                }
            }
            catch (IndexOutOfRangeException)
            {

                Console.WriteLine("The Credit Card Value can not be Null");
            }


            return Type.ToString();
        }

        /// <summary>
        /// Validates if the credit card number is a valid credit card number.
        /// </summary>
        /// <param name="CreditCardNumberSqueezed">The credit card number.</param>
        /// <returns>Boolean.</returns>
        public Boolean CreditCardValidation(String CreditCardNumber)
        {
            Boolean Valid = false;
            String pattern = @"^(\d{12,19})$";
            Char CheckSum;
            Int64 SumOfNumbers = 0;
            Int64 SumOfNonMultipliedNumbers = 0;
            Int64 LeadingNum;
            Int64 UnchangedCardNumber;
            String LeadingNumbers;
            String CreditCardNumberSqueezed = CreditCardNumber.Trim();
            

            try
            {

                LeadingNumbers = (LeadingNum = (Int64.Parse(CreditCardNumberSqueezed))/10).ToString();
                for (int i = CreditCardNumberSqueezed.Length - 2; i > 0; i = i - 2)
                {
                    UnchangedCardNumber = Int64.Parse((LeadingNumbers[i - 1]).ToString());
                    SumOfNonMultipliedNumbers += UnchangedCardNumber;
                }
               
                for (int i = CreditCardNumberSqueezed.Length - 1; i > 0; i = i - 2)
                {
                    Int64 LocatedCardNumber = Int64.Parse((LeadingNumbers[i - 1]).ToString());
                    if ((LocatedCardNumber*2) >= 10)
                    {
                        LocatedCardNumber = ((LocatedCardNumber*2) - 10) + 1;
                    }
                    else
                    {
                        LocatedCardNumber = LocatedCardNumber*2;
                    }
                    
                    SumOfNumbers += LocatedCardNumber;


                }
                CheckSum = CreditCardNumberSqueezed[CreditCardNumberSqueezed.Length - 1];
                long SumOfNumbersAndCheckSum = (long.Parse(CheckSum.ToString())) + SumOfNumbers +
                                               SumOfNonMultipliedNumbers;

                if (CreditCardNumberSqueezed.Length <= 19 && CreditCardNumberSqueezed.Length >= 12)
                {
                    Valid = true;
                }
                else
                {
                    Valid = false;

                }

                if (System.Text.RegularExpressions.Regex.IsMatch(CreditCardNumberSqueezed, pattern) == true && Valid == true)
                {
                    Valid = true;
                }
                else
                {
                    Valid = false;

                }


                if (SumOfNumbersAndCheckSum%10 == 0 && Valid == true)
                {
                    Valid = true;
                }
                else
                {
                    Valid = false;

                }

            }
            catch (Exception)
            {
                Valid = false;
            }
            //String CreditCardType = this.CreditCardType(CreditCardNumberSqueezed, Valid);
            return Valid;
        }

        /// <summary>
        /// Validates the credit card expiration date.
        /// </summary>
        /// <param name="ExperationDate">The expiration date.</param>
        /// <returns>Boolean.</returns>
        public Boolean ValidCreditCardDate(String ExperationMonth, String ExperationYear)
        {
            Boolean Valid = false;
            DateTime TodaysDateTime = DateTime.Today;
            int year = TodaysDateTime.Year;
            int month = TodaysDateTime.Month;
            if (Int16.Parse(ExperationYear) > year)
            {
                Valid = true;
            }
            else if (Int16.Parse(ExperationMonth) > month && Int16.Parse(ExperationYear) == year)
            {
                Valid = true;
            }
            else
            {
                Valid = false;
            }
            return Valid;
        }

        /// <summary>
        /// Validates the date year.
        /// </summary>
        /// <param name="ExpirationYear">The expiration year.</param>
        /// <returns>Boolean.</returns>
        public Boolean ValidDateYear(String ExpirationYear)
        {
            String pattern = @"^\d\d\d\d$";
            Boolean ValidationBool = ValidationBool = Regex.IsMatch(ExpirationYear, pattern);
            if (ValidationBool == true)
            {
                ValidationBool = false; 
                
                if (short.Parse(ExpirationYear) > 2015)
                {
                    ValidationBool = true;
                }

                
            }
             return ValidationBool;
        }

        /// <summary>
        /// Validates the date month.
        /// </summary>
        /// <param name="ExperationMonth">The expiration month.</param>
        /// <returns>Boolean.</returns>
        public Boolean ValidDateMonth(String ExperationMonth)
        {
            String pattern = @"^\d\d$";
            Boolean ValidationBool = Regex.IsMatch(ExperationMonth, pattern);
            if (ValidationBool == true)
            {
                ValidationBool = false;
               
                if (short.Parse(ExperationMonth) > 0 && short.Parse(ExperationMonth)<13)
                {
                    ValidationBool = true;
                }

            
            }
            return ValidationBool;
        }

        /// <summary>
        /// Validates the phone number.
        /// </summary>
        /// <param name="PhoneNumber">The phone number.</param>
        /// <returns>Boolean.</returns>
        public bool ValidPhoneNumber(string phoneNumber)
        {
            bool Valid = false;
            String pattern = @"^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";
            if (Regex.IsMatch(phoneNumber, pattern) == true)
            {
                Valid = true;
            }
            return Valid;
        }

        /// <summary>
        /// Validates the email address.
        /// </summary>
        /// <param name="EmailAddress">The email address.</param>
        /// <returns>Boolean.</returns>
        public Boolean ValidEmailAddress(String EmailAddress)
        {
            Boolean Valid = true;

            String pattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
            Valid = Regex.IsMatch(EmailAddress, pattern);
            try
            {
                String address = new MailAddress(EmailAddress).Address;
            }
            catch (FormatException)
            {
                Valid = false; //address is invalid
            }
            catch (ArgumentException)
            {
                Valid = false; //address is invalid

            }


            return Valid;
        }
    }
}