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
public class historyRoomController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 2;
    private int playerX;
    private int playerY;
    private int speed = gameConstants.speed;

    @FXML
    private ImageView bottomDoor;
    @FXML
    private Label lblRoomName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblRoomName.setText(business.getRoom(roomID).getRoomName());
    }

    public void changeRoomBottomDoor(KeyEvent event) throws IOException {

        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("blue").getScene());
        startStage.show();
        }

        
        
        
    



    
    }

    @Override
        public void collideWithImageView (KeyEvent event) {
  //if (player.intersects(player.sceneToLocal(this..localToScene(rightDoor.getBoundsInLocal()))))
              
        }
}

