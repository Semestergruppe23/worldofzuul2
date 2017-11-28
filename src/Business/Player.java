/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;
import Acquaintance.IPlayer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class Player implements IPlayer {
    
    String name;
    List<IItem> inventory;
    
    public Player(String name){
        this.name = name;
        inventory = new ArrayList();
    }

    @Override
    public void rewardPoints(int points) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTime(long time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTime(long time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
