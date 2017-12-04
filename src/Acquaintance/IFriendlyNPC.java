/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Oskar
 */
public interface IFriendlyNPC {
    /**
     * Is used so that the item to be found can be determined in the GUI
     * MUST be called before calling any other methods in this class!
     * @param itemToBeFound is the item that the player must find to get the key
     */
    void setItemToBeFound(IItem itemToBeFound);
    
    /**
     * Explains the quest, reward, and gives a tip
     * @return the "Welcome" string from the friendly NPC
     */
    String getQuestString();
    
    /**
     * Explains that the quest is complete, and that the NPC can give the player the key
     * @return the string to be used after the quest is complete
     */
    String getCompletedQuestString();
    
    /**
     * Checks the players inventory for the param: IItem itemToBeFound
     * @param itemToBeFound, is the IItem that the NPC asks for
     * @param player, is used so that the players inventory can be checked
     * @return true if the player has the item in question, false if not
     */
    boolean checkIfPlayerHasItem(IPlayer player);
    
}
