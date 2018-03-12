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
using System.Text.RegularExpressions;
using System.Windows.Forms;
using System.Collections.Generic;
using CreditCardProject;
using System.Collections;
using System.Globalization;
using System.Linq;

namespace _2200_201_IveyAllison_Project1
{
    /// <summary>
    /// This is the list class that holds a list of credit cards.  It does much of the user input
    /// that pertains to the list class. 
    /// </summary>
    /// <seealso cref="System.Collections.Generic.IEnumerable{_2200_201_IveyAllison_Project1.CreditCard}" />
    /// <seealso cref="System.Collections.Generic.IComparer{_2200_201_IveyAllison_Project1.CreditCard}" />
    public class CreditCardList : IEnumerable<CreditCard>, IComparer<CreditCard>
    {
        /// <summary>
        /// The new credit card list
        /// </summary>
        private readonly List<CreditCard> NewCreditCardList = new List<CreditCard>();
        /// <summary>
        /// The list needs saving
        /// </summary>
        private Boolean blnNeedsSaving = false;
        /// <summary>
        /// The save dialog
        /// </summary>
        private SaveFileDialog SaveDlg;
        /// <summary>
        /// Gets or sets a value indicating whether [needs saving].
        /// </summary>
        /// <value>
        ///   <c>true</c> if [needs saving]; otherwise, <c>false</c>.
        /// </value>
        public Boolean NeedsSaving
        {
            get { return blnNeedsSaving; }
            set { blnNeedsSaving = value; }
        }

        #region Addition Operator

        /// <summary>
        /// Implements the operator +.
        /// </summary>
        /// <param name="c">The c.</param>
        /// <param name="d">The d.</param>
        /// <returns>
        /// The result of the operator.
        /// </returns>
        public static CreditCardList operator +(CreditCardList c, CreditCard d)
        {
            c.NewCreditCardList.Add(d);
            return c;
        }

        #endregion

        #region Minus Operator

        /// <summary>
        /// Implements the operator -.
        /// </summary>
        /// <param name="c">The c.</param>
        /// <param name="d">The d.</param>
        /// <returns>
        /// The result of the operator.
        /// </returns>
        public static CreditCardList operator -(CreditCardList c, CreditCard d)
        {
            c.NewCreditCardList.Remove(d);
            return c;
        }

        #endregion

        #region Credit Card Validation Given File Values

        /// <summary>
        /// Credits the card validation.
        /// </summary>
        /// <param name="FileName">Name of the file.</param>
        public void CreditCardValidation(String FileName)
        {
            Boolean ValidEntery = false;
            InputValidation NameValid = new InputValidation();
            String ValidFirstName = String.Empty;
            String ValidLastName = String.Empty;
            String ValidPhone = String.Empty;
            String ValidEmail = String.Empty;
            String ValidDateValue = String.Empty;
            String ValidCCNum = String.Empty;
            Boolean ValidDate = false;
            Boolean ValidCC = false;
            StreamReader rdr = null;
            Boolean AddToTheList = true;
            try
            {
                rdr = new StreamReader(FileName);
                while (rdr.Peek() != -1)
                {
                    String[] fields = rdr.ReadLine().Split('|');
                    ValidFirstName = fields[0];
                    ValidLastName = fields[1];
                    ValidCCNum = fields[4];
                    ValidDateValue = fields[5];
                    ValidPhone = fields[2];
                    ValidEmail = fields[3];

                    ValidEntery = NameValid.NameValidation(ValidFirstName);
                      
                    if (ValidEntery == false)
                    {
                        Console.WriteLine(
                            ValidFirstName + " is not a valid Name\nCould Not Include Credit Card In List");

                        Console.ReadLine();
                        ValidFirstName = null;
                        AddToTheList = false;
                    }
                    else
                    {
                        ValidFirstName = fields[0];

                    }

                    ValidEntery = NameValid.NameValidation(ValidLastName);

                    if (ValidEntery == false)
                    {
                        Console.WriteLine(ValidLastName + " is not a valid name.\nCould not include this record");
                        ValidLastName = null;
                        AddToTheList = false;
                    }
                    else
                    {
                        ValidLastName = fields[1];
                        ValidEntery = false;
                    }

                    ValidEntery = NameValid.ValidPhoneNumber(ValidPhone);

                    if (ValidEntery == false)
                    {
                        Console.WriteLine(
                            ValidPhone + " is not a valid Phone Number\nCould not include this record");

                        ValidPhone = null;
                        AddToTheList = false;
                    }
                    else
                    {
                        ValidPhone = fields[2];
                    }

                    ValidEntery = NameValid.ValidEmailAddress(ValidEmail);

                    if (ValidEntery == false)
                    {
                        Console.WriteLine(ValidEmail + "is not a valid Email Address\nCould Not Include Credit Card In List");
                        ValidEmail = null;
                        AddToTheList = false;
                    }
                    else
                    {
                        ValidEmail = fields[3];
                    }


                    ValidCCNum = Regex.Replace(ValidCCNum, @"[\s]", "");
                    ValidCC = NameValid.CreditCardValidation(ValidCCNum);
                    String[] MonthYear = ValidDateValue.Split('/');
                    ValidDate = NameValid.ValidCreditCardDate(MonthYear[0], MonthYear[1]);
                    CreditCard
                        NewCreditCard = new CreditCard(ValidFirstName, ValidLastName, ValidPhone, ValidEmail,
                            ValidCCNum, ValidDateValue);
                    
                        NewCreditCard.setCreditCardType(NameValid.CreditCardType(ValidCCNum, ValidCC));
                    if(AddToTheList == true)
                        this.NewCreditCardList.Add(NewCreditCard);
                    else
                    {
                        Console.WriteLine("Cound Not Add This Record.  Some Values were not valid.\n\nPress Enter To Continue");
                        Console.ReadLine();
                    }
                    AddToTheList = true;

                }



            }
            catch (Exception)
            {
            }
            finally
            {
                if (rdr != null)
                    rdr.Close();
            }

            NeedsSaving = true;

        }

        #endregion

        #region Display Credit Cards

        /// <summary>
        /// Displays the credit cards.
        /// </summary>
        /// <returns></returns>
        public String DisplayCreditCards()
        {
            String CreditCardDisplay = String.Empty;
            int i = 1;
            foreach (CreditCard c in NewCreditCardList)
            {
                CreditCardDisplay += "Person" + i + c.ViewInputValues() + "\n";
                i++;
            }
            return CreditCardDisplay;
        }
        #endregion

        #region Number of Credit Cards in a List
        /// <summary>
        /// Numbers of cc in list.
        /// </summary>
        /// <returns></returns>
        public int NumCCInList()
        {
            int numCC = NewCreditCardList.Count;
            return numCC;
        }
        #endregion

        #region RemoveCCN

        /// <summary>
        /// Removes the credit card at n value
        /// </summary>
        /// <param name="n">The n.</param>
        public void RemoveCCN(int n)
        {
      
            NewCreditCardList.RemoveAt(n);
            NeedsSaving = true;

        }

        #endregion

        #region LocateCCN

        /// <summary>
        /// Locates the Credit Card Number.
        /// </summary>
        /// <param name="n">The n.</param>
        /// <returns></returns>
        public CreditCard LocateCCN(int n)
        {
            return NewCreditCardList[n];
        }

        #endregion

        #region Display First And Last Name

        /// <summary>
        /// Displays the first and last name.
        /// </summary>
        public void DisplayFirstandLast()
        {
            int i = 1;
            foreach (CreditCard c in this.NewCreditCardList)
            {
                Console.WriteLine(i + ".  " + c.FirstAndLastName() + "\n");
                i++;
            }
            //Console.ReadLine();
        }

        #endregion


        #region Retrieve Credit Card By Name

        /// <summary>
        /// Retrieves the credit card by name of card holder.
        /// </summary>
        /// <param name="First">The first.</param>
        /// <param name="Last">The last.</param>
        /// <returns></returns>
        public List<CreditCard> RetrieveByName(String First, String Last)
        {
            int[] CCIndex = new int[0];
            Int32 i = 0;
            String FirstAndLast;
            String InputFirstAndLast = First + Last;
            InputFirstAndLast = Regex.Replace(InputFirstAndLast, @"[\s]", "");
            List<CreditCard> FoundNames = new List<CreditCard>();

            

            try
            {
                foreach (CreditCard c in NewCreditCardList)
                {
                    FirstAndLast = Regex.Replace(c.FirstAndLastName(), @"[\s]", "");
                    if (InputFirstAndLast == FirstAndLast)
                    {
                        FoundNames.Add(NewCreditCardList[i]);
                    }
                    i++;

                }

                return FoundNames;
            }
            catch (ArgumentOutOfRangeException)
            {
                Console.WriteLine("Name Not Found");
                return FoundNames = new List<CreditCard>();
            }


        }

        #endregion

        #region Retrieve All Credit Cards That Are Not Expired

        /// <summary>
        /// Lists the of non expired credit cards.
        /// </summary>
        /// <returns></returns>
        public String ListOfNonExpiredCCs()
        {
            String ListOfValidCCs = String.Empty;

            foreach (CreditCard c in NewCreditCardList)
            {
                if (c.GetIfDateIsValid())
                {
                    ListOfValidCCs += c.ViewInputValues() + "\n";
                }
            }

            if (ListOfValidCCs == String.Empty)
            {
                Console.WriteLine("No Valid Credit Cards Found");
            }
            return ListOfValidCCs;
        }

        #endregion

        #region Num Indexer

        /// <summary>
        /// Gets or sets the <see cref="CreditCard"/> at the specified index.
        /// </summary>
        /// <value>
        /// The <see cref="CreditCard"/>.
        /// </value>
        /// <param name="index">The index.</param>
        /// <returns></returns>
        public CreditCard this[int index]
        {
            get
            {
                if (index >= 0 && index < NewCreditCardList.Count)
                {
                    return NewCreditCardList[index];
                }
                else
                {
                    return null;
                }
            }
            set
            {
                if (index >= 0 && index < NewCreditCardList.Count)
                {
                    NewCreditCardList[index] = value;
                }

            }
        }

        #endregion

        #region String Indexer
        /// <summary>
        /// Gets the <see cref="CreditCard"/> with the specified indexer.
        /// </summary>
        /// <value>
        /// The <see cref="CreditCard"/>.
        /// </value>
        /// <param name="indexer">The indexer.</param>
        /// <returns></returns>
        public CreditCard this[String indexer]
        {
            get
            {
                NewCreditCardList.Sort();
                int n = NewCreditCardList.BinarySearch(new CreditCard(indexer));
               
                if (n < 0)
                {
                   return null;
                }

                if (n != -1 || n>0)
                {
                    return NewCreditCardList[n];
                }
                else
                {
                    return null;
                }


            }

        }

        #endregion

        #region Sort By CC Number

        /// <summary>
        /// Sorts the list.
        /// </summary>
        public void SortedList()
        {
            NewCreditCardList.Sort();
            NeedsSaving = true;

        }

        /// <summary>
        /// Returns an enumerator that iterates through the collection.
        /// </summary>
        /// <returns>
        /// A <see cref="T:System.Collections.Generic.IEnumerator`1" /> that can be used to iterate through the collection.
        /// </returns>
        public IEnumerator<CreditCard> GetEnumerator()
        {
            return ((IEnumerable<CreditCard>)NewCreditCardList).GetEnumerator();
        }

        /// <summary>
        /// Returns an enumerator that iterates through a collection.
        /// </summary>
        /// <returns>
        /// An <see cref="T:System.Collections.IEnumerator" /> object that can be used to iterate through the collection.
        /// </returns>
        IEnumerator IEnumerable.GetEnumerator()
        {
            return ((IEnumerable<CreditCard>)NewCreditCardList).GetEnumerator();
        }

        /// <summary>
        /// Compares two objects and returns a value indicating whether one is less than, equal to, or greater than the other.
        /// </summary>
        /// <param name="x">The first object to compare.</param>
        /// <param name="y">The second object to compare.</param>
        /// <returns>
        /// A signed integer that indicates the relative values of <paramref name="x" /> and <paramref name="y" />, as shown in the following table.Value Meaning Less than zero<paramref name="x" /> is less than <paramref name="y" />.Zero<paramref name="x" /> equals <paramref name="y" />.Greater than zero<paramref name="x" /> is greater than <paramref name="y" />.
        /// </returns>
        /// <exception cref="NotImplementedException"></exception>
        int IComparer<CreditCard>.Compare(CreditCard x, CreditCard y)
        {
            throw new NotImplementedException();
        }

        #endregion

        #region Comparer

        /// <summary>
        /// Compares the specified CC1 and CC2.
        /// </summary>
        /// <param name="cc1">The CC1.</param>
        /// <param name="cc2">The CC2.</param>
        /// <returns></returns>
        public int Compare(CreditCard cc1, CreditCard cc2)
        {
            int returnValue = 1;
            if (cc1 != null && cc2 == null)
            {
                returnValue = 0;
            }
            else if (cc1 == null && cc2 != null)
            {
                returnValue = 0;
            }
            else if (cc1 != null && cc2 != null)
            {
                if (cc1.Equals(cc2))
                {
                    returnValue = cc1.CompareTo(cc2);
                }
                else
                {
                    returnValue = cc2.CompareTo(cc1);
                }
            }
            return returnValue;
        }

        #endregion

        #region SaveToAFile

        /// <summary>
        /// Saves to a file.
        /// </summary>
        public void SaveToAFile()
        {
            SaveDlg = new SaveFileDialog();
            SaveDlg.InitialDirectory = Application.StartupPath;
            SaveDlg.Title = "Save This List";
            SaveDlg.Filter = "text files|*.txt|all files|*.*";
            if (SaveDlg.ShowDialog() == DialogResult.Cancel)
            {
                MessageBox.Show("File Open Canceled by user. Program aborted", "File Open Error");
                Application.Exit();
            }

            StreamWriter writer = null;
            try
            {
                writer = new StreamWriter(new FileStream(SaveDlg.FileName, FileMode.Create, FileAccess.Write));
                for (int i = 0; i < NewCreditCardList.Count; i++)
                {
                    CreditCard c = NewCreditCardList[i];
                    writer.WriteLine(c.DeliminatedCCString());
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.GetType() + "\n" + ex.Message + "\n" + ex.StackTrace, "Output Error",
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                if(writer != null)
                    writer.Close();
            }

            NeedsSaving = false;
        }

        #endregion

        #region CountOfCC

        /// <summary>
        /// Counts the number of Credit Cards.
        /// </summary>
        /// <returns></returns>
        public int CountOfCC()
        {
            int Count;
            Count = NewCreditCardList.Count;
            return Count;
        }

        #endregion

    }
}




