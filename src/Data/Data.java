
package Data;

import Acquaintance.IData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
            result = statement.executeQuery("SELECT * FROM matador.highscore ORDER BY score DESC LIMIT 17");
            
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
}