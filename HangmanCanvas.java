/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Font;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
private static final int MID_HEIGHT = 200;
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		drawScaffold();
	}

// draw the scaffold.
private void drawScaffold() {
	GLine scaffold = new GLine(44.5,MID_HEIGHT+SCAFFOLD_HEIGHT/2,44.5,MID_HEIGHT-SCAFFOLD_HEIGHT/2);
	GLine beam = new GLine(44.5,MID_HEIGHT-SCAFFOLD_HEIGHT/2,44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2);
	GLine rope = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2,44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH);
	add(scaffold);
	add(beam);
	add(rope);
	
}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
    GLabel guessedWord = new GLabel("",50,420);
	public void displayWord(String word) {
		guessedWord.setLabel(word);
		guessedWord.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		add(guessedWord);
	}
	
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	String wrongGuess = "";
	GLabel wrongLetters = new GLabel(wrongGuess,50,450);
	public void noteIncorrectGuess(char letter) {
		
		wrongGuess = wrongGuess + letter;
		wrongLetters.setLabel(wrongGuess);
		add(wrongLetters);
		
		switch(counter){
		case 8:{
			drawHead();
			counter--;
			break;
		}
		case 7:{
			drawBody();
			counter--;
			break;
		}
		case 6:{
			drawRightArm();
			counter--;
			break;
		}
		case 5:{
			drawLeftArm();
			counter--;
			break;
		}
		case 4:{
			drawRightLeg();
			counter--;
			break;
		}
		case 3:{
			drawLeftLeg();
			counter--;
			break;
		}
		case 2:{
			drawRightFoot();
			counter--;
			break;
		}
		case 1:{
			drawLeftFoot();
			counter--;
			break;
		}
		}
	}
	
	//draw the left foot of the hangman.
private void drawLeftFoot() {
	GLine leftFoot = new GLine(44.5+BEAM_LENGTH+HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,44.5+BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
	add(leftFoot);
	
}

//draw the right foot of the hangman.
private void drawRightFoot() {
	GLine rightFoot = new GLine(44.5+BEAM_LENGTH-HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,44.5+BEAM_LENGTH-HIP_WIDTH-FOOT_LENGTH ,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
	add(rightFoot);
}

//draw the left leg of the hangman.
private void drawLeftLeg() {
	GLine leftRip = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,44.5+BEAM_LENGTH+HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
	GLine leftLeg = new GLine(44.5+BEAM_LENGTH+HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,44.5+BEAM_LENGTH+HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
    add(leftRip);
    add(leftLeg);
	
}

//draw the right leg of the hangman.
private void drawRightLeg() {
	GLine rightRip = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,44.5+BEAM_LENGTH-HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
	GLine rightLeg = new GLine(44.5+BEAM_LENGTH-HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,44.5+BEAM_LENGTH-HIP_WIDTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
    add(rightRip);
    add(rightLeg);
}

//draw the left arm of the hangman.
private void drawLeftArm() {
	GLine leftUpperArm = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD,44.5+BEAM_LENGTH+UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD);
	GLine leftLowerArm = new GLine(44.5+BEAM_LENGTH+UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD,44.5+BEAM_LENGTH+UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	add(leftUpperArm);
	add(leftLowerArm);
	
}

//draw the right arm of the hangman.
private void drawRightArm() {
	GLine rightUpperArm = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD,44.5+BEAM_LENGTH-UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD);
	GLine rightLowerArm = new GLine(44.5+BEAM_LENGTH-UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD,44.5+BEAM_LENGTH-UPPER_ARM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+2*ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	add(rightUpperArm);
	add(rightLowerArm);
}

//draw the body of the hangman.
private void drawBody() {
	GLine body = new GLine(44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS,44.5+BEAM_LENGTH,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
	add(body);
}

//draw the head of the hangman.
private void drawHead() {
	GOval head = new GOval(44.5+BEAM_LENGTH-HEAD_RADIUS,MID_HEIGHT-SCAFFOLD_HEIGHT/2+ROPE_LENGTH,HEAD_RADIUS*2,HEAD_RADIUS*2);
	add(head); 
}
private int counter = 8;
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
