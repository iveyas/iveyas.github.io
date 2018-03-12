/**
 * ---------------------------------------------------------------------------
 * File name: Frames.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 17, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.NoSuchElementException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * This sets up the main frame that the person will be working with
 *
 * <hr>
 * Date created: Apr 17, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Frames extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	//the class and default values
	protected RollManager rollManager = new RollManager("No Value Added", "No Value Added", "No Value Added");
	//the panel that holds all the names
	protected NamesPanel namesPanel = new NamesPanel(rollManager.studentNamesArray ( ));
	//this holds the the information about the class as a whole
	protected RollInfoPanel rollInfoPanel = new RollInfoPanel(rollManager);
	//holds the place where all the names go
	protected JPanel namesSpot = new JPanel();
	//holds the place where the list of the class goes
	protected JPanel rollManagerPanel = new JPanel();
	//the place where the student information panel goes
	protected JPanel studentSpot = new JPanel();
	//the place where the pictures go
	protected JPanel pictureSpot = new JPanel();
	//the default photo value that sets the photo to no photo available
	protected ImageIcon noPhoto = new ImageIcon("pictures/NoImageAvailable.jpeg");
	//the label that holds the default image
	protected JLabel lblNoPhoto = new JLabel(noPhoto);
	//the panel that holds the student information panel
	protected StudentInfoPanel studentInfo = new StudentInfoPanel();
	//the panel that holds the information about the selected student
	protected SelectedStudent selectedStudent = new Frames.SelectedStudent();
	

	


	public Frames()
	{
		setLocationRelativeTo (null); //sets location of the frame
		setTitle ("Roll Manager"); //sets the title of the frame
		//sets the icon image of the frame
		setIconImage(Toolkit.getDefaultToolkit ( ).getImage ("Pictures/newItem.png"));
		GridLayout grd = new GridLayout(); //sets the layout to grid
		grd.setColumns (3); //sets the number of columns
		grd.setRows (2); //sets the number of rows 
		setLayout (grd); //sets the layout to grid		
		setSize (900, 700);	//sets the overall size of the window
		setDefaultCloseOperation (EXIT_ON_CLOSE);	//sets close operation
		mainBox(); //calls the main box method
		namesSpot.setPreferredSize(new Dimension(300, 300)); //sets the size of names spot
		namesSpot.setMinimumSize(new Dimension(300, 300));//sets the min size of names spot
		namesSpot.setBorder (null); //sets the border of names spot
		namesSpot.add (namesPanel); //adds the names panel
		namesSpot.setVisible (true); //sets names spot viable
		rollManagerPanel.add (rollInfoPanel); //adds the roll manager panel
		rollManagerPanel.setVisible (true); //sets roll manager visible
		studentSpot.add (studentInfo); //adds student info to student spot
		studentSpot.setVisible (true); //sets student spot visible
		studentSpot.setPreferredSize (new Dimension(300,300)); //sets size
		pictureSpot.setVisible (true);	//sets picture spot visible
		pictureSpot.setPreferredSize (new Dimension(400,400));//sets size
		pictureSpot.add (lblNoPhoto);//adds the no photo label to picture spot
		this.add(namesSpot);	//adds the names spot
		this.add(rollManagerPanel);	//adds the roll manager panel
		this.add(studentSpot);	//adds the student spot
		this.add(pictureSpot);	//adds the picture spot
		setLookAndFeel();
		
	}
	
	JMenuItem newClassRollItem; //creates a new menu item for new class roll
	JMenuItem newOpenClassRoll; //creates a new menu item for open class roll
	JMenuItem newSaveCurrentClassRoll; //creates a new menu item for save class
	JMenuItem exitClassRoll; //creates a new menu item for exit class roll
	JMenuItem newAddStudent; //creates a new menu item for add student
	JMenuItem newModifyStudent; //creates a new menu item for modify student
	JMenuItem newDropStudent; //creates a new menu item for drop student
	JMenuItem aboutItem; //creates a new menu item for about item
	JMenuBar menuBar; //adds a menu bar
	
	
	/**
	 * This is the main panel where all the different panels come together 
	 * to make a cohesive window with all the items          
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void mainBox()
	{
		//the items that are going to go under the file tab
		ImageIcon newItem = new ImageIcon("Pictures/newItem.png");
		newClassRollItem = new JMenuItem("Create New Class Roll", newItem);
		newClassRollItem.setMnemonic (KeyEvent.VK_N);
		newClassRollItem.addActionListener (new ClassRollListener());
		
		//the items that are going to go under the open a class roll
		ImageIcon open = new ImageIcon("Pictures/open.jpeg");
		newOpenClassRoll = new JMenuItem("Open a Class Roll", open);
		newOpenClassRoll.setMnemonic (KeyEvent.VK_O);
		newOpenClassRoll.addActionListener (new NewOpenClassRoll());
		
		//the items that are going to go under the save current class roll tab
		ImageIcon save = new ImageIcon("Pictures/save.jpeg");
		newSaveCurrentClassRoll = new JMenuItem("Save Current Class Roll", save);
		newSaveCurrentClassRoll.setMnemonic(KeyEvent.VK_S);
		newSaveCurrentClassRoll.addActionListener(new NewSaveCurrentClassRoll());
		
		//items that are going to go under the save current class roll tab
		ImageIcon close = new ImageIcon("Pictures/close.jpeg");
		exitClassRoll = new JMenuItem("Exit Class Roll Manager", close);
		exitClassRoll.setMnemonic (KeyEvent.VK_ESCAPE);
		exitClassRoll.addActionListener (new SaveAndExitClassRoll());
		
		//the items that are going to go under the edit tab
		ImageIcon newStudent = new ImageIcon("Pictures/newStudent.jpeg");
		newAddStudent = new JMenuItem("Add a Student to the Roll", newStudent);
		newAddStudent.setMnemonic(KeyEvent.VK_A);
		newAddStudent.addActionListener(new AddStudentListener());
		
		//items that are going to go under the modify student data tab
		ImageIcon student = new ImageIcon("Pictures/student.png");
		newModifyStudent = new JMenuItem("Modify Student Data", student);
		newModifyStudent.setMnemonic(KeyEvent.VK_M);
		newModifyStudent.addActionListener(new ModifyStudentListener());
		
		//the items that are going to go under the delete student tab
		ImageIcon deleteStudent = new ImageIcon("Pictures/deleteStudent.jpeg"); 
		newDropStudent = new JMenuItem("Drop a Student From the Roll", deleteStudent);
		newDropStudent.setMnemonic(KeyEvent.VK_D);
		newDropStudent.addActionListener(new DropStudentListener());
		
		//the items that are going to go under the about tab
		ImageIcon aboutImage = new ImageIcon("Pictures/about.jpeg");
		aboutItem = new JMenuItem("About", aboutImage);
		aboutItem.setMnemonic (KeyEvent.VK_A);
		aboutItem.addActionListener (new AboutListener());
		
		
		//adds the labels to the drop down menu items on the bar
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		//adds all the items that fall under file
		fileMenu.add(newClassRollItem);
		fileMenu.add(newOpenClassRoll);
		fileMenu.add(newSaveCurrentClassRoll);
		fileMenu.add(exitClassRoll);
		
		//adds all the items that fall under edit 
		editMenu.add(newAddStudent);
		editMenu.add(newModifyStudent);
		editMenu.add(newDropStudent);
		
		//adds items that fall under the about tab
		helpMenu.add (aboutItem);
		
		//adds all the tabs to the menu bar
		menuBar.add(fileMenu);
		menuBar.add (editMenu);
		menuBar.add (helpMenu);
		
		//sets the menu bar to the frame
		this.setJMenuBar (menuBar);
		
		//sets the size and adds the panels the the main panels
		namesSpot.setSize (200, 200);
		namesSpot.setBorder (null);
		namesSpot.add (namesPanel);
		namesSpot.setVisible (true);
		rollManagerPanel.add (rollInfoPanel);
		rollManagerPanel.setVisible (true);
		pictureSpot.setSize (333, 333);
		pictureSpot.add (lblNoPhoto);
	}
	
	
	/**
	 * Listens for the new class roll button to be pushed
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class ClassRollListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			save();
			removePanels();
			rollManager = new RollManager("Class Name", "Class Number", "Instructor");
			addBackPanels();
			String strCourseName = null;	//the name of the course
			String strCourseNumber = null;	//the number of the course
			String strInstructor = null;	//the name of the instructor

			//sets the values for the course from the text boxes 
			strCourseName= rollInfoPanel.txtCourseName.getText ( );
			strCourseNumber= rollInfoPanel.txtCourseNumber.getText ( );
			strInstructor= rollInfoPanel.txtInstructor.getText ( );
			
			//creates an instance of RollManager with the new data
			rollManager = new RollManager(strCourseName, strCourseNumber, strInstructor);
				
		}
	}
	
	
	/**
	 * Listens for the open class roll button to be pushed
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class NewOpenClassRoll implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				//removes the panel so that a new one can be added
				removePanels();
				//creates a default rollManager with default values
				rollManager = new RollManager("No Value Added", "No Value Added", "No Value Added");
				//fills rollManger using a delimited file
				rollManager.fillFromFile ( );
				//adds the new panels back on
				addBackPanels();
			}
			catch(NoSuchElementException ex )
			{
				JOptionPane.showMessageDialog (null, "The File Could Not Be Uploaded");
			}
			catch(ArrayIndexOutOfBoundsException ep)
			{
				JOptionPane.showMessageDialog (null, "The File Could Not Be Uploaded");

			}
		}
	}
	
	
	/**
	 * Listens for the save current class roll button to be pushed
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class NewSaveCurrentClassRoll implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			rollManager.setCourseName (rollInfoPanel.txtCourseName.getText ( ).trim ( ));
			rollManager.setCourseNumber (rollInfoPanel.txtCourseNumber.getText ( ).trim ( ));
			rollManager.setInstructor (rollInfoPanel.txtInstructor.getText ( ).trim ( ));
			if(rollManager.fileName == null)
			{
				JFileChooser fc = new JFileChooser();
			    fc.setCurrentDirectory(new File("/home/me/Documents"));	//sets the directory of where to find the file
			    int status = fc.showSaveDialog(null);
			    if(status == JFileChooser.APPROVE_OPTION)	
			    {
			    	File selectedFile = fc.getSelectedFile ( );
					rollManager.fileName = selectedFile;
			    }
			}
			
			rollManager.saveToFile ( );
			rollManager.saveNeed=false;

		}
	}
	
	
	/**
	 * listens for the save and exit button to be pushed
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class SaveAndExitClassRoll implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			rollManager.setCourseName (rollInfoPanel.txtCourseName.getText ( ));
			rollManager.setCourseNumber (rollInfoPanel.txtCourseNumber.getText ( ));
			rollManager.setInstructor (rollInfoPanel.txtInstructor.getText ( ));
			if(rollManager.fileName == null)
			{
				JFileChooser fc = new JFileChooser();
			    fc.setCurrentDirectory(new File("/home/me/Documents"));	//sets the directory of where to find the file
			    int status = fc.showSaveDialog(null);
			    if(status == JFileChooser.APPROVE_OPTION)	
			    {
			    	File selectedFile = fc.getSelectedFile ( );
					rollManager.fileName = selectedFile;
					rollManager.saveNeed = false;
			    }
			}
			save();
			System.exit (0);
		}
	}
	
	
	/**
	 * Adds a listener for the tab that adds a student
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class AddStudentListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			removePanels();
			
			Student InStudent = new Student();
			InStudent.setStrNameFirst (studentInfo.txtFirstName.getText ( ));
			InStudent.setStrNameLast (studentInfo.txtLastName.getText ( ));
			InStudent.setStrMajor (studentInfo.txtMajor.getText ( ));
			InStudent.setStrStudentPhoto (studentInfo.txtPhoto.getText ( ));
			InStudent.setClassification ((String)studentInfo.classificationBox.getSelectedItem ( ));
			if(RollManager.isParsable(studentInfo.creditHours.getText ( ) )==true)
			{
				InStudent.setiHoursCompleted (Integer.parseInt (studentInfo.creditHours.getText ( )));
			}
			else
			{
				InStudent.setiHoursCompleted (0);
				JOptionPane.showMessageDialog (null, "Invalid Hours Completed Value");
			}
			
			if(RollManager.isParsable (studentInfo.txtGPA.getText ( ))==true)
			{
				InStudent.setfGPA (Float.parseFloat (studentInfo.txtGPA.getText ( )));
			}
			else
			{
				JOptionPane.showMessageDialog (null,"Invalid GPA Input");
				InStudent.setfGPA (0);
			}
			rollManager.addStudent (InStudent);
			String[] newNamesArray = new String[rollManager.studentNamesArray ( ).length];
			newNamesArray=rollManager.studentNamesArray ();
			namesPanel = new NamesPanel(newNamesArray);
			
			addBackPanels();
			rollManager.saveNeed = true;
			
		}
	}
	
	
	/**
	 * Adds a listener that listens for the tab when the student is modified 
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class ModifyStudentListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			removePanels();
			try
			{
				
				String[] namesArray = new String[2];
				String fullName = (String)namesPanel.names.getSelectedValue ( );
				namesArray = fullName.split(" ");
				Student InStudent = rollManager.findStudent (namesArray[0], namesArray[1]);
				InStudent.setStrNameFirst (studentInfo.txtFirstName.getText ( ));
				InStudent.setStrNameLast (studentInfo.txtLastName.getText ( ));
				InStudent.setStrMajor (studentInfo.txtMajor.getText ( ));
				InStudent.setStrStudentPhoto (studentInfo.txtPhoto.getText ( ));
				InStudent.setClassification ((String)studentInfo.classificationBox.getSelectedItem ( ));
				InStudent.setiHoursCompleted (Integer.parseInt (studentInfo.creditHours.getText ( )));
				InStudent.setfGPA (Float.parseFloat (studentInfo.txtGPA.getText ( )));
				rollManager.saveNeed=true;
			
			}
			catch(NullPointerException v)
			{
				JOptionPane.showMessageDialog (null, "Please Select A Student");
			}
			addBackPanels();
		}
	}
	
	
	/**
	 * Listens for when the button is pushed for a selected student
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class SelectedStudent implements ListSelectionListener
	{
		@Override
		public void valueChanged (ListSelectionEvent e)
		{
				
				addStudentInfo();
				addPicture(studentInfo.txtPhoto.getText ( ));
				
		}
		
	}
	
	
	
	/**
	 * Listens for when the drop student tab is pushed 
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class DropStudentListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			removePanels();
			removeStudent();
			addBackPanels();
			rollManager.saveNeed=true;
		}
	}
	
	
	/**
	 * Listens for when the about tab is pushed 
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 * <hr>
	 * @author Allison Ivey
	 */
	private class AboutListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			new AboutDialog (Frames.this, "About Class Manager", true);

		}
	}
	
	
	/**
	 * The method that removes all the panels and clears them so that 
	 * a new panel can be added         
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void removePanels()
	{
		Frames.this.getContentPane ( ).remove (rollManagerPanel);
		Frames.this.getContentPane ( ).remove (namesSpot);
		Frames.this.getContentPane().remove (studentSpot);
		Frames.this.getContentPane().remove (pictureSpot);
		rollManagerPanel.removeAll ( );
		namesSpot.removeAll ( );
		studentSpot.removeAll ( );
		pictureSpot.removeAll ( );
	}
	
	/**
	 * adds panels back after they have been cleared         
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void addBackPanels()
	{
		rollInfoPanel = new RollInfoPanel(rollManager);
		rollInfoPanel.setVisible (true);
		namesPanel = new NamesPanel(rollManager.studentNamesArray ( ));
		namesPanel.names.addListSelectionListener (selectedStudent); 

		studentInfo = new StudentInfoPanel();
		rollManagerPanel.add(rollInfoPanel);
		namesSpot.add(namesPanel);
		studentSpot.add (studentInfo);
		pictureSpot.add (lblNoPhoto);
		Frames.this.getContentPane().add(namesSpot);
		Frames.this.getContentPane().add(rollManagerPanel);	
		Frames.this.getContentPane().add (studentSpot);
		Frames.this.getContentPane().add (pictureSpot);
		Frames.this.getContentPane().revalidate ( );
		Frames.this.getContentPane().repaint ( );
	}
	
	/**
	 * Adds the student information from the current roll manager to the 
	 * text boxes for the selected students           
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void addStudentInfo()
	{
		String[] namesArray = new String[2];
		String fullName = (String)namesPanel.names.getSelectedValue ( );
		namesArray = fullName.split(" ");
		Student foundStudent = rollManager.findStudent (namesArray[0], namesArray[1]);
		studentInfo.txtFirstName.setText (foundStudent.getStrNameFirst ( ));
		studentInfo.txtLastName.setText(foundStudent.getStrNameLast ( ));
		studentInfo.txtGPA.setText(Float.toString(foundStudent.getfGPA ( )));
		studentInfo.txtMajor.setText(foundStudent.getStrMajor ( ));
		studentInfo.txtPhoto.setText(foundStudent.getStrStudentPhoto ( ));
		studentInfo.creditHours.setText(Integer.toString (foundStudent.getiHoursCompleted ()));
		studentInfo.classificationBox.setSelectedItem ((foundStudent.getClassification ( ).toString ( )));
	}
	
	/**
	 * Sets the default photo to no photo available.  If the photo is available
	 * then it is added to the panel         
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 * @param photoName
	 */
	public void addPicture(String photoName)
	{
		if(photoName == "null")
		{
			photoName = "NoImageAvailable.jpeg";
		}
		pictureSpot.removeAll ( );
		ImageIcon photo = new ImageIcon("pictures/" + photoName);
		JLabel picture = new JLabel(photo);
		pictureSpot.add (picture);
		pictureSpot.setVisible (true);
		pictureSpot.validate ( );
		pictureSpot.repaint ( ); 
	}
	
	/**
	 * removes a student from the class roll         
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 */
	public void removeStudent()
	{
		try
		{
			String[] namesArray = new String[2];
			String fullName = (String)namesPanel.names.getSelectedValue ( );
			namesArray = fullName.split(" ");
			Student foundStudent = rollManager.findStudent (namesArray[0], namesArray[1]);
			rollManager.removeStudent (foundStudent);
			rollManager.saveNeed=true;
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog (null, "Please Select A Student");
		}
	}
	
	/**
	 * saves the current roll manager to a file     
	 *
	 * <hr>
	 * Date created: Apr 30, 2016
	 *
	 * <hr>
	 * @return
	 */
	public int save()
	{
		int response=0;
		if(rollManager.saveNeed == true)
		{
			response = JOptionPane.showConfirmDialog (null, "Would you like to save?");
			if(response== JOptionPane.YES_OPTION && rollManager.fileName!=null)
			{
				rollManager.saveToFile();	
			}
			if(response==JOptionPane.YES_OPTION && rollManager.fileName==null)
			{
				JFileChooser fc = new JFileChooser();
			    fc.setCurrentDirectory(new File("/home/me/Documents"));	//sets the directory of where to find the file
			    int status = fc.showSaveDialog(null);
			    if(status == JFileChooser.APPROVE_OPTION)	
			    {
			    	File selectedFile = fc.getSelectedFile ( );
					rollManager.fileName = selectedFile;
			    }
			}
		}
		return response;

	}
	
	public void setLookAndFeel()
	{
		try
		{
			SwingUtilities.updateComponentTreeUI (this);
			UIManager.setLookAndFeel ( "javax.swing.plaf.metal.MetalLookAndFeel");
		    SwingUtilities.updateComponentTreeUI (this);
		}
		catch(Exception e)
		{
			
		}
	}
}
