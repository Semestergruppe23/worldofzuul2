/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IFriendlyNPC;
import Acquaintance.IItem;
import Acquaintance.IPlayer;


/**
 *
 * @author Oskar
 */
public class FriendlyNPC implements IFriendlyNPC {

    private String itemToBeFound = "";
    
    @Override
    public String getQuestString() { //Returns the String the friendly NPC first states when giving the the quest
        return "Hey you! \nYou look lost.. Can't get out eh? \n"
            + "Tell you what, i will lend you my key to the exit, if you fetch something for me "
            + "\nI need my " + this.itemToBeFound + ", for my studies. \nIt's somewhere around here\n"
            + "You may have to get creative with finding it!";
    }
    
    @Override
    public  String getStillWaitingString(){ //returns the String that the friendly NPC states when waiting for his item
        return "Im still waiting for that " + this.itemToBeFound +
            "\nHurry up a bit will you?"; 
    }
    
    @Override
    public String getCompletedQuestString() { //returns the String the friendly NPC states when the player has completed the quest
        return "Thank you so much!\nI needed that!\nHere is the key, you earned it!";
    }

    @Override
    public boolean checkIfPlayerHasItem(IPlayer player) {
        for(IItem item : player.getPlayerInventory()){ //Iterates through the players inventory
            if(item.getName().equals(this.itemToBeFound)){ //checks if the player has the "itemToBeFound" in the inventory
                return true; //returns true if the player has the "itemToBeFound" in the inventory
            }
        }
        return false; //returns false if the player does not have the item
    }

    @Override
    public void setItemToBeFound(String itemName) { //sets the item the NPC checks if the player has, by the items name
        this.itemToBeFound = itemName;
    }
    
    
    
}
