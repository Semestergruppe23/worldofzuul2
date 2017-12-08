/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static UserInterface.UserInterfaceFacade.business;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class exitRoomController {

    @FXML
    private ImageView player;

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

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        business.getData().addHighscore(business.getPlayer().getName(), business.getPlayer().getScore());
    }

    @FXML
    private void playerMovement(KeyEvent event) {
    }

   

            }