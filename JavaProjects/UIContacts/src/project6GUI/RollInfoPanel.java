/**
 * ---------------------------------------------------------------------------
 * File name: RollInfoPanel.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 24, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Holds the panel that has the information about the course
 *
 * <hr>
 * Date created: Apr 24, 2016
 * <hr>
 * @author Allison Ivey
 */
public class RollInfoPanel extends JPanel
{
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected JLabel lblInstructor = new JLabel("Instructor: "); //the label for instructor 
	protected JLabel lblCourseName = new JLabel("Course Name: ");//the label for the course name
	protected JLabel lblCourseNumber = new JLabel("Course Number: ");//the label for the course number
	protected JTextField txtInstructor = new JTextField();//the text field for the instructor
	protected JTextField txtCourseName = new JTextField();//text field for the course name
	protected JTextField txtCourseNumber = new JTextField();//text field for the course number
	protected RollManager classList; //the class list
	
	
	/**
	 * Adds all the boxes and labels to the roll panel.   
	 *
	 * <hr>
	 * Date created: Apr 30, 2016 
	 *
	 * 
	 * @param classList the main class roll
	 */
	RollInfoPanel(RollManager classList)
	{
		
		JPanel rollPanel = new JPanel();
		this.classList = classList;
		setInstructorText();
		setCourseName();
		setCourseNumber();
		rollPanel.add (lblCourseName);
		rollPanel.add (txtCourseName);
		rollPanel.add (lblCourseNumber);
		rollPanel.add (txtCourseNumber);
		rollPanel.add (lblInstructor);
		rollPanel.add (txtInstructor);
		GridLayout grd = new GridLayout(3,1);
		rollPanel.setLayout (grd);
		rollPanel.setPreferredSize (new Dimension(250,100));
		
		add(rollPanel);
		
	}
	
	/**
	 * setter for the instructor text       
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void setInstructorText()
	{
		txtInstructor = new JTextField(classList.getInstructor ( ));
	}
	
	/**
	 * Setter for the course name       
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void setCourseName()
	{
		txtCourseName = new JTextField(classList.getCourseName ( ));
	}
	
	/**
	 * setter for the course number       
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void setCourseNumber()
	{
		txtCourseNumber = new JTextField(classList.getCourseNumber ( ));
	}
	
	/**
	 * getter for the instructor text box       
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 * @return
	 */
	public String getInstructorText()
	{
		String instructor;
		instructor = txtInstructor.getText ( );
		return instructor;
	}
	
	/**
	 * The getter for the course name box 
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 * @return
	 */
	public String getCourseNameText()
	{
		String courseName;
		courseName = txtCourseName.getText ( );
		return courseName;
	}
	
	/**
	 * the getter for the course number box   
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 * @return
	 */
	public String getCourseNumber()
	{
		String courseNumber;
		courseNumber = txtCourseNumber.getText ( );
		return courseNumber;
	}
}
