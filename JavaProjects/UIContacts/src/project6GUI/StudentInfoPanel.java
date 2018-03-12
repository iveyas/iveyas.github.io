/**
 * ---------------------------------------------------------------------------
 * File name: StudentInfoPanel.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 25, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the panel that holds the information about one particular student
 * so that it can be manipulated within the panel to update the class roll
 *
 * <hr>
 * Date created: Apr 25, 2016
 * <hr>
 * @author Allison Ivey
 */
public class StudentInfoPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	protected JTextField txtFirstName; //the text box for the first name
	protected JTextField txtLastName; //the text box for the last name
	protected JTextField txtMajor; //the text box for the major
	protected JComboBox<String> classificationBox; //the classification drop down box
	protected JTextField creditHours; //the credit hours text field
	protected JTextField txtGPA; //the GPA text field
	protected JTextField txtPhoto;	//the photos text field
	
	
	/**
	 * Sets all the default values for the text boxes and all the labels for 
	 * those text boxes        
	 *
	 * <hr>
	 * Date created: Apr 30, 2016 
	 *
	 * 
	 */
	public StudentInfoPanel()
	{
		//All the information that goes with the student's first name
		JPanel studentInfo = new JPanel();
		JLabel studentFirstName = new JLabel("First Name: ");
		txtFirstName = new JTextField("No First Name Given");
		studentInfo.add(studentFirstName);
		studentInfo.add(txtFirstName);
		//All the information that goes with the student's last name
		JLabel studentLastName = new JLabel("Last Name: ");
		txtLastName = new JTextField("No Last Name Given");
		studentInfo.add (studentLastName);
		studentInfo.add (txtLastName);
		//All the information that goes with the student's major
		JLabel studentMajor = new JLabel("Major: ");
		txtMajor = new JTextField("No Major Given");
		studentInfo.add (studentMajor);
		studentInfo.add (txtMajor);
		//All the information that goes with the student's classification
		JLabel studentClassification = new JLabel("Classification");
		String[] classificationArray = {"FRESHMAN", "SOPHOMORE", "JUNIOR", "SENIOR", "OTHER"};
		classificationBox = new JComboBox<String>(classificationArray);
		studentInfo.add (studentClassification);
		studentInfo.add (classificationBox);

		//All the information that goes with the student's credit hours
		JLabel lblCreditHours = new JLabel("Credit Hours: ");
		creditHours = new JTextField("No Number of Credit Hours Given");
		studentInfo.add (lblCreditHours);
		studentInfo.add (creditHours);
		//All the information that goes with the student's GPA
		JLabel GPA = new JLabel("GPA:");
		txtGPA = new JTextField("No GPA Given");
		studentInfo.add (GPA);
		studentInfo.add (txtGPA);
		//All the information that goes with the student's photo
		JLabel lblPhoto = new JLabel("Photo Location: ");
		txtPhoto = new JTextField("NoImageAvailable.jpeg");
		studentInfo.add (lblPhoto);
		studentInfo.add (txtPhoto);
		//adds all the student's information 
		add(studentInfo);
		studentInfo.setVisible (true);
		//sets the layout of the panel and its size
		GridLayout grd = new GridLayout(7,1);
		studentInfo.setLayout (grd);
		studentInfo.setPreferredSize (new Dimension(250,225));
	
	}
	
}
