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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class Player implements IPlayer {
    
    String name;
    List<IItem> inventory;
    private String currentRoom;
    private long startTimeInSeconds; //The time when the game starts, is initialized in the Player constructor
    private long totalGameTime = 600; //The game time, in seconds
    private int playerPoints = 0; //The player points
    private int totalPoints = 0; 
    private int maxCapacity = 10;
    private int volumeUsedInInventory = 0;
    private boolean flashlightUsed = false;
    
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
    public long getRemainingTime(){
        long timeWhenChecked = System.currentTimeMillis() / 1000;
        long remainingTime = this.totalGameTime - (timeWhenChecked - this.startTimeInSeconds);
        return remainingTime; 
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
        this.totalPoints = (int)pointsFromTime + this.playerPoints;
        return this.totalPoints;
    }

    @Override
    public String getCurrentRoom() {
       return this.currentRoom;
    }
    
    @Override
    public boolean checkIfPlayerHasRoom(IItem item){
        if(this.maxCapacity < this.volumeUsedInInventory + item.getVolume()){
            return false;
        }
        return true;
    }
    

    
    /**
     * 
     * @param name
     * @param carryable 
     */
    @Override
    public void addItemToInventory(IItem item) {
        if(item.getCarryable() == true){
            if(checkIfPlayerHasRoom(item)){
            this.inventory.add(item);
            this.volumeUsedInInventory += item.getVolume();
            }
        }
    }


    
    @Override
    public void removeItemFromInventory(IItem item) {
        // Creating iterator for inventory
        Iterator<IItem> iterator = this.inventory.iterator();
        
        // going through all items in inventory
        while (iterator.hasNext()) {
            // creating buffer IItem to compare item with
            IItem buf = iterator.next();
            
            if (buf.equals(item)) {
                //removing item
                iterator.remove();
                this.volumeUsedInInventory -= item.getVolume();
            }
        }

    }
    
    

    @Override
    public List<IItem> getPlayerInventory() {
        return this.inventory;
    }
    @Override
    public void setCurrentRoom(String room){
        this.currentRoom = room;
    }
    @Override
    public boolean checkIfPlayerHasItem(String name){
        for (IItem itemChecked : this.inventory){
            if(itemChecked.getName().equals(name)){
                return true;
            }
         }
        return false;
    }   
    
    @Override
    public void increaseInventory(int increaseAmount) {
        this.maxCapacity += increaseAmount;
    }
    
    @Override
    public boolean getFlashlightUsed(){
        return this.flashlightUsed;
    }
    
    @Override
    public void setFlashlightUsed(boolean used){
        this.flashlightUsed = used;
    }
    
    @Override
    public int getMaxCapacity(){
        return this.maxCapacity;
    }
    
    @Override
    public int getCurrentVolumeUsed(){
        return this.volumeUsedInInventory;
    }
    
    
    //Methods only used for loading saved game
    
    @Override
    public void setTimefromLoadedGame(int time){
        this.totalGameTime = time;
    }
    
}
