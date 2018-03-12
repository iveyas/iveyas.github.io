/**
 * ---------------------------------------------------------------------------
 * File name: IOPanel.java
 * Project name: project6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 23, 2016
 * ---------------------------------------------------------------------------
 */

package project6GUI;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


/**
 * This is the panel that holds all the names from the class roll
 * it has a list in a scrollable box. 
 *
 * <hr>
 * Date created: Apr 23, 2016
 * <hr>
 * @author Allison Ivey
 */
public class NamesPanel extends JPanel
{

	
	protected JList <Object> names;
	
	
	/**
	 * The constructor that sets up the list selection box with a scroll bar
	 * and all the listeners and details it needs to function      
	 *
	 * <hr>
	 * Date created: Apr 30, 2016 
	 *
	 * 
	 * @param objects the student's names 
	 */
	public NamesPanel(Object [ ] objects)
	{
		super();
		names = new JList<Object>(objects); // the list that hold the names
		names.setSelectionMode (ListSelectionModel.SINGLE_SELECTION); //single selection option
		names.setBorder (BorderFactory.createTitledBorder ("Students")); //creates a titled boarder
		names.setVisibleRowCount (7); //sets the number of rows that can be seen at once
		names.setFixedCellWidth (200); //sets the cell width
		JScrollPane scrollPane = new JScrollPane(names); //makes it so that it can scroll
		JPanel namesPanel = new JPanel(); //creates the names panel
		namesPanel.add (scrollPane); //sets the scroll pane to the names panel
		names.setVisible (true); //sets the names panel visible
		add(namesPanel); //adds the names panel
		names.addListSelectionListener (null); //adds the listener for the list

	}
	private static final long serialVersionUID = 1L;
	

}
