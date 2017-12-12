package UserInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Casper
 * 
 * This is a class which contains all the rooms
 */
public class RoomController {
    
    
    List<Room> roomList;
    
    /**
     * Constructer of RoomController
     */
    public RoomController() {
        roomList = new ArrayList<>();
        
    }
    
    /**
     * Add a room to the list 
     * @param room the Room object you want to add
     */
    public void addRoom( Room room) {
        roomList.add(room);
        
    }
    
    /**
     * 
     * @param roomName - Inset a string of the room you want to get
     * @return return the room that match the param string
     */
    public Room getRoom(String roomName) {
        for (Room room : this.roomList) {
            if (roomName.equals(room.getName()))
                return room;
        }
        return null;
    }
    
}