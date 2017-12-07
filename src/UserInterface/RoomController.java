package UserInterface;

import java.util.ArrayList;
import java.util.List;


public class RoomController {
    
    
    List<Room> roomList;
    
    public RoomController() {
        roomList = new ArrayList<>();
        
        
    }
    
    
    public Room addRoom( Room room) {
        roomList.add(room);
        return room;
    }
    
    
    public Room getRoom(String roomName) {
        for (Room room : this.roomList) {
            if (roomName.equals(room.getName()))
                return room;
        }
        return null;
    }
    
}