/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;

/**
 * This class implements the faster answer round.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class FasterAnsRound extends RightAnsRound {

    public FasterAnsRound() {
        super();
    }

    /**
     * This method changes the players' scores based on the round rules.
     * 
     * @param players the player(s) currently playing the round
     */
    @Override
    public void play(Player[] players) {
        
        for (int i=1; i < players.length; i++) {
            // check if both players answered correclty
            if (players[i].getIsRight() && players[i-1].getIsRight()) {
                // check which player answered first and change score accordingly
                if (players[i].getPlayerFactor() < players[i-1].getPlayerFactor()) {
                    players[i].updateScore(1000);
                    players[i-1].updateScore(500);
                } else {
                    players[i].updateScore(500);
                    players[i-1].updateScore(1000);
                }
            // check if only 1 player answered correctly
            } else if(players[i].getIsRight()) {
                players[i].updateScore(1000);
            } else if(players[i-1].getIsRight()) {
                players[i-1].updateScore(1000);
            }
            // if none of the players answered correctly do nothing
        }
    }
}
