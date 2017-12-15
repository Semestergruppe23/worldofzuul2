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
    
    /**
     * Rewards the player with the specified amount of points
     * @param points, is the amount of points added to the variable "playerPoints"
     */
    void rewardPoints(int points);
    
    /**
     * Adds time (in seconds) to the variable totalGameTime
     * @param time, is the amount of time (in seconds) added to the game time
     */
    void addTime(long time);
    
    /**
     * Removes time (in seconds) from the variable totalGameTime
     * @param time, is the amount of time (in seconds) subtracted from the game time
     */
    void removeTime(long time);
    
    /**
     * Checks whether the current time of the game has exceded the game time
     * @return false if the current game time has not exceded the game time, 
     * true, if the current game time has exceded the game time
     */
    boolean checkTime();
    
    
    /**
     * @return the name of the player
     */
    String getName();
    
    /**
     * 
     * @return the remaining seconds of the game in seconds
     */
    long getRemainingTime();
    
    /**
     * The score is calculated using the time spent and points obtained in the game
     * @return the players score
     */
    int getScore();
    
    void addItemToInventory(IItem item);
    
    
    String getCurrentRoom();
    void setCurrentRoom(String room);
    
    List<IItem> getPlayerInventory();
    
    boolean checkIfPlayerHasRoom(IItem item);
    
    /**
     * 
     * @param item - Insert IItem which you want to remove from players inventory
     * 
     * Remove param's item from player inventory with an iterator
     */
    void removeItemFromInventory(IItem item);
    
    boolean checkIfPlayerHasItem(String name);
    
    
    void increaseInventory(int increaseAmount);
    
    boolean getFlashlightUsed();
    
    void setFlashlightUsed(boolean used);
    
    int getMaxCapacity();
    int getCurrentVolumeUsed();
    void setTimefromLoadedGame(int time);
}
