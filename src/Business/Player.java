/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;
import Acquaintance.IPlayer;
import Acquaintance.IRoom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class Player implements IPlayer {
    
    String name;
    List<IItem> inventory;
    private IRoom currentRoom;
    private long startTimeInSeconds; //The time when the game starts, is initialized in the Player constructor
    private long totalGameTime = 600; //The game time, in seconds
    private int playerPoints = 0; //The player points
    private int totalPoints = 0;
    
    public Player(String name){
        this.name = name;
        inventory = new ArrayList();
        this.startTimeInSeconds = System.currentTimeMillis() / 1000; //Initializes the time at the start of the game
    }

    @Override
    public void rewardPoints(int points) { //Rewards the player points, by adding to the playerPoints variable
        this.playerPoints += points;
    }

    @Override
    public void addTime(long time) { //Adds time to the total game time, in seconds
        this.totalGameTime += time;
    }

    @Override
    public void removeTime(long time) { //Subtracts time from the total game time, in seconds
        this.totalGameTime -= time;
    }
    
    @Override
    public boolean checkTime(){ //Checks whether the time of the current game is larger than the specified total game time
        if((System.currentTimeMillis()/ 1000) - this.startTimeInSeconds > this.totalGameTime){  // Checks if (current time - startime) is larger than the game time
            return false; //If the game is over
        }else{
            return true; // If there is still more time
        }
    }

    /**
     * 
     * @return the name of the player
     */
    @Override
    public String getName() {
        return this.name;
    }

    
    @Override
    public int getScore() { //Returns the players score
        long pointsFromTime = this.totalGameTime - ((System.currentTimeMillis()/1000 - this.startTimeInSeconds));
        int totalPoints = (int)pointsFromTime + this.playerPoints;
        return this.totalPoints;
    }

    @Override
    public String getCurrentRoom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    /**
     * 
     * @param name
     * @param carryable 
     */
    @Override
    public void addItemToInventory(IItem item) {
        if(item.getCarryable() == true){
            this.inventory.add(item);
        }
    }

    @Override
    public void removeItemFromInventory(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IItem> getPlayerInventory() {
        return this.inventory;
    }
    @Override
    public void setCurrentRoom(IRoom room){
        this.currentRoom = room;
    }

    
    
}
