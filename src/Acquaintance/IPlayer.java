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
public interface IPlayer {
    
    void rewardPoints(int points);
    void addTime(long time);
    void removeTime(long time);
    String getName();
    int getScore();
    String getCurrentRoom();
    
    
}
