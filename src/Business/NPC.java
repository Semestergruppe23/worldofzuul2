/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.INPC;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class NPC implements INPC {

    List<String> questions = new ArrayList<>();
    List<String> answers = new ArrayList<>();
    int questionsAskedAnswersChecked = 0;
    
    @Override
    public void fillArraysWithQuestionsAndAnswers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkAnswer(String playerAnswer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
