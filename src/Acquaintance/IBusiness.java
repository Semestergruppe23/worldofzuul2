/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Oskar
 */
public interface IBusiness {
    
    void injectData(IData data);
    void createItem(String id, int volume);
    String pickUpItem(String id);
    String test();
    
    
}
