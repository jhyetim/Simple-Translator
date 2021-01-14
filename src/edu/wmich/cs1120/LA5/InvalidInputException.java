package edu.wmich.cs1120.LA5;

public class InvalidInputException extends Exception{

	public InvalidInputException() {
		System.out.println("Invalid input! Input should be 1 or 2. Please try again:");
	}
}
