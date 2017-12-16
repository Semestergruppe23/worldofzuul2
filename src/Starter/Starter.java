/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IUserInterface;
import Business.BusinessFacade;
import Data.Data;
import UserInterface.UserInterfaceFacade;

/**
 *
 * @author Oskar
 */
public class Starter {
    
    public static void main(String[] args) {
        IBusiness business = new BusinessFacade();
        IUserInterface userInterface = new UserInterfaceFacade();
        userInterface.injectBusiness(business);
        IData data = new Data();
        business.injectData(data);
        userInterface.startGame();
    }
    
}
