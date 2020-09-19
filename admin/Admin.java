package admin;

import java.io.IOException;
import java.util.*;

import student.Student;

public class Admin extends Student{
	public void start()
	{
		System.out.println("Welcome to Admin Mode.");
		System.out.println("Input the password: ");

		// create an object of Scanner
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		// take input from the user
		

		int limit=4;
		int i=4;

		boolean jump=false;

		while(limit!=0)
		{
			limit--;
			--i;
			String pass = input.nextLine();
			if(pass.equals("admin"))
			{
				System.out.println("\nAccess Granted\n");
				limit=0;
			}
			else if(limit>0)
			{
				System.out.println("Wrong password, try again.");
			}
		}
		
		if(i<=0)
		{
			System.out.println("Limit Exceeded. Program has been halted");
			System.exit(0);
		}
		
		while(!jump)
		{
			System.out.println("\t1. Alter Teacher Information");
			System.out.println("\t2. Jump to main");


			System.out.println("\nEnter Your Choice:");

			// take input from the user
			int number = input.nextInt();

			switch(number)
			{
			case 1:
				Admin a = new Admin();

				System.out.println("Enter the old line you want to change: ");
				@SuppressWarnings("unused") String temp = input.nextLine();
				String old = input.nextLine();

				System.out.println("Enter the new line: ");
				String newest = input.nextLine();

				try {
					a.change("TeacherInfo.txt", old, newest);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				jump=true;
				System.out.println("Jumping to Main Menu\n");
				break;

			default:
				System.out.println("Invalid Input. Try Again.");
			}
		}

	}

}
