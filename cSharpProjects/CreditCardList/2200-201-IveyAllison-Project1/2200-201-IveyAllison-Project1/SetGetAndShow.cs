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
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.SqlServer.Server;

namespace _2200_201_IveyAllison_Project1
{
    /// <summary>
    /// Class SetGetAndShow This class sets all the values that can be shown to the user
    /// and populates a display that can be shown to the user.
    /// </summary>
    class SetGetAndShow
    {
        private String FirstName = ""; 
        private String LastName = "";
        private String CreditCardNumber = "";
        private String ExperationDate = "";
        private String EmailAddress = "";
        private String PhoneNumber = "";
        private String CreditCardType;
        private String MaskedCreditCardNumber = "";

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
        /// Sets the credit card number.
        /// </summary>
        /// <param name="CreditCardNumber">The credit card number.</param>
        protected internal void setCreditCardNumber(String CreditCardNumber)
        {
            this.CreditCardNumber = CreditCardNumber;
        }

        /// <summary>
        /// Sets the expiration date.
        /// </summary>
        /// <param name="ExpirationDate">The expiration date.</param>
        protected internal void setExpirationDate(String ExpirationDate)
        {
            this.ExperationDate = ExpirationDate;
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
        /// <returns>String.</returns>
        protected internal String ViewInputValues()
        {
            char[] CreditCardNumberArray = CreditCardNumber.ToCharArray();
            for (int i = 0; i < CreditCardNumber.Length - 5; i++)
            {
                MaskedCreditCardNumber += "*";
            }
            for (int i = CreditCardNumber.Length - 4; i <= CreditCardNumber.Length - 1; i++)
            {
                MaskedCreditCardNumber += CreditCardNumberArray[i];

            }

            
            String InputInfo = ("     Personal Information:" +
                        "\n        First Name: " + this.FirstName +
                        "\n         Last Name: " + this.LastName +
                        "\nCredit Card Number: " + this.MaskedCreditCardNumber +
                        "\n  Credit Card Type: " + this.CreditCardType +
                        "\n   Expiration Date: " + this.ExperationDate +
                        "\n     Email Address: " + this.EmailAddress +
                        "\n      Phone Number: " + this.PhoneNumber) +
                        "\n\nPress Enter To Continue";
            return InputInfo;

        }
    }
}
