/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IFriendlyNPC;
import Acquaintance.IIntro;
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
    private IIntro intro;
    
    
    /**
     * 
     * @param name of the player to be created
     */
    public void createPlayer(String name){
        this.player = new Player(name);
    }
    
    /**
     * 
     * @return The IIplayer 
     */
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
    
    /**
     * 
     * @param name of the item String
     * @param id of the item String
     * @param volume of the item int
     * @param carryable true if the item is carryable
     */
    @Override
    public void createItem(String name,String id, int volume, boolean carryable) {
        this.items.add(new Item(name, id, volume, carryable));
    }
    
    /**
     * 
     * @param name of the item String
     * @param id of the item String
     * @param volume of the item int
     * @param carryable true if the item is carryable
     * @param amountOfTime the item shoulde decrease the playing time i seconds
     */
    @Override
    public void createNegativeDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime){
        this.items.add(new NegativeDrinkableItem(name, id, volume, carryable, amountOfTime)); 
    }
    
    /**
     * 
     * @param name of the item String
     * @param id of the item String
     * @param volume of the item int
     * @param carryable true if the item is carryable
     * @param amountOfTime the item shoulde increase the playing time i seconds
     */
    @Override
    public void createPositiveDrinkableItem(String name, String id, int volume, boolean carryable, int amountOfTime){
        this.items.add(new PositiveDrinkableItem(name, id, volume, carryable, amountOfTime));
    }
    
    /**
     * 
     * @param name of the item String
     * @param id of the item String
     * @param volume of the item int
     * @param carryable true if the item is carryable
     * @param volumeIncrease the size the item should increase the players inventory list
     */
    @Override
    public void createWearableItem(String name, String id, int volume, boolean carryable, int volumeIncrease){
        this.items.add(new WearableItem(name, id, volume, carryable, volumeIncrease));
    }
    
    /**
     * 
     * @param name of the item String
     * @param id of the item String
     * @param volume of the item int
     * @param carryable true if the item is carryable
     */
    @Override
    public void createFlashlightItem(String name, String id, int volume, boolean carryable){
        this.items.add(new FlashlightItem(name, id, volume, carryable));
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public String pickUpItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void injectData(IData data) {
      this.data = data;
    }
    
   
    

    /**
     * 
     * @param name of the item to return
     * @return the founden item or null if nothing is found
     */
    @Override
    public IItem getItem(String name) {
        // for-each loop through all items
        for(IItem item : this.items){
            // Comparing item with name
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
      
    }

  /**
   * 
   * @param indexId of the room integer
   * @param roomName the name of the room String
   * @param locked true if the room is locked
   */
    @Override 
    public void createRoom(int indexId, String roomName, Boolean locked ) {
        IRoom room = new Room(indexId, roomName, locked);
        rooms.add(room);
    }

    /**
     * 
     * @param roomId the id as index
     * @return the founden room
     */
    @Override
    public IRoom getRoom(int roomId) {
        return rooms.get(roomId);
    }

   
    
    /**
    * 
    * @return the data object
    */
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


    /**
     * 
     * @return the list of all items
     */
    public List<IItem> getItemList() {
        return this.items;
    }

    @Override
    public void createIntro() {
        this.intro = new Intro();
    }

    @Override
    public IIntro getIntro() {
        return this.intro;
    }

    @Override
    public void setPlayerFromLoadedGame(IPlayer loadedPlayer) {
        this.player = loadedPlayer;
    }
}
