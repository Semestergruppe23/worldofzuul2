/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;

/**
 *
 * @author Oskar
 */
public class BusinessFacade implements IBusiness {

    private IData data;
    
    
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
    
}
