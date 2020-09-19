package teacher;
import java.util.*; // Import the IOException class to handle errors
import java.io.*;  // Import the File class

public class Teacher {
	public void start()
	{
		System.out.println("Teacher Information");

		boolean jump=false;

		do
		{
			System.out.println("\n\t1. Create new entry");
			System.out.println("\t2. Display teacher info");
			System.out.println("\t3. Jump to main");
			
			System.out.println("\nEnter Your Choice:");

			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			// take input from the user
			int number = input.nextInt();

			switch(number)
			{
			case 1:
				System.out.println("Only Admin Mode can change Teacher Information. If you want Admin Mode, go to Main Menu and Press 3");
				break;

			case 2:

				try {
					File myObj = new File("TeacherInfo.txt");
					Scanner myReader = new Scanner(myObj);

					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						System.out.println(data);
					}
					myReader.close();
				} 
				catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				break;

			case 3: 
				jump=true;
				System.out.println("Jumping to Main Menu\n");
				break;

			default:
				System.out.println("Invalid Input. Try Again.");
			}

		}
		while(jump!=true);

	}


}
