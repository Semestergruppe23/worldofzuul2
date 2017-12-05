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
public class Item implements IItem{
    private boolean carryable;
    private String name;
    private int volume;
    
    public Item(String name, int volume, boolean carryable){
        this.carryable = carryable;
        this.name = name;
        this.volume = volume;
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


    
    
    
    
}
