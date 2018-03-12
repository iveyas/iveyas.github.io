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
namespace CreditCardProject
{
    /// <summary>
    /// Enum CreditCardType
    /// </summary>
    public enum CreditCardType
    {
        /// <summary>
        /// The credit card types that can be accessed through entering a valid credit card number
        /// </summary>
        INVALID = 1, VISA, MASTERCARD, AMERICAN_EXPRESS, DISCOVER, OTHER 
    }
}