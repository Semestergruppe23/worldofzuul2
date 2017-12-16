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
    private boolean questCompleted = false;
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
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("blue").getRoomID());
        startStage.show();
        }

        
        
        
    



    
    }
    
    //The history teacher, friendly NPC
    @Override
        public void collideWithImageView (KeyEvent event) {
            if(player.intersects(player.sceneToLocal(this.friendlyNPC.localToScene(this.friendlyNPC.getBoundsInLocal())))){ //Checks if the player has collided with the imageview
                if(event.getCode() == KeyCode.E ){ //The player must press E to interact
                    if(this.questStarted == false){ //If the quest hasnt already started
                        this.dialogueLabel.setText(business.getFriendlyNPC().getQuestString()); //Changes the label to the quest string from the businesslayer
                        this.questStarted = true; //Does so the same message does not come back
                    } else if(this.questStarted == true){ //If the player has already received the opening message
                        if(business.getFriendlyNPC().checkIfPlayerHasItem(business.getPlayer()) == false){ //If the player does not have the required item
                        this.dialogueLabel.setText(business.getFriendlyNPC().getStillWaitingString()); //Sets the Label to the text asking the player to hurry up
                        }if((business.getFriendlyNPC().checkIfPlayerHasItem(business.getPlayer()) == true) && this.questCompleted == false){ //Is the player has the desired item
                            this.dialogueLabel.setText(business.getFriendlyNPC().getCompletedQuestString()); //Sets the label to the completed quest string from the businesslayer
                            business.getPlayer().removeItemFromInventory(business.getItem("History Book")); //Removes the desired item from the players inventory
                            business.getPlayer().addItemToInventory(business.getItem("Key to exit")); //Adds the key to the exit to the players inventory
                            business.getRoom(9).setLocked(false); //Unlocks the locked room (room 9), because the player has the key
                            this.questCompleted = true; //Sets the boolean questCompleted to true, so the NPC does not ask for the item anymore
                        }if(this.questCompleted == true){ //If the quest has been completed
                            this.dialogueLabel.setText(business.getFriendlyNPC().getCompletedQuestString()); //Sets the Label text to a thank you instead
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
    
   
}

