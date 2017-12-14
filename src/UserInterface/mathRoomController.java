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

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
public class mathRoomController extends Controller {

    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 1;
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
    private ImageView bottomDoor;
    @FXML
    private Label lblRoomName;
    @FXML
    private ImageView waterBottleImageView;
    @FXML
    private ImageView lunchBoxImageView;
    
    @FXML
    private ListView playerInventoryGUI;
    @FXML
    private Label dialogueLabel;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;
    @FXML
    private ImageView flashLightImageView;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblRoomName.setText(business.getRoom(roomID).getRoomName());
        business.getPlayer().setCurrentRoom(business.getRoom(roomID).getRoomName());
        business.getData().save(business.getPlayer());
    }

    

     public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("red").getScene());
        startStage.show();
        }
    
    }
     
     
    @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(waterBottleImageView.localToScene(waterBottleImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Water Bottle").getName(), waterBottleImageView);
          }
          else if (player.intersects(player.sceneToLocal(lunchBoxImageView.localToScene(lunchBoxImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Lunch box").getName(), lunchBoxImageView);
          }
          
          else if (player.intersects(player.sceneToLocal(flashLightImageView.localToScene(flashLightImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Flashlight").getName(), flashLightImageView);
          }
    }

    @FXML
    private void clickMainMenu(ActionEvent event) 
    {
        
    }
    
    public void popup(KeyEvent event) {
     if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }


}


    
}
