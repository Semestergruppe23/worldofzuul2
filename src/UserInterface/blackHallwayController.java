/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IItem;
import static UserInterface.UserInterfaceFacade.business;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class blackHallwayController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;

    ObservableList<IItem> GUIInventory; 
    private int roomID = 7;
    
    @FXML
    private Label clockLabel;

    @FXML
    private ImageView topWall;
    @FXML
    private ImageView leftWall;
    @FXML
    private ImageView bottomWall;
    @FXML
    private ImageView rightWall;
    @FXML
    private ImageView topDoor;
    @FXML
    private ImageView rightDoor;
    @FXML
    private ImageView leftDoor;
    @FXML
    private Label lblRoomName;
    @FXML
    private ListView<IItem> playerInventoryGUI;
    private Button btnKeyToExit;
    
    @FXML
    private ImageView imgKeyToExit;
    @FXML
    private Label dialogueLabel;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblRoomName.setText(business.getRoom(roomID).getRoomName());
        GUIInventory = FXCollections.observableArrayList((ArrayList)business.getPlayer().getPlayerInventory());
    }

    
    
       public void changeRoomRightDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
          
            
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("green").getScene());
        startStage.show();
        }
    }
    
    @Override
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E && business.getRoom(9).getLocked() == true ) {
            // Temporary placeholder for room locked message. 
            System.out.println("Room is locked!");
        }
        // If the Locked boolean is false, then the room is unlocked and you can enter.
        else if(player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E && business.getRoom(9).getLocked() == false) 
        {
        
        
        
            
            
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("toilet").getScene());
        startStage.show();
    
    }
    }
      
    
    @Override
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
          if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
            
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("blue").getScene());
        startStage.show();
        
    }
    }


        /*
      public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(imgKeyToExit.localToScene(imgKeyToExit.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              business.getPlayer().addItemToInventory(business.getItem("Key To Exit", business.getRoom(roomID).getRoomName()));
        GUIInventory = FXCollections.observableArrayList((ArrayList)business.getPlayer().getPlayerInventory());
        playerInventoryGUI.setItems(GUIInventory);
        imgKeyToExit.setDisable(true);
          }
            

}
*/

    @FXML
    private void clickMainMenu(ActionEvent event) 
    {
        
    }
    
    public void popup(KeyEvent event) {
     if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
     
     if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
     
     if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
    }


    @FXML
    private void useItem(ActionEvent event) {
    }

}
