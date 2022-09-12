/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

/**
 * This class illustrates a player and holds all the data associated with the
 * player. It also provides access methods for the player's data.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class Player {
    
    private final String name;
    private double score;
    private char answer;
    private boolean isRight;
    private double playerFactor; // holds a score factor that depends on 
   
    
    public Player(String name) {
        score = 0;
        playerFactor = 0;
        this.name = name;
        answer = ' ';
    }
    
    public char getAnswer() {
        return answer;
    }
    
    public void setAnswer(char answer) {
        this.answer = answer;
    }
    
    public boolean getIsRight() {
        return isRight;
    }
    
    public void setIsRight(boolean r) {
        isRight = r;
    }
    
    public double getPlayerFactor() {
        return playerFactor;
    }
    public void setPlayerFactor(double pFactor) {
        this.playerFactor = pFactor;
    }
    
    public double getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     *     Adds(or removes) points to (from) the player's score.
     * 
     * @param p points to be added (removed)
     */
    public void updateScore(double p){
        score+=p;
    }
    
   
   
}
