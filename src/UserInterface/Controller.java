/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IItem;
import static UserInterface.UserInterfaceFacade.business;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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

    @FXML
    private ImageView item1;
    
    @FXML
    private Label clockLabel;
    
    @FXML
    private Label volumeLabel;
    
    
    public static Room room;
    public static RoomController roomController;
    
    @FXML
    private ImageView item;
    
    private String ItemID;

    @FXML
    public ListView<IItem> playerInventoryGUI = new ListView<>();

    @FXML
    ObservableList<IItem> GUIInventory;

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
        
         if (event.getCode() == KeyCode.E) {
                            timelineW.stop();
                            timelineA.stop();
                            timelineS.stop();
                            timelineD.stop();
                             }


        changeRoomRightDoor(event);
        changeRoomBottomDoor(event);
        changeRoomLeftDoor(event);
        changeRoomTopDoor(event);
        this.collideWithImageView(event);
        pickItemUp(event);
        updateListView();
        updateClockLabel();
        popup(event);
        collideWithShadows(event);
        updateInventoryVolumeLabel();
        
        
       if(business.getPlayer().checkTime() == false){
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(roomController.getRoom("endGame").getScene());
            startStage.show();
        }
        

        if (event.getCode() == KeyCode.W) {
            if (player.intersects(player.sceneToLocal(topWall.localToScene(topWall.getBoundsInLocal())))) {
                // DO NOTHING.

                timelineW.stop();

            } else {
                createTimeLineW();
                timelineW.play();
                timelineA.stop();
                timelineS.stop();
                timelineD.stop();

            }
        } else {
            if (event.getCode() == KeyCode.A) {
                if (player.intersects(player.sceneToLocal(leftWall.localToScene(leftWall.getBoundsInLocal())))) {
                    // DO NOTHI;
                    timelineA.stop();

                } else {
                    player.setNodeOrientation(RIGHT_TO_LEFT);
                    createTimeLineA();
                    timelineA.play();
                    timelineW.stop();
                    timelineD.stop();
                    timelineS.stop();

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
                    if (event.getCode() == KeyCode.D) {
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

    }

    public void changeRoomLeftDoor(KeyEvent event) throws IOException {

    }

    public void changeRoomBottomDoor(KeyEvent event) throws IOException {

    }

    public void changeRoomTopDoor(KeyEvent event) throws IOException {

    }

    public void collideWithImageView(KeyEvent event) {

    }

    public void createRooms() throws IOException {
        roomController = new RoomController();
        
        room = new Room("endGame");
        room.buildroom("GameLostScreen.fxml");
        roomController.addRoom(room);

        room = new Room("startRoom");
        room.buildroom("startRoom.fxml");
        roomController.addRoom(room);

        room = new Room("red");
        room.buildroom("redHallway.fxml");
        roomController.addRoom(room);

        room = new Room("black");
        room.buildroom("blackHallway.fxml");
        roomController.addRoom(room);

        room = new Room("blue");
        room.buildroom("blueHallway.fxml");
        roomController.addRoom(room);

        room = new Room("green");
        room.buildroom("greenHallway.fxml");
        roomController.addRoom(room);

        room = new Room("history");
        room.buildroom("historyRoom.fxml");
        roomController.addRoom(room);

        room = new Room("janitorRoomDark");
        room.buildroom("janitorRoomDark.fxml");
        roomController.addRoom(room);

        room = new Room("janitorRoomLight");
        room.buildroom("janitorRoomLight.fxml");
        roomController.addRoom(room);

        room = new Room("math");
        room.buildroom("mathRoom.fxml");
        roomController.addRoom(room);

        room = new Room("toilet");
        room.buildroom("toiletRoom.fxml");
        roomController.addRoom(room);

    }

    public void pickItemUp(KeyEvent event) {
         
    }
    
    /**
     * 
     * @param id Insert a item name 
     * @param imageView insert a imageView fx:id
     * 
     * This method takes to params and puts the item in the player inventory
     * and disables the imageView
     */
    public void handleItem(String id, ImageView imageView  ) {

        // check player inventory for item (id)
        if (!business.getPlayer().getPlayerInventory().contains(business.getItem(id))) {
            // add item to player inventory
            business.getPlayer().addItemToInventory(business.getItem(id));
            
           updateListView();
           
           if ( business.getItem(id).getCarryable()) {
           imageView.setVisible(false);
        } 
        }
    }
    
    

    /**
     * This method update Observable and add player inventory and show it in the list view
     */
    public void updateListView() {
        //initialize Observablelist
        GUIInventory = FXCollections.observableArrayList();
        // add player inventory to Observablelist
        GUIInventory.addAll(business.getPlayer().getPlayerInventory());
        //show observablelist in listView
        playerInventoryGUI.setItems(GUIInventory);
    }
    
    public void updateClockLabel(){
        clockLabel.setText("Remaining time: " + (int)business.getPlayer().getRemainingTime());
    }
    
    public void updateInventoryVolumeLabel(){
        volumeLabel.setText("Inventory weight: " + business.getPlayer().getCurrentVolumeUsed() + "/" +  business.getPlayer().getMaxCapacity());
    }
    
    public void popupBox(Rectangle popupRectangle, Text popupText) {

          FadeTransition ft = new FadeTransition(Duration.millis(200), popupRectangle);
            FadeTransition ft2 = new FadeTransition(Duration.millis(200), popupText);
            
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
            
            ft2.setFromValue(0);
            ft2.setToValue(1);
            ft2.play();
     
     }
    
    public void popup(KeyEvent event) {
        
    }
    
    /**
     * Method remove selected item in listview from players inventory 
     */
    public void dropItem() {
        
        business.getPlayer().removeItemFromInventory(this.playerInventoryGUI.getSelectionModel().getSelectedItem());
        updateListView();
    }
    
        @FXML
    private void dropItem(ActionEvent event) {
       dropItem();
    }
    
    @FXML
    private void useItem(ActionEvent event) {
        useItem();
    }
    
    
    public void useItem() {
    business.getItem(this.playerInventoryGUI.getSelectionModel().getSelectedItem().getName()).use(business.getPlayer());
        updateListView(); 
        updateClockLabel();
    }
    
    public void collideWithShadows(KeyEvent event){
        
    }
    
    
}
