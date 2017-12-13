package UserInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class playerData {
    public String playerName, className, xCoord, yCoord, gameTime, playerPoints;
    
    public playerData() throws FileNotFoundException, IOException
    {
        File fr = new File("src\\PlayerDataText\\playerData.txt");

            BufferedReader br = new BufferedReader(new FileReader(fr));

            playerName = "";
            className = "";
            xCoord = "";
            yCoord = "";
            gameTime = "";
            playerPoints = "";


            playerName = br.readLine();
            className = br.readLine();
            xCoord = br.readLine();
            yCoord = br.readLine();
            gameTime = br.readLine();
            playerPoints = br.readLine();
            br.close();
    }
    
    public void setGameTime(String gtime)
    {
        this.gameTime = gtime;
    }
    
    public String getGameTime()
    {
        return gameTime;
    }
    
    public void setPlayerPoints(String points)
    {
        this.playerPoints = points;
    }
    
    public String getPlayerPoints()
    {
        return playerPoints;
    }
    
    public void savePlayerData(String pname, String cname, String xcoord, String ycoord) throws IOException
    {
                File fw = new File("src\\PlayerDataText\\playerData.txt");

                BufferedWriter bw = new BufferedWriter(new FileWriter(fw));  
                bw.write(pname);
                bw.newLine();
                bw.write(cname);
                bw.newLine();
                bw.write(xcoord);
                bw.newLine();
                bw.write(ycoord);
                bw.newLine();
                bw.write(getGameTime());
                bw.newLine();
                bw.write(getPlayerPoints());
                bw.close();  
    }
    
}
