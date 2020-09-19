import student.*; //to use all class under student package
import teacher.*; //to use all class under teacher package
import admin.*; //to use all class under admin package, password is "admin"
import java.util.*;

public class Start {

	@SuppressWarnings("resource") //not to show error for not closing Scanner object
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\tUniversity Management System");
		System.out.println("\t\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\t\tData Management");
		System.out.println("\t\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
		

		while(true)
		{
			System.out.println("\n\t1. Student Information");
			System.out.println("\t2. Teacher Information");
			System.out.println("\t3. Admin");
			System.out.println("\t4. Exit Program\n");
			
			System.out.println("Enter Your Choice:");

			// create an object of Scanner
			Scanner input = new Scanner(System.in);

			// take input from the user
			int number = input.nextInt();

			switch(number)
			{
				case 1:
					Student s = new Student(); //creating an object of Student
					s.start(); //calling a function from Student class
					break;

				case 2:
					Teacher t = new Teacher();
					t.start();
					break;

				case 3:
					Admin a = new Admin();
					a.start();
					break;

				case 4:
					System.out.println("\n\tExiting. Thank you.");
					System.exit(0);

				default:
					System.out.println("Invalid Input. Try Again.");
			}
		}
	}

}
