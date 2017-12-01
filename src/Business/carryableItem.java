/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;

/**
 *
 * @author Oskar
 */
public class carryableItem implements IItem{
    private String name;
    private int volume;
    private boolean canPickUp = true;
    private String itemText;
    
    public carryableItem(String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }
    public int getVolume() {
        return this.volume;
    }
    public boolean canPickUp() {
        return this.canPickUp;
    }
    public String getItemText(){
        return this.itemText;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setItemText(String itemText){
        this.itemText = itemText;
    }
    
    public String toString() {
        return this.name;
    }
}
