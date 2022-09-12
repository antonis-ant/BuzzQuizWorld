/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

import BuzzProject.Questions.QuestionManager;
import BuzzProject.Questions.Question;
import BuzzProject.RoundTypes.RightAnsRound;
import BuzzProject.RoundTypes.BetRound;
import BuzzProject.RoundTypes.StopWatchRound;
import BuzzProject.RoundTypes.FasterAnsRound;
import BuzzProject.RoundTypes.ThermometerRound;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 *  This class contains the main logic of the application. It performs all the 
 * vital operations that define the game-flow and functionality.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class Game {

    private static final int QUESTIONS_PER_ROUND = 5;

    private final QuestionManager qm;
    private final Player[] players;
    private int plCount; // a counter for the players
    private final int playerSum;
    private int roundType;
    private final boolean multiplayer;
    private RightAnsRound round;
    private final History stats;
    private final Locale locale;

    /**
     * This constructor Initialize the question manager and loads the 
     * questions to the array list
     *
     * @param pSum the number of players playing the game.
     * @param loc
     * @throws java.io.IOException if file load fails
     */
    public Game(int pSum, Locale loc) throws IOException {
        
        qm = new QuestionManager();
        locale=loc;
        if(locale.getLanguage().equals("el")){
             qm.loadQuestions("questions_gr.txt");

        }
        if(locale.getLanguage().equals("en")){
            qm.loadQuestions("questions_en.txt");
        }
        stats = new History();
        stats.loadStatistics(); // load stats from file
        playerSum = pSum;
        players = new Player[playerSum];
        plCount = -1;
        roundType = 0;
        multiplayer = playerSum > 1;
    }
    
    /**
     * This method updates a players high-score stats in single-player game.
     * 
     * @param p the player
     * @throws java.io.IOException in case stats file could not be saved
     */
    public void updateStats_sP(Player p) throws IOException {
        stats.updateScore(p);
        stats.saveStatistics();
    }
    
    /**
     * This method updates a players high-score stats in multi-player game.
     * 
     * @param winner the player who won in multi-player game.
     * @throws java.io.IOException in case stats file could not be opened
     */
    public void updateStats_mP(Player winner) throws IOException {
        stats.updateWins(winner);
        stats.saveStatistics();
    }
    
    /**
     * This method finds and returns the player with the highest score as the 
     * winner in multi-player game.
     * 
     * @return the player with the highest score(winner).
     */
    public Player getWinner() {
        double max = 0;
        int index = 0;
        for(int i=0; i<playerSum; i++) {
            if(players[i].getScore() > max) {
                max = players[i].getScore();
                index = i;
            }
        }
     
        return players[index];
    }
   
    /**
     * This method gets the player statistics from the History class in a 
     * 2-dimensional array form and returns it.
     * 
     * @return a 2d array with the player's statistics
     */
    public Object[][] getStats() {
        Object[][] statsArr = stats.toTable();
        return statsArr;
       
    }
    
    /**
     * Initializes a player object
     *
     * @param name player's name
     * @return player the player object created
     */
    public Player initializePlayer(String name) {
        plCount++;
        players[plCount] = new Player(name);
        
        return players[plCount]; // return current player and increment playercounter
    }

    /**
     * This method starts a new round
     *
     * @return a new round created
     */
     public ArrayList<Question> initializeRound() {
        // get a random integer which represent the round type.
        getRandomType();
        ArrayList<Question> questions = getQuestionsForRound();
        switch(roundType) {
            case 0:
                round = new RightAnsRound();
                return questions;
            case 1:
                round = new BetRound();
                return questions;
            case 2:
                round = new StopWatchRound();
                return questions;
            case 3:
                round = new FasterAnsRound();
                return questions;
            case 4:
                round = new ThermometerRound();
                return questions;
            default:
                return null;
        }
       
    }
     
    /**
     * This getter-function returns the current round type.
     * @return the current round type
     */
    public int getRoundType() {
        return roundType;
    }
    
    /**
     * This function returns the number of questions for the round
     * @return the number of questions for current round
     */
    public int getQuestionsPerRound() {
        return QUESTIONS_PER_ROUND;
    }

    /**
     * This method gets 5(=QUESTIONS_PER_ROUND) random questions and stores them
     * in an ArrayList only if questions has not been used before.
     *
     * @return an array list of 5(=QUESTIONS_PER_ROUND) questions
     */
    public ArrayList<Question> getQuestionsForRound() {

        ArrayList<Question> qsForRound = new ArrayList();
        Question randQ; // a random question
        for (int i = 0; i < QUESTIONS_PER_ROUND; i++) {
            do {
                randQ = qm.fetchRandomQuestion(); // get a random question  
            } while (randQ.getUsedFlag() == true); // check if question was used in current game
            qsForRound.add(randQ); // add it to the array.
            randQ.setUsedFlag(true); // flag question as used.
        }
        
        return qsForRound;
    }

    /**
     * This method produces a random value which represents the round type
     *
     * @return type a random integer between 0 and 3 for single-player game or
     * a random integer between 0 and 4 for multi-player game
     */
    public int getRandomType() {
        Random rt = new Random(System.currentTimeMillis());
        if (multiplayer) {
            roundType = rt.nextInt(4);
        } else {
            roundType = rt.nextInt(3);
        }
        //roundType = 4;
        return roundType;
    }
    
    /**
     *  This method illustrates the round game routine.
     * 
     * @param q the current question asked to player(s)
     */
    public void playRound(Question q) {
        boolean isRight;
        for(int i=0; i < playerSum; i++) {
            isRight = q.checkAnswer(players[i].getAnswer()); // check if player's answer correct
            players[i].setIsRight(isRight);// flag player's answer accordingly 
        }
        round.play(players);
    }

}
