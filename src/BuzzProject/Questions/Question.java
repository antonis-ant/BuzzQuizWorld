/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.Questions;
import java.util.HashMap;
import java.util.Set;

/**
 * This class implements a question by holding all the relative data. It also 
 * provides access methods for the question's data.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class Question {
    
    private final String question;
    private final String category;
    private final HashMap<String, Boolean> answers;
    private final HashMap<Character, Boolean> abcd; // a hashmap used to properly match letters(A - D) to the answers and identify which answer is true
    private boolean usedFlag; // a flag that indicates if the question has already been used
    
    
    /**
     *  This constructor "Builds" the question by initializing every field.
     * 
     * @param question a string which is the actual question
     * @param category a string which is the question's category
     * @param answers  a hash map of 4 answers 
     */
    public Question(String question, String category, HashMap<String, Boolean> answers) {
        
        this.question = question;
        this.category = category;
        this.answers = answers;
        abcd = new HashMap<>();
        usedFlag = false;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getCategory(){
        return category;
    }
    
    public boolean getUsedFlag(){
        return usedFlag;
    }
    
    public void setUsedFlag(boolean used){
        this.usedFlag = used;
    }
    
    public HashMap<String, Boolean>  getAnswers(){
        return new HashMap<>(answers);
    }
    
    /**
     *     A function that constructs a string which gives a form to the question.
     * The question should look like this:
     * Question "some question" 
     *  
     * A. answer
     * B. answer 
     * C. answer 
     * D. answer
     *
     
     * @return a string that represents the question.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // print the question and category
        sb.append(question).append(" ").append("<br>"); 
        Set<String> options = answers.keySet(); // get the question's answers
        char letter = '1';
        for (String ans : options) {
            abcd.put(letter, answers.get(ans));
            sb.append(letter++).append(". ");
            sb.append(ans).append("<br>");
        }
        return sb.toString();
    }
    
    /** 
     *     Checks if player's question is right
     * 
     * @param pA player's answer
     * @return true if player's answer is true and false if player's answer is false
     */
     public Boolean checkAnswer(char pA) {
        
        for(char ans : abcd.keySet()) {
            // right answer case
            // check if player's answer corresponds to a key with a value of true
            if(abcd.get(pA)) {
                return true;
            }
        }
        // wrong answer case
        return false;
        
    } 
     
    
}
