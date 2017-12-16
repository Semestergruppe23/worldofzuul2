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
    
    //The hallucination pops up, happens when the player intersects with the imageview representing the hallucination (hidden at first)
    public void hallucinationPopsUp(ImageView view, Label dialogueLabel, IBusiness business){
        if(this.hallucinationAlreadyPoppedUp == false){ //If this is the first time, the hallucination has popped up
            view.setVisible(true); //Show the image of the hallucination
            dialogueLabel.setText(business.getNPC().generateQuestion()); //Set the text on the Label to the text generated from the NPC class in the businesslayer
        }
    }
    //Gets and checks the players answer, with a button click, implemented in the rooms, the hallucination pops up in
    public void questioning(String answer, IBusiness business, Label dialogueLabel, ImageView view){
        if(this.hallucinationAlreadyPoppedUp == false){ //Checks this is the first time the hallucination popped up
            if(business.getNPC().checkAnswer(answer) == true){ //If the answer (A, B or C) is right
                dialogueLabel.setText("That's right!"); //Sets the text on the Label
                business.getPlayer().rewardPoints(200); //Gives the player 200 points
                this.hallucinationAlreadyPoppedUp = true; //So that the hallucination does not pop up again
                view.setVisible(false); //Makes the imageview hidden
            } else{
                dialogueLabel.setText("Noo... That's not right..");
                business.getPlayer().removeTime(30);
                this.hallucinationAlreadyPoppedUp = true;
                view.setVisible(false);
            }
        }
    }
}
