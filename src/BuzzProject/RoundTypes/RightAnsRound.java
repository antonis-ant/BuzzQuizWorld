
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;

/**
 * This class implements the right answer round type.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class RightAnsRound {
    private double scoreFactor; // the amount of points given/taken to/from player

    
    public RightAnsRound() {
    }

   
    /**
     * Sets the score factor for the specific round type
     * 
     * @param outFactor an outside parameter that changes the scoreFactor 
     * accordingly.
     */
    protected void setScoreFactor(double outFactor) {
        scoreFactor = outFactor;
    }
    
    protected double getScoreFactor() {
        return scoreFactor;
    }
    
    /**
     * This method changes the players' scores based on the round rules.
     * 
     * @param players the player(s) currently playing the round
     */
    public void play(Player[] players) {
        for(int i=0; i < players.length; i++) {
            if(players[i].getIsRight()) {
                setScoreFactor(players[i].getPlayerFactor()); // set the round's score factor from player
                players[i].updateScore(scoreFactor);
            }
        }
    } 
    
    
}