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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private ProgressBar timer;
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
    private Label dialogueLabel;
    
    boolean hallucinationAlreadyPoppedUp = false;

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
        startStage.show();
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E) {
           
            
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("red").getScene());
        startStage.show();
    
    }
    }
    
    public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("black").getScene());
        startStage.show();
    
    }
    }
    
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
        
    if (player.intersects(player.sceneToLocal(topDoor.localToScene(topDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("history").getScene());
        startStage.show();
        
        }
    
    
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
                this.hallucinationAlreadyPoppedUp = true;
                this.hallucinationImageView.setVisible(false);
              }
        }
    }
}