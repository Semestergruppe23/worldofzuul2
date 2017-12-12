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
public class janitorRoomDarkController extends Controller {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;
    private int roomID = 5;
    @FXML
    private ImageView topWall;
    @FXML
    private Label clockLabel;
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
    private Label dialogueLabel;
    @FXML
    private Rectangle popUp;
    @FXML
    private Text popUpText;
    @FXML
    private ImageView keyImageView;
    @FXML
    private ImageView gasolineImageView;
    @FXML
    private ImageView shadowsImageView;
          
    
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     lblRoomName.setText(business.getRoom(roomID).getRoomName());
    }

    
     public void changeRoomLeftDoor(KeyEvent event) throws IOException {
         if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
             Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        startStage.setScene(super.roomController.getRoom("blue").getScene());
        startStage.show();
        }
    
    }

    @FXML
    private void clickMainMenu(ActionEvent event) 
    {
        
    }
    
    public void popup(KeyEvent event) {
        
    
     if (player.intersects(player.sceneToLocal(leftDoor.localToScene(leftDoor.getBoundsInLocal())))) {
         super.popupBox(popUp, popUpText);
     } else {
         popUp.setOpacity(0);
         popUpText.setOpacity(0);
     }
    }
    
    @Override
    public void pickItemUp(KeyEvent event) {
          if (player.intersects(player.sceneToLocal(keyImageView.localToScene(keyImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Key to bathroom").getName(), keyImageView);
          }
          else if (player.intersects(player.sceneToLocal(gasolineImageView.localToScene(gasolineImageView.getBoundsInLocal())))&& event.getCode() == KeyCode.E ) {
              super.handleItem(business.getItem("Gasoline").getName(), gasolineImageView);
    }
    }
    
    @Override
    public void collideWithShadows(KeyEvent event){
        if (player.intersects(player.sceneToLocal(this.shadowsImageView.localToScene(this.shadowsImageView.getBoundsInLocal())))){
            if (business.getPlayer().getFlashlightUsed()){
                this.shadowsImageView.setVisible(false);
            }
        }
    }


}