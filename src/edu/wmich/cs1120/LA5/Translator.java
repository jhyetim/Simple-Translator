package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Translator implements ITranslator {

	private String fileName;
	String translated = "";
	private String sourceText;
	private String[][] wordArray;
	private String field[];

	public Translator(String fileName, String sourceText) {
		// set fileName and sourceText
		this.fileName = fileName;
		this.sourceText = sourceText;

	} // End of constructor Translator

	public void readCorpus() throws FileNotFoundException {
		try {
			// open file and declare scanner to read through the file
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			// initialize wordArray using the total number of word to word translation
			// available
			int totalWords = Integer.parseInt(scanner.nextLine());
			wordArray = new String[totalWords][2];
			String aLine;

			int i = 0;
			while (scanner.hasNext()) {
				int j = 0;
				aLine = scanner.nextLine();
				String[] field = new String[2];
				field = aLine.split(",");
				wordArray[i][j] = field[0];
				wordArray[i][j + 1] = field[1];
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	} // End of method readCorpus

	public String translate() {

		// if fileName is "EnglishToFrench.txt" call method englishToFrench()
		if (fileName == "EnglishToFrench.txt") {
			englishToFrench();
		}
		// if fileName is "FrenchToEnglish.txt" call method frenchToEnglish()
		if (fileName == "FrenchToEnglish.txt") {
			frenchToEnglish();
		}
		// return translated
		return translated;

	} // End of method translate

	public void englishToFrench() {
		// Split sourceText into fields
		field = sourceText.split(" ");

		for (int i = 0; i < field.length; i++) {
			// Use method lookup to translate words
			translated = translated + lookup(field[i].toLowerCase());

		}

	} // End of method englishToFrench

	public void frenchToEnglish() {
		// Split sourceText into fields
		field = sourceText.split(" ");

		for (int i = 0; i < field.length; i++) {
			// Use method lookup to translate words
			translated = translated + lookup(field[i].toLowerCase());
		}

	} // End of method frenchToEnglish

	private String lookup(String key) {

		// set boolean variable for wordFound
		boolean wordFound = false;

		// check if it is the last word from the sourceText and if it does not end with
		// a character
		if (key == field[field.length - 1]
				&& Character.isLetter(field[field.length - 1].charAt(field[field.length - 1].length() - 1)) == false) {
			for (int r = 0; r < wordArray.length; r++) {
				// If key is the same as the word in the file, then set key to it's translated
				// word with the punctuation mark
				if (key.contains(wordArray[r][0])) {
					key = wordArray[r][1] + key.charAt(key.length() - 1) + " ";
					wordFound = true;
				}
			}
		}
		// if key is not the last word in the source text, check if key has a
		// punctuation
		else {
			// if key has a punctuation, use substring to modify it
			if (Character.isLetter(key.charAt(key.length() - 1)) == false) {
				key = key.substring(0, key.length() - 1);
			}
			// compare key with the wordArray
			for (int r = 0; r < wordArray.length; r++) {
				// If key is the same as the word in the file, then set key to it's translated
				// word
				if (key.compareTo(wordArray[r][0]) == 0) {
					key = wordArray[r][1];
					wordFound = true;
				}
			}
		}
		// If word is not found in text file then print out the word that hasn't been
		// translated
		if (!wordFound) {
			key = key;
		}

		return key + " ";

	} // End of method lookup

} // End of class Translator