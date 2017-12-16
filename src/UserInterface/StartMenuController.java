/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONException;

/**
 * FXML Controller class
 *
 * @author Oskar
 */
public class StartMenuController extends Controller implements Initializable {

    private IBusiness business;
    @FXML
    private TextField txtNameInput;
    @FXML
    private Label characterText;
    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnStartGame(ActionEvent event) throws IOException {
          if (txtNameInput.getText().isEmpty()) {
              characterText.setText("Please enter a name!");
        } else {
        
        
        business.createPlayer(txtNameInput.getText());
        createRoomsInBusiness();
        createItemsInBusiness();
        initilizeNPC();
        
        super.createRooms();
        business.getItem("History Book").setText("The book needed by the professor. You must get it to him, quick!");
        
 
        
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("introRoom").getScene());
        startStage.show();
    }
    }

    @FXML
    private void btnHighScore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HighScore.fxml"));
        Parent startParent = loader.load(); 
        Scene startScene = new Scene(startParent);
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(startScene);
        startStage.show();
    }


    @FXML
    private void btnExitGame(ActionEvent event) {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.close();
    }
    
    
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }
    
    /**
     * Create the rooms from the business layer, not the gui layer
     * private because this method is only used in this class
     */
    private void createRoomsInBusiness() {
        
        // Create a room, with an ID, title , and a boolean to check the lock status
        business.createRoom(1, "Gym", false);
        business.createRoom(2, "Math Room", false);
        business.createRoom(3, "History Room", false);
        business.createRoom(4, "Red hallway", false);
        business.createRoom(5, "Blue hallway", false);
        business.createRoom(6, "Janitor Room", true);
        business.createRoom(7, "Green hallway", false);
        business.createRoom(8, "Black hallway", false);
        business.createRoom(9, "Restroom", true);
        business.createRoom(10, "Exit", true);
    }
    
    /**
     * Creating items in the business layer.
     * Priavte because this method is only use in this class
     */
    private void createItemsInBusiness() {
        business.createItem("Key to exit","exitKey", 2, true); // Don't put it anywhere, given out by the friendly NPC!
        business.createItem("Coffee pot", "coffeepot", 10, true);
        business.createPositiveDrinkableItem("Water Bottle", "waterBottle", 10, true, 300);
        business.createPositiveDrinkableItem("Coffee","coffee", 2, true, 200);
        business.createPositiveDrinkableItem("Cola", "cola", 2, true, 200);
        business.createItem("Lunch box", "lunchBox", 0, false);
        business.createFlashlightItem("Flashlight", "flashLight", 10, true);
        business.createItem("Battery", "battery", 5, true);
        business.createItem("Mobile Phone", "mobilePhone", 0, false);
        business.createItem("Beer Bottle", "beerBottle", 2, true);
        business.getItem("Mobile Phone").setText("The battery is dead");
        business.createItem("Key to bathroom", "keyToBathroom", 5, true);
        business.createItem("Calender", "calender", 0, false);
        business.createWearableItem("Pants", "pants", 0, true, 10);
        //To be deleted, test!
        business.createNegativeDrinkableItem("Beer", "beer", 5, true, 300);
        business.createNegativeDrinkableItem("Second Beer", "beerTwo", 5, true, 300);
        business.createNegativeDrinkableItem("Gasoline", "gasoline", 5, true, 400);
        business.getItem("Calender").setText("20.12.2018");
        business.getItem("Lunch box").setText("");
        business.createItem("Broom", "broom", 5, true);
        business.createItem("History Book", "historyBook", 10, true);
    }
    
    /**
     * Create npc objects and run methods so npc is ready
     * 
     */
    private void initilizeNPC() {
        
        // Creating NPC
        business.createNPC();
        
        // Fills the array with questions and asnwers, and catch if the 
        // file is not found
        try {
        business.getNPC().fillArraysWithQuestionsAndAnswers();
        } catch(FileNotFoundException ex) {
            System.out.println("File is not found.");
        }
        
        business.createFriendlyNPC();
        business.getFriendlyNPC().setItemToBeFound("History Book");
        business.getNPC().randomizeQuestions(2);
    }

    //Method for loading game from previously saved TXT-file
    @FXML
    private void btnLoadGame(ActionEvent event) throws IOException, JSONException {
        

        business.setPlayerFromLoadedGame(business.getData().load());
        System.out.println("Player initialized!");
        createRoomsInBusiness();
        createItemsInBusiness();
        initilizeNPC();
        
        super.createRooms();
        business.getItem("History Book").setText("The book needed by the professor. You must get it to him, quick!");
        
        //Getting roomname of loaded "currentRoom" to initialize game from that room
        int loadedRoomID = business.getPlayer().getCurrentRoom();
        String loadRoom = super.roomController.roomList.get(loadedRoomID).getName();
 
        
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom(loadRoom).getScene());
        startStage.show();

    }
}
