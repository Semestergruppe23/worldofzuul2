/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Hansi
 */
public class Room {
    
    private Scene scene;
    
    
    private Parent parent;
    
    FXMLLoader loader;
    
    String name;
    
    
    public Room(String name) {
        this.name = name;
    }
    
    
    
    public Scene getScene() {
        return this.scene;
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public Parent getParent() {
        return this.parent;
    }
    
    public void setParent(Parent parent) {
    this.parent = parent;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        
    }
    
    public void buildroom(String fxmlFilename) throws IOException
{
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(fxmlFilename));  
    this.parent = loader.load();
    this.scene = new Scene(this.parent);
}
    
    


    
    
}