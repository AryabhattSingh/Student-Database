package studentdb;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	static Scanner sc = new Scanner(System.in);

	private String name;
	private int year, balance;
	private int uniqueID, feesDue = 0;
	private ArrayList<String> courses = new ArrayList<>(); 
	private boolean feesPaidFully = false;

	public Student(int initialBalance){
		balance = initialBalance;
	}

	protected String getName() {
		return name;
	}
	protected int getID() {
		return uniqueID;
	}
	protected void getCoursesEnrolled() {
		char ch = 'a';
		int i;
		for (i = 0; i < courses.size() - 1; i++, ch++)
			System.out.print(ch + ") " + courses.get(i) + ", ");
		System.out.println(ch + ") " + courses.get(i));
	}
	protected void getBalance() {
		System.out.println("\nOutstanding Dues : " + feesDue);
		System.out.println("\nCurrent Wallet Balance : " + balance);
	}

	public void takeInput() {
		System.out.print("\nEnter student's name : ");
		name = sc.nextLine();
		System.out.println("\nPlease select student's year.\n1. First year\n2. Second year\n3. Third Year\n4. Fourth / Final Year");
		System.out.print("\nEnter student's year : ");
		year = sc.nextInt();
		generateUniqueID();

	}

	private void generateUniqueID() {
		String str = "0123456789";
		int length = str.length();
		String unique = "";
		for (int i = 0; i < 4; i++) {
			unique += str.charAt((int) (Math.random() * length)); 
		}
		//####################
		unique = year + unique;
		//$############
		uniqueID = Integer.parseInt(unique);
	}

	public void enrollCourse() {

		boolean addAnotherCourse = true, isDuplicateCourse = false;
		System.out.println("\n########## COURSE SELECTION ##########");


		while (addAnotherCourse) {
			
			System.out.println("\nWe provide following courses : ");
			System.out.println("1. History 101\n2. Mathematics 101\n3. English 101\n4. Chesmistry 101\n5. Computer Science 101");
			
			System.out.print("\nEnter your course choice : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			feesDue += 600;
			
			switch (choice) {
			case 1 :
				if (courses.contains("History 101"))
					isDuplicateCourse = true;
				else
					courses.add("History 101");
				break;
			case 2 :
				if (courses.contains("Mathematics 101"))
					isDuplicateCourse = true;
				else
					courses.add("Mathematics 101");
				break;
			case 3 : 
				if (courses.contains("English 101"))
					isDuplicateCourse = true;
				else
					courses.add("English 101");
				break;
			case 4 :
				if (courses.contains("Chemistry 101"))
					isDuplicateCourse = true;
				else
					courses.add("Chemistry 101");
				break;
			case 5 :
				if (courses.contains("Computer Science 101"))
					isDuplicateCourse = true;
				else
					courses.add("Computer Science 101");
				break;
			}

			if (isDuplicateCourse)
				System.out.println("\n------You have already added this course. Please try another------");
			else
				System.out.println("\n----------Course Added----------");
			
			isDuplicateCourse = false;

			if (courses.size() < 5) {
				System.out.print("\nDo you want to add another course? Yes / No : ");
				String ch = sc.nextLine();
				ch = ch.toLowerCase();
				if (ch.equals("yes") || ch.equals("y")) {
					System.out.println("\n----------Adding another course----------");
				}
				else {
					addAnotherCourse = false;
				}
			}
			else {
				addAnotherCourse = false;
				System.out.println("\n------Adding upto 5 courses only is allowed------");

			}
			
			if (addAnotherCourse == false) {
				System.out.println("\n########## Course Selection Complete ########## ");
			}
		}//end of while

	}

	public void balanceCalculation() {

		int choice = 0;
		System.out.println("\n\n********* FEES and BALANCE details **********");
		System.out.println("\n--------------------------------------");
		System.out.println("Your outstanding due is : " + feesDue);

		while (balance < feesDue) {
			System.out.println("Current balance is      : " + balance);
			System.out.println("--------------------------------------");
			System.out.println("\nCurrent Balance is NOT sufficient to clear outstanding due. Please add money to the wallet in order to make payment.");
			System.out.println("\nSelect your option : ");
			System.out.println("1. Recharge Wallet \n2. Continue with current balance \n3. PAY LATER");
			System.out.print("\nEnter your option : ");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1) {
				System.out.println("\nEnter the amount to add to the wallet : ");
				int rechargeAmount = sc.nextInt();
				sc.nextLine();
				balance += rechargeAmount;
				System.out.println("\n----------Wallet Recharge Successful----------");
			}
			if (choice == 2 || choice == 3) {
				break;
			}

		}

		if (choice == 2) {
			System.out.print("\nDo you wish to make the payment with current balance? Yes or No : ");
			String option = sc.nextLine().toLowerCase();
			if (option.equals("yes") || option.equals("y")) {
				if (balance >= feesDue) {
					balance = balance - feesDue;
					feesDue = 0;
					feesPaidFully = true;
				}
				else {
					feesDue = feesDue - balance;
					balance = 0;
					feesPaidFully = false;
				}
				System.out.println("\n----------Payment Successful----------");
				if (feesPaidFully)
					//
					System.out.println("********** All Dues Cleared **********");
				else
					System.out.println("********** Dues Cleared Partially **********");
			}

		}
		else if (choice == 3) {
			System.out.println("\n********** Payment to be done later **********");
		}

	}

}
