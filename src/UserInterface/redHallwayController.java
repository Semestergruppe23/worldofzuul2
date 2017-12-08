/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static UserInterface.UserInterfaceFacade.business;
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
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class redHallwayController extends Controller implements Initializable {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private Label lblRoomName;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    @FXML
    private ImageView topDoor;
    @FXML
    private ImageView topWall;
    @FXML
    private ImageView leftWall;
    @FXML
    private ImageView bottomWall;
    @FXML
    private int roomID = 3;
    private ImageView rightWall;
    @FXML
    private ImageView rightDoor;
    @FXML
    private ImageView bottomDoor;
    @FXML
    private ImageView leftDoor;
    @FXML
    private ListView<?> playerInventoryGUI;
    @FXML
    private Label clockLabel;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lblRoomName.setText(business.getRoom(roomID).getRoomName()); 
        
    }

    public void changeRoomRightDoor(KeyEvent event) throws IOException {
        
      if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
        FXMLLoader loader = new FXMLLoader();
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("blue").getScene());
        startStage.show();
        }
    }
    
    
    
    public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
         Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("green").getScene());
        startStage.show();
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal()))) && event.getCode() == KeyCode.E ) {
         Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("startRoom").getScene());
        startStage.show();
    
    }
    }
    
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
         Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("math").getScene());
        startStage.show();
   
        
        }
    }

    @FXML
    private void clickMainMenu(ActionEvent event)
    {
        
    }
}


    
    

     


