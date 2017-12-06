/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Oskar
 */
public interface IItem {
    
    String getName();
    boolean getCarryable();
    int getVolume();
    void setText(String description);
    String getText();
    String getID();
    
}
