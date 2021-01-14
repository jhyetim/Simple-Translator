package edu.wmich.cs1120.LA5;

import java.io.FileNotFoundException;

public class LA5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface uI = new UserInterface();
		try {
			uI.runProgram();
		} catch (FileNotFoundException e) {
			System.out.println("FIle not found!");
		}
	}

}
