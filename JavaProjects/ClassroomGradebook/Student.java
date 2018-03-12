import java.util.Scanner;
import java.text.DecimalFormat;
public class Student 
{
	private String name;
	private String courseDesc;		//holds the value of the course description
	private String courseNum;		//holds the value of the couse number
	private String instructor;		//holds the value of the instructor's name
	private int test1;				//holds the value of test 1
	private int test2;				//holds the value of test 2
	private int test3;				//holds the value of test 3
	private int testGraded;			//holds the value of the number of tests graded
	private int quiz1;				//holds the value of quiz 1
	private int quiz2;				//holds the value of quiz 2
	private int quiz3;				//holds the value of quiz 3
	private int quiz4;				//holds the value of quiz 4
	private int quiz5;				//holds the value of quiz 5
	private int quizzesGraded;		//holds the value of number of quizzes graded
	private int proj1;				//holds the value of project 1
	private int proj2;				//holds the value of project 2
	private int proj3;				//holds the value of project 3
	private int proj4;				//holds the value of project 4
	private int projGraded;			//holds the value of the number of projects 
									//graded
	private int finalExam;			//holds the value of the final exam
	private boolean recordedFinalExam;	//tells if the final has been recorded	
	private double pctT;			//holds the weight for tests
	private double pctQ;			//holds the weight for the quizzes
	private double pctP;			//holds the weight for the projects
	private double pctF;			//holds the weight for the final
	
	/**
	*Method Name: setName (String)<hr>
	* Method purpose:  This method validates that the user input name is greater than 
	* zero. If the name has more than zero characters it will return a zero if not it 
	* will return a -1.  It also stores the user input name into the class attribute 
	* name. 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iNameLength int, stores the a value of zero if the veriable contains 
	* more than one character and -1 if the name value is empty.
	* 
	* *<hr>
	* @return iNameLength int, returns 0 if there are any number of characters above
	* zero and -1 if the are no characters. 
	*/
	public int setName(String name)
	{

		int iNameLength;
		if(name.length()>0)
		{
			this.name=name;
			iNameLength=(0);
		}
		else
		{
			iNameLength=(-1);
		}
		return iNameLength;
	}//end setName(String)
	
	/**
	*Method Name: setInstructor(String) <hr>
	* Method purpose:  This method validates that the user input name is greater than 
	* zero. If instructor has more than zero characters it will return a zero if not 
	* it will return a -1.  It also stores the user input name into the class 
	* attribute instructor. 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iInstructorLength int, stores the a value of zero if the veriable 
	* contains more than one character and -1 if the name value is empty.
	* 
	* *<hr>
	* @return iInstructorLength int, returns 0 if there are any number of characters 
	* above  zero and -1 if the are no characters. 
	*/
	
	public int setInstructor(String instructor)
	{
		int iInstructorLength;
		if(instructor.length()>0)
		{
			this.instructor=instructor;
			iInstructorLength=(0);
		}
		else
		{
			iInstructorLength=(-1);
		}
		return iInstructorLength;
	}//end setInstructor(String)
	
	/**
	*Method Name: setCourse (char, String)<hr>
	* Method purpose:  The user can enter what type of information that they want to 
	* enter and what value they want to enter for that type.  If any of the enteries
	* are invalid the method will return a -1 if the are valid it will return a 0.
	* this method sets the course. 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iNum int, accepts a value of 0 or -1 to validate the input of the data.
	* 
	* *<hr>
	* @return iNum int, returns 0 if there are any number of characters 
	* above  zero and -1 if the are no characters. 
	*/
	
	public int setCourse(char type, String desc)
	{
		int iNum;
		iNum=0;
		if (desc.length()>0)
		{
			iNum=0;
		}
		else
		{
			iNum=-1;
		}
		if (iNum==0)	
		{
			switch(type)
			{
				case 'n':
					courseNum=desc;
					break;
				case 'N':
					courseNum=desc;
					break;
				case 'd':
					courseDesc=desc;
					break;
				case 'D':
					courseDesc=desc;
					break;
				default:
					iNum=-1;
					break;
			}
		}	
		else
		{
		}
		return iNum;
	}//end setCourse(String)
	
	/**
	*Method Name: setPercent (char, double) <hr>
	* Method purpose:  The user can enter what type of information that they want to 
	* enter and what value they want to enter for that type.  If any of the enteries
	* are invalid the method will return a -1 if the are valid it will return a 0.
	* this method sets the course. 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iVal int, accepts a value of 0 or -1 to validate the input of the data.
	* 
	* *<hr>
	* @return iVal int, returns 0 if there are any number of characters 
	* above  zero and -1 if the are no characters. 
	*/
	
	public int setPercent(char type, double pctAmt)
	{
		int iVal;
		if(pctAmt>0)
		{
			switch(type)
			{
				case 'q':
				case 'Q':
					pctQ=pctAmt;
					iVal=0;
					break;
				
				case 'T':
				case 't':
					pctT=pctAmt;
					iVal=0;
					break;
				
				case 'p':
				case 'P':
					pctP=pctAmt;
					iVal=0;
					break;
				
				case 'f':
				case 'F':
					pctF=pctAmt;
					iVal=0;
					break;
				default:
					iVal=-1;
			}
		}
		else
		{
			iVal=-1;
		}
		return iVal;
	}//end changeGrade(char, double)
	
	/**
	*Method Name: changeGrade (char, int, int)<hr>
	* Method purpose:  The user can enter what type of information that they want to 
	* enter and what value they want to enter for that type.  If any of the enteries
	* are invalid the method will return a -1 if the are valid it will return a 0.
	* this method sets the course.  The user can only change a grade that has been
	* previously entered 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iVal int, accepts a value of 0 or -1 to validate the input of the data.
	* 
	* *<hr>
	* @return iVal int, returns 0 if there are any number of characters 
	* above  zero and -1 if the are no characters. 
	*/
	
	public int changeGrade(char type, int grade, int numGrade)
	{
		int iVal;
		switch(type)
		{	
			case 'q':
			case 'Q':
				iVal=0;
				if(quizzesGraded>0 && numGrade<=quizzesGraded)
				{
					switch(numGrade)
					{
					case 1:
						quiz1=grade;
						break;
					case 2:
						quiz2=grade;
						break;
					case 3:
						quiz3=grade;
						break;
					case 4:
						quiz4=grade;
						break;
					case 5:
						quiz5=grade;
						break;
					default:
						iVal=-1;
					}
				}
				else
				{
					iVal=-1;
				}	
				break;
			case 't':
			case 'T': 
				iVal=0;
				if(testGraded>0 && numGrade<=testGraded)
				{
					switch(numGrade)
					{
					case 1:
						test1=grade;
						break;
					case 2:
						test2=grade;
						break;
					case 3:
						test3=grade;
						break;
					default:
						iVal=-1;
					}
				}
				else
				{
					iVal=-1;
				}
				break;
			case 'F': 
			case 'f': 
				iVal=0;
				if(recordedFinalExam==false)
				{
					iVal=-1;
				}
				else
				{
					finalExam=grade;
					recordedFinalExam=true;
				}
				break;
			case 'p':	 
			case 'P': 
				iVal=0;
				if(projGraded>0 && numGrade<=projGraded)
				{
					switch(numGrade)
					{	
						case 1:
							proj1=grade;
							break;
						case 2:
							proj2=grade;
							break;
						case 3:
							proj3=grade;
							break;
						case 4:
							proj4=grade;
							break;
						default:
							iVal=-1;
					}
				}
				break;
			default:
				iVal=-1;
		}		
	
				
	return iVal;
	}//end changeGrade(char, int, int)
	
	/**
	*Method Name: getName()hr>
	* Method purpose:  this is a method so the user can get the value of the users
	* name
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param strName String, stores the value of the user's name
	* 
	* *<hr>
	* @return strName String, returns the value of the users name.
	*/
	
	public String getName()
	{
		String strName;
		strName=this.name;
		return strName;
	}//end getName()
	
	/**
	*Method Name: getInstructor()hr>
	* Method purpose:  this is a method so the user can get the value of the users
	* name
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param strInstructor String, stores the value of the user's instructor
	* 
	* *<hr>
	* @return strInstructor String, returns the value of the users instructor.
	*/
	
	public String getInstructor()
	{
		String strInstructor;
		strInstructor=this.instructor;
		return strInstructor;
	}//end getInstructor()
	
	/**
	*Method Name: getCourse(char)hr>
	* Method purpose:  this is a method so the user can get the value of the users
	* course when they give the type of information that they would like to recieve.
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param strCourse String, stores the value of the user's course
	* 
	* *<hr>
	* @return strCourse String, returns the value of the users course.
	*/
	public String getCourse(char type)
	{
		String strCourse;
		switch(type)
		{
			case 'd':
			case 'D':
				strCourse = courseDesc;
				break;
			case 'n':
			case 'N':
				strCourse= courseNum;
				break;
			default:
				strCourse= ("invalid");
		}
		return strCourse;
	}//end getCourse(char)
	
	/**
	*Method Name: getGrade(char, int)hr>
	* Method purpose:  this is a method so the user can get the value of the users
	* grade when they tell the computer what number of grade and type of grade
	* they would like to recieve
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iGrade int, stores the value of the user's grade
	* 
	* *<hr>
	* @return iGrade int, returns the value of the users grade.
	*/
	
	public int getGrade(char type, int num)
	{
		int iGrade;
		switch(type)
		{
			case 'q':
			case 'Q':
				if(quizzesGraded>=num)
				{
					switch(num)
					{
					case 1:
					iGrade=quiz1;
					break;
					case 2:
					iGrade=quiz2;
					break;
					case 3:
					iGrade=quiz3;
					break;
					case 4:
					iGrade=quiz4;
					break;
					case 5:
					iGrade=quiz5;
					break;
					default:
					iGrade=-1;
					}
				}
				else
				{
					iGrade=-1;
				}
				break;	
			case 'p':
			case 'P':
				if(projGraded>=num)
				{
					switch(num)
					{
					case 1:
					iGrade=proj1;
					break;
					case 2:
					iGrade=proj2;
					break;
					case 3:
					iGrade=proj3;
					break;
					case 4:
					iGrade=proj4;
					break;
					default:
					iGrade=-1;
					}
				}
				else
				{
					iGrade=-1;
				}
				break;
			case 't':
			case 'T':
				if(testGraded>=num)
				{
					switch(num)
					{
					case 1:
					iGrade=test1;
					break;
					case 2:
					iGrade=test2;
					break;
					case 3:
					iGrade=test3;
					break;
					default:
					iGrade=-1;
					}
				}
				else
				{
					iGrade=-1;
				}
				break;
			case 'f':
			case 'F':
				if(recordedFinalExam==true)
				{
				iGrade=finalExam;
				}	
				else
				{
					iGrade=-1;
				}
				break;
			default:
				iGrade= -1;
				
		}
		
		return iGrade;
	}//end getGrade(char, int)
	
	/**
	*Method Name: getName()hr>
	* Method purpose:  this is a method so the user can get the value of the users
	* a chosen catigory of percent
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param dPercent double, stores the value of the user's percent
	* 
	* *<hr>
	* @return dPercent double, returns the value of the users percent.
	*/
	
	public double getPercent(char type)
	{
		double dPercent;
		switch(type)
		{
			case 'q':
			case 'Q':
				dPercent=pctQ;
				break;
			case 'p':
			case 'P':
				dPercent=pctP;
				break;
			case 't':
			case 'T':
				dPercent=pctT;
				break;
			case 'f':
			case 'F':
				dPercent=pctF;
				break;
			default:
				dPercent= -1;
		}
		return dPercent;
		
	}//end getPercent(char)
	
	/**
	*Method Name: addGrade()hr>
	* Method purpose:  this is a method so that the user can change a grade that has
	* already been entered.  It can not add a grade that has not been entered yet.
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param iVal int, holds the value of 0 if valid and -1 if it is not valid
	* 
	* *<hr>
	* @return iVal int, returns the value of 0 if valid and -1 if not valid
	*/
	
	public int addGrade(char type, int grade)
	{
		int iVal;
		switch(type)
		{
			case 'q':
			case 'Q':
				if(quizzesGraded <= 4)
				{
					switch(quizzesGraded)
					{
						case 0:
							quiz1 = grade;
							iVal=0;
							this.quizzesGraded = quizzesGraded+=1;
							break;
						case 1:
							quiz2=grade;
							iVal=0;
							this.quizzesGraded = quizzesGraded+=1;
							break;
						case 2: 
							quiz3=grade;
							iVal=0;
							this.quizzesGraded = quizzesGraded+=1;
							break;
						case 3:
							quiz4=grade;
							iVal=0;
							this.quizzesGraded = quizzesGraded+=1;
							break;
						case 4:
							quiz5=grade;
							iVal=0;
							this.quizzesGraded = quizzesGraded+=1;
							break;
						default:
							iVal=-1;
					}
				}
				else
				{
					iVal=-1;
				}
				break;
			case 'p':
			case 'P':
				if(projGraded<4)
				{
					switch(projGraded)
					{
						case 0:
							proj1=grade;
							iVal=0;
							this.projGraded = projGraded+=1;
							break;
						case 1:
							proj2=grade;
							iVal=0;
							this.projGraded = projGraded+=1;
							break;
						case 2:
							proj3=grade;
							iVal=0;
							this.projGraded = projGraded+=1;
							break;
						case 3:
							proj4=grade;
							iVal=0;
							this.projGraded = projGraded+=1;
							break;
						default:
							iVal=-1;
					}
				}
				else
				{
					iVal=-1;
				}
				break;
			case 't':
			case 'T':
				if(testGraded<3)
				{
					switch(testGraded)
					{
						case 0:
							test1=grade;
							iVal=0;
							this.testGraded = testGraded+=1;
							break;
						case 1:
							test2=grade;
							iVal=0;
							this.testGraded = testGraded+=1;
							break;
						case 2:
							test3=grade;
							iVal=0;
							this.testGraded = testGraded+=1;
							break;
						default:
							iVal=-1;
					}
				}
				else
				{
					iVal=-1;
				}
				break;
			case 'f':
			case 'F':
				if(recordedFinalExam==false)
				{
					finalExam=grade;
					this.recordedFinalExam=true;
					iVal=0;
				}
				else
				{
					iVal=-1;
				}
				break;
			default:
				iVal=-1;
		}
		return iVal;
	}//end addGrade(char, int)
	
	/**
	*Method Name: average(char)hr>
	* Method purpose:  this method returns that average of a particular user chosen 
	* group 
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param dAverage double, stores the value of the chosen group's percent
	* 
	* *<hr>
	* @return dAverage double, returns the value of the users chosen group's percent
	*/
	
	public double average(char type)
	{
		double dAverage;
		switch(type)
		{
			case 't':
			case 'T':
				switch(testGraded)
				{	
					case 1: 
						dAverage=test1;
						break;
					case 2:
						dAverage= ((1.0 * test1 + test2)/2);
						break;
					case 3:
						dAverage= ((1.0 * test1 + test2 + test3)/3);
						break;
					default:
						dAverage=-1;
				}
				break;
			case 'q':
			case 'Q':
				switch(quizzesGraded)
					{
					case 1:
						dAverage=quiz1;
						break;
					case 2:
						dAverage= ((1.0 * quiz1 + quiz2)/2);
						break;
					case 3:
						dAverage= ((1.0 * quiz1 + quiz2 + quiz3)/3);
						break;
					case 4:
						dAverage= ((1.0 * quiz1 + quiz2 + quiz3 + quiz4)/4);
						break;
					case 5:
						dAverage= ((1.0 * quiz1 + quiz2 + quiz3 + quiz4 + quiz5)/5);
						break;
					default:
						dAverage=-1;
					}
				break;
			case 'p':
			case 'P':
				switch(projGraded)
					{
					case 1:
						dAverage=(proj1);
						break;
					case 2:
						dAverage=((1.0 * proj1 + proj2)/2);
						break;
					case 3:
						dAverage=((1.0 * proj1 + proj2 + proj3)/3);
						break;
					case 4:
						dAverage=((1.0 * proj1 + proj2 + proj3 + proj4)/4);
						break;
					default:
						dAverage=-1;
					}
				break;
			default:
				dAverage=-1;
			
		}
		return dAverage;
	}//end average(char)
	
	/**
	*Method Name: average(char)hr>
	* Method purpose:  this method returns that average of all the scores entered
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param dQuiz double, stores the value of the weighted quiz average
	* @param dProj double, stores the value of the weighted project average
	* @param dTest double, stores the value of the weighted test average
	* @param dFinal double, stores the value of the weighted final average
	* @param dWeightedAvg double, stores the value of the weighted average of the 
	* course.
	* 
	* *<hr>
	* @return dWeightedAvg, returns the wieghted average
	*/
	
	public double courseAverage()
	{
		double dQuiz;
		double dProj;
		double dTest;
		double dFinal;
		double dWeightedAvg;
		
		switch(quizzesGraded)
		{
			
			case 1:
				dQuiz= (1.0 * quiz1) * pctQ;
				break;
			case 2:
				dQuiz=((1.0 * quiz1+quiz2)/2) * pctQ;
				break;
			case 3:
				dQuiz=((1.0 * quiz1 + quiz2 + quiz3)/3) * pctQ;
				break;
			case 4:
				dQuiz=((1.0 * quiz1 + quiz2 + quiz3 + quiz4)/4) * pctQ;
				break;
			case 5:
				dQuiz=((1.0 * quiz1 + quiz2 + quiz3 + quiz4 + quiz5)/5) * pctQ;
				break;
			default:
				dQuiz = 0;
		}
		switch(projGraded)
		{
			
			case 1: 
				dProj=((1.0 * proj1)) * pctP;
				break;
			case 2:
				dProj=((1.0 * proj1 + proj2)/2) * pctP;
				break;
			case 3:
				dProj=((1.0 * proj1 + proj2 + proj3)/3)*pctP;
				break;
			case 4:
				dProj=((1.0 * proj1 + proj2 + proj3 + proj4)/4) * pctP;
				break;
			default:
				dProj = 0;
		}
		switch(testGraded)
		{
			case 1:
				dTest=(1.0 * test1) * pctT;
				break;
			case 2:
				dTest=((1.0 * test1+test2)/2) * pctT;
				break;
			case 3:
				dTest=((1.0 * test1 + test2 + test3)/3) * pctT;
				break;
			default:
				dTest = 0;
		}
		if(recordedFinalExam==true)
		{
			dFinal=finalExam*pctF;
		}
		else
		{
			dFinal=0;
		}
		dWeightedAvg= (dProj + dTest + dQuiz + dFinal);
		return dWeightedAvg;
		
	}//end courseAverage()
	
	/**
	*Method Name: studentInfo()hr>
	* Method purpose:  this method returns a summary of the student information
	* 
	* <hr>
	* Date created: 11/4/2015
	* Date Last Modified 10/14/2015 <br>
	* 
	* <hr>
	* @param dRoundedCourseAverage double, holds the rounded course average 
	* @param dCourseAverage, holds the value of the course average 
	* @param strStudentInfo String, holds the value of the string that is being 
	* returned with all the student information
	* 
	* *<hr>
	* @return strStudentInfo String, returns a summary of the student information
	*/
	public String studentInfo()
	{
		String strStudentInfo;
		DecimalFormat percent = new DecimalFormat("0.0%");
		double dRoundedCourseAverage;
		double dCourseAverage;
		dCourseAverage= courseAverage();
			
		dRoundedCourseAverage= Math.round(dCourseAverage);
		strStudentInfo =
		("\nName:      " + name +
		"\nCourse:    " + courseDesc +
		"\nNumber:    " + courseNum +
		"\nInstructor:" + instructor +
		"\nGrades:" +
		"\nTest:    \tAverage: "+ average('t') +"\tPercent: " + pctT +
		"\nQuizzes: \tAverage: "+ average('q') +"\tPercent: " + pctQ +
		"\nProject: \tAverage: "+ average('p') +"\tPercent: " + pctP +
		"\nCourse Average: " + dCourseAverage + "(or "+
			percent.format(dRoundedCourseAverage/100) + ")");
		return strStudentInfo;
	}//end studentInfo()
	
	
}
