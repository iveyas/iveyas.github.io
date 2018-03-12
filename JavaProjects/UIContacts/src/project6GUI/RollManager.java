/**
 * ---------------------------------------------------------------------------
 * File name: RollManager.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 23, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 * The RollManager is like a class list.  It has all the methods so that a
 * user can populate a class list with all of the student's information
 * as well as information about the course and its instructor.  
 *
 * <hr>
 * Date created: Mar 14, 2016
 * <hr>
 * @author Allison Ivey
 */
public class RollManager
{
	private ArrayList<Student> classRoll = new ArrayList<Student>();	//this is an array of students like a class list
	private String courseName;	//this is the user entered name of the course
	private String courseNumber;	//this is the user input course number
	private String instructor;	//this is the user input instructor's name
	private String courseToFileString;
	JFileChooser fc = new JFileChooser();	//creates a new fileChooser object
	protected File fileName;	//the name of where the file is to be saved
	protected boolean saveNeed = false;

	/**
	 * Constructor this constructor fully sets all the information about
	 * the class list itself        
	 *
	 * <hr>
	 * Date created: Mar 14, 2016 
	 *
	 * 
	 * @param classRoll this is an array of students.
	 */
	public RollManager (String strCourseName, String strCourseNumber, String strInstructor)
	{
		super ( );
		this.classRoll = new ArrayList<Student>();
		this.courseName = strCourseName;
		this.setCourseNumber (strCourseNumber);
		this.setInstructor (strInstructor);
		this.setCourseToFileString (strCourseName + " | " + strCourseNumber + " | " + strInstructor) ;
		saveNeed=true;
	}
	
	
	/**
	 * This is a method that allows that user to add a student to the classRoll
	 * by passing it an instance of the Student class.         
	 *
	 * <hr>
	 * Date created: Mar 14, 2016
	 *
	 * <hr>
	 * @param InStudent an instance of a student player from Student class
	 */
	public void addStudent(Student InStudent)
	{
		classRoll.add (InStudent);
		this.saveNeed = true;

		
	}
	
	/**
	 * The purpose of this method is to remove a student from the class roll when 
	 * passed an instance of a student from the Student class.        
	 *
	 * <hr>
	 * Date created: Mar 14, 2016
	 *
	 * <hr>
	 * @param InStudent an instance of a student from the Student class
	 */
	public void removeStudent(Student InStudent)
	{
		classRoll.remove (InStudent);
		saveNeed = true;

	}

	
	
	/**
	 * This method returns the name of the course         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return courseName the name of the course
	 */
	public String getCourseName ( )
	{
		if(courseName.length ( )==0 || courseName==null)
		{
			courseName = "Course Name";
		}
		return courseName;
	}

	
	
	/**
	 * Sets the course name         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param courseName the name of the course
	 */
	public void setCourseName (String courseName)
	{
		if(courseName.length ( )==0 || courseName==null)
		{
			courseName="Course Name";
		}
		this.courseName = courseName;
		this.saveNeed = true;

	}
	
	/**
	 * This method creates a list of student's first and last name and
	 * returns it to the user.        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return courseOutput is the list of all the students
	 */
	public String getStudentList()
	{
		String courseOutput = "";
		int studentNum = 1;
		
		for(Student student: classRoll)
		{
			courseOutput += studentNum + ". " + student + "\n";	
				//adds a Student to the already created string one student at a time
			studentNum++;
		}
		
		courseOutput = getCourseName() + getCourseNumber() + getInstructor() + courseOutput;
		return courseOutput;
	}
	
	
	/**
	 * This method updates the student's classification of a particular student        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param student the student that is being updated
	 * @param changeString the information that is being updated 
	 */
	public void editStudentClassification(Student student, String changeString)
	{
		student.setClassification (changeString);
		this.saveNeed = true;


	}
	
	/**
	 * Updates the students first name         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param changeStudent the student that is being updated
	 * @param firstName the changed name
	 */
	public void editStudentFirstName(Student changeStudent, String firstName)
	{
		changeStudent.setStrNameFirst (firstName);
		this.saveNeed = true;


	}
	
	/**
	 * Updates the last name of the student        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param changeStudent the student that is being updated
	 * @param name the name that is being changed to
	 */
	public void editStudentLastName(Student changeStudent, String name)
	{
		changeStudent.setStrNameLast (name);
		this.saveNeed = true;


	}
	
	/**
	 * Updates the major of the student        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param student the student that is being updated
	 * @param major the major that is being updated to
	 */
	public void editStudentMajor(Student student, String major)
	{
		student.setStrMajor (major);
		this.saveNeed = true;

	}
	
	/**
	 * This method updates the student's GPA        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param tempStudent the student that is being updated
	 * @param fGPA the GPA that is being changed to
	 */
	public void editStudentGPA(Student tempStudent, float fGPA)
	{
		tempStudent.setfGPA(fGPA);
		this.saveNeed = true;


	}
	
	/**
	 * This method updates the hours that the student has completed         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param student that is being updated
	 * @param hoursCompleted hours that are being changed to
	 */
	public void editStudentHoursCompleted(Student student, int hoursCompleted)
	{
		student.setiHoursCompleted (hoursCompleted);
		this.saveNeed = true;


	}
	
	/**
	 * Updates the student's photo file location
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param student the student that is being updated
	 * @param studentPhoto the new photo location
	 */
	public void editStudentPhoto(Student student, String studentPhoto)
	{
		student.setStrStudentPhoto (studentPhoto);
		this.saveNeed = true;


	}
	
	/**
	 * This method finds a student when given the first and last name 
	 * of the given student        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param firstName the student's first name
	 * @param lastName the student's last name
	 * @return foundStudent the student that is found give the first and last name
	 */
	public Student findStudent(String firstName, String lastName)
	{
		Student foundStudent = null;	
		for(Student b : classRoll)
		{
			
			if (b.getStrNameFirst ( ) != null && b.getStrNameFirst().contains(firstName))
			{
				if(b.getStrNameLast ( ) != null && b.getStrNameLast().contains(lastName))
				{
					foundStudent = b;
				}
			}
		}
		return foundStudent;
	}
	
	/**
	 * This method find a student and then displays all of their information        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param lastName last name of student
	 * @param firstName first name of student
	 * @return studentInfo returns all the information on the found student
	 */
	public String displayStudent(String lastName, String firstName)
	{
		Student foundStudent = findStudent(firstName, lastName); //finds the student
		String studentInfo;
		if(foundStudent != null)
		{
			studentInfo = foundStudent.toString ( );
		}//if the student is found it is displayed
		else
		{
			studentInfo = "Invalid Student Name";
		}//if the student is not found it displays invalid student name
		return studentInfo;
	}
	

	
	/**
	 * Displays a list of the students with their GPA       
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return studentList a list of the students in classRoll and their GPA
	 */
	public String DisplayStudentsGPA()
	{	
		String studentList= "";
		int i=1; //iterates the leading number for each student on the list
		for(Student b : classRoll) //loops through classRoll adding students to the list
		{
			studentList += i + ". " + b.getStrNameFirst ( ) + " " + b.getStrNameLast ( ) + " " + b.getfGPA ( ) +"\n";
			i++;
		}
		return studentList= getCourseName() +"\n" + getCourseNumber()+"\n" + getInstructor()+ "\n" + studentList;
	}
	
	/**
	 * Displays all the student of a given classRoll        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return studentList returns a list of students from the classRoll
	 */
	public String DisplayStudents()
	{	
		String studentList= "";
		int i=1; //the leading number that is interated for each student
		for(Student b : classRoll)
		{
			studentList += i + ". " + b.getStrNameFirst ( ) + " " + b.getStrNameLast () +"\n";
			i++;
		}
		return studentList= getCourseName() +"\n" + getCourseNumber()+"\n" + getInstructor()+ "\n" + studentList;
	}
	
	
	/**
	 * This method gets the course number and returns it         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return courseNumber the number of the course
	 */
	public String getCourseNumber ( )
	{
		return courseNumber;
	}

	
	
	/**
	 * This method sets the course number     
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param courseNumber the number of the course
	 */
	public void setCourseNumber (String courseNumber)
	{
		if(courseNumber.length ( )==0 || courseNumber==null)
		{
			courseNumber ="Course Number"; 
		}
		this.courseNumber = courseNumber;
		this.saveNeed = true;


	}

	
	
	/**
	 * Sets the instructor of the class       
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @return instructor the name of the instructor
	 */
	public String getInstructor ( )
	{
		if(instructor.length ( )==0 || instructor ==null)
		{
			instructor="Instructor";
		}
		return instructor;
		
	}

	
	
	/**
	 * Sets the name of the instructor         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param instructor the name of the instructor
	 */
	public void setInstructor (String instructor)
	{
		if(instructor.length ( )==0 || instructor == null)
		{
			instructor = "Instructor";
		}
		this.instructor = instructor;
		this.saveNeed = true;


	}
	
	public ArrayList<Student> getStudents()
	{
		ArrayList<Student> copyStudent = new ArrayList<Student>(classRoll);
		return copyStudent;
	}


	
	/**
	 * gets the string that is used to save to a file with delimiter 
	 * @return courseToFileString
	 */
	public String getCourseToFileString ( )
	{
		return courseToFileString;
	}


	
	/**
	 * sets the delimited string that will be saved to the file
	 * @param courseToFileString the courseToFileString to set
	 */
	public void setCourseToFileString (String courseToFileString)
	{
		this.courseToFileString = getCourseName ( ) + " | " + getCourseNumber ( ) + " | " + getInstructor ( ) + "\n" ;
		this.saveNeed = true;

	}
	
	public String[] studentNamesArray()
	{
		String [ ] studentArray = new String[classRoll.size ( )];
		for(int i=0; i<classRoll.size ( ); i++)
		{
			studentArray[i]= classRoll.get (i).getStrNameFirst ( ) + " " + classRoll.get (i).getStrNameLast ( );
		}
			
			
		return studentArray;
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
	            fw.write (getCourseToFileString ( ));
	            for(Student b : getStudents ( ))	            	
	            	fw.write(b.toFileString ( ));
	            	fw.close ( );
	            	;
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        }
			this.saveNeed = false;

	  }
	    
	}
	
	
	/**
	 * Allows the user to save their input to a file that they have
	 * already created.         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 */
	public void saveToFile()
	{	
		setCourseToFileString(courseToFileString);
			try 
	        {
	            FileWriter fw = new FileWriter(fileName);
	            fw.write (this.getCourseToFileString ( ));
	            for(Student b : this.getStudents ( ))	            	
	            	fw.write(b.toFileString ( ));
	            	fw.close ( );
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        }
			this.saveNeed = false;

	}
	
	/**
	 * Allows the user to select a file from their directory and then load 
	 * an instance of a class with student.          
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @throws FileNotFoundException 
	 */
	public void fillFromFile()
	{
		JFileChooser fc = new JFileChooser();	//creates a new fileChooser object
		int status = fc.showOpenDialog(null);	//creates a var to catch the dialog output
		if(status == JFileChooser.APPROVE_OPTION)	
		{
			File selectedFile = fc.getSelectedFile ( );
			this.fileName = selectedFile;
			Scanner file = null; //scans the file looking for information to load

			if(selectedFile.exists())
			{
				try
				{
					file = new Scanner(fileName); //scans the input file
				}
				catch(Exception IOException)
				{
					JOptionPane.showConfirmDialog (null, "Unable to import data from the list");
					System.exit (-1);
				}//if there was an error it will pop up this message
				
				String str = file.nextLine ( ); //names the line
				String [] header = str.split ("\\|"); //splits the line at the |
				setCourseNumber(header[1]);
				setCourseName(header[0]);
				setInstructor(header[2]);
				
				while(file.hasNextLine ( ))
				{
					str = file.nextLine ( ); //names the line
					String [] tokens = str.split ("\\|"); //splits the line at the |
					Student p = new Student();

					try
					{
						p.setStrNameLast (String.valueOf (tokens[0]));
						p.setStrNameFirst (String.valueOf (tokens[1]));
						p.setStrMajor (String.valueOf (tokens[2]));
						p.setClassification (tokens[3]);
						p.setiHoursCompleted (new Integer (tokens[4]).intValue ( ));
						p.setfGPA (new Float (tokens[5]).floatValue ( ));
						p.setStrStudentPhoto (String.valueOf (tokens[6]));
					//creates a person object and then populates it with an array of scanned input values
						classRoll.add (p);
						}//creates a person object and then populates it with an array of scanned input values
						catch(Exception IOException)
						{
							IOException.printStackTrace ( );
							JOptionPane.showMessageDialog (null, "Bad input record: '" + str + "'" + IOException.getMessage());
						}//pops up a message if there were any errors reading from the file
				}//continues through the file until there are no more lines to scan
			file.close ( ); //closes the file

				if(selectedFile.exists ( )==false)
				{
					try
					{
						throw new Exception();
					}
					catch (Exception IOException)
					{
						JOptionPane.showMessageDialog (null, "Bad input record: '" + selectedFile + "' " + IOException.getMessage());
					}
				}//if the user picks a file that does not exist this error message will be caught.
			}
		}//if the input is good it will load the information from the selected file to and Array List
			else
			{
				System.exit (0);
			}
		this.saveNeed = true;

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
	
	
}		
