//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 3- Profiling Research Program
//	File Name:		ProfilingResearchProgram.cs
//	Description:    Program to test the efficiency of seven different sorting methods
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey,iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Thursday, October 27, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2200_201_IveyAllisonProfilingResearch
{
    /// <summary>
    /// This program uses seven sorting algorithms and modifiable input data to sort numbers in a list
    /// </summary>
    class ProfilingResearchProgram
    {
        /// <summary>
        /// Mains the specified arguments.
        /// </summary>
        /// <param name="args">The arguments.</param>
        static void Main(string[] args)
        {
            int max = 100; //the biggest number that can be put into a list
            int ListSize = 100; // the size of the list 
            SortingMethods sortingMethods = new SortingMethods(); //instanciates the sorting methods
            Random randomNum = new Random(max); 

            List<int> test = new List<int>(100); //the list that is copied to all the other lists so that the lists are consistant 

            for (int i = 0; i < ListSize; i = i +2)
            {
                test.Add(randomNum.Next(100));
                test.Add(i);
            }

            List<int> test1 = new List<int>(test);
            List<int> test2 = new List<int>(test);
            List<int> test3 = new List<int>(test);
            List<int> test4 = new List<int>(test);
            List<int> test5 = new List<int>(test);
            List<int> test6 = new List<int>(test);
            List<int> test7 = new List<int>(test);

            sortingMethods.InsertionSortMethod(test7, ListSize);

            sortingMethods.SinkSort(test1, ListSize);

            sortingMethods.SelectionSort(test2, ListSize);

            sortingMethods.ShellSort(test3, ListSize);

            sortingMethods.QuickMedianOfThreeSort(test4);

            sortingMethods.MergeSort(test5);

            sortingMethods.OriginalQuickSort(test6);

        }
    }
}
