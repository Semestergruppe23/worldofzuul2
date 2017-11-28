/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;
import Acquaintance.IRoom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class Room implements IRoom {
    
    private String roomName;
    private boolean locked = false;
    private List<IItem> roomItemList;
    
    public Room(String roomName, boolean locked){
        this.roomName = roomName;
        this.locked = locked;
        this.roomItemList = new ArrayList<>();
    }

    @Override
    public String getRoomName() {
        return this.roomName;
    }

    @Override
    public boolean getLocked() {
        return this.locked;
    }

    @Override
    public List<IItem> getItemsInRoom() {
        return this.roomItemList;
    }

    @Override
    public void putItemsInsideRoom(IItem item) {
        this.roomItemList.add(item);
    }

    @Override
    public void removeItemFromRoom(IItem item) {
        for(IItem items : this.roomItemList){
            if(items.getName().equals(item)){
                this.roomItemList.remove(items.getName());
            }
        }
    }

    @Override
    public IItem getSpecificItem(String name) {
        for(IItem items : this.roomItemList){
            if(items.getName().equals(name)){
                return items;
            }
        }
        return null;
    }
    
    
    
}
