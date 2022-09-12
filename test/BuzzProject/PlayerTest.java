/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 */
public class PlayerTest {
    
    private final Player instance;
    
    public PlayerTest() {
        instance = new Player("testPlayer");
    }
    
    /**
     * Test of updateScore method, of class Player.
     */
    @Test
    public void testUpdateScore() {
        System.out.println("updateScore");
        double points = 1000.0;
        instance.updateScore(points);
        double expResult = 1000.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0);
       
    }

    
}
