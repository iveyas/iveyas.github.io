/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: IveyAllison_Project4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 26, 2016
 * ---------------------------------------------------------------------------
 */

package SchoolManager;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Mar 26, 2016
 * <hr>
 * @author Allison Ivey
 */
public class Driver
{

	/**
	 * This main method allows the user to impliment the different menus so that they are
	 * able to update or create new classes.         
	 *
	 * <hr>
	 * Date created: Mar 26, 2016
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		menuLayerTwo twoMenu = new menuLayerTwo();	//creates an instance of the second menu
		menuLayerThree threeMenu = new menuLayerThree();//creates and instance of the third menu

		int menuChoice;	//user menu choice
		boolean blnStart= true;	//makes sure the person wants to keep entering data
		
					
		while(blnStart==true)
		{
			menuChoice = layerOneMenu.MenuLayerOne ( ); //shows the first menu
			
			switch(menuChoice)
			{
				case 1:
					twoMenu.createNewClassRoll ( ); 
					twoMenu.saveNewRollManager ( );
					blnStart = true;
				break;
				case 2:
					threeMenu.fillFromFile ( );
					menuChoice = threeMenu.menuItems ( );
					threeMenu.menuSwitch (menuChoice);
					blnStart = true;
					break;
				case 3: 
					System.exit (0);
				default:
			}//allows the user to input their choice 	
		}		
		
		// TODO Auto-generated method stub

	}

}
