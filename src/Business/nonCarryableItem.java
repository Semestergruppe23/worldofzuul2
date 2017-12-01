/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Oskar
 */
public class nonCarryableItem implements IItem {
    private String name;
    private boolean canPickUp = false;
    private Map < IItem, Integer > objectContent = new HashMap<>();
    
    public nonCarryableItem(String name){
        this.name = name;
    }
    
    @Override
    public String getName() {
    return this.name;
    }
    @Override
    public boolean canPickUp() {
        return this.canPickUp;
    }
    public void setName(String name){
        this.name = name;
    }
    public void insertObject(IItem item, Integer volume){
        this.objectContent.put(item, volume);
    }
    
    public String toString() {
        return this.name;
    }
}
