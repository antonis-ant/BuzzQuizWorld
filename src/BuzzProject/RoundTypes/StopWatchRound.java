/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;
/**
 * This class implements the stopwatch round type.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class StopWatchRound extends RightAnsRound{
    
    public StopWatchRound() {
        super();
    }
    
    /**
     * This method checks if players have answered correctly to the question and
     * changes their score according to the time left after player gave the
     * answer.
     * 
     * @param players the players currently playing the round
     */
    @Override
    public void play(Player[] players) {
        double time;
        for(int i=0; i<players.length; i++) {
            time = players[i].getPlayerFactor();// get remaining time after players answer 
            if(players[i].getIsRight() && time > 0) {
                setScoreFactor(time*0.2);// set the score factor for specific round
                players[i].updateScore(getScoreFactor());
            }
               
        }
            
    }
}
