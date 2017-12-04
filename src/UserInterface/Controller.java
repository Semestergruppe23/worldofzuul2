/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class Controller implements Initializable {

    // Timelines for movement. One for each key W,A,S,D.
    Timeline timelineW = new Timeline();
    Timeline timelineA = new Timeline();
    Timeline timelineS = new Timeline();
    Timeline timelineD = new Timeline();

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;

    private int roomID = 0;
   
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
    
    private ImageView leftDoor;
    private Label lblRoomName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

    }

    // Adds value to the timelines created.
    public void createTimeLineW() {
        timelineW.setCycleCount(Timeline.INDEFINITE);
        final KeyValue kv = new KeyValue(player.yProperty(), -Integer.MAX_VALUE);
        final KeyFrame kf = new KeyFrame(Duration.hours(3000), kv);
        timelineW.getKeyFrames().add(kf);
    }

    public void createTimeLineA() {
        timelineA.setCycleCount(Timeline.INDEFINITE);
        final KeyValue kv = new KeyValue(player.xProperty(), -Integer.MAX_VALUE);
        final KeyFrame kf = new KeyFrame(Duration.hours(3000), kv);
        timelineA.getKeyFrames().add(kf);
    }

    public void createTimeLineS() {
        timelineS.setCycleCount(Timeline.INDEFINITE);
        final KeyValue kv = new KeyValue(player.yProperty(), Integer.MAX_VALUE);
        final KeyFrame kf = new KeyFrame(Duration.hours(3000), kv);
        timelineS.getKeyFrames().add(kf);
    }

    public void createTimeLineD() {
        timelineD.setCycleCount(Timeline.INDEFINITE);
        final KeyValue kv = new KeyValue(player.xProperty(), Integer.MAX_VALUE);
        final KeyFrame kf = new KeyFrame(Duration.hours(3000), kv);
        timelineD.getKeyFrames().add(kf);
    }

    
    // Called on keyPressed.
    @FXML
    private void playerMovement(KeyEvent event) throws IOException {
    
            changeRoomRightDoor(event);
            changeRoomBottomDoor(event);
            changeRoomLeftDoor(event);
            changeRoomTopDoor(event);
            this.collideWithImageView(event);
 
            

        if (event.getCode() == KeyCode.W ) {
            if (player.intersects(player.sceneToLocal(topWall.localToScene(topWall.getBoundsInLocal())))|| player.intersects(player.sceneToLocal(leftWall.localToScene(leftWall.getBoundsInLocal()))) ) {
                // DO NOTHING.
                System.out.println("collied");
                timelineW.stop();
           
                System.out.println("W");
            } else {
                createTimeLineW();
                timelineW.play();
                timelineA.stop();
                timelineS.stop();
                timelineD.stop();
                        
                System.out.println(player.getX() + player.getY());
                System.out.println("W");
            }
        } else {
            if (event.getCode() == KeyCode.A ) {
                if (player.intersects(player.sceneToLocal(leftWall.localToScene(leftWall.getBoundsInLocal()))) ||player.intersects(player.sceneToLocal(topWall.localToScene(topWall.getBoundsInLocal()))) ) {
                    // DO NOTHI;
                    timelineA.stop();
                 
                    System.out.println("A");
                } else {
                    player.setNodeOrientation(RIGHT_TO_LEFT);
                    createTimeLineA();
                    timelineA.play();
                    timelineW.stop();
                    timelineD.stop();
                    timelineS.stop();
                    System.out.println("A");
                    
                }
            } else {
                if (event.getCode() == KeyCode.S) {
                    if (player.intersects(player.sceneToLocal(bottomWall.localToScene(bottomWall.getBoundsInLocal())))) {
                        // DO NOTHING.
                        timelineS.stop();
                    } else {
                        createTimeLineS();
                        timelineS.play();
                        timelineW.stop();
                        timelineA.stop();
                        timelineD.stop();
                    }

                } else {
                    if (event.getCode() == KeyCode.D ) {
                        if (player.intersects(player.sceneToLocal(rightWall.localToScene(rightWall.getBoundsInLocal())))) {
                            // DO NOTHING.

                            timelineD.stop();
                        } else {
                            player.setNodeOrientation(LEFT_TO_RIGHT);
                            createTimeLineD();
                            timelineD.play();
                            timelineS.stop();
                            timelineW.stop();
                            timelineA.stop();
                        }

                    }

                }

            }
        }
    }

    
    // Called on keyReleased. 
    @FXML
    public void stopMove(KeyEvent event) {
        if (event.getCode() == KeyCode.W) {
            timelineW.stop();
        } else {
            if (event.getCode() == KeyCode.A) {
                timelineA.stop();
            } else {
                if (event.getCode() == KeyCode.S) {
                    timelineS.stop();
                } else {
                    if (event.getCode() == KeyCode.D) {
                        timelineD.stop();
                    }
                }
            }
        }
        
        
        
        
    
    }
    
    public void changeRoomRightDoor(KeyEvent event) throws IOException {
        
        if (player.intersects(player.sceneToLocal(rightDoor.localToScene(rightDoor.getBoundsInLocal())))) {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("redHallway.fxml"));
            Parent startParent = loader.load();
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
        }
    }
    
    public void changeRoomLeftDoor(KeyEvent event) throws IOException {
        
    
    }
    
    public void changeRoomBottomDoor(KeyEvent event) throws IOException {
        
    
    }
    
    public void changeRoomTopDoor(KeyEvent event) throws IOException {
        
   
        
        }
    
    public void collideWithImageView(KeyEvent event){
        
    }
    }
    
    
    

        
    

