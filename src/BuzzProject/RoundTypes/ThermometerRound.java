/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;

/**
 * This class implements the thermometer round type.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class ThermometerRound extends RightAnsRound{
    
    public ThermometerRound() {
        super();
    }
    
    /**
     * This method checks if a player has answered correctly 5 questions in a row
     * and if so, it increments his score by 5000.
     * @param players the players currently playing the round
     */
    @Override
    public void play(Player[] players) {
        setScoreFactor(5000); // set round's score factor
        for(int i=0; i<players.length; i++) {
            // check if player gave right answer
            if(players[i].getIsRight()) {
                // get player's current number of continous right answers,
                double rCounter = players[i].getPlayerFactor(); 
                rCounter++; // and increment them by 1.
                players[i].setPlayerFactor(rCounter);// update the player factor
                // check if player answered 5 questions correclty
                if(rCounter == 5) {
                    players[i].updateScore(getScoreFactor());
                    return;
                }
            // if player's answer is incorrect reset the counter to 0 
            } else {
                players[i].setPlayerFactor(0);
            }
        }
    } 
    
}
