/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
import Acquaintance.IUserInterface;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Oskar
 */
public class UserInterfaceFacade extends Application implements IUserInterface{

    static IBusiness business;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
        Parent root = loader.load();

        StartMenuController controller = loader.getController();

        controller.injectBusiness(business);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @Override
    public void injectBusiness(IBusiness _business) {
        business = _business;
    }

    @Override
    public void startGame() {
      launch();
    }
    
    
    
    

}
