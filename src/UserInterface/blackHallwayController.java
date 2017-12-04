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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
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
public class blackHallwayController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;

    ObservableList<IItem> GUIInventory; 
    private int roomID = 7;
    private int playerX;
    private int playerY;
    private int speed = gameConstants.speed;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblRoomName.setText(business.getRoom(roomID).getRoomName());
        GUIInventory = FXCollections.observableArrayList((ArrayList)business.getPlayer().getPlayerInventory());
    }

    
    
       public void changeRoomRightDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
            Parent startParent = FXMLLoader.load(getClass().getResource("greenHallway.fxml"));
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
        }
    }
    
    @Override
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
            Parent startParent = FXMLLoader.load(getClass().getResource("toiletRoom.fxml"));
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
    
    }
    }
      
    
    @Override
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
          if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))) {
            Parent startParent = FXMLLoader.load(getClass().getResource("blueHallway.fxml"));
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
    }
    }

    @FXML
    private void btnKeyToExit(ActionEvent event) {
      //  business.getPlayer().addItemToInventory(business.getItem("Key To Exit", this.roomName));
        GUIInventory = FXCollections.observableArrayList((ArrayList)business.getPlayer().getPlayerInventory());
        playerInventoryGUI.setItems(GUIInventory);
    }

}