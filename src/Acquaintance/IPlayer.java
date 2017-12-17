package Acquaintance;

import java.util.List;

/**
 *
 * @author All
 */
public interface IPlayer {
    
    /**
     * Rewards the player with the specified amount of points
     * @param points, is the amount of points added to the variable "playerPoints"
     */
    void rewardPoints(int points);
    
    /**
     * Adds time (in seconds) to the variable totalGameTime
     * @param time, is the amount of time (in seconds) added to the game time
     */
    void addTime(long time);
    
    /**
     * Removes time (in seconds) from the variable totalGameTime
     * @param time, is the amount of time (in seconds) subtracted from the game time
     */
    void removeTime(long time);
    
    /**
     * Checks whether the current time of the game has exceded the game time
     * @return false if the current game time has not exceded the game time, 
     * true, if the current game time has exceded the game time
     */
    boolean checkTime();
    
    
    /**
     * @return the name of the player
     */
    String getName();
    
    /**
     * 
     * @return the remaining seconds of the game in seconds
     */
    long getRemainingTime();
    
    /**
     * The score is calculated using the time spent and points obtained in the game
     * @return the players score
     */
    int getScore();
    
    /**
     * 
     * @param item that you want to add to the inventory
     */
    void addItemToInventory(IItem item);
    
    /**
     * 
     * @return the id of the room the player is in
     */
    int getCurrentRoom();
    
    /**
     * 
     * @param roomID That you want the player to be placed in
     */
    void setCurrentRoom(int roomID);
    
    /**
     * 
     * @return the player's inventory
     */
    List<IItem> getPlayerInventory();
    
    /**
     * 
     * @param item that you want to check for space in the inventorylist
     * @return true if item can be placed in the inventorylist
     */
    boolean checkIfPlayerHasRoom(IItem item);
    
    /**
     * 
     * @param item - Insert IItem which you want to remove from players inventory
     * 
     * Remove param's item from player inventory with an iterator
     */
    void removeItemFromInventory(IItem item);
    
    /**
     * 
     * @param name of the IItem you want to chheck
     * @return true if the player has the item in invenotry
     */
    boolean checkIfPlayerHasItem(String name);
    
    /**
     * 
     * @param increaseAmount int that you want to increase the invenotry with
     */
    void increaseInventory(int increaseAmount);
    
    /**
     * 
     * @return true if the flashLight item is used
     */
    boolean getFlashlightUsed();
    
    /**
     * 
     * @param used true if the flashLight has been used
     */
    void setFlashlightUsed(boolean used);
    
    /**
     * 
     * @return the max capacity of the inventory in integer
     */
    int getMaxCapacity();
    
    /**
     * 
     * @return the current volume used in invenotory
     */
    int getCurrentVolumeUsed();
    
    /**
     * Setter method for setting time remaining from saved game
     * @param time 
     */
    void setTimefromLoadedGame(int time);  
    
    /**
     * Setter method for setting player in business-layer from a loaded IPlayer player object
     * @param loadedPlayer 
     */
    void setPlayerFromLoadedGame(IPlayer loadedPlayer);
    /**
    * Setter method for setting max inventory capacity from saved loaded file
    * @param load 
    */
    void setMaxCapacityFromLoad(int load);
    /**
     * Getter method for getting list of strings of items in saved inventory
     * @return 
     */
    List<String> getStringInventoryForLoading();
    /**
     * Setter method for adding names of items in list of names of items from saved game
     * @param item 
     */
    void addInventory(String item);
}
