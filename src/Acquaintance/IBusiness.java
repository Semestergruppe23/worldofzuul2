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
    void createItem(String id, int volume);
    String pickUpItem(String id);
    String test();
    void createPlayer(String name);
    IPlayer getPlayer();
    IItem getItem(String name, String currentRoom); 
    void createRoom(int indexId, String roomName, Boolean locked);
    IRoom getRoom(int roomId);
    IData getData();
    INPC getNPC();
    void createNPC();
    IFriendlyNPC getFriendlyNPC();
    void createFriendlyNPC();
    void createItems();

}
