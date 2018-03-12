/**
 * ---------------------------------------------------------------------------
 * File name: RollManager.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 14, 2016
 * ---------------------------------------------------------------------------
 */

package SchoolManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	}
	
	
	/**
	 * Copy Constructor        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016 
	 *
	 * 
	 * @param copyRollManager the rollManager to be copied 
	 */
	public RollManager(RollManager copyRollManager)
	{
		ArrayList<Student> copyClass = new ArrayList<Student>();
		for(Student p: copyRollManager.classRoll)
		{
			copyClass.add (p);
	
		}
		
		this.courseName= String.valueOf(copyRollManager.courseName);
		this.courseNumber= String.valueOf(copyRollManager.courseNumber);
		this.instructor= String.valueOf(copyRollManager.instructor);
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
		this.courseName = courseName;

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
	 * This method searches for students with a particular classification
	 * and then returns a list of those students.       
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 * @param studentStanding The classification of the students that is being searched for
	 * @return foundStudent the students that are found during the search 
	 */
	public String findStudentByClassification(String studentStanding)
	{
		String foundStudents = "";
		for(Student b : classRoll) //loops through the classRoll looking for the classification
		{
			if (b.getClassification() != null && Classification.valueOf (studentStanding.toUpperCase ( )) == b.getClassification ( ))
			{
					foundStudents += "\n" + b.toString ( ); //creates a string of all the students found
			}
		}
		return foundStudents;
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
	 * This sorts the students by last name and then first name         
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 */
	public void sortByName() 
	{
		Collections.sort(classRoll, new Comparator<Student>() //compares the student of classRoll
		{
			public int compare(Student s1, Student s2) //sets the name of the two students to s1 and s2
			{
				int res =  s1.getStrNameLast().compareToIgnoreCase(s2.getStrNameLast()); //compares the last names
				if (res != 0)
		        return res;
				return s1.getStrNameFirst().compareToIgnoreCase(s2.getStrNameFirst()); //compares the first names
			}
		});

	}
	
	/**
	 * This method sorts the students based on their GPA from highest to lowest        
	 *
	 * <hr>
	 * Date created: Mar 20, 2016
	 *
	 * <hr>
	 */
	public void sortByGPA()
	{
		Collections.sort (classRoll);

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
		this.courseNumber = courseNumber;

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
		this.instructor = instructor;

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

	}
	
}		
		
			
		
		
		
		


