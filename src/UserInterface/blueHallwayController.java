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
public class blueHallwayController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 4;
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
    private ImageView bottomDoor;
    @FXML
    private ImageView leftDoor;
    @FXML
    private Label lblRoomName;
    @FXML
    private ImageView hallucinationImageView;
    @FXML
    private ImageView coffeeImageView;
    @FXML
    private Label dialogueLabel;
    @FXML
    private Label clockLabel;
    
    boolean hallucinationAlreadyPoppedUp = false;
    @FXML
    private ListView<?> playerInventoryGUI;
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

 
    
    public void changeRoomRightDoor(KeyEvent event) throws IOException {
        
       if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E) {

        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("janitorRoomDark").getScene());
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("janitorRoomDark").getRoomID());
        startStage.show();
        
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E) {
           
            
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("red").getScene());
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("red").getRoomID());
        startStage.show();
    
    }
    }
    
    public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("black").getScene());
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("black").getRoomID());
        startStage.show();
    
    }
    }
    
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
        
    if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("history").getScene());
        business.getPlayer().setCurrentRoom(super.roomController.getRoom("history").getRoomID());
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
    
    
    @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(coffeeImageView.localToScene(coffeeImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Coffee").getName(), coffeeImageView);
          }
          }
    @FXML
    private void clickMainMenu(ActionEvent event) 
    {
        
    }

public void popup(KeyEvent event) {
     if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
     
      if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
      
       if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
       
        if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
     
}



    

}