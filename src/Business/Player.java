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
import Business.BusinessFacade;

/**
 *
 * @author Oskar
 */
public class Player implements IPlayer {
    
    String name;
    List<IItem> inventory;
    List<String>stringInventoryForLoading;
    private int currentRoomID;
    private long startTimeInSeconds; //The time when the game starts, is initialized in the Player constructor
    private long totalGameTime = 600; //The game time, in seconds
    private int playerPoints = 0; //The player points
    private long remainingTime = 0;
    private int totalPoints = 0; 
    private int maxCapacity = 10;
    private int volumeUsedInInventory = 0;
    private boolean flashlightUsed = false;
    
    public Player(String name){
        this.name = name;
        inventory = new ArrayList();
        stringInventoryForLoading = new ArrayList();
        this.startTimeInSeconds = System.currentTimeMillis() / 1000; //Initializes the time at the start of the game, divided by 1000 to get seconds
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
        long timeWhenChecked = System.currentTimeMillis() / 1000; //Gets the time of the time when used
        this.remainingTime = this.totalGameTime - (timeWhenChecked - this.startTimeInSeconds); //Obtains the remaining time, by detracting the difference from the total game time
        return this.remainingTime; //Return the remaining time, in seconds
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
        long pointsFromTime = this.totalGameTime - ((System.currentTimeMillis()/1000 - this.startTimeInSeconds)); //Gets points from the remaining time
        this.totalPoints = (int)pointsFromTime + this.playerPoints; //Get the total points(timePoints + given points)
        return this.totalPoints;
    }

    @Override
    public int getCurrentRoom() {
       return this.currentRoomID;
    }
    
    @Override
    public boolean checkIfPlayerHasRoom(IItem item){
        if(this.maxCapacity < this.volumeUsedInInventory + item.getVolume()){ //Checks if the players capacity is less, than the volume used + the volume of the item
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
    public void setCurrentRoom(int roomID){
        this.currentRoomID = roomID;
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
    @Override
    public void setPlayerFromLoadedGame(IPlayer loadedPlayer){
        this.currentRoomID = loadedPlayer.getCurrentRoom();
        this.flashlightUsed = loadedPlayer.getFlashlightUsed();
        this.totalGameTime = loadedPlayer.getRemainingTime();
        this.maxCapacity = loadedPlayer.getMaxCapacity();
        this.totalPoints = loadedPlayer.getScore();

    }
        
    @Override
   public List<String> getStringInventoryForLoading(){
        return this.stringInventoryForLoading;
    }
   
    @Override
    public void setMaxCapacityFromLoad(int load) {
        this.maxCapacity = load;
    }
    
    public void addInventory(String item) {
        this.stringInventoryForLoading.add(item);
    }

    @Override
    public void setInventoryUsed(int spaceUsed) {
        this.volumeUsedInInventory = spaceUsed;
    }
}
