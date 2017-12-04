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
     * Sets the item that the player will need to have in the inventory to complete the quest
     * @param itemName is used to check if the player has the item in the inventory
     */
    void setItemToBeFound(String itemName);
    
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
     * Used if the player interacts with the quest giver, after already receiving the quest,
     * while still not having the item the NPC needs
     * @return the still waiting String
     */
    String getStillWaitingString();
    /**
     * Checks the players inventory for the param: IItem itemToBeFound
     * @param player, is used so that the players inventory can be checked
     * @return true if the player has the item in question, false if not
     */
    boolean checkIfPlayerHasItem(IPlayer player);
    
}
