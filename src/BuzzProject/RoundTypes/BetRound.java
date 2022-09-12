/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;

/**
 * This class implements the bet round type.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class BetRound extends RightAnsRound {
    /**
     *     Constructor
     */
   public BetRound() {
        super();  
    }
   
    /**
     * This method changes the players' scores based on the round rules.
     * 
     * @param players the player(s) currently playing the round
     */
    @Override
    public void play(Player[] players) {
        for(int i=0;i<players.length; i++) {
            if(players[i].getIsRight()) {
                setScoreFactor(players[i].getPlayerFactor());
                players[i].updateScore(getScoreFactor());
            }
        }
    }

}
