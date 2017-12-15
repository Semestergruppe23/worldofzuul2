/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IIntro;
import java.io.IOException;

/**
 *
 * @author Oskar
 */
public class Intro implements IIntro {

    private String intro = "";
    private String lore = "";
    
    
    @Override
    public void fillStringWithIntro() throws IOException {
        
    }

    @Override
    public void fillStringWithLore() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateIntro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateLore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
