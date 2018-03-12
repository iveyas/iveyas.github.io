/**
 * ---------------------------------------------------------------------------
 * File name: layerOneMenu.java
 * Project name: IveyAllison_Project4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 26, 2016
 * ---------------------------------------------------------------------------
 */

package SchoolManager;

import javax.swing.JOptionPane;

/**
 * This menu allows the user to select what they want to do either update or create
 * It also checks that the values that they enter are valid.
 *
 * <hr>
 * Date created: Mar 26, 2016
 * <hr>
 * @author Allison Ivey
 */
public class layerOneMenu
{
	public static int MenuLayerOne()
	{
		boolean blnCanParse;
		int menuSelection = 0;
		try
		{
			String temp = JOptionPane.showInputDialog ("Student Management System\n_________________________________________\n" +
			"1. Create a new class\n" +
			"2. Update and existing class\n"+
			"3. Exit");
			blnCanParse = menuLayerTwo.isParsable (temp);
			if(blnCanParse == true)
			{
				menuSelection = Integer.parseInt (temp);
				while(menuSelection > 3 && menuSelection <1 && blnCanParse == false)
				{
					temp = JOptionPane.showInputDialog ("Student Management System\n_________________________________________\n" +
						"1. Create a new class\n" +
						"2. Update and existing class\n"+
						"3. Exit");
					blnCanParse = menuLayerTwo.isParsable (temp);
	
				}
				menuSelection = Integer.parseInt (temp);
	
			}
		}
		catch(Exception e)
		{
			System.exit (0);
		}
		return menuSelection;
	}
}
