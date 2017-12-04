/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IItem;
import Acquaintance.INPC;
import Acquaintance.IPlayer;
import Acquaintance.IRoom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskar
 */
public class BusinessFacade implements IBusiness {

    private IData data;
    private IPlayer player;
    List<IRoom> rooms = new ArrayList<>();
    private INPC npc; 
    
    public void createPlayer(String name){
        player = new Player(name);
    }
    
    public IPlayer getPlayer(){
        
        return this.player;
    }
    
    @Override
    public void createNPC(){
        npc = new NPC();
    }
    
    @Override
    public INPC getNPC(){
        return npc; 
    }
    
    @Override
    public void createItem(String id, int volume) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pickUpItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void injectData(IData data) {
      this.data = data;
    }
    
    public String test(){
        return "Hello, world!";
    }

    @Override
    public IItem getItem(String name, String currentRoom) {
       return getRoom(1).getSpecificItem(name);
      
    }

  
    @Override 
    public void createRoom(int indexId, String roomName, Boolean locked ) {
        IRoom room = new Room(indexId, roomName, locked);
        rooms.add(room);
    }

    @Override
    public IRoom getRoom(int roomId) {
        player.setCurrentRoom(rooms.get(roomId));
        return rooms.get(roomId);
    }

    @Override
    public void createItems() {
        IItem flashlight, keyToExit, keyToJanitorRoom, plant;
        
        flashlight = new Item("Flashlight", 10, true);
        keyToExit = new Item("Key To Exit", 3, true);
        plant = new Item("Plant", 0, false);
        
        /*
        this.getRoom("Black hallway").putItemsInsideRoom(plant);
        this.getRoom("Black hallway").putItemsInsideRoom(flashlight);
        this.getRoom("Black hallway").putItemsInsideRoom(keyToExit);
        */
    }

    @Override
    public IData getData() 
    {
        return this.data;
    }
    
    
}
