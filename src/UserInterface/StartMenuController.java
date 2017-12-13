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
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Oskar
 */
public class StartMenuController extends Controller implements Initializable, Serializable {

    private IBusiness business;
    @FXML
    private TextField txtNameInput;
    @FXML
    private Label characterText;
    
    private playerData pd;

    
    private String classes[] = {"startRoom", "red", "black", "blue", "green", "history", 
                                "janitorRoomDark", "janitorRoomLight", "math", "toilet"};
     public StartMenuController()
    {
        //for checking
        //updateListView();
        //
        try {
            pd = new playerData();
            //p = new Player(pd.playerName);
        }
        catch (IOException ex) {
            Logger.getLogger(StartMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        startStage.setScene(super.roomController.getRoom("startRoom").getScene());
           startStage.setOnCloseRequest(e -> {
                
            
                for (int i = 0; i < 10; i++)
                {
                    if (super.roomController.getRoom(classes[i]).getScene() == startStage.getScene())
                         //System.out.println("Same..: " + classes[i]);
                        pd.className = classes[i];
                        
                }
                sr=new staticalRepresentation();
                pd.playerName = txtNameInput.getText();
                pd.xCoord = Double.toString(sr.getX());
                pd.yCoord = Double.toString(sr.getY());
                
               // System.out.println("in mennu start=------exit: X: " + sr.getX() + " Y: " + sr.getY());
            try {
                pd.setGameTime("400");
                pd.setPlayerPoints(String.valueOf(business.getPlayer().getScore()));  //p.getScore to this one
                business.getPlayer().storeInventory();
                pd.savePlayerData(pd.playerName, pd.className, pd.xCoord, pd.yCoord);
               //p.checkInventory();
            } catch (IOException ex) {
                Logger.getLogger(StartMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
                startStage.close();
            });
        
        startStage.show();
    }
    }
    public void btnContinue(ActionEvent event)
    {
        try {
            
            business.createPlayer(pd.playerName);
            //business.createItems();
            business.createPlayer(txtNameInput.getText());
        business.createItem("Key to exit","exitKey", 2, true); // Don't put it anywhere, given out by the friendly NPC!
        business.createItem("Coffee pot", "coffeepot", 10, true);
        business.createPositiveDrinkableItem("Water Bottle", "waterBottle", 10, true, 400);
        business.createItem("Lunch box", "lunchBox", 0, false);
        business.createFlashlightItem("Flashlight", "flashLight", 10, true);
        business.createItem("Battery", "battery", 5, true);
        business.createItem("Mobile Phone", "mobilePhone", 0, false);
        business.createItem("Beer Bottle", "beerBottle", 2, true);
        business.getItem("Mobile Phone").setText("The battery is dead");
        business.createItem("Key to bathroom", "keyToBathroom", 5, true);
        business.createItem("Calender", "calender", 0, false);
        //To be deleted, test!
        business.createNegativeDrinkableItem("Beer", "beer", 5, true, 300);
        business.getItem("Calender").setText("20.12.2018");
        business.getItem("Lunch box").setText("");
        business.createItem("Broom", "broom", 5, true);
        business.createItem("History Book", "historyBook", 10, true);
        business.getItem("History Book").setText("The book needed by the professor. You must get it to him, quick!");
        
        business.createRoom(0, "Start", false);
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
        business.getNPC().randomizeQuestions(2);
        
        //business.getFriendlyNPC().setItemToBeFound("NAVNET PÅ DET ITEM PLAYER SKAL FINDE!");
        
        // checking here
        business.getPlayer().retrieveInventory();
        super.updateListView();

        super.createRooms();
            
        
            String cname = pd.className;
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(super.roomController.getRoom(cname).getScene());      //startRoom by mee
            StaticalContinue sc=new StaticalContinue();
            sc.setCon();
            
 
            startStage.show();
            startStage.setOnCloseRequest(e -> {
                
                
                for (int i = 0; i < 10; i++)
                {
                    if (super.roomController.getRoom(classes[i]).getScene() == startStage.getScene())
                        pd.className = classes[i];
                        
                }
                sr=new staticalRepresentation();
                pd.setGameTime("400");
                pd.setPlayerPoints(String.valueOf(business.getPlayer().getScore()));
                pd.playerName = txtNameInput.getText();
                pd.xCoord = Double.toString(sr.getX());
                pd.yCoord = Double.toString(sr.getY());
                business.getPlayer().storeInventory();      /// by me this time..
                
                 try {
                pd.savePlayerData(pd.playerName, pd.className, pd.xCoord, pd.yCoord);
            } catch (IOException ex) {
                Logger.getLogger(StartMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
                startStage.close();
            });
                        

        } catch (IOException e) {
            e.printStackTrace();
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
    
    /**
     * Create the rooms from the business layer, not the gui layer
     * private because this method is only used in this class
     */
    private void createRoomsInBusiness() {
        
        // Create a room, with an ID, title , and a boolean to check the lock status
        business.createRoom(0, "Gym", false);
        business.createRoom(1, "Math Room", false);
        business.createRoom(2, "History Room", false);
        business.createRoom(3, "Red hallway", false);
        business.createRoom(4, "Blue hallway", false);
        business.createRoom(5, "Janitor Room", true);
        business.createRoom(6, "Green hallway", false);
        business.createRoom(7, "Black hallway", false);
        business.createRoom(8, "Restroom", true);
        business.createRoom(9, "Exit", true);
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
        //business.getNPC().randomizeQuestions(2);
    }
}
