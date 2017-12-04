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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private ImageView rightWall;
    @FXML
    private ImageView rightDoor;
    @FXML
    private ImageView bottomDoor;
    @FXML
    private ImageView leftDoor;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }

    public void changeRoomRightDoor(KeyEvent event) throws IOException {
        
      if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("blueHallway.fxml"));
            Parent startParent = loader.load();
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
        }
    }
    
    
    public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))) {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("greenHallway.fxml"));
            Parent startParent = loader.load();
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("startRoom.fxml"));
            Parent startParent = loader.load();
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
    
    }
    }
    
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))) {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mathRoom.fxml"));
            Parent startParent = loader.load();
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
   
        
        }
    }
    
    }


    
    

     


