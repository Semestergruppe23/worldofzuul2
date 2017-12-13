/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.INPC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oskar
 */
public class NPC implements INPC {

    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private int questionsAskedAnswersChecked = 0;
    
    @Override
    public void fillArraysWithQuestionsAndAnswers() throws FileNotFoundException {
        File questionsAndAnswersFile = new File("questionsAndAnswersByHallucination.txt");
        Scanner inputFromFile = new Scanner(questionsAndAnswersFile);
        
        while(inputFromFile.hasNextLine()){
            String dialogue = inputFromFile.nextLine(); 
            String question = inputFromFile.nextLine(); 
            String optionA = inputFromFile.nextLine(); 
            String optionB = inputFromFile.nextLine(); 
            String optionC = inputFromFile.nextLine(); 
            String answer = inputFromFile.nextLine(); 
            this.questions.add(dialogue + "\n" + question + 
                    "\n" + optionA + "\n" + optionB + "\n" +
                    optionC);
            this.answers.add(answer);
        }
    }

    @Override
    public String generateQuestion() {
        for(int i = this.questionsAskedAnswersChecked; i < this.questions.size();){
            return this.questions.get(i);
        }
        return "Ran out of questions";
    }

    @Override
    public boolean checkAnswer(String playerAnswer) {
        if(playerAnswer.equalsIgnoreCase(this.answers.get(questionsAskedAnswersChecked))){
            this.questionsAskedAnswersChecked++;
            return true;
        } else{
            this.questionsAskedAnswersChecked++;
            return false; 
        }
    }
    
    @Override
    public void randomizeQuestions(int numberOfQuestionsAsked){
       Random r = new Random();
       int randomValue = r.nextInt(this.questions.size()) - numberOfQuestionsAsked;
       this.questionsAskedAnswersChecked += randomValue;

        // int startInArray  = (int)(Math.random() * ((this.questions.size()) + 1)) - numberOfQuestionsAsked;
       // this.questionsAskedAnswersChecked = startInArray - 1;
    }
    
}
