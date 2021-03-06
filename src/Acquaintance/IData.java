package Acquaintance;

import java.io.IOException;
import java.util.List;
import org.json.JSONException;

/**
 *
 * @author All
 */
public interface IData {
    
    /**
     * 
     * @return  a list of the highscore
     */
    public List<String> getHighscore();
    
    /**
     * 
     * @param name of the player
     * @param score of the player
     */
    public void addHighscore(String name, int score);
    
    
    public void save(IPlayer player);
    public IPlayer load()throws IOException, JSONException;
    
    String getSavedPlayerName();
}
