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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Tim
 */
public class HighScoreController implements Initializable {

    @FXML
    private ListView<String> lstvHighScore = new ListView<>();
    private ObservableList<String> highscores = FXCollections.observableArrayList(business.getHighscores());

    private ObservableList<String> clear = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lstvHighScore.setItems(highscores);

    }    

    @FXML
    private void clickReturn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
        Parent root = loader.load();

        StartMenuController controller = loader.getController();

        controller.injectBusiness(business);
        Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        startStage.setScene(scene);
        startStage.show();
    }
}