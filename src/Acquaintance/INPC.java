/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.io.FileNotFoundException;

/**
 *
 * @author Oskar
 */
public interface INPC {
    
    /**
     * Fills arrays with questions and answers read from a .txt file
     * This file can be changed as needed as long as it continuesly follows this
     * structure: line: 1: Dialogue, 2: question, 3,4,5: answer options, 6: the actual answer
     * @throws FileNotFoundException because it fills two arrays containing 
     * the NPC's questions and answers from a .txt file, therefor, it must be
     * implemented in a try-catch block, that catches a FileNotFoundException
     */
    void fillArraysWithQuestionsAndAnswers() throws FileNotFoundException;
    
    /**
     * returns questions in the order it is written in the .txt file saved in the build of the game
     * @return a String containing the next question
     */
    String generateQuestion();
    
    /**
     * checks the answer from the player, case insensitive
     * @param playerAnswer: is the answer from the player
     * @return true if the answer is correct, false if not correct
     */
    boolean checkAnswer(String playerAnswer);
    
}
