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
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApplication2
{

    /// <summary>
    /// This is the class file with all the action handlers 
    /// </summary>
    /// <seealso cref="System.Windows.Forms.Form" />
    public partial class InfixToPostFixForm : Form
    {
        /// <summary>
        /// The infix list
        /// </summary>
        private List<String> InfixList = new List<string>();
        /// <summary>
        /// The file name
        /// </summary>
        string fileName = "";
        /// <summary>
        /// Initializes a new instance of the <see cref="InfixToPostFixForm"/> class.
        /// </summary>
        public InfixToPostFixForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Handles the Click event of the button1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void button1_Click(object sender, EventArgs e)
        {
            Postfix displayPostFix = new Postfix();
            PostfixExpression.Text = displayPostFix.InfixToPostfixConvert(InfixExpression.Text);
           
        }

        /// <summary>
        /// Handles the Click event of the Clear control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void Clear_Click(object sender, EventArgs e)
        {
            InfixExpression.Text = String.Empty;
            PostfixExpression.Text = String.Empty;
        }

        /// <summary>
        /// Handles the Click event of the label1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void label1_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the Click event of the toolStripDropDownButton1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void toolStripDropDownButton1_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the Click event of the toolStripTextBox1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void toolStripTextBox1_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the Click event of the toolStripButton1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void toolStripButton1_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the 1 event of the toolStripDropDownButton1_Click control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void toolStripDropDownButton1_Click_1(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the Load event of the InfixToPostFixForm control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void InfixToPostFixForm_Load(object sender, EventArgs e)
        {
             
        }

        /// <summary>
        /// Handles the Click event of the Exit control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void Exit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        /// <summary>
        /// Handles the Click event of the fileToolStripMenuItem control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void fileToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Handles the Click event of the exitToolStripMenuItem control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        /// <summary>
        /// Handles the Click event of the inputInfixDataFileToolStripMenuItem control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void inputInfixDataFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog OpenDlg = new OpenFileDialog();
            OpenDlg.InitialDirectory = Application.StartupPath;
            OpenDlg.Title = "Open a Infix File,";
            OpenDlg.Filter = "text files|*.txt|all files|*.*";
            

            if (OpenDlg.ShowDialog() == DialogResult.Cancel)
                return;
            else
            {
                this.fileName = OpenDlg.FileName;
            }
            this.InfixList = PopulateList(this.fileName);
            InputDataInfix.DataSource= InfixList;

          
        }

        /// <summary>
        /// Handles the Click event of the aboutInfixToPostfixToolStripMenuItem control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void aboutInfixToPostfixToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AboutBox1 aboutBox = new AboutBox1();
            aboutBox.ShowDialog();
        }

        /// <summary>
        /// Handles the SelectedIndexChanged event of the listBox1 control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
          
            InfixExpression.Text = InputDataInfix.SelectedItem.ToString();
            Postfix displayPostFix = new Postfix();
            PostfixExpression.Text =  displayPostFix.InfixToPostfixConvert(InfixExpression.Text);

        }

        /// <summary>
        /// Populates the list.
        /// </summary>
        /// <param name="fileName">Name of the file.</param>
        /// <returns></returns>
        private List<String> PopulateList(string fileName)
        {

            List<string> lines = new List<string>();
            using (StreamReader r = new StreamReader(fileName))
            {
                string line;
                while ((line = r.ReadLine()) != null)
                {
                    lines.Add(line);
                }
            }

            return lines;

        }

        /// <summary>
        /// Handles the TextChanged event of the InfixExpression control.
        /// </summary>
        /// <param name="sender">The source of the event.</param>
        /// <param name="e">The <see cref="EventArgs"/> instance containing the event data.</param>
        private void InfixExpression_TextChanged(object sender, EventArgs e)
        {
           
        }

    }
}
