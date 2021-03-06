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
public class NegativeDrinkableItem extends Item {
   
    int timeToBeRemoved = 0;
    
    
    //Has a extra parameter, so that the time that is removed from the player is decided when the object is initialized
    public NegativeDrinkableItem(String name, String id, int volume, boolean carryable, int timeToBeRemoved){
        super(name, id, volume, carryable);
        this.timeToBeRemoved = timeToBeRemoved;
    }
    
    
    @Override
    public void use(IPlayer player){
        player.removeItemFromInventory(this);
        player.removeTime(this.timeToBeRemoved);
    }
}
