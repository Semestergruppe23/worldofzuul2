package UserInterface;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Room {
    
    
    private Scene scene;
    
    private Parent parent;
    
    FXMLLoader loader;
    private int roomID;
    String name;
    
    
    /**
     * Constructor
     * @param name - the name of the room
     */
    public Room(int id, String name) {
        this.name = name;
        this.roomID = id;
    }
    
    /**
     * 
     * @return Scene - a getter method
     */
    public Scene getScene() {
        return this.scene;
    }
    
    /**
     * 
     * @param scene - A setter method which sets the scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    
    /**
     * 
     * @return A getter method which returns the parent
     */
    public Parent getParent() {
        return this.parent;
    }
    
    /**
     * 
     * @param parent - A setter method which sets the parent
     */
    public void setParent(Parent parent) {
    this.parent = parent;
    }
    
    /**
     * 
     * @return A getter method which gets the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * @param name - A setter method for the name(String)
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param fxmlFilename - a filepath to the fxml document
     * @throws IOException if the file is not found
     */
    public void buildroom(String fxmlFilename) throws IOException
{
    // create a new FXML loader 
    FXMLLoader loader = new FXMLLoader();
    //  This method takes all in the fxml document and instance it
    loader.setLocation(getClass().getResource(fxmlFilename));  
    // Sets the parent
    this.parent = loader.load();
    // Creates a new scene and takes a parent as argument
    this.scene = new Scene(this.parent);
}
    
    public int getRoomID(){
        return this.roomID;
    }


    
    
}