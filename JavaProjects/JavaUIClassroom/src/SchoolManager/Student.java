/**
 * ---------------------------------------------------------------------------
 * File name: Student.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jan 30, 2016
 * ---------------------------------------------------------------------------
 */

package SchoolManager;

import java.text.DecimalFormat;
/**
 * This class holds all of the methods that help the user to set the student values
 * The user is able to set the Student's first and last name, major, Classification,
 * hours completed, GPA, and the student's photo location.  It also formats the 
 * user's input so that it will display nicely.
 *
 * <hr>
 * Date created: Jan 30, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Student implements Comparable<Student>
{
	private String strNameLast;		//holds the private value of the student's last name
	private String strNameFirst;	//holds the private value of the student's first name
	private String strMajor;		//hold the value of the student's major in 3 letters
	private Classification classification;	//holds the student's classification 
	private int iHoursCompleted;	//holds the hours the student has completed
	private float fGPA;				//holds the value of the student's GPA
	private String strStudentPhoto;	//holds the location of where the student's photo can be found
	DecimalFormat df= new DecimalFormat("0.00");	//Decimal formatter for the displaying the GPA
	/**
	 * Constructor that generates a fully filled out student class. 
	 * including first and last name, major, classification, GPA,
	 * hours completed and student photo location.          
	 *
	 * <hr>
	 * Date created: Jan 30, 2016 
	 *
	 * 
	 * @param strNameLast
	 * @param strNameFirst
	 * @param fGPA
	 * @param iHoursCompleted
	 * @param strMajor
	 * @param Classification
	 * @param strStudentPhoto
	 */
	public Student (String strNameLast, String strNameFirst, String strMajor, 
	                Classification Classification, int iHoursCompleted, float fGPA, 
	                String strStudentPhoto)
	{
		this.strNameLast = strNameLast;
		this.strNameFirst = strNameFirst;
		this.fGPA = fGPA;
		this.iHoursCompleted= iHoursCompleted;
		this.strMajor= strMajor;
		this.classification= Classification;
		this.strStudentPhoto= strStudentPhoto;
		
	}

	/**
	 * Default Constructor        
	 *It populates the fields with default values
	 * <hr>
	 * Date created: Jan 30, 2016 
	 *
	 * 
	 */
	public Student ( )
	{
		super ( );
		this.strNameLast = "Doe";
		this.strNameFirst = "John";
		this.fGPA = 0.00f;
		this.iHoursCompleted= 0;
		this.strMajor= "NULL";
		this.classification= Classification.NOT_ENTERED;
		this.strStudentPhoto= "photo.jpg";
	}//end Student()

	/**
	 * Method so the user can get the last name of
	 * the student.
	 * 
	 * @return strNameLast
	 */
	public String getStrNameLast ( )
	{
		return strNameLast;
	}
	
	/**
	 * Method so the user can set the last name of
	 * the user. 
	 * 
	 * @param strNameLast the strNameLast to set
	 */
	public void setStrNameLast (String strNameLast)
	{
		this.strNameLast = strNameLast;
	}
	
	/**
	 * Method so the user can get the first name of
	 * the student
	 * 
	 * @return strNameFirst
	 */
	public String getStrNameFirst ( )
	{
		return strNameFirst;
	}
	
	/**
	 * Method so the user can set the name of the student
	 * And formats the name so that the first letter is always capitalized
	 * @param strNameFirst the strNameFirst to set
	 */
	public void setStrNameFirst (String strNameFirst)
	{
		this.strNameFirst = strNameFirst;
	}
	
	/**
	 * Method so the user can get the major of the
	 * student and it formats it to all capitals
	 * 
	 * @return strMajor
	 */
	public String getStrMajor ( )
	{
		return strMajor;
	}
	
	/**
	 * A method so the user can set the major of a student
	 * 
	 * @param strMajor the strMajor to set
	 */
	public void setStrMajor (String strMajor)
	{
		this.strMajor = strMajor;
	}
	
	/**
	 * A method so the user can get the hours completed 
	 * by the student.
	 * 
	 * @return iHoursCompleted
	 */
	public int getiHoursCompleted ( )
	{
		return iHoursCompleted;
	}
	
	/**
	 * A method so that the user can set the amount of 
	 * hours completed by the student.
	 * 
	 * @param iHoursCompleted the iHoursCompleted to set
	 */
	public void setiHoursCompleted (int iHoursCompleted)
	{
		this.iHoursCompleted = iHoursCompleted;
	}
	
	/**
	 * A method so that the user can get the GPA of the student
	 * 
	 * @return fGPA
	 */
	public float getfGPA ( )
	{
		return fGPA;
	}
	
	/**
	 * Method so that the user can set the GPA of the
	 * student
	 * 
	 * @param fGPA the fGPA to set
	 */
	public void setfGPA (float fGPA)
	{
		this.fGPA = fGPA;
	}
	
	/**
	 * Method so that the user can get the name of
	 * the .jpg where the student's photo can
	 * be found.
	 * 
	 * @return strStudentPhoto
	 */
	public String getStrStudentPhoto ( )
	{
		return strStudentPhoto;
	}
	
	/**
	 * Method so that the user can set the place
	 * where the name of the .jpg file of the student's
	 * photo can be found.
	 * 
	 * @param strStudentPhoto the strStudentPhoto to set
	 */
	public void setStrStudentPhoto (String strStudentPhoto)
	{
		this.strStudentPhoto = strStudentPhoto;
	}

	
	/**
	 * Method so the the user can get the classification
	 * of the student.
	 * @return classification
	 */
	public Classification getClassification ( )
	{
		return classification;
	}

	
	/**
	 * Method of where the user can set the student's 
	 * classification 
	 * 
	 * @param classification the classification to set
	 */
	public void setClassification (String strClassification)
	{
		this.classification = Classification.valueOf (strClassification.toUpperCase ( ));
	}

	/**
	 * Takes all the student's information and 
	 * neatly displays it for the user.  
	 * It also formats the first and last names to insure
	 * that they are upper case. It also formats the GPA
	 * to insure that it is in a 0.00 format.      
	 *
	 * <hr>
	 * Date created: Jan 30, 2016 
	 *
	 * <hr>
	 * @return toString 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String firstName;
		String lastName;
		firstName = strNameFirst.substring(0, 1).toUpperCase() + strNameFirst.substring(1);
		lastName = strNameLast.substring(0, 1).toUpperCase() + strNameLast.substring(1);

		return "Student \nLast Name: " + lastName + " \nFirst Name: " + firstName +
						" \nMajor: " + strMajor.toUpperCase ( ) + " \nClassification: " + classification +
						" \nHoursCompleted: " + iHoursCompleted + " \nGPA: " + df.format (fGPA) +
						" \nStudent Photo: " + strStudentPhoto;
	}
	
	/**
	 * This method looks at two student's GPA and returns a 0 if they are
	 * the same and a -1 if they are different          
	 *
	 * <hr>
	 * Date created: Mar 20, 2016 
	 *
	 * <hr>
	 * @param InStudent the student that is being compared 
	 * @return value the number that confirms if they are the same or not
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Student InStudent)
	{
		int value = 1;	//holds the value of the int that will indicate outcome of 
						//the comparison 
		
		if(this.getfGPA ( )== InStudent.getfGPA ( ))
		{
			value = 0;
		}
		
		if(this.getfGPA() > InStudent.getfGPA ( ))
		{
			value = -1;
		}
		return value;
	}
	
	/**
	 * This creates a delimited string         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @return fileString returns the formatted string
	 */
	public String toFileString()
	{
		String fileString= strNameLast + "|" +	strNameFirst + "|" + strMajor
			+ "|" + classification + "|" + iHoursCompleted + "|" + fGPA				//holds the value of the student's GPA
			+ "|" +	 strStudentPhoto + "\n";
		return fileString;
		
	}
	
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
