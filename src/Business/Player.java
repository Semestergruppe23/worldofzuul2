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
    private long startTimeInSeconds;
    private long totalGameTime = 600;
    private int playerPoints = 0;
    
    public Player(String name){
        this.name = name;
        inventory = new ArrayList();
        this.startTimeInSeconds = System.currentTimeMillis() / 1000;
    }

    @Override
    public void rewardPoints(int points) {
        this.playerPoints += points;
    }

    @Override
    public void addTime(long time) {
        this.totalGameTime += time;
    }

    @Override
    public void removeTime(long time) {
        this.totalGameTime -= time;
    }
    
    @Override
    public boolean checkTime(){
        if((System.currentTimeMillis()/ 1000) - this.startTimeInSeconds > this.totalGameTime){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 
     * @return the name of the player
     * et eller andet
     */
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getScore() {
        return this.playerPoints;
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
