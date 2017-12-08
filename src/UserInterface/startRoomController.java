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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class startRoomController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private Label lblRoomName;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
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
    private Label clockLabel;
    @FXML
    private ImageView beerBottleImageView;
    
    @FXML
    private ListView playerInventoryGUI;
    @FXML
    private Label dialogueLabel;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;
    private int roomID = 0;
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
    lblRoomName.setText(business.getRoom(roomID).getRoomName());
    
    }
 public void changeRoomRightDoor(KeyEvent event) throws IOException {
     
     
     
        if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal()))) && event.getCode() == KeyCode.E ) {
            
            
            
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(roomController.getRoom("red").getScene());
            startStage.show();
            
        }
    }

 @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(beerBottleImageView.localToScene(beerBottleImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Beer Bottle").getName(), beerBottleImageView);
          }
    }
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
    }


}