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
    private int questionsAskedAnswersChecked = 0; //determines where in the List's the questions should come from
    //and synchonizes the answers in the "checkAnswer()" method
    
    @Override
    public void fillArraysWithQuestionsAndAnswers() throws FileNotFoundException {
        File questionsAndAnswersFile = new File("questionsAndAnswersByHallucination.txt"); //creates a new file, from the exsisting txt file
        Scanner inputFromFile = new Scanner(questionsAndAnswersFile);
        
        while(inputFromFile.hasNextLine()){ //Runs while the file has a next line filled with text
            String dialogue = inputFromFile.nextLine(); 
            String question = inputFromFile.nextLine(); 
            String optionA = inputFromFile.nextLine(); 
            String optionB = inputFromFile.nextLine(); 
            String optionC = inputFromFile.nextLine(); 
            String answer = inputFromFile.nextLine(); 
            this.questions.add(dialogue + "\n" + question + 
                    "\n" + optionA + "\n" + optionB + "\n" +
                    optionC); //Adds the lines together from the five lines, and adds it to the questions ArrayList()
            this.answers.add(answer); //Add the answer String to the answers ArrayList()
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
        int low = numberOfQuestionsAsked;
        int high = this.questions.size();
        int randomValue = r.nextInt(high - low) + low;
        this.questionsAskedAnswersChecked = randomValue - numberOfQuestionsAsked;
    }
    
}
