/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public interface IData {
    
    public List<String> getHighscore();
    public void addHighscore(String name, int score);
    
}
