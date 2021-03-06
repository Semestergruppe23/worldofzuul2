
package Data;

import Acquaintance.IData;
import Acquaintance.IPlayer;
import Business.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;


// @author Tim
/**
 * Create highscore list implementing interface
 * @author Tim
 */
public class Data implements IData 
{
    Connection conn = null;
    private String ip = "jdbc:mysql://207.154.205.244/matador";
    private String userName = "tim_user";
    private String password = "Tim!Er&Dejlig932!";
    
    private String savedPlayerName;
    
    /**
     * Constructor - Automatically make connection to server
     */
    public Data()
    {
        try 
        {
            conn = DriverManager.getConnection(ip, userName, password);

        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }
    /**
     * Method for retrieving top 10 scores and names from server
     * @return list of 10 top scores
     */
    @Override
    public List<String> getHighscore()
    {
        Statement statement = null;
        ResultSet result = null;
        List <String> HighScoreList = new ArrayList<>();
        
        try
        {
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM highscore ORDER BY score DESC LIMIT 14");
            
            while (result.next())
                {
                    HighScoreList.add(result.getString("bruger") + ":  " + result.getString("score"));
                }
        } catch (SQLException ex) 
        {
            System.out.println(ex.toString());
            
        }
        return HighScoreList;
    }
    
    /**
     * Method for adding highscore to server list
     * @param name of the player
     * @param score of the player
     */
    @Override
    public void addHighscore(String name, int score) 
    {
        String query = "INSERT INTO highscore (bruger, score) VALUES (\'" + name + "\'," + score + ")";
        try 
        {
            Statement statement = conn.createStatement();
            statement.execute(query);

        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    


    /**
     * Methods for saving and loading the Player-object locally
     * Saving method, using a printwriter
     * @param player to be saved
     */
    public void save(IPlayer player) {
        try {
            PrintWriter pw1 = new PrintWriter("savePlayer.txt", "UTF-8");
            
            pw1.println("{\"name\":\"" + player.getName() + "\",");
            pw1.println("\"currentRoom\":\"" + player.getCurrentRoom() + "\",");
            pw1.println("\"totalGameTime\":\"" + player.getRemainingTime() + "\",");
            pw1.println("\"playerPoints\":\"" + player.getScore() + "\",");
            pw1.println("\"maxCapacity\":\"" + player.getMaxCapacity() + "\",");
//            pw1.println("\"inventoryUsed\":\"" + player.getCurrentVolumeUsed() + "\",");
            pw1.println("\"flashlightUsed\":\"" + player.getFlashlightUsed() + "\",");
            pw1.println("\"item\": [");
            //Print Inventory
                for (int i = 0; i < player.getPlayerInventory().size(); i++){
                pw1.println("\"" + player.getPlayerInventory().get(i).getName()+ "\",");
                }
            pw1.println("]}");
            pw1.close();
        } catch (Exception ex) {
            //
        }  
    }
    /**
     * Loading method, using a JSONobject for easy access to data that has been written in txt-file
     * @return IPlayer with last games attributes
     * @throws IOException if file is not found
     * @throws JSONException if json if not found
     */
    @Override
    public IPlayer load() throws IOException, JSONException {
        String str = readFile("savePlayer.txt", StandardCharsets.UTF_8);
        JSONObject loadedPlayer = new JSONObject(str);
        
        IPlayer player = new Player(loadedPlayer.getString("name"));
        this.savedPlayerName = loadedPlayer.getString("name");

        player.setCurrentRoom(Integer.parseInt(loadedPlayer.getString("currentRoom")));
        player.setFlashlightUsed(Boolean.valueOf(loadedPlayer.getString("flashlightUsed")));
        player.setTimefromLoadedGame(Integer.parseInt(loadedPlayer.getString("totalGameTime")));
        player.rewardPoints(Integer.parseInt(loadedPlayer.getString("playerPoints")));
        player.setMaxCapacityFromLoad(Integer.parseInt(loadedPlayer.getString("maxCapacity")));
        
        int length = loadedPlayer.getJSONArray("item").length();
        
        for ( int i = 0; i < length; i++){
            player.addInventory(loadedPlayer.getJSONArray("item").get(i).toString());
        }

        return player;
    }
    
    /**
     * Short method for reading txt-file into java
     * @param path
     * @param encoding
     * @return
     * @throws IOException 
     */
    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public String getSavedPlayerName(){
        return this.savedPlayerName;
    }
 
}