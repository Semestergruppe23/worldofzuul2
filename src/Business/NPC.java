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
        Scanner inputFromFile = new Scanner(questionsAndAnswersFile); //Creates the scanner, using the file
        
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

    //Returns the questions
    @Override
    public String generateQuestion() {
        for(int i = this.questionsAskedAnswersChecked; i < this.questions.size();){ //Runs while the array still has more indexes
            return this.questions.get(i);
        }
        return "Ran out of questions"; //Returns this if the last index of the arrayList has been returned
    }

    @Override
    public boolean checkAnswer(String playerAnswer) {
        if(playerAnswer.equalsIgnoreCase(this.answers.get(questionsAskedAnswersChecked))){ //Checks if the answer matches the answer in the ArrayList, case insensitive
            this.questionsAskedAnswersChecked++; //increases the number of the next index to be checked, and the next question to be asked
            return true;
        } else{
            this.questionsAskedAnswersChecked++;
            return false; 
        }
    }
    
    //Randomizes the starting point of the ArrayList containing the questions and answers
    @Override
    public void randomizeQuestions(int numberOfQuestionsAsked){
        Random r = new Random(); //Instance of the Random framework
        int low = numberOfQuestionsAsked; //The lowest randomValue
        int high = this.questions.size(); //The highest random value, should never be higher than the ArrayList's size, as it would throw an exception
        int randomValue = r.nextInt(high - low) + low; //Creates the random value between numberOfQuestionsAsked, and the ARrayList's size
        this.questionsAskedAnswersChecked = randomValue - numberOfQuestionsAsked; //Changes the questionsAskedAndAswersChecked, so it is between 0, and ArrayList.size - 1
    }
    
}
