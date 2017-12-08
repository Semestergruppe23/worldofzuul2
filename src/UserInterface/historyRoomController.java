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
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 2;
    private int playerX;
    private int playerY;
    @FXML
    private Label clockLabel;
    @FXML
    private ImageView friendlyNPC; 

    @FXML
    private ImageView bottomDoor;
    @FXML
    private Label lblRoomName;
    @FXML
    private Label dialogueLabel; 
    
    private boolean questStarted = false;
    @FXML
    private ListView<?> playerInventoryGUI;
    @FXML
    private ImageView topWall;
    @FXML
    private ImageView leftWall;
    @FXML
    private ImageView bottomWall;
    @FXML
    private ImageView rightWall;
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
            if(player.intersects(player.sceneToLocal(this.friendlyNPC.localToScene(this.friendlyNPC.getBoundsInLocal())))){
                if(event.getCode() == KeyCode.E ){
                    if(this.questStarted == false){
                        this.dialogueLabel.setText(business.getFriendlyNPC().getQuestString());
                        this.questStarted = true;
                    } else if(this.questStarted == true){
                        if(business.getFriendlyNPC().checkIfPlayerHasItem(business.getPlayer()) == false){
                        this.dialogueLabel.setText(business.getFriendlyNPC().getStillWaitingString());
                        } else if(business.getFriendlyNPC().checkIfPlayerHasItem(business.getPlayer()) == true){
                            this.dialogueLabel.setText(business.getFriendlyNPC().getCompletedQuestString());
                            business.getPlayer().addItemToInventory(business.getItem("Key to exit"));
                            business.getRoom(9).setLocked(false);
                            business.getPlayer().removeItemFromInventory("History Book");
                        }
                    }
                }
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
    
    
        @FXML
    private void dropItem(ActionEvent event) {
    }

    @FXML
    private void useItem(ActionEvent event) {
    }
}

