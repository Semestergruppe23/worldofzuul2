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
    private ImageView beerBottle2ImageView;
    @FXML
    private ImageView pantsImageView;
    @FXML
    private ImageView mobilePhoneImageView;
    @FXML
    private ListView playerInventoryGUI;
    @FXML
    private Label dialogueLabel;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;
    private int roomID = 1;
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
    lblRoomName.setText(business.getRoom(roomID).getRoomName());
    }
 public void changeRoomRightDoor(KeyEvent event) throws IOException {
     
     
     
        if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal()))) && event.getCode() == KeyCode.E ) {
            
            
            
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(roomController.getRoom("red").getScene());
            business.getPlayer().setCurrentRoom(super.roomController.getRoom("red").getRoomID());
            startStage.show();
            
        }
    }

 @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(beerBottleImageView.localToScene(beerBottleImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Beer").getName(), beerBottleImageView);
          }
          else if(player.intersects(player.sceneToLocal(pantsImageView.localToScene(pantsImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Pants").getName(), pantsImageView);
               }
          else if(player.intersects(player.sceneToLocal(beerBottle2ImageView.localToScene(beerBottle2ImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Second Beer").getName(), beerBottle2ImageView);
               }
          else if(player.intersects(player.sceneToLocal(mobilePhoneImageView.localToScene(mobilePhoneImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Mobile Phone").getName(), mobilePhoneImageView);
              this.dialogueLabel.setText(business.getItem("Mobile Phone").getText());
              
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


