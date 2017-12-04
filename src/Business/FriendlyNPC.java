/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IFriendlyNPC;
import Acquaintance.IItem;
import Acquaintance.IPlayer;
import java.util.ArrayList;


/**
 *
 * @author Oskar
 */
public class FriendlyNPC implements IFriendlyNPC {

    IItem itemToBeFound;
    
    String questString = "Hey you! \n You look lost.. Can't get out eh? \n"
            + "Tell you what, i will lend you my key to the exit, if you fetch something for me "
            + "\nI need " + this.itemToBeFound.getName() + ", for my studies. \nIt's somewhere around here"
            + ", but you may have to get into creative with finding it!";
    String completedQuestString = "Thank you so much!\nI needed that!\nHere is the key, you earned it!";
    
    @Override
    public String getQuestString() {
        return this.questString;
    }

    @Override
    public String getCompletedQuestString() {
        return this.completedQuestString;
    }

    @Override
    public boolean checkIfPlayerHasItem(IPlayer player) {
        for(IItem item : player.getPlayerInventory()){
            if(item.getName().equals(this.itemToBeFound.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setItemToBeFound(IItem itemToBeFound) {
        this.itemToBeFound = itemToBeFound;
    }
    
    
    
}
