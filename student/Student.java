package student;
import java.util.*;
import java.io.*;  // Import the File classes
import java.io.IOException;  // Import the IOException class to handle errors

public class Student{
	protected String first_name;
	protected String second_name;
	protected String registration_number;
	static int i=1;

	public void update_fn(String str)
	{
		this.first_name=str;
	}

	public void update_sn(String str)
	{
		this.second_name=str;
	}

	public void update_rn(String str)
	{
		this.registration_number=str;
	}
	
	public void change(String filename, String old, String newest) throws IOException {
	      //Instantiating the File class
	      String filePath = filename;
	      //Instantiating the Scanner class to read the file
	      Scanner sc = new Scanner(new File(filePath));
	      //instantiating the StringBuffer class
	      StringBuffer buffer = new StringBuffer();
	      //Reading lines of the file and appending them to StringBuffer
	      while (sc.hasNextLine()) {
	         buffer.append(sc.nextLine()+System.lineSeparator());
	      }
	      
	      String fileContents = buffer.toString();
	      
	      System.out.println("Contents of the file: "+fileContents);
	      
	      //closing the Scanner object
	      sc.close();
	      
	      String oldLine = old;
	      String newLine = newest;
	      
	      //Replacing the old line with new line
	      fileContents = fileContents.replaceAll(oldLine, newLine);
	      
	      //instantiating the FileWriter class
	      FileWriter writer = new FileWriter(filePath);
	      
	      System.out.println("");
	      
	      System.out.println("new data: "+fileContents);
	      
	      writer.append(fileContents);
	      writer.flush();
	      writer.close();
	}

	public void start()
	{
		System.out.println("Student Information");

		boolean jump=false;

		do
		{
			System.out.println("\t1. Create new entry");
			System.out.println("\t2. Display student info");
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
				System.out.println("Entry: "+i);

				System.out.println("Enter First Name:");
				String str;
				str=input.nextLine();
				str=input.nextLine();
				update_fn(str);

				System.out.println("Enter Second Name:");
				str=input.nextLine();
				update_sn(str);

				System.out.println("Enter Registration Number:");
				str=input.nextLine();
				update_rn(str);

				File log = new File("StudentInfo.txt");
				try{
					if(log.exists()==false){
						System.out.println("I had to make a new file.");
						log.createNewFile();
					}
					PrintWriter out = new PrintWriter(new FileWriter(log, true));
					out.append(i+". First Name: "+first_name+"\nSecond Name: "+second_name+"\nRegistration Number: "+registration_number+"\n");
					out.append("\n");
					i++;
					out.close();
					
					System.out.println("\nSuccessfully Saved.\n");
				}
				catch(IOException e){
					System.out.println(e);
				}

				break;

			case 2:

				try {
					File myObj = new File("StudentInfo.txt");
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
