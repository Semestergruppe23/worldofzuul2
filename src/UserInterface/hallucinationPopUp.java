/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author Oskar
 */
public class hallucinationPopUp {
    
    boolean hallucinationAlreadyPoppedUp = false;
    
    //Implementer med collideWithImageView metoden overriddet
    public void hallucinationPopsUp(ImageView view, Label dialogueLabel, IBusiness business){
        if(this.hallucinationAlreadyPoppedUp == false){
            view.setVisible(true);
            dialogueLabel.setText(business.getNPC().generateQuestion());
        }
    }
    //Implementer under alle tre knapper
    public void questioning(String answer, IBusiness business, Label dialogueLabel, ImageView view){
        if(this.hallucinationAlreadyPoppedUp == false){
            if(business.getNPC().checkAnswer(answer) == true){
                dialogueLabel.setText("That's right!");
                business.getPlayer().rewardPoints(200);
                this.hallucinationAlreadyPoppedUp = true;
                view.setVisible(false);
            } else{
                dialogueLabel.setText("Noo... That's not right..");
                business.getPlayer().removeTime(30);
                this.hallucinationAlreadyPoppedUp = true;
                view.setVisible(false);
            }
        }
    }
}
