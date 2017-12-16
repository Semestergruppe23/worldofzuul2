/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IIntro;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Oskar
 */
public class Intro implements IIntro {

    private String intro = "";
    private String lore = "";
   
    
    @Override
    public void fillStringWithIntro() throws IOException {
        File introFile = new File("instructionsRevized.txt"); //takes in the file from the .txt file
        Scanner inputFromFile = new Scanner(introFile); //creates the scanner, using the file
        while(inputFromFile.hasNext()){ //iterates through the file until no more text is found
            String sentence = inputFromFile.nextLine() + "\n"; //adds each line to the string, seperated by a new sentence
            this.intro += sentence; 
        }
    }

    @Override
    public void fillStringWithLore() throws IOException {
        File introFile = new File("lore.txt"); //takes in the file from the .txt file
        Scanner inputFromFile = new Scanner(introFile);//creates the scanner, using the file
        while(inputFromFile.hasNext()){ //iterates through the file until no more text is found
            String sentence = inputFromFile.nextLine(); //adds each line to the string, seperated by a new sentence
            this.lore += sentence + "\n";
        }

    }

    //Return the String containing the intro, or manual
    @Override
    public String generateIntro() {
        return this.intro;
    }

    //Returns the string containing the lore of the game
    @Override
    public String generateLore() {
        return this.lore;
    }
    
}
