
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

// Create highscore list implementing interface
public class Data implements IData 
{
    Connection conn = null;
    private String ip = "jdbc:mysql://207.154.205.244/matador";
    private String userName = "tim_user";
    private String password = "Tim!Er&Dejlig932!";
    
    //Constructor - Automatically make connection to server
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
    
    //Method for retrieving top 10 scores and names from server
    @Override
    public List<String> getHighscore()
    {
        Statement statement = null;
        ResultSet result = null;
        List <String> HighScoreList = new ArrayList<>();
        
        try
        {
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM matador.highscore ORDER BY score DESC LIMIT 14");
            
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
    //Method for adding highscore to server list
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
    

    
    //Methods for saving and loading the Player-object locally
    
    
    
    public void save(IPlayer player) {
        try {
            PrintWriter pw = new PrintWriter("save.txt", "UTF-8");
            pw.println("{\"name\":\"" + player.getName() + "\"}");
            pw.println("{\"currentRoom\":\"" + player.getCurrentRoom() + "\"}");
            pw.println("{\"totalGameTime\":\"" + player.getRemainingTime() + "\"}");
            pw.println("{\"playerPoints\":\"" + player.getScore() + "\"}");
            pw.println("{\"maxCapacity\":\"" + player.getMaxCapacity() + "\"}");
            pw.println("{\"flashlightUsed\":\"" + player.getFlashlightUsed() + "\"}");
            pw.close();
        } catch (Exception ex) {
            //
        }  
    }
    
    public IPlayer load() throws IOException, JSONException {
        String str = readFile("save.txt", StandardCharsets.UTF_8);
        JSONObject loadedPlayer = new JSONObject(str);
        
        IPlayer player = new Player(loadedPlayer.getString("name"));
        player.setCurrentRoom(loadedPlayer.getString("currentRoom"));
        System.out.println("næste");
        int time = Integer.parseInt(loadedPlayer.getString("totalGameTime"));
        int score = Integer.parseInt(loadedPlayer.getString("playerPoints"));
        boolean flashlightUsed = Boolean.valueOf(loadedPlayer.getString("flashlightUsed"));
        
        player.setFlashlightUsed(flashlightUsed);
        player.setTimefromLoadedGame(time);
        player.rewardPoints(score);
        
        if (loadedPlayer.getString("maxCapacity") == "10"){
            //Do nothing
        } else if (loadedPlayer.getString("playerPoints") == "20"){
            player.increaseInventory(10);
        }
        System.out.println("HOLA");
        return player;
    }
    
    public String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
 
}