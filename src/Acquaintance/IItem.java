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
    
    /**
     * 
     * @return the name of the item as a string
     */
    String getName();
    
    /**
     * 
     * @return true if the item is carryable and flse if it is not
     */
    boolean getCarryable();
    int getVolume();
    void setText(String description);
    String getText();
    String getID();
    /**
     * is the use of the item, different for each subclass of Item.java
     */
    void use(IPlayer player);
    
}
