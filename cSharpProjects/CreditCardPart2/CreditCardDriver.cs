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
using System.IO;
using System.Security.Cryptography.X509Certificates;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;
using _2200_201_IveyAllison_Project1;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.Linq;

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
        [STAThread]
        /// <summary>
        /// Defines the entry point of the application.
        /// </summary>
        static void Main()
        {
            Console.BackgroundColor = ConsoleColor.White;
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Title = "Credit Card Information";
            #region Class Level Variables 

            CreditCard show = new CreditCard();
            String FileName = String.Empty;
            NewCardMenu newCreditCardMenu = new NewCardMenu();
            CreditCardList CreditCardListWorking = new CreditCardList();
            InputValidation ValidValue = new InputValidation();
            int CountOfCC = 0;

            #endregion

            #region Menu Values

            Menu menu = new Menu("Enter The Number of Your Choice");
            menu = menu + "Create a New Empty Credit Card List" +
                   "Open a Text File and Populate a Credit Card List" +
                   "Add A Credit Card To the Current List" +
                   "Remove A Credit Card From the Current Credit Card List" +
                   "Retrieve and Display a Credit Card From Position n in the List" +
                   "Retrieve and Display a Credit Card by its Card Number" +
                   "Retrieve and Display Credit Cards That Belong to a Specified Person" +
                   "Retrieve and Display all Non-Expired Valid Credit Cards" +
                   "Sort the Credit Cards in the Credit Card List by Card Number" +
                   "Display all the Credit Cards in the Credit Card List" +
                   "Quit";

            #endregion


            ChoicesMain choice = (ChoicesMain)menu.GetChoice();
            while (choice != ChoicesMain.QUIT)
            {
                switch (choice)
                {
                    #region EmptyCC

                    case ChoicesMain.EMPTYCC:
                        if (CreditCardListWorking.NeedsSaving == true)
                        {
                            CreditCardListWorking.SaveToAFile();
                            CreditCardListWorking = new CreditCardList();
                            CreditCardListWorking.NeedsSaving = true;
                            CountOfCC = CreditCardListWorking.Count();
                        }
                        else
                        {
                            CreditCardListWorking = new CreditCardList();
                            CreditCardListWorking.NeedsSaving = true;
                            CountOfCC = CreditCardListWorking.Count();

                        }
                        break;

                    #endregion

                    #region Open File and Populate A List

                    case ChoicesMain.OPENFILE:
                        OpenFileDialog dlg = new OpenFileDialog();
                        dlg.InitialDirectory = Application.StartupPath;
                        dlg.Title = "Select the input file to be processed...";
                        dlg.Filter = "text files (*.txt)|*.txt|text files (*.text)|*.text|all files|*.*";


                        if (dlg.ShowDialog() == DialogResult.Cancel)
                        {
                            MessageBox.Show("File Open canceled by user. Program aborted.", "File Open Error");
                            Application.Exit();
                        }
                        else
                        {
                            CreditCardListWorking.CreditCardValidation(dlg.FileName);
                        }
                        CountOfCC = CreditCardListWorking.Count();
                        Console.WriteLine("\nYou Have A Total of " + CountOfCC + " Credit Cards in the List\n\nPress Enter To Continue");
                        Console.ReadLine();
                        break;

                    #endregion

                    #region Add a Credit Card To The List

                    case ChoicesMain.ADDCC:
                        newCreditCardMenu = new NewCardMenu();
                        CreditCard AddCreditCard = (CreditCard)newCreditCardMenu.NewCreditCardMenu();
                        CreditCardListWorking = CreditCardListWorking + AddCreditCard;
                        CreditCardListWorking.NeedsSaving = true;
                        CountOfCC = CreditCardListWorking.Count();
                        Console.WriteLine("\nYou Have A Total of " + CountOfCC + " Credit Cards in the List\n\nPress Enter To Continue");
                        Console.ReadLine();
                        break;

                    #endregion

                    #region Remove a Credit Card From The List

                    case ChoicesMain.REMOVECC:
                        CreditCardListWorking.DisplayFirstandLast();
                        Boolean valid = false;
                        int RemoveN = -1;
                        Console.Write("What Number Person Would You Like to Remove?");
                        while (valid == false)
                        {
                            try
                            {
                                RemoveN = int.Parse(Console.ReadLine());
                            }
                            catch (Exception)
                            {

                                Console.WriteLine("Please enter a number between 1 and " +
                                                  CreditCardListWorking.NumCCInList());
                                valid = false;
                            }
                            valid = true;
                        }
                        if (RemoveN <= CreditCardListWorking.NumCCInList() && RemoveN > -1 && CreditCardListWorking.Count() > 0)
                        {
                            CreditCardListWorking.RemoveCCN(RemoveN - 1);
                            valid = true;
                        }
                        else
                        {
                            valid = false;
                        }
                        CreditCardListWorking.NeedsSaving = true;
                        CountOfCC = CreditCardListWorking.Count();
                        Console.WriteLine("\nYou Have A Total of " + CountOfCC + " Credit Cards in the List\n\nPress Enter To Continue");
                        Console.ReadLine();
                        break;

                    #endregion

                    #region Retrieve Credit Card at Index N

                    case ChoicesMain.RETRIEVEATN:
                        CreditCardListWorking.DisplayFirstandLast();
                        int NumberOfCardChosen;
                        Boolean validChoice = false;
                        if (CreditCardListWorking.Count() <= 0)
                        {
                            Console.WriteLine("There are no records to work with.");
                            break;
                        }
                        while (validChoice == false)
                        {

                            try
                            {
                                Console.WriteLine("What number credit card would you like to look at?");
                                NumberOfCardChosen = (int.Parse(Console.ReadLine())) - 1;
                                CreditCard FoundCreditCard = new CreditCard();
                                if (NumberOfCardChosen < CreditCardListWorking.NumCCInList() && NumberOfCardChosen >= 0)
                                {
                                    Console.WriteLine(CreditCardListWorking[NumberOfCardChosen].ViewInputValues());
                                    Console.WriteLine("\nPress Enter To Continue");
                                    Console.ReadLine();
                                    valid = true;
                                    break;

                                }
                                else
                                {

                                    Console.WriteLine("Please enter a number between 1 and " +
                                                      CreditCardListWorking.NumCCInList());
                                    valid = false;
                                }
                            }
                            catch (Exception)
                            {

                                Console.WriteLine("You did not enter a valid number.");
                                valid = false;
                            }
                        }
                        break;

                    #endregion

                    #region Retrieve A Credit Card By Number

                    case ChoicesMain.RETRIEVEBYCCNUM:
                        String EnteredCCNum = String.Empty;
                        valid = false;
                        Console.WriteLine("Enter the Credit Card You Would Like To Search For: ");
                        EnteredCCNum = Console.ReadLine();
                        EnteredCCNum = Regex.Replace(EnteredCCNum, @"[\s]", "");
                        valid = ValidValue.CreditCardValidation(EnteredCCNum);

                        if (EnteredCCNum == null)
                        {
                            EnteredCCNum = String.Empty;
                        }

                        EnteredCCNum = Regex.Replace(EnteredCCNum, @"[\s]", "");

                        if (CreditCardListWorking[EnteredCCNum] != null)
                        {
                            Console.WriteLine(CreditCardListWorking[EnteredCCNum].ViewInputValues());
                            Console.WriteLine("Press Enter To Continue");
                            Console.ReadLine();
                        }
                        else
                        {
                            Console.WriteLine("Credit Card Not Found\nPress Enter To Continue");
                            Console.ReadLine();
                        }

                        break;
                    #endregion

                    #region Retrieve A Credit Card By Name
                    case ChoicesMain.RETRIEVEBYNAME:
                        String FirstName = String.Empty;
                        String LastName = String.Empty;
                        valid = false;
                        Console.WriteLine("The first name of the person you would like to search for: ");
                        FirstName = Console.ReadLine();
                        valid = ValidValue.NameValidation(FirstName);

                        while (valid == false)
                        {

                            Console.WriteLine("You did not enter a valid name\nPlease Try Again.");
                            FirstName = Console.ReadLine();
                            valid = ValidValue.NameValidation(FirstName);

                        }

                        FirstName = Regex.Replace(FirstName, @"[\s]", "");

                        Console.WriteLine("Please enter the last name of the person you would like to search for: ");
                        LastName = Console.ReadLine();
                        valid = ValidValue.NameValidation(LastName);

                        while (valid == false)
                        {
                            Console.WriteLine("You did not enter a valid name\nPlease Try Again.");
                            valid = ValidValue.NameValidation(LastName);

                        }

                        LastName = Regex.Replace(LastName, @"[\s]", "");

                        try
                        {
                            foreach (CreditCard c in CreditCardListWorking.RetrieveByName(FirstName, LastName))
                            {
                                Console.WriteLine(c.ViewInputValues() + "\n\n");
                            }
                            Console.ReadLine();
                        }
                        catch (IndexOutOfRangeException)
                        {
                            Console.WriteLine("Name Not Found");
                            Console.ReadLine();
                        }

                        break;
                    #endregion

                    #region Retrieve All Non-Expired Credit Cards
                    case ChoicesMain.NONEXPIRED:
                        Console.WriteLine(CreditCardListWorking.ListOfNonExpiredCCs() + "\n\nPress Enter To Continue\nCount: ");
                        Console.ReadLine();
                        break;
                    #endregion

                    #region Sort By Credit Card Number
                    case ChoicesMain.SORTBYCCNUM:
                        CreditCardListWorking.SortedList();
                        CreditCardListWorking.NeedsSaving = true;
                        break;

                    #endregion

                    #region Display all Credit Cards
                    case ChoicesMain.DISPLAYALLCC:
                        Console.WriteLine(CreditCardListWorking.DisplayCreditCards());
                        Console.WriteLine("\nYou Have A Total of " + CountOfCC + " Credit Cards in the List\n\nPress Enter To Continue");
                        Console.ReadLine();
                        Console.ReadLine();
                        break;
                    #endregion


                    #region Quit
                    case ChoicesMain.QUIT:
                        if (CreditCardListWorking.NeedsSaving == true)
                        {
                            CreditCardListWorking.SaveToAFile();

                        }
                        Console.WriteLine("You selected Quit");
                        Console.ReadLine();

                        break;
                        #endregion




                }  // end of switch


                choice = (ChoicesMain)menu.GetChoice();

                //Console.WriteLine("Press Enter To Continue");

            }  // end of while
            Console.WriteLine("Count: " + CreditCardListWorking.CountOfCC());

        }// end of main
    }//end CCDriver
}//end namespace
   
