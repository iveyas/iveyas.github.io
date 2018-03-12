//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 1 - Strings and Dates
//	File Name:		2200-201-IveyAllison-Project1.cs
//	Description:	Management and verification of credit card information 
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey, iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Monday, October 4, 2016
//	Copyright:		Allison Ivey, 2016
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


using System;
using System.Collections.Generic;

namespace CreditCardProject
{
    /// <summary>
    /// Implementation of a Menu class for console applications
    /// </summary>
    public class Menu
    {
        /// <summary>
        /// The items
        /// </summary>
        private List<string> Items = new List<string> ( );
        /// <summary>
        /// Gets or sets the title.
        /// </summary>
        /// <value>The title.</value>
        public string Title { get; set; }

        #region Constructor
        /// <summary>
        /// Constructor 
        /// </summary>
        /// <param name="title">the title to be displayed above menu</param>
        public Menu(string title = "Menu")
        {
            Title = title;
        }
        #endregion

        #region Plus and Minus Operators
        /// <summary>
        /// Operator + adds a choice to the menu
        /// </summary>
        /// <param name="menuItem">the menu to which the choice is added</param>
        /// <param name="item">the choice to be added</param>
        /// <returns></returns>
        public static Menu operator +(Menu menuItem, String item)
        {
            menuItem.Items.Add(item);
            return menuItem;
        }

        /// <summary>
        /// Operator  - removes a choice from the menu
        /// </summary>
        /// <param name="menuItem">the menu from which the choice is removed</param>
        /// <param name="item">the number of the choice to be removed</param>
        /// <returns></returns>
        public static Menu operator -(Menu menuItem, int n)
        {
            if (n > 0 && n <= menuItem.Items.Count)
                menuItem.Items.RemoveAt(n - 1);
            return menuItem;
        }
        #endregion

        #region Display and GetChoice methods
        /// <summary>
        /// Display the menu on the console window
        /// </summary>
        public void Display()
        {
            string str = "";
            Console.Clear();
            str = DateTime.Today.ToLongDateString();
            Console.SetCursorPosition(Console.WindowWidth - str.Length, 0);
            Console.WriteLine(str);
            Console.ForegroundColor = ConsoleColor.Red;

            Console.WriteLine("\n\n\t   " + Title);
            Console.Write("\t   ");
            for (int n = 0; n < Title.Length; n++)
                Console.Write("-");
            Console.WriteLine("\n");
            Console.ForegroundColor = ConsoleColor.Blue;
            for (int n = 0; n < Items.Count; n++)
                Console.WriteLine("\t{0}. {1}", (n + 1), Items[n]);
        }

        /// <summary>
        /// Obtain the user's selection, verify it is valid, and return it
        /// </summary>
        /// <returns>the number of the user's valid selection</returns>
        public int GetChoice()
        {
            int choice = -1;
            string line;
            if (Items.Count < 1)
                throw new Exception("The menu is empty");

            while (true)
            {
                Display();
                Console.Write("\n\t   Type the number of your choice from the menu: ");
                Console.ForegroundColor = ConsoleColor.Red;
                line = Console.ReadLine();
                Console.ForegroundColor = ConsoleColor.Blue;
                if (!Int32.TryParse(line, out choice))
                {
                    Console.WriteLine("\n\t   Your choice is not a number between 1 and {0}.  Please try again.",
                        Items.Count);
                    Console.ReadKey();
                }
                else
                {
                    if (choice < 1 || choice > Items.Count)
                    {
                        Console.WriteLine("\n\t   Your choice is not a number between 1 and {0}.  Please try again.",
                        Items.Count);
                        Console.ReadKey();
                    }
                    else
                    {
                        Console.Clear();
                        return choice;
                    }
                }
            }
        }
        #endregion
    }
}
