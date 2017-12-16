/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Oskar
 */
public interface IIntro {
    
    /**
     * Fills the String containing the intro text, used in the GUI
     * @throws IOException, because it reads in the text from a .txt file, placed with the build of the project
     */
    void fillStringWithIntro() throws IOException;
    
    /**
     * Fills the String containing the lore text, used in the GUI
     * @throws IOException, because it reads in the text from a .txt file, placed with build of the project
     */
    void fillStringWithLore() throws IOException;
    
    /**
     * 
     * @return the String containing the intro of the game
     */
    String generateIntro();
    
    /**
     * 
     * @return the String containing the lore text of the game
     */
    String generateLore();
}
