/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.List;

/**
 *
 * @author Oskar
 */
public interface IBusiness {
    
    void injectData(IData data);
    /**
     * Creates a single item
     * @param name to identify the item
     * @param volume the weight of the item
     * @param carryable whether he can carry the item
     */
    void createItem(String name,String id, int volume, boolean carryable);
    void createNegativeDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime);
    void createPositiveDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime);
    void createWearableItem(String name, String id, int volume, boolean carryable, int volumeIncrease);
    void createFlashlightItem(String name, String id, int volume, boolean carryable);
    
    String pickUpItem(String id);
    void createPlayer(String name);
    IPlayer getPlayer();
    IItem getItem(String name); 
    void createRoom(int indexId, String roomName, Boolean locked);
    IRoom getRoom(int roomId);
    IData getData();
    INPC getNPC();
    void createNPC();
    List<IItem> getItemList();
    
    
    void createFriendlyNPC();
    IFriendlyNPC getFriendlyNPC();
    
     
    

}
