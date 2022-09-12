/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

import BuzzProject.Questions.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 */
public class GameTest {
    
    private final Game gameInstance;
    private final Game instance2p;
    private Player testP;
    
    public GameTest() throws IOException {
        gameInstance = new Game(1,new Locale("en","US"));
        instance2p = new Game(2,new Locale("en","US"));
        testP = null;
        
    }
    
    /**
     * Test of initializePlayer method, of class Game.
     */
    @Test
    public void testInitializePlayer() {
        // v2.0
        System.out.println("initializePlayer");
        String expNameRes = "Tony";
        testP = gameInstance.initializePlayer(expNameRes);
        String nameRes = testP.getName();
        assertEquals(expNameRes, nameRes);
        
    }

   
    /**
     * Test of getQuestionsForRound method, of class Game.
     */
    @Test
    public void testGetQuestionsForRound() {
        System.out.println("getQuestionsForRound");
        
        ArrayList<Question> qs = gameInstance.getQuestionsForRound();
        if(qs.isEmpty()||qs.size() != gameInstance.getQuestionsPerRound()){
          fail("Something is wrong");
        }
        
    }

    /**
     * Test of getRandomType method, of class Game.
     */
    @Test
    public void testGetRandomType() {
        System.out.println("getRandomType");
        int result = gameInstance.getRandomType();
        if(result < 0 || result >= 5){
          fail("Type must be between 0 and 4");  
        }
    }
    
    @Test
    public void testInitializeRound() {
        ArrayList<Question> result = gameInstance.initializeRound();
        ArrayList<Question> expResult;
        int type = gameInstance.getRoundType();
        if(type < 0 || type >= 5 ) {
            expResult = null;
        } else{
            expResult = result;
        }
        assertEquals(expResult, result);
        
    }
    
}
