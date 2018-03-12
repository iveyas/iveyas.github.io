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
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication2
{
    /// <summary>
    /// This is th emain class that controls the rest of the program.
    /// </summary>
    static class InfixPostfixDriver
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }

 
    }
}
