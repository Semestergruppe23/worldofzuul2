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
    private int playerX;
    private int playerY;
    private int speed = gameConstants.speed;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblRoomName.setText(business.getRoom(roomID).getRoomName());
        this.hallucinationImageView.setVisible(false);
    }

 
    
    public void changeRoomRightDoor(KeyEvent event) throws IOException {
        
       if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
            
            
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("janitorRoomDark").getScene());
        startStage.show();
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
           
            
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
            if(player.intersects(player.sceneToLocal(this.hallucinationImageView.localToScene(this.hallucinationImageView.getBoundsInLocal())))){
                this.hallucinationImageView.setVisible(true);
                this.dialogueLabel.setText(business.getNPC().generateQuestion());
            }

        }

    @FXML
    private void btnOptionA(ActionEvent event) {
        String answer = "A";
        if(business.getNPC().checkAnswer(answer) == true){
            this.dialogueLabel.setText("Thats right!");
            business.getPlayer().rewardPoints(200);
        } else{
            this.dialogueLabel.setText("No.. That's not right..");
        }
        
    }

    @FXML
    private void btnOptionB(ActionEvent event) {
        String answer = "B";
        if(business.getNPC().checkAnswer(answer) == true){
            this.dialogueLabel.setText("Thats right!");
        } else{
            this.dialogueLabel.setText("No.. That's not right..");
        }
    }

    @FXML
    private void btnOptionC(ActionEvent event) {
        String answer = "C";
        if(business.getNPC().checkAnswer(answer) == true){
            this.dialogueLabel.setText("Thats right!");
        } else{
            this.dialogueLabel.setText("No.. That's not right..");
        }
    }

   
}