package SchoolManager;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * ---------------------------------------------------------------------------
 * File name: menuLayerTwo.java
 * Project name: IveyAllison_Project4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 26, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * This part of the menu allows the user to choose from options that will allow them
 * to create a new class and add new students to that class. 
 *
 * <hr>
 * Date created: Mar 26, 2016
 * <hr>
 * @author Allison Ivey
 */
public class menuLayerTwo
{
	JFileChooser fc = new JFileChooser();	//creates a new fileChooser object
	private RollManager newClass;	//creates a new class
	
	/**
	 * Allows the user to create a new class and allows the user to add 
	 * students to that class.           
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 */
	public void createNewClassRoll()
	{
		String strCourseName = null;	//the name of the course
		String strCourseNumber = null;	//the number of the course
		String strInstructor = null;	//the name of the instructor
		boolean blnNewStudent= true;	//asks if they want to add a new student
		try
		{
			strCourseName= JOptionPane.showInputDialog ("Enter the Course Name");
			strCourseNumber= JOptionPane.showInputDialog ("Enter the Course Number");
			strInstructor= JOptionPane.showInputDialog ("Enter the name of the instructor");
		}
		catch(Exception e)
		{
			
		}
			
			newClass = new RollManager(strCourseName, strCourseNumber, strInstructor);
			while(blnNewStudent == true)
			{
				JFrame frame = new JFrame();
				String message = "Would you like to enter a new student to this class?";
				int answer = JOptionPane.showConfirmDialog (frame, message);
				if(answer== JOptionPane.YES_OPTION)
				{
					Student newStudent= createNewStudent();
					newClass.addStudent (newStudent);
					blnNewStudent = true;
					
				}
				if(answer == JOptionPane.NO_OPTION)
				{
					blnNewStudent = false;
				}
			}
		
	}
	
	/**
	 * This method makes sure that a value can be parsed and returns a true if 
	 * it can be parsed and a false if it can not.         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @param inString the string that is being checked if it can be parsed
	 * @return blnParsable tells if the string can be parsed
	 */
	public static boolean isParsable(String inString)
	{
		boolean blnParsable= true; //tells if the value can be parsed 
		try
		{
			Double.parseDouble (inString);
		}
		catch(NumberFormatException e)
		{
			blnParsable = false;
		}
		return blnParsable;
	}
	
	/**
	 * This method allows the user to create a new student instance.        
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @return newStudent returns a new student that has been populated with user input data 
	 */
	public Student createNewStudent()
	{	
		String strNameLast = null;		//holds the private value of the student's last name
		String strNameFirst = null;	//holds the private value of the student's first name
		String strMajor = null;		//hold the value of the student's major in 3 letters
		int iHoursCompleted = 0;	//holds the hours the student has completed
		float fGPA = 0;				//holds the value of the student's GPA
		String strStudentPhoto = null;	//holds the location of where the student's photo can be found
		String temp= "";	//holds a temp string
		boolean blnParseCheck;	//checks to see if a string can be parsed
		Classification classification = null;	//tells the year the student is in college
		
		try
		{
			strNameLast= JOptionPane.showInputDialog("Enter the Student's last name: ");
			while(strNameLast.length ( )==0)
			{
				strNameLast= JOptionPane.showInputDialog("Enter the Student's last Name");
			}
	
			strNameFirst= JOptionPane.showInputDialog("Enter the Student's first name: ");
			while(strNameFirst.length ( )==0)
			{
				strNameFirst= JOptionPane.showInputDialog ("Enter the Student' last Name");
			}
			
			temp= JOptionPane.showInputDialog("Enter the Student's GPA: ");
			blnParseCheck = isParsable(temp);
			
			while(blnParseCheck==false)
			{
				temp= JOptionPane.showInputDialog("Enter the Student's GPA: ");
				blnParseCheck = isParsable(temp);
			}
			fGPA = Float.parseFloat (temp);
			
			boolean ok=false;
			while(!ok)
			{
				blnParseCheck = false;
				
				temp= JOptionPane.showInputDialog("Enter the Student's Hours Completed: ");
				blnParseCheck = isParsable(temp);
				while(blnParseCheck == false)
				{
					temp= JOptionPane.showInputDialog("Enter the Student's HourseCompleted: ");
					blnParseCheck = isParsable(temp);
				}
				try
				{
					iHoursCompleted= Integer.parseInt (temp);
					ok=true; 
				}
				catch(Exception e)
				{
					
				}
			}
			
			strMajor= JOptionPane.showInputDialog("Enter the Student's Major: ");
			while(strMajor.length ( )==0)
			{
				strMajor= JOptionPane.showInputDialog ("Enter the Student's Major");
			}
			
			classification = Classification.valueOf (classificationSwitch());
			
			strStudentPhoto= JOptionPane.showInputDialog("Enter the Student's photo file name: ");
			while(strStudentPhoto.length ( )==0)
			{
				strStudentPhoto= JOptionPane.showInputDialog ("Enter the Student's photo file name");
			}
			
		}
		catch(Exception NullPointerException)
		{
			
		}
		
		Student newStudent = new Student(strNameLast, strNameFirst, strMajor, classification, iHoursCompleted, fGPA, strStudentPhoto);
		
		return newStudent;		
		
	}
	/**
	 * Gives the user options as to what year they want to choose for the student and 
	 * then returns a formatted string of their choice so that it can be used as a 
	 * properly formatted enum value.
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @return strClassification the formatted classification of the student
	 */
	public static String classificationSwitch()
	{
		int iTemp;	//holds the user's menu choice 
		boolean blnParseCheck;	//checks to see if a value can be parsed
		String temp;	//holds the string that will be parsed
		
		String strClassification; 
		iTemp=0;
		try
		{
			while(iTemp<=0 || iTemp>=6)
			{
				temp = JOptionPane.showInputDialog ("Enter the number of the Student's Standing\n" +
				"1. Freshman\n" +
				"2. Sophomore\n" +
				"3. Junior\n" +
				"4. Senior\n" +
				"5. Other");
				blnParseCheck = false;		//this makes sure that the input can be parsed
				blnParseCheck = isParsable(temp);	//parses the input by the user.
				while(blnParseCheck == false)
				{
					temp = JOptionPane.showInputDialog ("Enter the number of the Student's Standing\n" +
									"1. Freshman\n" +
									"2. Sophomore\n" +
									"3. Junior\n" +
									"4. Senior\n" +
									"5. Other");
					blnParseCheck = isParsable(temp);
				}
				iTemp= Integer.parseInt (temp);
			}
		}
		catch(Exception e)
		{
			
		}
		switch(iTemp)
		{
			case 1:
				strClassification ="FRESHMAN";
			break;
			//sets string to freshman
			case 2:
				strClassification ="SOPHOMORE";
			break;
			//sets string to sophomore
			case 3:
				strClassification ="JUNIOR";
			break;
			//sets string to junior
			case 4: 
				strClassification ="SENIOR";
			break;
			//sets string to senior
			case 5:
				strClassification ="OTHER";
			break;
			//sets string to other
			default:
				strClassification = "NOT_ENTERED";
			//if the entry is invalid it defaults to not enters 	
		}
		return strClassification;
	}
	
	/**
	 * Allows the user to save the new class that they have created to a 
	 * chosen file          
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 */
	public void saveNewRollManager()
	{
	    JFileChooser chooser = new JFileChooser(); //allows the user to choose a file
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));	//sets the directory of where to find the file
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try 
	        {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write (newClass.getCourseToFileString ( ));
	            for(Student b : newClass.getStudents ( ))	            	
	            	fw.write(b.toFileString ( ));
	            	fw.close ( );
	            	layerOneMenu.MenuLayerOne ( );
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        }
	    }
	    
	}
	
	
		
}
