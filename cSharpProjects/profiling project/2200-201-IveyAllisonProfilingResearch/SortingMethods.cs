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
    /// This class contains all the sorting algorithms 
    /// </summary>
    class SortingMethods
    {
        /// <summary>
        /// Insertions sort method.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="N">The n.</param>
        public void InsertionSortMethod(List<int> list, int N)
        {
            int temp, j;
            for (int i = 1; i < N; i++)
            {
                temp = list[i];

                for (j = i; j > 0 && temp < list[j - 1]; j--)
                {
                    list[j] = list[j - 1];
                }

                list[j] = temp;
            }

           
            
        }

        /// <summary>
        /// Sinks sort method.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="N">The n.</param>
        public void SinkSort(List<int> list, int N)
        {
            bool sorted = false;
            int pass = 0;

            while (!sorted && (pass<N))
            {
                pass++;
                sorted = true;

                for(int i = 0; i < N - pass; i++)
                {
                    if(list[i] > list[i +1])
                    {
                        Swap(list, i, i + 1);
                        sorted = false;
                    }
                }
            }

           
            

        }

        /// <summary>
        /// Swaps the specified list.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="n">The n.</param>
        /// <param name="m">The m.</param>
        public void Swap (List<int> list, int n, int m)
        {
            int temp = list[n];
            list[n] = list[m];
            list[m] = temp;
        }

        /// <summary>
        /// Selections sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="n">The n.</param>
        public void SelectionSort(List<int> list, int n)
        {
            if(n <= 1)
            {
                return;
            }

            int max = Max(list, n);
            if (list[max] != list[n - 1])
                Swap(list, max, n - 1);

            SelectionSort(list, n - 1);

           
            


        }

        /// <summary>
        /// Maximums the specified list.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="n">The n.</param>
        /// <returns></returns>
        public int Max(List<int> list, int n)
        {
            int max = 0;
            
            for(int i = 0; i<n; i++)
            {
                if (list[max] < list[i])
                    max = i;
            }

            return max;
        }

        /// <summary>
        /// Originals quick sort.
        /// </summary>
        /// <param name="list">The list.</param>
        public void OriginalQuickSort(List<int> list)
        {
            QuickSort(list, 0, list.Count - 1);

           
            

        }

        /// <summary>
        /// Quicks sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="start">The start.</param>
        /// <param name="end">The end.</param>
        public void QuickSort(List<int> list, int start, int end)
        {
            int left = start;
            int right = end;

            if(left >= right)
            {
                return;
            }

            while(left < right)
            {
                while (list[left] <= list[right] && left < right)
                    right--;

                if (left < right)
                    Swap(list, left, right);

                while(list[left] <= list[right] && left <right)
                    left++;
                

                if (left < right)
                    Swap(list, left, right);
            }
        }

        /// <summary>
        /// Quicks median of three sort.
        /// </summary>
        /// <param name="list">The list.</param>
        public void QuickMedianOfThreeSort(List<int> list)
        {
            QuickMedOfThreeSort(list, 0, list.Count - 1);

           
            

        }

        /// <summary>
        /// Quicks  med of three sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="start">The start.</param>
        /// <param name="end">The end.</param>
        public void QuickMedOfThreeSort(List<int> list, int start, int end)
        {
            const int cutoff = 100;
            
            if(start + cutoff > end)
            {
                InsertSort(list, start, end);

            } 
            else
            {
                int middle = (start + end) + 2;
                if (list[middle] < list[start])
                    Swap(list, start, end);
                if (list[end] < list[start])
                    Swap(list, start, end);
                if (list[end] < list[middle])
                    Swap(list, middle, end);

                int pivot = list[middle];
                Swap(list, middle, end);

                int left, right;
                for(left = start, right = end - 1; ; )
                {
                    while (list[++left] < pivot) ;
                    while (pivot < list[--right]) ;
                    if (left < right)
                        Swap(list, left, right);
                    else
                        break;
                }

                Swap(list, left, end - 1);

                QuickMedOfThreeSort(list, start, left - 1);
                QuickMedOfThreeSort(list, left + 1, end);
                
                

            }
        }

        /// <summary>
        /// Insert sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="start">The start.</param>
        /// <param name="end">The end.</param>
        public void InsertSort(List<int> list, int start, int end)
        {
            int temp, j;
            for(int i = start +1; i <= end; i++)
            {
                temp = list[i];

                for(j = i; j > start && temp < list[j-1]; j--)
                {
                    list[j] = list[j - 1];
                }

                list[j] = temp; 
            }

           
            


        }

        /// <summary>
        /// Shells sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <param name="N">The n.</param>
        public void ShellSort(List<int> list, int N)
        {
            for(int gap = N/2; gap >0; gap = (gap == 2 ?1 : (int)(gap/2.2)))
            {

                int temp, j;
                for(int i = gap; i<N; i++)
                {
                    temp = list[i];

                    for(j = i; j >= gap && temp < list[j-gap]; j -= gap)
                    {
                        list[j] = list[j - gap];
                    }

                    list[j] = temp;

                }
            }

           
            


        }

        /// <summary>
        /// Merges sort.
        /// </summary>
        /// <param name="list">The list.</param>
        /// <returns></returns>
        public List<int> MergeSort(List<int> list)
        {
            if (list.Count <= 1)
                return list;

            List<int> result = new List<int>();
            List<int> left = new List<int>();
            List<int> right = new List<int>();

            int middle = list.Count / 2;
            for(int i = 0; i < middle; i++)
            {
                left.Add(list[i]);
            }

            for(int i = middle; i< list.Count; i++)
            {
                right.Add(list[i]);
            }

            left = MergeSort(left);
            right = MergeSort(right);

            if (left[left.Count - 1] <= right[0])
                return append (left, right);

            result = merge(left, right);
           
            
            return result;
        }

        /// <summary>
        /// Merges the specified left.
        /// </summary>
        /// <param name="left">The left.</param>
        /// <param name="right">The right.</param>
        /// <returns></returns>
        public List<int> merge (List<int> left, List<int> right)
        {
            List<int> result = new List<int>();

            while(left.Count > 0 && right.Count > 0)
            {
                if(left[0] < right[0])
                {
                    result.Add(left[0]);
                    left.RemoveAt(0);
                }
                else
                {
                    result.Add(right[0]);
                    right.RemoveAt(0);
                }
            }

            while(left.Count > 0)
            {
                result.Add(left[0]);
                left.RemoveAt(0);
            }

            while(right.Count >0)
            {
                result.Add(right[0]);
                right.RemoveAt(0);
            }

            return result;
        }

        /// <summary>
        /// Appends the specified left.
        /// </summary>
        /// <param name="left">The left.</param>
        /// <param name="right">The right.</param>
        /// <returns></returns>
        public List<int> append (List<int> left, List<int> right)
        {
            List<int> result = new List<int>(left);
            foreach (int x in right)
                result.Add(x);
            return result;
        }




    }
}
