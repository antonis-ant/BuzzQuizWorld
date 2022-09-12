/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.RoundTypes;

import BuzzProject.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DoubleA
 */
public class StopWatchRoundTest {
    
    private Player[] players1;
    private String name1;
    private Player p1;
         
    public StopWatchRoundTest()  {
        players1 = new Player[1];
        p1= new Player(name1);
        p1.setIsRight(true);
        p1.setPlayerFactor(1000);
        players1[0] = p1;
        
    }
    
    /**
     * Test of play method, of class RightAnsRound.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        
        StopWatchRound instance = new StopWatchRound();
        instance.play(players1);
        double expResult = 1000*0.2;
        double result = players1[0].getScore();
        assertEquals(expResult, result, 0);
       
    }
    
}
