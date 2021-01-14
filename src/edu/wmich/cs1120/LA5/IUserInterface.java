package edu.wmich.cs1120.LA5;

import java.io.FileNotFoundException;

public interface IUserInterface {

	/**
	 * * Calls the necessary methods to: display a greeting, ask the user what s/he
	 * wants to do; update the * corpus file name and the text to be translated
	 * based on the user's input, uses these to initialize * a Translator object,
	 * and loops until the user no longer wants to translate any sentences.
	 * 
	 * @throws FileNotFoundException Included in case input file is not found.
	 */
	void runProgram() throws FileNotFoundException;

	/**
	 * * Displays a greeting to the user and indicates briefly what the program
	 * does.
	 */
	void greeting();

	/**
	 * * Displays the translation options to the user and, after reading in the
	 * option selected by the user, sets * the name of the corpus file. Uses
	 * try-catch block(s) to enforce correct input.
	 */
	void getCorpusFileName();

	/**
	 * * Requests the text the user wants to translate (i.e. the source text).
	 */
	void getSourceText();

	/**
	 * * Uses the Translator object to translate the source text and displays the
	 * translated text to the user. *
	 * 
	 * @throws FileNotFoundException Included in case input file is not found.
	 */
	void translate() throws FileNotFoundException;

}
