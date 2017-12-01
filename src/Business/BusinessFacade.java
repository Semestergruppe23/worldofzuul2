/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IItem;
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
    
    public void createPlayer(String name){
        player = new Player(name);
    }
    
    public IPlayer getPlayer(){
        
        return this.player;
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
        return getRoom(currentRoom).getSpecificItem(name);
    }

    @Override
    public void createRooms() {
        IRoom startRoom, MathRoom, HistoryRoom, HallWay_red, HallWay_blue, JanitorRoom, HallWay_green, HallWay_black, toilet, exit; //Declares the rooms of the game

        startRoom = new Room("Start", false);
        MathRoom = new Room("Math Room", false);
        HistoryRoom = new Room("History Room", false);
        HallWay_red = new Room("Red hallway", false);
        HallWay_blue = new Room("Blue hallway", false);
        JanitorRoom = new Room("Janitor Room", true);
        HallWay_green = new Room("Green hallway", false);
        HallWay_black = new Room("Black hallway", false);
        toilet = new Room("Restroom", false);
        exit = new Room("Exit", true);
        
        rooms.add(exit);
        rooms.add(startRoom);
        rooms.add(MathRoom);
        rooms.add(HistoryRoom);
        rooms.add(HallWay_red);
        rooms.add(HallWay_blue);
        rooms.add(JanitorRoom);
        rooms.add(HallWay_green);
        rooms.add(HallWay_black);
        rooms.add(toilet);
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
        
        this.getRoom("Black hallway").putItemsInsideRoom(plant);
        this.getRoom("Black hallway").putItemsInsideRoom(flashlight);
        this.getRoom("Black hallway").putItemsInsideRoom(keyToExit);
    }
    
    
}
