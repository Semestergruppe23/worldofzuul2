/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IFriendlyNPC;
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
    List<IItem> items = new ArrayList<>();
    private INPC npc; 
    private IFriendlyNPC friendlyNPC;
    
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
    public void createItem(String name,String id, int volume, boolean carryable) {
        this.items.add(new Item(name, id, volume, carryable));
    }
    
    @Override
    public void createNegativeDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime){
        this.items.add(new NegativeDrinkableItem(name, id, volume, carryable, amountOfTime)); 
    }
    
    @Override
    public void createPositiveDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime){
        this.items.add(new PositiveDrinkableItem(name, id, volume, carryable, amountOfTime));
    }
    
    @Override
    public void createWearableItem(String name, String id, int volume, boolean carryable, int volumeIncrease){
        this.items.add(new WearableItem(name, id, volume, carryable, volumeIncrease));
    }
    
    @Override
    public void createFlashlightItem(String name, String id, int volume, boolean carryable){
        this.items.add(new FlashlightItem(name, id, volume, carryable));
    }

    @Override
    public String pickUpItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void injectData(IData data) {
      this.data = data;
    }
    
   
    

    @Override
    public IItem getItem(String name) {
        for(IItem item : this.items){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
      
    }

  
    @Override 
    public void createRoom(int indexId, String roomName, Boolean locked ) {
        IRoom room = new Room(indexId, roomName, locked);
        rooms.add(room);
    }

    @Override
    public IRoom getRoom(int roomId) {
        return rooms.get(roomId);
    }

   
    

    @Override
    public IData getData() 
    {
        return this.data;
    }

    @Override
    public void createFriendlyNPC() {
        friendlyNPC = new FriendlyNPC();
    }

    @Override
    public IFriendlyNPC getFriendlyNPC() {
        return friendlyNPC;
    }


    public List<IItem> getItemList() {
        return this.items;
    }
    
}
