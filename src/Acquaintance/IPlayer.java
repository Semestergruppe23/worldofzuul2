/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.List;

/**
 *
 * @author Oskar
 */
public interface IPlayer {
    
    void rewardPoints(int points);
    void addTime(long time);
    void removeTime(long time);
    
    
    /**
     * @return the name of the player
     */
    String getName();
    int getScore();
    
    void addItemToInventory(IItem item);
    void removeItemFromInventory(String name);
    
    String getCurrentRoom();
    
    List<IItem> getPlayerInventory();
    
    
    
}
