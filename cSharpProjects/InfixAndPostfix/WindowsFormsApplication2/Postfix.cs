//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:		Project 3- Infix and Postfix Convertion Project
//	File Name:		2200-201-IveyAllison-ProjectThree.cs
//	Description:    This program converts infix equations to postfix equations
//	Course:			CSCI 2210-201 - Data Structures
//	Author:			Allison Ivey,iveyas@etsu.edu, Department of Computing, East Tennessee State University
//	Created:		Thursday, November 4, 2016
//	Copyright:		Allison Ivey, 2016
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Status;

namespace WindowsFormsApplication2
{
    /// <summary>
    /// This class is the class that handles all the convertions of the infix equations
    /// </summary>
    class Postfix
    {
        /// <summary>
        /// Infixes to postfix convert.
        /// </summary>
        /// <param name="infixBuffer">The infix buffer.</param>
        /// <returns></returns>
        public string InfixToPostfixConvert(string infixBuffer)
        {
            int priority = 0;  //initializes the priority of an operator to zero
            string postfixBuffer = ""; //the string of the processed informmation for postfix
           
            Stack<Char> listOfOperators = new Stack<char>(); //stack of all the the operators 

            for (int i = 0; i < infixBuffer.Length; i++)
            {
                
                char I = infixBuffer[i]; //holds the value of each character in the infix buffer so the operators can be found
                if (I == '(')
                {
                    
                    String NestedOutput = "";
                    i++;
                    
                    try
                    {
                        while (infixBuffer[i] != ')')
                        {
                              NestedOutput += infixBuffer[i];
                              i++;   
                        }
                    }
                    catch (Exception) // this is the error message for when the parenthesis don't match up
                    {
                        postfixBuffer = "";
                        return "********Error********* Your prenthesis do not line up!";
                    }
                    postfixBuffer += InfixToPostfixConvert(NestedOutput);
                    i++;
                    priority = 0; 
                }
                if (I == '+' || I == '-' || I == '*' || I == '/') //checks if + - * or / are in the infix buffer
                {
                    // check the precedence
                    if (listOfOperators.Count <= 0) //if there are no values on the stack then it pushes the first operator value onto the stack
                        listOfOperators.Push(I);
                    else
                    {
                        
                        if (listOfOperators.Peek() == '*' || listOfOperators.Peek() == '/') //sets the priority if the operator is a * or / of the previous operator
                            priority = 1; 
                        else //sets the priority to zero if the operator on the stack is + or - in the previous operator on the stack
                            priority = 0;
                        if (priority == 1) //if the priority of the previous value was / or * 
                        {
                            if (I == '+' || I == '-') //if the new value is + or - then it has lower priority value and the value is popped onto the postfix buffer
                            {
                                postfixBuffer += " ";
                                postfixBuffer += listOfOperators.Pop();
                                i--; //goes back one value in the infixBuffer
                            }
                            else
                            { // Same
                                postfixBuffer += " ";
                                postfixBuffer += listOfOperators.Pop();
                                i--;
                            }
                        }
                        else //if the priority is 0 
                        {
                            if (I == '+' || I == '-') 
                            {
                                postfixBuffer += " ";
                                postfixBuffer += listOfOperators.Pop(); //if it has low priority it is popped onto the postfixBuffer
                                listOfOperators.Push(I); //then new comparitor is pushed onto the list 
                            }
                            else
                                listOfOperators.Push(I); //otherwise the new value is pushed onto the buffer
                        }
                    }
                }
                else if(I == ')')
                {
                    return "********Error********* Your prenthesis do not line up!";
                }
                else if (I != '(') // if the value on the stack is not an operator then it is added to the postfix buffer
                 {
                    postfixBuffer += I;
                 }
            }
            int len = listOfOperators.Count; //sees how many operators are left on the stack at the end of the infix values string
            for (int j = 0; j < len; j++) //all the remaining values on the operator stack are added to the end of the postfix buffer
            {
                postfixBuffer += " ";
                postfixBuffer += listOfOperators.Pop();
            }

            if (postfixBuffer.Contains("********Error********* Your prenthesis do not line up!") == true)
                return postfixBuffer = "********Error********* Your prenthesis do not line up!"; // the postfix buffer is returned
            else
            {
                return postfixBuffer; // the postfix buffer is returned
            }
        }
       
    }
}
        

