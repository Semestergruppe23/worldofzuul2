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
public class toiletRoomController extends Controller {

    @FXML
    private TitledPane playerInventory;
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
    private ListView<?> playerInventoryGUI;
    @FXML
    private ImageView historyBookImageView;
    @FXML
    private ImageView hallucinationImageView;
    @FXML
    private Label dialogueLabel;
    private boolean hallucinationAlreadyPoppedUp = false;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;
    hallucinationPopUp hallucination = new hallucinationPopUp();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    lblRoomName.setText(business.getRoom(roomID).getRoomName());
    this.hallucinationImageView.setVisible(false);
    }


     public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        
     if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("black").getScene());
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("black").getRoomID());
        startStage.show();
        }
    }
     
     
    //Hallucination pop up
    @Override
        public void collideWithImageView (KeyEvent event) {
            if(player.intersects(player.sceneToLocal(this.hallucinationImageView.localToScene(this.hallucinationImageView.getBoundsInLocal())))){
            hallucination.hallucinationPopsUp(this.hallucinationImageView, dialogueLabel, business);
            }
        }

    //The buttons used to answer the hallucination
    @FXML
    private void btnOptionA(ActionEvent event) {
        hallucination.questioning("A", business, dialogueLabel, this.hallucinationImageView);  
    }
    @FXML
    private void btnOptionB(ActionEvent event) {
        hallucination.questioning("B", business, dialogueLabel, this.hallucinationImageView);
    }
    @FXML
    private void btnOptionC(ActionEvent event) {
        hallucination.questioning("C", business, dialogueLabel, this.hallucinationImageView);
    }
    
    
    public void popup(KeyEvent event) {
     if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
    }
    
    



}