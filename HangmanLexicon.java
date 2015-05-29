/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import acm.util.*;

public class HangmanLexicon {
	ArrayList<String> wordList = new ArrayList<String>();
	//This is the HangmanLexicon constructor.It will read all the words in the given file.
	public HangmanLexicon() {
		try{
		BufferedReader br = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		while(true){
		String line = br.readLine();
		if(line == null) break;
		wordList.add(line);
		}
		}catch(IOException e){
			throw new ErrorException("Can not read file.");
		}
		
		
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();    
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {	
	return wordList.get(index);
}
}
