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
    
    void fillArraysWithQuestionsAndAnswers() throws FileNotFoundException;
    String generateQuestion();
    boolean checkAnswer(String playerAnswer);
    
}
