package edu.wmich.cs1120.LA5;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface implements IUserInterface {

	private String sourceText;
	private String fileName;

	public void runProgram() throws FileNotFoundException {
		// declare a keyboard variable
		Scanner keyboard = new Scanner(System.in);

		String userInput = "Y";

		// continue looping until user inputs "n"
		while (userInput.compareToIgnoreCase("Y") == 0) {
			// call the necessary methods
			greeting();
			getCorpusFileName();
			getSourceText();
			translate();
			System.out.println("Another translation? (y/n)");
			// ask for user input
			userInput = keyboard.nextLine();

			// If user enters an "n", then stop loopin
			if (userInput.compareToIgnoreCase("N") == 0) {
				break;
			}
			
			// If user enters anything other than a "y" or "n", then display message and ask
			// user for input until user enters a "y" or "n"
			while (userInput.compareToIgnoreCase("Y") != 0) {
				System.out.println("Invalid input! Please enter 'y' or 'n':");
				userInput = keyboard.nextLine();
				// If user enters an "n", then stop looping
				if (userInput.compareToIgnoreCase("N") == 0) {
					break;
				}
			}

		}
		

	} // End of method runProgram

	public void greeting() {
		// Display greeting and options
		System.out.println("Welcome to the Translator! Bienvenue!!\n"
				+ "You can translate sentences from English to French and vice versa!\n"
				+ "So, what would you like to do? Please select from one of the following: \n"
				+ ">> From English to French: (input '1')\n>> From French to English: (input '2')");

	} // End of method greeting

	public void getCorpusFileName() {
		Scanner userInput = new Scanner(System.in);
		int option = 0;
		boolean quitFlag = false;

		// Use while loop to keep asking user for either a 1 or a 2
		while (!quitFlag) {
			// use a try catch block for the exceptions
			try {
				option = userInput.nextInt();
				userInput.nextLine();
				// Use switch statement for different options
				switch (option) {
				// If user enters 1, then set fileName to EnglishToFrench.txt
				case 1:
					fileName = "EnglishToFrench" + ".txt";
					quitFlag = true;
					break;
				// If user enters 2, then set fileName to FrenchToEnglish.txt
				case 2:
					fileName = "FrenchToEnglish" + ".txt";
					quitFlag = true;
					break;
				// If user does not enter a 1 or 2, then ask the user again
				default:
					if (option < 1 || option > 2) {
						// throw InvalidInputException
						throw new InvalidInputException();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Input must be an integer! Try again: ");
				quitFlag = false;
				userInput.nextLine();
			} catch (InvalidInputException e) {
				quitFlag = false;
			}
		}

	} // End of method getCorpusFileName

	public void getSourceText() {
		boolean quitFlag = false;
		// ask for user input for the sentence they want to translate
		while (!quitFlag) {
			try {
				System.out.println("Input the sentence for translation");
				Scanner keyboard = new Scanner(System.in);
				sourceText = keyboard.nextLine();
				// check if sourceText is empty
				if (sourceText.equals("")) {
					throw new EmptyStringException();
				} else {
					quitFlag = true;
				}

			} catch (EmptyStringException e) {
			}
		}

	} // End of method getSourceText

	public void translate() throws FileNotFoundException {
		try {
			// initialize a translator object
			Translator trans = new Translator(fileName, sourceText);
			// call readCorpus method
			trans.readCorpus();
			// print the translated sentence
			String translated = trans.translate();
			System.out.println("Your sentence translated is:");
			// print translated string if the first letter is in upper case
			if (Character.isUpperCase(sourceText.charAt(0))) {
				System.out.println(
						" >> " + translated.substring(0, 1).toUpperCase() + translated.substring(1).toLowerCase());
			}
			// print translated string if the first letter in the text is not in upper case
			else {
				System.out.println(" >> " + translated);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	} // End of method translate

} // End of class UserInterface
