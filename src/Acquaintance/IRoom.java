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
public interface IRoom {
    
    String getRoomName();
    boolean getLocked();
    List<IItem> getItemsInRoom();
    void putItemsInsideRoom(IItem item);
    void removeItemFromRoom(IItem item);
    IItem getSpecificItem(String name);
    
}
