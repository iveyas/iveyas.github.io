/**
 * ---------------------------------------------------------------------------
 * File name: AboutDialog.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 23, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;


import java.awt.*;
import javax.swing.*;


/**
 * This class makes an about box
 *
 * <hr>
 * Date created: Apr 21, 2016
 * <hr>
 * @author Allison Ivey
 */
public class AboutDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel icon; 	//the label with the picture
	private JLabel title;	//the title label
	private JLabel author;	//the author label
	private JLabel copyright;	//the copyright information
	protected JPanel grid;	//the main panel 
	
	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Apr 21, 2016 
	 *
	 * 
	 */
	public AboutDialog()
	{
		super();
	}
	
	
	/**
	 * Constructor parameterized constructor that takes in three values
	 * and passes them to the super constructor.  It sets the default 
	 * close operation sets the size of the panel and the layout.  It then adds
	 * the two panels one with the picture and the other with the information.       
	 *
	 * <hr>
	 * Date created: Apr 21, 2016 
	 *
	 * 
	 * @param mathPanel the panels that will have the different math 
	 * operations set to them
	 * @param windowName the label for the window
	 * @param modality the modality of the window
	 */
	public AboutDialog(Frames framesPanel, String windowName, boolean modality)
	{
		super(framesPanel, windowName, modality);
		this.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
		grid = new JPanel();
		setSize(750, 200);
		setLayout(new GridLayout(1,2));
		setLeftPanel();
		setRightPanel();
		setLocationRelativeTo(framesPanel);
		setVisible(true);
		
	}
	
	/**
	 * This is the left panel that will be used to insert a piture into the 
	 * main box         
	 *
	 * <hr>
	 * Date created: Apr 21, 2016
	 *
	 * <hr>
	 */
	public void setLeftPanel()
	{
		JPanel leftPanel = new JPanel();
		ImageIcon image = new ImageIcon("pictures/ETSU.jpg");
		icon = new JLabel();
		icon.setIcon (image);
		leftPanel.add (icon);
		this.add (leftPanel);
	}
	
	/**
	 * The right panel that has the information about the program.          
	 *
	 * <hr>
	 * Date created: Apr 21, 2016
	 *
	 * <hr>
	 */
	public void setRightPanel()
	{
		String strTitle = "Class Roll Book Manager";
		String strAuthor = "Author: Allison Ivey";
		String strCopyright = "Copyright CSCI 1260 Allison Ivey Lab 11";
		
		JPanel rightPanel = new JPanel();
		title = new JLabel();
		author = new JLabel();
		copyright = new JLabel();
		title.setFont (new Font("Serif", Font.BOLD, 24));
		title.setText (strTitle);
		author.setFont (new Font("Serif", Font.PLAIN, 18));
		author.setText (strAuthor);
		copyright.setFont (new Font("Serif", Font.PLAIN, 18));
		copyright.setText (strCopyright);
		rightPanel.add (title);
		rightPanel.add (author);
		rightPanel.add (copyright);
		
		this.add (rightPanel);
		
	}
	
}

