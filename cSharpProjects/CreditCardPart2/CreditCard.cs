//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 1 - Strings and Dates
//	File Name:		2200-201-IveyAllison-Project1.cs
//	Description:	Management and verification of credit card information read and writes to a file
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey, iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Monday, October 4, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

using System;
using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;
using CreditCardProject;

namespace _2200_201_IveyAllison_Project1
{
    /// <summary>
    /// Class CreditCard This class sets all the values that can be shown to the user
    /// and populates a display that can be shown to the user.
    /// </summary>
    /// <seealso cref="CreditCard" />
    /// <seealso cref="CreditCard" />
    public class CreditCard : IComparable<CreditCard>, IEquatable<CreditCard>
    {
        /// <summary>
        /// The first name
        /// </summary>
        private String FirstName = "";
        /// <summary>
        /// The last name
        /// </summary>
        private String LastName = "";
        /// <summary>
        /// The credit card number
        /// </summary>
        private String CreditCardNumber = "";
        /// <summary>
        /// The experation date
        /// </summary>
        private String ExperationDate = "";
        /// <summary>
        /// The email address
        /// </summary>
        private String EmailAddress = "";
        /// <summary>
        /// The phone number
        /// </summary>
        private String PhoneNumber = "";
        /// <summary>
        /// The credit card type
        /// </summary>
        private String CreditCardType;
        /// <summary>
        /// The masked credit card number
        /// </summary>
        private String MaskedCreditCardNumber = "";
        /// <summary>
        /// The valid experation date
        /// </summary>
        private Boolean ValidExperationDate = false;
        /// <summary>
        /// The valid credit card number
        /// </summary>
        private Boolean ValidCreditCardNum = false;
        /// <summary>
        /// The delimiter cc string
        /// </summary>
        private String DelimCCString;
        /// <summary>
        /// The credit card list
        /// </summary>
        private List<String> CreditCardList;
        /// <summary>
        /// The valid input
        /// </summary>
        readonly InputValidation ValidInput = new InputValidation();

        /// <summary>
        /// Initializes a new instance of the <see cref="CreditCard"/> class.
        /// </summary>
        protected internal CreditCard()
        {
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="CreditCard"/> class.
        /// </summary>
        /// <param name="FileName">Name of the file.</param>
        /// <param name="valid">if set to <c>true</c> [valid].</param>
        protected internal CreditCard(String FileName, bool valid)
        {
            StreamReader rdr = new StreamReader(FileName);
            ;
            int Count;
            String line = rdr.ReadLine();
            CreditCardList = new List<string>();
            while (rdr.Peek() != -1)
            {
                line = rdr.ReadLine();
                CreditCardList.Add(line);
            }
            Count = CreditCardList.Count;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="CreditCard"/> class.
        /// </summary>
        /// <param name="FirstName">The first name.</param>
        /// <param name="LastName">The last name.</param>
        /// <param name="PhoneNum">The phone number.</param>
        /// <param name="Email">The email.</param>
        /// <param name="CCNum">The cc number.</param>
        /// <param name="Date">The date.</param>
        protected internal CreditCard(String FirstName, String LastName, String PhoneNum, String Email, String CCNum,
            String Date)

        {
            Boolean ValidCCNum = false;
            setFirstName(FirstName);
            setLastName(LastName);
            setPhoneNumber(PhoneNum);
            setEmailAddress(Email);
            ValidCCNum = ValidInput.CreditCardValidation(CCNum);
            setCreditCardNumber(CCNum, ValidCCNum);

            ValidCCNum = ValidInput.ValidDateMonth(Date);

            setExpirationDate(Date, ValidCCNum);

            var CCType = ValidInput.CreditCardType(CCNum, ValidCCNum);
            setCreditCardType(CCType);



        }

        /// <summary>
        /// Initializes a new instance of the <see cref="CreditCard"/> class.
        /// </summary>
        /// <param name="CreditCardNumber">The credit card number.</param>
        protected internal CreditCard(String CreditCardNumber)
        {
            this.CreditCardNumber = CreditCardNumber;
        }


        /// <summary>
        /// Sets the first name.
        /// </summary>
        /// <param name="FristName">Name of the frist.</param>
        protected internal void setFirstName(String FristName)
        {
            this.FirstName = FristName;
        }

        /// <summary>
        /// Sets the last name.
        /// </summary>
        /// <param name="LastName">The last name.</param>
        protected internal void setLastName(String LastName)
        {
            this.LastName = LastName;
        }

        /// <summary>
        /// Credits the card match.
        /// </summary>
        /// <param name="CCNum">The cc number.</param>
        /// <returns></returns>
        public Boolean CreditCardMatch(String CCNum)
        {
            Boolean valid = false;
            valid = this.CreditCardNumber == CCNum;
            return valid;
        }
        /// <summary>
        /// Sets the credit card number.
        /// </summary>
        /// <param name="CreditCardNumber">The credit card number.</param>
        /// <param name="ValidCreditCardNum">if set to <c>true</c> [valid credit card number].</param>
        protected internal void setCreditCardNumber(String CreditCardNumber, Boolean ValidCreditCardNum)
        {
            this.CreditCardNumber = String.Empty;
            this.CreditCardNumber = Regex.Replace(CreditCardNumber, @"[\s]", "");
            this.ValidCreditCardNum = ValidCreditCardNum;
        }

        /// <summary>
        /// Sets the expiration date.
        /// </summary>
        /// <param name="ExpirationDate">The expiration date.</param>
        /// <param name="ValidExpirationDate">if set to <c>true</c> [valid expiration date].</param>
        protected internal void setExpirationDate(String ExpirationDate, Boolean ValidExpirationDate)
        {
            this.ExperationDate = ExpirationDate;
            this.ValidExperationDate = ValidExpirationDate;
        }

        /// <summary>
        /// Gets if date is valid.
        /// </summary>
        /// <returns></returns>
        protected internal bool GetIfDateIsValid()
        {
            Boolean ValidDate = false;
            try
            {
               
                String[] Date = Regex.Split(ExperationDate, "/");
                ValidDate = ValidInput.ValidCreditCardDate(Date[0], Date[1]);
                return ValidDate;
            }
            catch (Exception)
            {

                return ValidDate;
            }
        }

        /// <summary>
        /// Sets the email address.
        /// </summary>
        /// <param name="EmailAddress">The email address.</param>
        protected internal void setEmailAddress(String EmailAddress)
        {
            this.EmailAddress = EmailAddress;
        }

        /// <summary>
        /// Sets the phone number.
        /// </summary>
        /// <param name="PhoneNumber">The phone number.</param>
        protected internal void setPhoneNumber(String PhoneNumber)
        {
            this.PhoneNumber = PhoneNumber;
        }

        /// <summary>
        /// Sets the type of the credit card.
        /// </summary>
        /// <param name="CreditCardType">Type of the credit card.</param>
        protected internal void setCreditCardType(String CreditCardType)
        {
            this.CreditCardType = CreditCardType;
        }

        /// <summary>
        /// Allows the user to see the input data with a masked credit card number.
        /// </summary>
        /// <returns>
        /// String.
        /// </returns>
        #region View Input Values Of CC with Masked CC Num
        protected internal String ViewInputValues()
        {
            MaskedCreditCardNumber = String.Empty;
            char[] CreditCardNumberArray = CreditCardNumber.ToCharArray();
            string Valid = "";
            if (CreditCardNumber.Length > 0)
            {
                for (int i = 0; i < CreditCardNumber.Length - 5; i++)
                {
                    MaskedCreditCardNumber += "*";
                }
                for (int i = CreditCardNumber.Length - 4; i <= CreditCardNumber.Length - 1; i++)
                {
                    MaskedCreditCardNumber += CreditCardNumberArray[i];

                }
            }
            else
            {
                MaskedCreditCardNumber = "";
            }
            
            if (ValidCreditCardNum == true)
            {
                Valid = "Valid";
            }
            else
            {
                Valid = "Invalid";
            }
            String InputInfo = (
                    "\n        First Name: " + this.FirstName +
                    "\n         Last Name: " + this.LastName +
                    "\nCredit Card Number: " + this.MaskedCreditCardNumber + " " + Valid +
                    "\n  Credit Card Type: " + this.CreditCardType +
                    "\n   Expiration Date: " + this.ExperationDate + " " +
                    "\n     Email Address: " + this.EmailAddress +
                    "\n      Phone Number: " + this.PhoneNumber)
                ;
            return InputInfo;

        }
        #endregion

        #region Delimitted Credit Card String
        /// <summary>
        /// Deliminateds the cc string.
        /// </summary>
        /// <returns></returns>
        protected internal String DeliminatedCCString()
        {
            DelimCCString = String.Empty;
            DelimCCString = FirstName + "|" + LastName + "|" + PhoneNumber +
                            "|" + EmailAddress + "|" + CreditCardNumber +
                            "|" + ExperationDate + "|" + CreditCardType + "|";
            return DelimCCString;
        }
        #endregion

        #region Resets All the Values In The List
        /// <summary>
        /// Resets the values.
        /// </summary>
        public void ResetValues()
        {
            this.FirstName = String.Empty;
            this.LastName = String.Empty;
            this.CreditCardNumber = String.Empty;
            this.CreditCardType = String.Empty;
            this.PhoneNumber = String.Empty;
            this.MaskedCreditCardNumber = String.Empty;
            this.EmailAddress = String.Empty;
            this.DelimCCString = String.Empty;
        }
        #endregion

        #region Creates A First And Last Name String
        /// <summary>
        /// Firsts the last name displayed together.
        /// </summary>
        /// <returns></returns>
        public String FirstAndLastName()
        {
            String FirstAndLastName = FirstName + " " + LastName;
            return FirstAndLastName;
        }
        #endregion

        /// <summary>
        /// Equalses the specified cc card.
        /// </summary>
        /// <param name="ccCard">The cc card.</param>
        /// <returns></returns>
        /// <exception cref="ArgumentException"></exception>
        public bool Equals(CreditCard ccCard)
        {
            if (ccCard == null)
                return base.Equals(ccCard);

            if (!(ccCard is CreditCard))
                throw new ArgumentException();

            else
            {
                return Equals(ccCard as CreditCard);

            }

        }

        /// <summary>
        /// Returns a hash code for this instance.
        /// </summary>
        /// <returns>
        /// A hash code for this instance, suitable for use in hashing algorithms and data structures like a hash table. 
        /// </returns>
        public override int GetHashCode()
        {
            return CreditCardNumber.GetHashCode();
        }

        /// <summary>
        /// Compares the current object with another object of the same type.
        /// </summary>
        /// <param name="other">An object to compare with this object.</param>
        /// <returns>
        /// A value that indicates the relative order of the objects being compared. The return value has the following meanings: Value Meaning Less than zero This object is less than the <paramref name="other" /> parameter.Zero This object is equal to <paramref name="other" />. Greater than zero This object is greater than <paramref name="other" />.
        /// </returns>
        public int CompareTo(CreditCard other)
        {
            return CreditCardNumber.CompareTo(other.CreditCardNumber);
        }
    }
}

