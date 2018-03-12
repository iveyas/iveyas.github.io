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
namespace WindowsFormsApplication2
{
    /// <summary>
    /// This is the class that handles all the buttons and boxes that are on the main page
    /// </summary>
    /// <seealso cref="System.Windows.Forms.Form" />
    partial class InfixToPostFixForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(InfixToPostFixForm));
            this.button1 = new System.Windows.Forms.Button();
            this.Clear = new System.Windows.Forms.Button();
            this.Exit = new System.Windows.Forms.Button();
            this.PostfixExpression = new System.Windows.Forms.TextBox();
            this.InfixExpression = new System.Windows.Forms.TextBox();
            this.InputDataInfix = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.inputInfixDataFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutInfixToPostfixToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Stencil", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.ForeColor = System.Drawing.SystemColors.ControlText;
            this.button1.Location = new System.Drawing.Point(162, 251);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(118, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "&Generate Postfix";
            this.button1.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Clear
            // 
            this.Clear.Font = new System.Drawing.Font("Stencil", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Clear.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Clear.Location = new System.Drawing.Point(358, 251);
            this.Clear.Name = "Clear";
            this.Clear.Size = new System.Drawing.Size(118, 23);
            this.Clear.TabIndex = 1;
            this.Clear.Text = "&Clear";
            this.Clear.UseVisualStyleBackColor = true;
            this.Clear.Click += new System.EventHandler(this.Clear_Click);
            // 
            // Exit
            // 
            this.Exit.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.Exit.Font = new System.Drawing.Font("Stencil", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Exit.ForeColor = System.Drawing.SystemColors.ControlText;
            this.Exit.Location = new System.Drawing.Point(554, 251);
            this.Exit.Name = "Exit";
            this.Exit.Size = new System.Drawing.Size(118, 23);
            this.Exit.TabIndex = 2;
            this.Exit.Text = "&Exit";
            this.Exit.UseVisualStyleBackColor = true;
            this.Exit.Click += new System.EventHandler(this.Exit_Click);
            // 
            // PostfixExpression
            // 
            this.PostfixExpression.AccessibleName = "Postfix Expression ";
            this.PostfixExpression.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            this.PostfixExpression.Location = new System.Drawing.Point(173, 206);
            this.PostfixExpression.Name = "PostfixExpression";
            this.PostfixExpression.ReadOnly = true;
            this.PostfixExpression.Size = new System.Drawing.Size(499, 20);
            this.PostfixExpression.TabIndex = 3;
            // 
            // InfixExpression
            // 
            this.InfixExpression.Location = new System.Drawing.Point(173, 172);
            this.InfixExpression.Name = "InfixExpression";
            this.InfixExpression.Size = new System.Drawing.Size(499, 20);
            this.InfixExpression.TabIndex = 4;
            this.InfixExpression.TextChanged += new System.EventHandler(this.InfixExpression_TextChanged);
            // 
            // InputDataInfix
            // 
            this.InputDataInfix.FormattingEnabled = true;
            this.InputDataInfix.Location = new System.Drawing.Point(173, 28);
            this.InputDataInfix.Name = "InputDataInfix";
            this.InputDataInfix.Size = new System.Drawing.Size(499, 121);
            this.InputDataInfix.TabIndex = 5;
            this.InputDataInfix.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(75, 209);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(92, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "Postfix Expression";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "label2";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(87, 175);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(80, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "Infix Expression";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.helpToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(780, 24);
            this.menuStrip1.TabIndex = 10;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.inputInfixDataFileToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "&File";
            this.fileToolStripMenuItem.Click += new System.EventHandler(this.fileToolStripMenuItem_Click);
            // 
            // inputInfixDataFileToolStripMenuItem
            // 
            this.inputInfixDataFileToolStripMenuItem.Name = "inputInfixDataFileToolStripMenuItem";
            this.inputInfixDataFileToolStripMenuItem.Size = new System.Drawing.Size(175, 22);
            this.inputInfixDataFileToolStripMenuItem.Text = "Input Infix Data File";
            this.inputInfixDataFileToolStripMenuItem.Click += new System.EventHandler(this.inputInfixDataFileToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(175, 22);
            this.exitToolStripMenuItem.Text = "&Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // helpToolStripMenuItem
            // 
            this.helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.aboutInfixToPostfixToolStripMenuItem});
            this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            this.helpToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
            this.helpToolStripMenuItem.Text = "&Help";
            // 
            // aboutInfixToPostfixToolStripMenuItem
            // 
            this.aboutInfixToPostfixToolStripMenuItem.Name = "aboutInfixToPostfixToolStripMenuItem";
            this.aboutInfixToPostfixToolStripMenuItem.Size = new System.Drawing.Size(184, 22);
            this.aboutInfixToPostfixToolStripMenuItem.Text = "About Infix to Postfix";
            this.aboutInfixToPostfixToolStripMenuItem.Click += new System.EventHandler(this.aboutInfixToPostfixToolStripMenuItem_Click);
            // 
            // InfixToPostFixForm
            // 
            this.AcceptButton = this.button1;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.Exit;
            this.ClientSize = new System.Drawing.Size(780, 324);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.InputDataInfix);
            this.Controls.Add(this.InfixExpression);
            this.Controls.Add(this.PostfixExpression);
            this.Controls.Add(this.Exit);
            this.Controls.Add(this.Clear);
            this.Controls.Add(this.button1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "InfixToPostFixForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.InfixToPostFixForm_Load);
            this.Leave += new System.EventHandler(this.Exit_Click);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        /// <summary>
        /// The button1
        /// </summary>
        private System.Windows.Forms.Button button1;
        /// <summary>
        /// The clear
        /// </summary>
        private System.Windows.Forms.Button Clear;
        /// <summary>
        /// The exit
        /// </summary>
        private System.Windows.Forms.Button Exit;
        /// <summary>
        /// The postfix expression
        /// </summary>
        private System.Windows.Forms.TextBox PostfixExpression;
        /// <summary>
        /// The infix expression
        /// </summary>
        private System.Windows.Forms.TextBox InfixExpression;
        /// <summary>
        /// The input data infix
        /// </summary>
        private System.Windows.Forms.ListBox InputDataInfix;
        /// <summary>
        /// The label1
        /// </summary>
        private System.Windows.Forms.Label label1;
        /// <summary>
        /// The label2
        /// </summary>
        private System.Windows.Forms.Label label2;
        /// <summary>
        /// The label3
        /// </summary>
        private System.Windows.Forms.Label label3;
        /// <summary>
        /// The menu strip1
        /// </summary>
        private System.Windows.Forms.MenuStrip menuStrip1;
        /// <summary>
        /// The file tool strip menu item
        /// </summary>
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        /// <summary>
        /// The input infix data file tool strip menu item
        /// </summary>
        private System.Windows.Forms.ToolStripMenuItem inputInfixDataFileToolStripMenuItem;
        /// <summary>
        /// The exit tool strip menu item
        /// </summary>
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        /// <summary>
        /// The help tool strip menu item
        /// </summary>
        private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
        /// <summary>
        /// The about infix to postfix tool strip menu item
        /// </summary>
        private System.Windows.Forms.ToolStripMenuItem aboutInfixToPostfixToolStripMenuItem;
    }
}

