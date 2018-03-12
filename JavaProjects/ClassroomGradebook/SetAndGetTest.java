import java.util.Scanner;
class SetAndGetTest
{
	public static void main(String[] args)	
	{
		Student s1 = new Student();
		int iValid;
		int iValid1;
		int iValid2;
		int iValid3;
		int iValid4;
		int iGrade;
		String strName;
		String strInstructor;
		String strCourse;
		double dPercent;
		double dAverage;
		double dCourseAverage;
		String strStudentInfo;

		iValid=s1.setName("Allison Ivey");
		System.out.print("\n" + iValid);
		
		strName=s1.getName();
		System.out.print("\n" + strName);
		
		iValid1=s1.setInstructor("Bailey");
		System.out.print("\n" + iValid1);
		
		strInstructor=s1.getInstructor();
		System.out.println("\n" + strInstructor);
		
		iValid2=s1.setCourse('n', "Intro To Computer Science");
		System.out.print("\n" + iValid2);
		
		strCourse=s1.getCourse('n');
		System.out.print(strCourse);
		
		s1.setPercent('t', .20);
		s1.setPercent('p', .20);
		s1.setPercent('q', .20);
		s1.setPercent('f', .40);
	
		
		dPercent=s1.getPercent('f');
		System.out.print(dPercent);
		
		
		iValid4=s1.addGrade('q', 85);
		System.out.print("\n" + iValid4);
		s1.addGrade('t', 95);
		s1.addGrade('f', 96);
		s1.addGrade('q', 97);
		s1.addGrade('p', 98);
		System.out.print("\n" + iValid4);
		
		iGrade=s1.getGrade('q', 2);
		System.out.println("\n" + iGrade);
		
		s1.changeGrade('q', 99, 2);
		
		iGrade=s1.getGrade('q', 2);
		System.out.println("\n" + iGrade);
		
		dAverage=s1.average('q');
		System.out.print(dAverage);
		
		dCourseAverage = s1.courseAverage();
		System.out.print(dCourseAverage);
		strStudentInfo = s1.studentInfo();
		System.out.print(strStudentInfo);
		
		
		
	}//end main(String[] args)
}//end SetAndGetTest
