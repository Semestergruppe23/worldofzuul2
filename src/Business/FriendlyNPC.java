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

    String questString = "REPLACE WITH QUESTTEXT";
    String completedQuestString = "REPLACE WITH COMPLETED QUESTTEXT";
    
    @Override
    public String getQuestString() {
        return this.questString;
    }

    @Override
    public String getCompletedQuestString() {
        return this.completedQuestString;
    }

    @Override
    public boolean checkIfPlayerHasItem(IItem itemToBeFound, IPlayer player) {
        for(IItem item : player.getPlayerInventory()){
            if(item.getName().equals(itemToBeFound.getName())){
                return true;
            }
        }
        return false;
    }
    
    
    
}
