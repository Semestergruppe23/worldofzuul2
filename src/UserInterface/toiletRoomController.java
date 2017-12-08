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
    private ListView<?> playerInventoryGUI;
    @FXML
    private ImageView historyBookImageView;
    @FXML
    private ImageView hallucinationImageView;
    @FXML
    private Label dialogueLabel;
    private boolean hallucinationAlreadyPoppedUp = false;
    

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
        startStage.show();
        }
    }
     
     
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
    
    @Override
        public void collideWithImageView (KeyEvent event) {
            if(player.intersects(player.sceneToLocal(this.hallucinationImageView.localToScene(this.hallucinationImageView.getBoundsInLocal()))) && this.hallucinationAlreadyPoppedUp == false){
                this.hallucinationImageView.setVisible(true);
                this.dialogueLabel.setText(business.getNPC().generateQuestion());
            }

        }

    @FXML
    private void btnOptionA(ActionEvent event) {
        if(this.hallucinationAlreadyPoppedUp == false){
            String answer = "A";
            if(business.getNPC().checkAnswer(answer) == true){
                this.dialogueLabel.setText("Thats right!");
                business.getPlayer().rewardPoints(200);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
            } else{
                this.dialogueLabel.setText("No.. That's not right..");
                business.getPlayer().removeTime(30);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
              }
        }
        
    }

    @FXML
    private void btnOptionB(ActionEvent event) {
                if(this.hallucinationAlreadyPoppedUp == false){
            String answer = "B";
            if(business.getNPC().checkAnswer(answer) == true){
                this.dialogueLabel.setText("Thats right!");
                business.getPlayer().rewardPoints(200);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
            } else{
                this.dialogueLabel.setText("No.. That's not right..");
                business.getPlayer().removeTime(30);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
              }
        }
    }

    @FXML
    private void btnOptionC(ActionEvent event) {
        if(this.hallucinationAlreadyPoppedUp == false){
            String answer = "C";
            if(business.getNPC().checkAnswer(answer) == true){
                this.dialogueLabel.setText("Thats right!");
                business.getPlayer().rewardPoints(200);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
            } else{
                this.dialogueLabel.setText("No.. That's not right..");
                business.getPlayer().removeTime(30);
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
              }
        }
    }
    
}