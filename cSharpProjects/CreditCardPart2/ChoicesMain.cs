//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 1 - Strings and Dates
//	File Name:		2200-201-IveyAllison-Project1.cs
//	Description:	Management and verification of credit card information reads and writes to a file
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey, iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Monday,October 4, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
namespace CreditCardProject
{
    /// <summary>
    /// <summary>
    /// All the values that the user will be entering into the prompts for main 
    /// </summary>
    public enum ChoicesMain
    {
        EMPTYCC = 1, OPENFILE, ADDCC, REMOVECC, RETRIEVEATN, RETRIEVEBYCCNUM, RETRIEVEBYNAME, NONEXPIRED, SORTBYCCNUM, DISPLAYALLCC, QUIT
    }
}