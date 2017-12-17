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
public class WearableItem extends Item {
    
    int volumeIncrease;
    
    public WearableItem(String name, String id, int volume, boolean carryable, int volumeIncrease){
        super(name, id, volume, carryable); 
        this.volumeIncrease = volumeIncrease;
    }
    
    @Override
    public void use(IPlayer player){
        player.removeItemFromInventory(this);
        player.increaseInventory(this.volumeIncrease);
    }
    
}
