/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IItem;
import Acquaintance.IPlayer;
import java.io.Serializable;
/**
 *
 * @author Oskar
 */
public class Item implements IItem, Serializable{
    private boolean carryable;
    private String name;
    private int volume;
    private String description;
    private String id;
    
    public Item(String name, String id, int volume, boolean carryable){
        this.carryable = carryable;
        this.id = id;
        this.volume = volume;
        this.name = name;
    }
    
    @Override
    public void use(IPlayer player){
        
    }
    
    @Override
    public String toString(){
        return this.name + "; Weight: " + this.volume;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean getCarryable() {
        return this.carryable;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setText(String description) {
        this.description = description;
        
    }

    @Override
    public String getText() {
        return this.description;
    }
    
    @Override
    public String getID(){
        return this.id;
    }


    
    
    
    
}
