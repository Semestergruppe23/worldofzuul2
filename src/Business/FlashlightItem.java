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
public class FlashlightItem extends Item {
    
    //The constructor to the item, takes the same parameters as it's super class
    public FlashlightItem(String name, String id, int volume, boolean carryable){
        super(name, id, volume, carryable);
    }
    
    //It's overridet use function, sets the boolean flashlightUsed to "true"
    @Override
    public void use(IPlayer player){
        player.setFlashlightUsed(true);
    }
    
}
