package co.grandcircus.Lab8;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab8 {

	public static void main(String[] args) {
		
		//Creates scanner
		Scanner scnr = new Scanner(System.in);
		
		//Creates 2D array of all the students
		String[] [] allStudents = { 
				{"Full name", "Fun fact", "Hometown", "Coded with them yet?"},
				{"Sharde' Smith", "drives a cool green car!", "is from Detroit, MI", "and I have coded together!"}, 
				{"Jasmine Allen", "speaks Japanese!", "is from Detroit, MI", "and I have coded together!"},
				{"Shontinique Uqdah", "surfed on sand in Huacachina, Peru!", "is from Detroit, MI", "is me! I can't pair with myself."},
				{"Cameron Barnes", "is a musician. He plays the viola!", "is from Detroit, MI", "and I have not coded together!"}, 
				{"Kris Runde", "moves alot and does not like the heat!", "is from ???. But she has lived in Italy.", "and I have coded together!"},
				{"Louis Privette", "is a care-taker!", "is from ???", "and I have not coded together!"},
				{"Andrew Foley", "programmed in Python before the bootcamp!", "is from Ann Arbor, MI", "and I have coded together!"},
				{"Anesha Jenkins", "makes a vegan potato salad that you wouldn't guess was vegan!", "is from Detrit, MI", "and I have coded together!"} 
		};
		
		//Declares variables
		String[] currentStudent;
		boolean startOver = true;
		
		//Welcomes user to the program
		System.out.println("Welcome to the Facebook Java class!");
		System.out.println("Let's get to know some of our students!\n");
		
		//Ensures loop repeats as long as user wants to learn about different students
		while (startOver == true) {	
			
			//declared and initialized variables here so they would be reset at the start of the next cycle of the outermost loop
			int student = -1;
			boolean proceed = true;
			int userChoice = -1;
			
			//Continues looping until a valid student input is entered
			while(student <= 0 || student > 8) {
				
				//Prints numbered list of all students in the array
				for (int i = 1; i < allStudents.length; i++) {
					System.out.println(i + ". " + allStudents[i][0]);
				}
				
				System.out.println();
				
				//Catches exceptions that occur as a result of type mismatch when an int is requested from user
				try {
					System.out.println("Which student would you like to learn more about? (Enter a number 1-8):");
					student = scnr.nextInt();
				}
				catch (InputMismatchException ex) {
					}
				scnr.nextLine();
				
				//Prints error message if user enters invalid input
				if (student <= 0 || student > 8) {
					System.out.println("That student does not exist. Please try again.\n");
				}
			}
			
			//Initializes an array of all data for current student
			currentStudent = allStudents[student];
			
			//Prints student number and name
			System.out.print("Student " + student + " is " + currentStudent[0] + ". ");
			
			//Gets first name from student's name
			String[] bothNames = currentStudent[0].split(" ");
			String firstName = bothNames[0];
			
			//Ensures loop continues as long a user wants to learn about this particular student
			while (proceed == true) {
				//Prompts user for desired student facts
				System.out.println("What would you like to know about " + firstName + "?\n");
				
				//Continues looping until a valid value is entered, within the bounds of the student data array			
				do {
					
				//Prints data available about each student	
				for (String data : allStudents[0]) {
					System.out.println(data);
				}
				
				System.out.println();
				
				//Retrieves user selection for desired facts and calls factsCheck method and validates selection
				String facts = scnr.nextLine();
				userChoice = factsCheck(facts);
				
				//Catches exception that would occur if index is out of the range of the student array
				try {
					if (userChoice == 0) {
						System.out.println(currentStudent[userChoice]);
					}
					
					else {
						System.out.println(firstName + " " + currentStudent[userChoice]);
					}
				}
				catch (IndexOutOfBoundsException ex) {
					System.out.println("That data does not exist. Please try again.\n");
					};
			}
				while (userChoice >= currentStudent.length || userChoice == -1);
					
				
				//Prompts user to continue learning about this particular student
				System.out.println("Would you like to learn more about " + firstName + "? (y/n)");
				String learnMore = scnr.nextLine();
				
				//If they wish to continue, the student loop restarts
				if (learnMore.toLowerCase().startsWith("y")) {
					proceed = true;
				}
				
				//If they choose not to continue, they exit the student loop
				else {
					proceed = false;
					System.out.println("Wow! You've learned a lot about " + firstName + "!");
				}
			}	
			
			//Prompts user to continue learning about other students
			System.out.println("Would you like to continue learning about the other students of Java Facebook? (y/n)");
			String nextStudent = scnr.nextLine();
			
			//If user wishes to continue, entire program basically begins again
			if (nextStudent.toLowerCase().startsWith("y")) {
				startOver = true;
			}
			
			//If they choose to stop, program exits
			else {
				startOver = false;
				System.out.println("Thanks for learning about our Java Facebook students! Goodbye :)");
			}
	}
	
		//Closes scanner to avoid memory leaks
		scnr.close();

	}
	
	public static int factsCheck(String userInput) {
		
		//Creates regex patterns and matchers to match all possible inputs for student data
		Pattern check = Pattern.compile("[Ff]ull\\s[nN]ame");
		Matcher match = check.matcher(userInput);
		
		Pattern check1 = Pattern.compile("[Ff]un\\s[Ff]act");
		Matcher match1 = check1.matcher(userInput);
		
		Pattern check2 = Pattern.compile("[Hh]ome\\s{0,1}[Tt]own");
		Matcher match2 = check2.matcher(userInput);
		
		Pattern check3 = Pattern.compile("[Cc]oded*.*");
		Matcher match3 = check3.matcher(userInput);
		
		//If matches are found, the corresponding index of the array is returned
		if (match.find()) {
			return 0;
		}
		else if (match1.find()) {
			return 1;
		}
		else if (match2.find()) {
			return 2;
		}
		else if (match3.find()) {
			return 3;
		}
		
		//If no match is found, an out of bounds index is returned
		else {
			return 4;
		}
	}
	
		
		
	}


