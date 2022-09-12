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
public class ThermometerRoundTest {
    
    private Player[] players1;
    private Player p1;
    private Player p2;
       
    public ThermometerRoundTest() {
        players1 = new Player[2];
        p1= new Player("test1");
        p1.setIsRight(true);
      //  p1.setPlayerFactor(5000);
        players1[0] = p1;
        
        p2= new Player("test2");
        p2.setIsRight(false);
        //p2.setPlayerFactor();
        players1[1] = p2;
        
    }
    
    /**
     * Test of play method, of class FasterAnsRound.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        
        ThermometerRound instance = new ThermometerRound();
        for(int i=0;i<5;i++){
            instance.play(players1);
        }
        double result1 = players1[0].getScore();
        double expResult1 = 5000;
        double result2 = players1[1].getScore();
        double expResult2 = 0;
        assertEquals(expResult1, result1,0);
        assertEquals(expResult2, result2,0);


        
    }
        
}
