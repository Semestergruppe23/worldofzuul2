package Acquaintance;

import java.util.List;

/**
 *
 * @author All
 */
public interface IBusiness {
    

    /**
     * 
     * @param data object you want to inject
     */
    void injectData(IData data);
    
    
    /**
     * 
     * @param name to identify the item
     * @param id the weight of the item
     * @param volume weight of the item
     * @param carryable whether he can carry the item
     */
    void createItem(String name,String id, int volume, boolean carryable);
    /**
     * 
     * @param name The name of the item
     * @param id the id of the item
     * @param volume - the weight of the item
     * @param carryable if the item is carryable
     * @param amountOfTime  - Amount of time the item is decreased
     */
    void createNegativeDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime);
    /**
     * 
     * @param name The name of the item
     * @param id the id of the item
     * @param volume - the weight of the item
     * @param carryable if the item is carryable
     * @param amountOfTime  - Amount of time the item is increased
     */
    void createPositiveDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime);
    /**
     * 
     * @param name The name of the item
     * @param id the id of the item
     * @param volume - the weight of the item
     * @param carryable if the item is carryable
     * @param volumeIncrease amoun to increase inventory
     */
    void createWearableItem(String name, String id, int volume, boolean carryable, int volumeIncrease);
    
    /**
     * 
     * @param name The name of the item
     * @param id the id of the item
     * @param volume - the weight of the item
     * @param carryable if the item is carryable
     */
    void createFlashlightItem(String name, String id, int volume, boolean carryable);
    

    
    /**
     * 
     * @param name of the player yoy want to create
     */
    void createPlayer(String name);
    
    /**
     * 
     * @return the the IPlayer object
     */
    IPlayer getPlayer();
    /**
     * 
     * @param name of the item you want to get
     * @return the item as an IItem object
     */
    IItem getItem(String name); 
    
    /**
     * 
     * @param indexId the room indexId
     * @param roomName of the room
     * @param locked if the room should be locked or not
     */
    void createRoom(int indexId, String roomName, Boolean locked);
    
    /**
     * 
     * @param roomId of the room you want to get
     * @return the room as an IRoom object
     */
    IRoom getRoom(int roomId);
    
    /**
     * 
     * @return IData
     */
    IData getData();
    
    /**
     * 
     * @return the INPC object
     */
    INPC getNPC();
    
    /**
     * create an NPC
     */
    void createNPC();
    
    /**
     * 
     * @return the item list
     */
    List<IItem> getItemList();
    
    
    /**
     * create a friendly NPC
     */
    void createFriendlyNPC();
    
    /**
     * 
     * @return the friendly NPC object
     */
    IFriendlyNPC getFriendlyNPC();
    
    /**
     * Creating intro object
     */
    void createIntro();
    
    /**
     * 
     * @return Intro object
     */
    IIntro getIntro();
    
    /**
     * 
     * @param loadedPlayer that should be set
     */
    void setPlayerFromLoadedGame(IPlayer loadedPlayer); 

}
