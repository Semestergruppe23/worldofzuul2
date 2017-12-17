/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IPlayer;

/**
 *
 * @author Oskar
 */
public class PositiveDrinkableItem extends Item {
    
    int timeToBeAdded = 0;
    
    
    //Has a extra parameter, so that the time that is removed from the player is decided when the object is initialized
    public PositiveDrinkableItem(String name, String id, int volume, boolean carryable, int timeToBeAdded){
        super(name, id, volume, carryable);
        this.timeToBeAdded = timeToBeAdded;
    }
    
    
    @Override
    public void use(IPlayer player){
        player.removeItemFromInventory(this);
        player.addTime(this.timeToBeAdded);
    }
}
