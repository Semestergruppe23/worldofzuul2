package Acquaintance;

import java.util.List;

/**
 *
 * @author All
 */
public interface IRoom {
    
    /**
     * 
     * @return Return the room name
     */
    String getRoomName();
    /**
     * 
     * @return true if the room is locked
     */
    boolean getLocked();
    
    /**
     * 
     * @param locked true to set the room locked
     */
    void setLocked(boolean locked);
    
    /**
     * 
     * @return the items in the room
     */
    List<IItem> getItemsInRoom();
    
    /**
     * 
     * @param item to be placed in the room
     */
    void putItemsInsideRoom(IItem item);
    
    /**
     * 
     * @param item to remove from room
     */
    void removeItemFromRoom(IItem item);
    
    /**
     * 
     * @return the id of the room
     */
    int getRoomID();
    
    
}
