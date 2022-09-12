/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

import BuzzProject.Questions.Question;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 */
public class QuestionTest {
    private final Question instance;
    
    public QuestionTest() {
       instance = new Question("testQestion", "testCategory", new HashMap<String, Boolean>() {
            {
                put("test a", false);
                put("test b", false);
                put("test c", true);
                put("test d", false);
            }}
            
        );
    }
    
    /**
     * Test of toString method, of class Question.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String result = instance.toString();
        assertNotEquals(null, result);
     
    }

    /**
     * Test of checkAnswer method, of class Question.
     */
    @Test
    public void testCheckAnswer() {
        
        System.out.println("checkAnswer");
        char pA = '3';  
        Boolean expResult = false;
        Boolean result = instance.checkAnswer(pA);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }
    
}
