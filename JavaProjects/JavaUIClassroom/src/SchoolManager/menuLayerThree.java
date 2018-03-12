/**
 * ---------------------------------------------------------------------------
 * File name: menuLayerThree.java
 * Project name: IveyAllison_Project4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 29, 2016
 * ---------------------------------------------------------------------------
 */

package SchoolManager;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * This menu is used to update an already created class and then save the new information
 *
 * <hr>
 * Date created: Mar 29, 2016
 * <hr>
 * @author Allison Ivey
 */
public class menuLayerThree
{
	private JFileChooser fc = new JFileChooser();	//creates a new fileChooser object
	private RollManager newClass;	//creates a new class 
	private File fileName;	//the name of where the file is to be saved
	
	/**
	 * Allows the user to select a file from their directory and then load 
	 * an instance of a class with student.          
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 */
	public void fillFromFile()
	{
		//JFileChooser fc = new JFileChooser();	//creates a new fileChooser object
		int status = fc.showOpenDialog(null);	//creates a var to catch the dialog output
		if(status == JFileChooser.APPROVE_OPTION)	
		{
			//newPeople.load (new File("fileTwo"));
			File selectedFile = fc.getSelectedFile();
			this.fileName = selectedFile;
			Scanner file = null; //scans the file looking for information to load

			if(selectedFile.exists())
			{
				try
				{
					file = new Scanner(selectedFile); //scans the input file
				}
				catch(Exception IOException)
				{
					JOptionPane.showConfirmDialog (null, "Unable to import data from the list");
					System.exit (-1);
				}//if there was an error it will pop up this message
				
				String str = file.nextLine ( ); //names the line
				String [] header = str.split ("\\|"); //splits the line at the |
				newClass = new RollManager(header[0], header[1], header[2]);
				
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
						newClass.addStudent (p);
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
		}
	
	/**
	 * This method has a switch that allows the user to select a category that they
	 * would like to update that has to do with the student's information.        
	 *
	 * <hr>
	 * Date created: Mar 19, 2016
	 *
	 * <hr>
	 * @param iTemp holds the number of the user's selection of what they want to change
	 */
	public void changeStudentSwitch(int iTemp)
	{
			String temp = null;
			boolean blnParseCheck;
			float fTemp;
			boolean blnChanges;
			Student tempStudent = null;
			switch(iTemp)
			{
				case 1:
					try
					{
					temp = JOptionPane.showInputDialog ("Enter the updated first name");
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentFirstName (tempStudent, temp);
						saveToFile();
					}
				break;
				//changes the first name
				case 2: 
					try
					{
					temp = JOptionPane.showInputDialog ("Enter the updated last name");
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentLastName (tempStudent, temp);
						saveToFile();
					}
				break;
				//changes the last name
				case 3:
					try
					{
						temp= JOptionPane.showInputDialog("Enter the Student's updated GPA: ");
						blnParseCheck= menuLayerTwo.isParsable (temp);
						while(blnParseCheck == false)
						{
							temp= JOptionPane.showInputDialog("Enter the Student's updated GPA: ");
							blnParseCheck = menuLayerTwo.isParsable(temp);	
						}
					}
					catch(Exception e)
					{
						
					}
					fTemp= Float.parseFloat (temp);
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentGPA (tempStudent, fTemp);
						saveToFile();
					}
				break;
				//changes the student's GPA
				case 4:
					boolean ok=false;
					while(!ok)
					{
						blnParseCheck = false;
						
						temp= JOptionPane.showInputDialog("Enter the updated hours completed: ");
						blnParseCheck = menuLayerTwo.isParsable(temp);
						while(blnParseCheck == false)
						{
							temp= JOptionPane.showInputDialog("Enter the updated hours completed: ");
							blnParseCheck = menuLayerTwo.isParsable(temp);
						}
						try
						{
							newClass.editStudentHoursCompleted (tempStudent, Integer.parseInt (temp));
							ok=true; 
						}
						catch(Exception e)
						{
							
						}
					}
					
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentHoursCompleted(tempStudent, iTemp);
						saveToFile();
					}
				break;
				//Changes the student's hours completed
				case 5: 
					try
					{
					temp = JOptionPane.showInputDialog ("Enter the new major");
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentMajor (tempStudent, temp);
						saveToFile();
					}
				break;
				//changes the student's major
				case 6: 
					temp = menuLayerTwo.classificationSwitch();
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentClassification (tempStudent, temp);
						saveToFile();
					}
				break;
				//changes the student's classification
				case 7:	
					try
					{
					
						temp = JOptionPane.showInputDialog ("Enter the new Photo File Location");
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.editStudentPhoto(tempStudent, temp);
						saveToFile();
					}
				break;
				//changes the photo file name
				case 8:
					temp = JOptionPane.showInputDialog ("Exit");
					Integer.parseInt (temp);
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						saveToFile();
					}
				break;
				//exits the program
			}
	
	}
	
	/**
	 * This method has all the menu items that allow a user update their class with
	 * user input data         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @return menuOptions the option that the user has selected from the menu.
	 */
	public int menuItems()
	{
		int menuOption=0; //the parsed validated number put in by the user
		String temp;	//hold the temp string value that is to be parsed
		int menuNumber = 0;	//gets into the loop
		boolean blnParseCheck = false;	//returns true if the String can be parsed
	
		if(menuNumber>10)
		{
			
		}
		else
		{
			temp = JOptionPane.showInputDialog ("Class Roll Menu Options\n------------------------------------\n"+
			"\t1.  Edit Course Name\n" +
			"\t2.  Add a new Stududent to the class list\n" +
			"\t3.  Edit and existing Student\n" +
			"\t4.  Drop a Student from the Class Roll\n" +
			"\t5.  Display all Student on the Class Roll\n" +
			"\t6.  Find a Student and Display their Information\n" +
			"\t7.  Display all the Students with the same Student Standing\n" +
			"\t8.  Sort the Students by Name\n" +
			"\t9.  Sort the Students by GPA\n" +
			"\t10. Exit");
			
			if(temp== null) //allows the user to exit the program
			{
				temp = "10";
			}
			
			blnParseCheck = menuLayerTwo.isParsable (temp);
			
			while(blnParseCheck == false) //asks the user to choose again if the first value is wrong
			{
				temp = JOptionPane.showInputDialog ("Class Roll Menu Options\n------------------------------------\n"+
								"\t1.  Edit Course Name\n" +
								"\t2.  Add a new Stududent to the class list\n" +
								"\t3.  Edit and existing Student\n" +
								"\t4.  Drop a Student from the Class Roll\n" +
								"\t5.  Display all Student on the Class Roll\n" +
								"\t6.  Find a Student and Display their Information\n" +
								"\t7.  Display all the Students with the same Student Standing\n" +
								"\t8.  Sort the Students by Name\n" +
								"\t9.  Sort the Students by GPA\n" +
								"\t10. Exit");
								
								if(temp== null)
								{
									temp = "10";
								}
				blnParseCheck = menuLayerTwo.isParsable (temp); //uses the isParsable method to see if it can be parsed
			}
			menuOption = Integer.parseInt (temp); //sets the menu option
		}
		return menuOption;		
	}
	
	/**
	 * The user's selection was made and now they are able to update their 
	 * given choice         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @param menuNumber the number from the previouse menu that the user selected. 
	 */
	public void menuSwitch(int menuNumber)
	{	
		int iTemp;					//holds a temp int
		boolean blnParseCheck = false;	//holds a boolean value that checks if values can parse	
		boolean blnChanges;
		String courseName = null;			//holds the course name
		String courseNumber;		//holds the course number
		String instructor;			//holds the instructor's name
		String strNameLast = null;			//holds the address of the student's last name
		String strNameFirst = null;		//holds the address of the student's first name
		float fGPA;							//holds a float number of student's GPA			
		int iHoursCompleted;				//holds the hours completed by the student
		String strMajor = null;			//holds the address to the student's major
		Classification classification;	//creates a classification element
		String strStudentPhoto = null;		//holds the address of the student's photo file name
		String temp = null;				//holds a temporary address location to be reused
		Student newStudent;			//holds the value of a student element
		Student tempStudent;		//holds the address to a temporary student
		String strNameLastTemp = null;		//holds the address that points to a temp last name
		String strNameFirstTemp = null;	//holds the address that points to a temp first name
		//this switch accepts a user input number and asked the relevant questions	
		switch(menuNumber)
			{
				case 1:
					try
					{
						courseName= JOptionPane.showInputDialog("Enter the course Name");
						while(courseName.length ( )==0)
						{
							courseName= JOptionPane.showInputDialog("Enter the course Name");
						}
					}
					catch(Exception e)
					{
						
					}
					newClass.setCourseName (courseName);
					
					courseNumber = null;
					try
					{
					courseNumber= JOptionPane.showInputDialog("Enter the course Number");
					while(courseNumber.length ( )==0)
					{
						courseNumber= JOptionPane.showInputDialog("Enter the course Number");
					}
					}
					catch(Exception e)
					{
						
					}
					newClass.setCourseNumber (courseNumber);
					
					instructor= null;
					try
					{
					instructor= JOptionPane.showInputDialog("Enter the course Instructor");
					while(instructor.length ( )==0)
					{
						instructor= JOptionPane.showInputDialog("Enter the course Instructor");
					}
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.setInstructor (instructor);
						saveToFile();
					}
					menuNumber= menuItems();
					menuSwitch(menuNumber);
				break;
				//this part of the switch handles things that have to do with the course
				case 2:
					try
					{
					strNameLast= JOptionPane.showInputDialog("Enter the Student's last name: ");
					while(strNameLast.length ( )==0)
					{
						strNameLast= JOptionPane.showInputDialog("Enter the Student's last Name");
					}
					}
					catch(Exception e)
					{
						
					}
					
					try
					{
					strNameFirst= JOptionPane.showInputDialog("Enter the Student's first name: ");
					
					while(strNameFirst.length ( )==0)
					{
						strNameFirst= JOptionPane.showInputDialog ("Enter the Student' first Name");
					}
					}
					catch(Exception e)
					{
						
					}
					try
					{
					temp= JOptionPane.showInputDialog("Enter the Student's GPA: ");
					blnParseCheck = menuLayerTwo.isParsable(temp);
					
					while(blnParseCheck==false)
					{
						temp= JOptionPane.showInputDialog("Enter the Student's GPA: ");
						blnParseCheck = menuLayerTwo.isParsable(temp);
					}
					}
					catch(Exception e)
					{
						
					}
					fGPA = Float.parseFloat (temp);
					
					blnParseCheck = false;
					try
					{
						temp= JOptionPane.showInputDialog("Enter the Student's Hours Completed: ");
						blnParseCheck = menuLayerTwo.isParsable(temp);
					
						while(blnParseCheck == false)
						{
							temp= JOptionPane.showInputDialog("Enter the Student's HourseCompleted: ");
							blnParseCheck = menuLayerTwo.isParsable(temp);
						}
					}
					catch(Exception e)
					{
						
					}
					iHoursCompleted= Integer.parseInt (temp);
					
					try
					{
						strMajor= JOptionPane.showInputDialog("Enter the Student's Major: ");
						while(strMajor.length ( )==0)
						{
							strMajor= JOptionPane.showInputDialog ("Enter the Student's Major");
						}
					}
					catch(Exception e)
					{
						
					}
					temp = menuLayerTwo.classificationSwitch();
					classification = Classification.valueOf (temp);
					
					try
					{
					strStudentPhoto= JOptionPane.showInputDialog("Enter the Student's photo file name: ");
					while(strStudentPhoto.length ( )==0)
					{
						strStudentPhoto= JOptionPane.showInputDialog ("Enter the Student's photo file name");
					}
					}
					catch(Exception e)
					{
						
					}
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newStudent = new Student(strNameLast, strNameFirst, strMajor, classification, iHoursCompleted, fGPA, strStudentPhoto);
						newClass.addStudent (newStudent);
						saveToFile();
					}
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles the information about the student
				case 3:
					try
					{
					strNameFirstTemp = JOptionPane.showInputDialog ("Enter the first name of the student you would like to change:");
					strNameLastTemp = JOptionPane.showInputDialog ("Enter the last name of the student you would like to change:");
					tempStudent = newClass.findStudent (strNameFirstTemp, strNameLastTemp);
					if(tempStudent== null)
					{
						JOptionPane.showMessageDialog (null, "Invalid Student Name");
					}
					else
					{
						boolean saveNeededs = true;
						while(saveNeededs==true)
						{
							temp = JOptionPane.showInputDialog ("What would you like to change?\n1. Student's First Name\n2.Student's Last Name" +
							"\n3. GPA\n4. Hours Completed\n5. Major\n6. Classification\n7. Student Photo File Name\n");
							iTemp = Integer.parseInt (temp);
							changeStudentSwitch(iTemp);
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to make more changes to this student?", "Warning", dialogButton);
							if(dialogResult == JOptionPane.YES_OPTION)
								{
									saveNeededs= true;
									saveToFile();
								}
							else
								saveNeededs= false;
						}
						
					}
					}
					catch(Exception e)
					{
						
					}
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles what the user wants to change about the student
				case 4:
					try
					{
					strNameFirstTemp = JOptionPane.showInputDialog ("Enter the first name of the student you would like to delete:");
					strNameLastTemp = JOptionPane.showInputDialog ("Enter the last name of the student you would like to delete:");
					}
					catch(Exception e)
					{
						
					}
					tempStudent = newClass.findStudent (strNameFirstTemp, strNameLastTemp);
					blnChanges = saveNeeded();
					if(blnChanges == true)
					{
						newClass.removeStudent (tempStudent);
						saveToFile();
					}
					JOptionPane.showMessageDialog (null, newClass.DisplayStudents ());
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles removing students from the class roll
				case 5:
					JOptionPane.showMessageDialog (null, newClass.DisplayStudents ());
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles displaying all the students
				case 6:
					try
					{
					strNameFirstTemp = JOptionPane.showInputDialog ("Enter the first name of the student you would like to find:");
					strNameLastTemp = JOptionPane.showInputDialog ("Enter the last name of the student you would like to find:");
					}
					catch(Exception e)
					{
						
					}
					temp = newClass.displayStudent (strNameLastTemp, strNameFirstTemp );
					JOptionPane.showMessageDialog (null, temp); 
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles displaying a particular student
				case 7:
					temp = menuLayerTwo.classificationSwitch();
					JOptionPane.showMessageDialog (null, newClass.findStudentByClassification (temp));
					menuNumber= menuItems();
					menuSwitch(menuNumber);
				break;
				//this part of the switch handles finding the students of a particular classification
				case 8:
					newClass.sortByName();
					JOptionPane.showMessageDialog (null, newClass.DisplayStudents ());
					saveToFile();
					menuNumber= menuItems();
					menuSwitch(menuNumber);
				break;
				//this part of the switch handles sorting the class roll
				case 9:
					newClass.sortByGPA();
					JOptionPane.showMessageDialog (null, newClass.DisplayStudentsGPA ());
					saveToFile();
					menuNumber= menuItems();
					menuSwitch(menuNumber);

				break;
				//this part of the switch handles sorting the students by GPA
				case 10:
				break;
				//this part of the switch exits the user from the program
				default:
					
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
			try 
	        {
	            FileWriter fw = new FileWriter(fileName);
	            fw.write (newClass.getCourseToFileString ( ));
	            for(Student b : newClass.getStudents ( ))	            	
	            	fw.write(b.toFileString ( ));
	            	fw.close ( );
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        }
	}
	
	/**
	 * Tells if the user wants to save the changes that they have made or not         
	 *
	 * <hr>
	 * Date created: Mar 31, 2016
	 *
	 * <hr>
	 * @return saveNeeded tells if the user wants to save the information or not. 
	 */
	public boolean saveNeeded()
	{
		boolean saveNeeded = false;
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save these changes?", "Warning", dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION)
			saveNeeded= true;
		
		return saveNeeded;
	}
}

