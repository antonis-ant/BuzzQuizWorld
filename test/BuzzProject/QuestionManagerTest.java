/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;


import BuzzProject.Questions.QuestionManager;
import BuzzProject.Questions.Question;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 */
public class QuestionManagerTest {
    
    public QuestionManagerTest() {
    }
    
    /**
     * Test of addQuestion method, of class QuestionManager.
     */
    @Test
    public void testAddQuestion() {
        
        System.out.println("addQuestion");
        Question q = new Question("testQuestion","testCat",null);
        QuestionManager instance = new QuestionManager();
        instance.addQuestion(q);
        ArrayList<Question> list = new ArrayList<>();
        list.add(q);
        assertEquals(instance.getQuestions(),list);  //[] vs null
      
    }

    /**
     * Test of fetchRandomQuestion method, of class QuestionManager.
     * Tests the case in which the array list with the questions is empty. 
     */
    @Test
    public void testFetchRandomQuestion() {
        
        System.out.println("fetchRandomQuestion");
        QuestionManager instance = new QuestionManager();
        Question expResult = null;
        Question result = instance.fetchRandomQuestion();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of fetchRandomQuestion method, of class QuestionManager.
     * Tests the case in which the array list with the questions is not empty. 
     */
    @Test
    public void testFetchRandomQuestion2() {
        
        System.out.println("fetchRandomQuestion2");
        QuestionManager instance = new QuestionManager();
        Question q = new Question("testQ", "testC", null);
        instance.addQuestion(q);
        String expResult = q.getQuestion();
        String result = instance.fetchRandomQuestion().getQuestion();
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testLoadQuestions() {
        QuestionManager qmInstance = new QuestionManager();
        qmInstance.loadQuestions("questions_gr.txt");
        if(qmInstance.getQuestions() == null) {
            fail("No Questions Were Loaded");
        }
    }
    
}
