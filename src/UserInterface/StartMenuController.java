/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oskar
 */
public class StartMenuController extends Controller implements Initializable {

    private IBusiness business;
    @FXML
    private TextField txtNameInput;
    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnStartGame(ActionEvent event) throws IOException {
        // createRoom(Index id in arrayList, Room Name, Locked or not)
        business.createPlayer(txtNameInput.getText());
        business.createItem("Key to exit","exitKey", 2, true); // Don't put it anywhere, given out by the friendly NPC!
        business.createItem("Coffee pot", "coffeepot", 10, true);
        business.createItem("Water Bottle", "waterBottle", 10, true);
        business.createItem("Lunch box", "lunchBox", 0, false);
        business.createItem("Flashlight", "flashLight", 10, true);
        business.createItem("Battery", "battery", 5, true);
        business.createItem("Mobile Phone", "mobilePhone", 0, false);
        business.createItem("Beer Bottle", "beerBottle", 2, true);
        business.getItem("Mobile Phone").setText("The battery is dead");
        business.createItem("Calender", "calender", 0, false);
        business.getItem("Calender").setText("20.12.2018");
        business.getItem("Lunch box").setText("");
        business.createItem("Broom", "broom", 5, true);
        business.createItem("History Book", "historyBook", 10, true);
        business.getItem("History Book").setText("The book needed by the professor. You must get it to him, quick!");
        business.createRoom(0, "Gym", false);
        business.createRoom(1, "Math Room", false);
        business.createRoom(2, "History Room", false);
        business.createRoom(3, "Red hallway", false);
        business.createRoom(4, "Blue hallway", false);
        business.createRoom(5, "Janitor Room", true);
        business.createRoom(6, "Green hallway", false);
        business.createRoom(7, "Black hallway", false);
        business.createRoom(8, "Restroom", false);
        business.createRoom(9, "Exit", true);
        business.createNPC();
        business.getNPC().fillArraysWithQuestionsAndAnswers();
        business.createFriendlyNPC();
        business.getFriendlyNPC().setItemToBeFound("History Book");
        
        

        super.createRooms();
        
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("startRoom").getScene());
        startStage.show();
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
    private void btnSettings(ActionEvent event) {
    }

    @FXML
    private void btnExitGame(ActionEvent event) {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.close();
    }
    
    
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }
}
