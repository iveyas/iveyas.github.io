import java.util.Scanner;
public class Proj3
{
	public static void main(String[] args)	
	{
		Student s1= new Student();
		Scanner kb = new Scanner(System.in);
		double dTest1;		//holds the value of test 1
		double dTest2;		//holds the value of test 2
		double dTest3;		//holds the value of test 3
		double dQuiz1;		//holds the value of quiz 1
		double dQuiz2;		//holds the value of quiz 2
		double dQuiz3;		//holds the value of quiz 3
		double dQuiz4;		//holds the value of quiz 4
		double dQuiz5;		//holds the value of quiz 5
		double dProj1;		//holds the value of project 1
		double dProj2;		//holds the value of project 2
		double dProj3;		//holds the value of project 3
		double dProj4;		//holds the value of project 4
		double dPercentAmt;	//holds the percent amount of all scores
		String strName;		//holds the value of the name of the student
		String strCourseDesc;	//holds the value of the course description
		String strCourseNum;	//holds the value of the course number
		String strInstructor;	//holds the value of the isntructor's name
		int iGrade;				//holds the grade value
		int iNumGrade;			//holds the number of the grade the user is entering
		int iValidate;			//holds -1 or 0 in order to validate the user input
		int iMenu;				//holds the number the user enters into the menu
		char cCategory;			//holds the value of the category the user wants 
		String strStudentInfo;	//holds the value of the summary student information
		
		System.out.print("\nEnter your name: ");
		strName=kb.nextLine();
		iValidate=s1.setName(strName);
		if(iValidate==-1)
		{
			System.out.print("Invalid Name");
		}
		
		System.out.print("\nEnter your instructor: ");
		strInstructor= kb.nextLine();
		iValidate=s1.setInstructor(strInstructor);
		if(iValidate==-1)
		{
			System.out.print("Invalid Instructor");
		}
		
		System.out.print("\nEnter your course description: ");
		strCourseDesc= kb.nextLine();
		iValidate=s1.setCourse('d', strCourseDesc);
		if(iValidate==-1)
		{
			System.out.print("invalid");
		}
		
		System.out.print("\nEnter your course number: ");
		strCourseNum= kb.nextLine();
		iValidate=s1.setCourse('n', strCourseNum);
		if(iValidate==-1)
		{
			System.out.print("Invalid Course Number: ");
		}
		
		for(int i=1;i<=20;i++)
		{
			iMenu=menu();
			
			if(iMenu==1)
			{
				System.out.print("\nWhich weight would you like to set? \nPress T" + 
				" for test, P for project, Q for qizzes and F for the final ");
				cCategory=kb.next().charAt(0);
				if(cCategory==-1)
				{
					System.out.print("Invalid");
					cCategory=0;
					dPercentAmt=0;
				}
				else
				{
					System.out.print("\nWhat would you like to set the weight to? ");
					dPercentAmt= kb.nextDouble();
					
					if(dPercentAmt==-1)
					{
						System.out.print("invalid");
						dPercentAmt=0;
					}
				}
					
				s1.setPercent(cCategory, dPercentAmt);
			}
			else 
			{
				if(iMenu==2)
				{
					System.out.print("Which grade would you like to change?\n Press " +
						"t for test, p for project, q for quiz or f for final ");
					cCategory = kb.next().charAt(0);
						if(cCategory==-1)
						{
							System.out.print("invalid");
							cCategory=0;
							iGrade=0;
						}
						else
						{
							System.out.print("Enter grade: ");
							iGrade=kb.nextInt();
							if(iGrade==-1)
							{
								System.out.print("invalid");
								iGrade=0;
							
							}
						}
							s1.addGrade(cCategory, iGrade);
				}
				
			
				else 
				{
					if(iMenu==3)
					{
						System.out.print("Which grade would you like to enter?\n Press " +
							"t for test, p for project, q for quiz or f for final ");
						cCategory = kb.next().charAt(0);
						if(cCategory==-1)
						{
							System.out.print("invalid");
							cCategory=0;
							iNumGrade=0;
							iGrade=0;
						}
						else
						{
							System.out.print("What number of either projects, quizzes," +
							" or tests would you like to change?");
							iNumGrade= kb.nextInt();
							if(iNumGrade==-1)
							{
								System.out.print("invalid");
								iNumGrade=0;
								iGrade=0;
							}
							else
							{
								System.out.print("What would you like to change the grade to? ");
								iGrade=kb.nextInt();
								if(iGrade==-1)
								{
									System.out.print("invalid");
									iGrade=0;
								}
							}
						}
						s1.changeGrade(cCategory, iGrade, iNumGrade);
					}
				
					else
					{	
						if(iMenu==4)
						{
							System.out.print("What category's average would you like to display?");
							cCategory = kb.next().charAt(0);
							System.out.print(s1.average(cCategory));
							
						}
						else
						{	
								if(iMenu==5)
								{
								strStudentInfo = s1.studentInfo();
								System.out.print(strStudentInfo);
								
								}
						}	
					}
				}
			}	
		}		
	}//end main(String[] args)
	/**
	*Method Name: menu <hr>
	* Method purpose:  Propmts the user to enter a number that corresponds to a 
	* menue item.
	* 
	* <hr>
	* Date created: 11/9/2015
	* Date Last Modified 11/14/2015 <br>
	* 
	* *<hr>
	* @return iMenu int, the users numeric menu item choice
	*/	
	public static int menu()
	{
		Scanner kb = new Scanner(System.in);
		int iMenu;
		System.out.print("\n1. Enter the weight for either tests, quizzes," +
			" projects, or the final: ");
		System.out.print("\n2. Enter a grade: ");
		System.out.print("\n3. Change a grade: ");
		System.out.print("\n4. Display the average: ");
		System.out.print("\n5. Display Student Information: ");
		iMenu= kb.nextInt();
		return iMenu;
	}//end menu (int)

}//end Proj3	
