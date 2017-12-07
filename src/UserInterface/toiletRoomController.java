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
public class toiletRoomController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 8;
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
    private ImageView leftDoor;
    @FXML
    private Label lblRoomName;
    @FXML
<<<<<<< HEAD
    private ImageView idCardImageView;
=======
    private ListView<?> playerInventoryGUI;
    @FXML
    private ImageView historyBookImageView;
    
>>>>>>> ecaa7dfc1dd5651f65947fda7eca163f40dfbc8a
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    lblRoomName.setText(business.getRoom(roomID).getRoomName());
    }


     public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        
     if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("black").getScene());
        startStage.show();
        }
    }
<<<<<<< HEAD
         
    @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(idCardImageView.localToScene(idCardImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("ID-card").getName(), idCardImageView);
          }
       
    }
}
=======
     
     
    @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(historyBookImageView.localToScene(historyBookImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("History Book").getName(), historyBookImageView);
          }
    } 

    @FXML
    private void clickMainMenu(ActionEvent event) 
    {
        
    }
}
>>>>>>> ecaa7dfc1dd5651f65947fda7eca163f40dfbc8a
