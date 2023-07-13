package studentdb;

import java.util.Scanner;

public class StudentMain {

	static Scanner sc  = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		System.out.print("\nHow many new students are to be added in database? : ");
		int numOfStudents = sc.nextInt();
		
		Student student[] = new Student[numOfStudents];
		
		for (int i = 0; i < numOfStudents; i++) {
			System.out.println("\n\n~~~~~~~~~~" + (i + 1) + " Student Form~~~~~~~~~~");
			student[i] = new Student(500);
			student[i].takeInput(); // take user name and their year. Also generates Unique ID
			student[i].enrollCourse(); // enroll and fees tracker
			student[i].balanceCalculation(); // view balance, dues, make payment
			System.out.println("\n<<<<<<<<<< Form Completed >>>>>>>>>>");
		}
		
		for (int i = 0; i < numOfStudents; i++) {
			System.out.println("\n\n~~~~~~~~~~" + (i + 1) + " Student Details~~~~~~~~~~");
			System.out.println("\nName : " + student[i].getName());
			System.out.println("\nID : " + student[i].getID());
			System.out.print("\nCourses enrolled : ");
			student[i].getCoursesEnrolled();
			student[i].getBalance();
		}

	}

}
