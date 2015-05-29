/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.util.Random;

public class Hangman extends ConsoleProgram {
	int guessChances = 8;
	String randomWord = getRandomWord();
	String randomWordCopy = randomWord;
	String guessedLetters = "";
	int guessedLetterNo = 0;
	private HangmanCanvas canvas;

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		canvas.reset();
	}

	public void run() {
		setUp();
		System.out.println(randomWord);
		canvas.reset();
		while (guessChances > 0 && guessedLetterNo < randomWord.length()) {
			char guess = readLine("Your guess:").toUpperCase().charAt(0);
			upDateUI(guess);
		}
	}

	private void upDateUI(char letter) {
		
		//Check whether letter is in the given word.
		int index = randomWord.indexOf(letter);
		
		//If the char is in the word, add it to the guessed letters.
		if (index >= 0) {
			guessedLetters = guessedLetters.substring(0, index) + letter
					+ guessedLetters.substring(index + 1);

			randomWord = randomWord.substring(0, index) + "-"
					+ randomWord.substring(index + 1);

			canvas.displayWord(guessedLetters);

			guessedLetterNo++;
			println("That guess is correct.");
			
			/*
			 * If the user guessed all the letters in the word, then the user win.
			 * Or it will continue to guess.
			 */
			
			if (guessedLetterNo == randomWord.length()) {
				println("You guessed the word: " + guessedLetters);
				println("You win.");
//				String playAgain = readLine("Do you want play again? y/n: ");
//				if (playAgain.equalsIgnoreCase("y")) {
//					canvas.reset();
////					setUp();
//				}
			} else {
				println("The word now looks like this: " + guessedLetters);
				println("You have " + guessChances + " guesses left.");
			}

		} else {
			/*
			 * If the character is not in the word, draw the next part of scafford.
			 * And add the character to the wrong characters.
			 */
			
			canvas.noteIncorrectGuess(letter);
			guessChances--;
			println("There are no " + letter + "'s in the word.");

			//if the user has no guess chances left, he will lose.
			if (guessChances == 0) {
				println("You are completely hung.");
				println("The word is " + randomWordCopy);
				println("You lose.");
			} else {
				println("You have " + guessChances + " guesses left.");
			}
		}

	}
/*
 * set up the initial graphics and guessed letters.
 */
	private void setUp() {
		initGuessedLetters();
		canvas.reset();
		canvas.displayWord(guessedLetters);
		println("Welcome to Hangman!");
		println("The world now looks like this:" + guessedLetters);
	}

	//initial the guessed letters to dashes.
	private void initGuessedLetters() {
		for (int i = 0; i < randomWord.length(); i++) {
			guessedLetters = "-" + guessedLetters;
		}
	}

	//get a random word from the given file.
	private String getRandomWord() {
		HangmanLexicon lexicon = new HangmanLexicon();
		int wordCount = lexicon.getWordCount();
		Random rand = new Random();
		int wordIndex = rand.nextInt(wordCount) + 1;
		return (lexicon.getWord(wordIndex));

	}

}
