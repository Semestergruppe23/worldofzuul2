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
        File introFile = new File("instructions.txt");
        Scanner inputFromFile = new Scanner(introFile);
        while(inputFromFile.hasNext()){
            String sentence = inputFromFile.nextLine() + "\n";
            this.intro += sentence;
        }
    }

    @Override
    public void fillStringWithLore() throws IOException {
        File introFile = new File("lore.txt");
        Scanner inputFromFile = new Scanner(introFile);
        while(inputFromFile.hasNext()){
            String sentence = inputFromFile.nextLine();
            this.lore += sentence + "\n";
        }

    }

    @Override
    public String generateIntro() {
        return this.intro;
    }

    @Override
    public String generateLore() {
        return this.lore;
    }
    
}
