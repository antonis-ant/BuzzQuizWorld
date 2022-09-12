/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.Questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class handles the storing and organization of the questions. It provides 
 * methods to load and access the questions.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class QuestionManager {

    private final ArrayList<Question> questions;
    private BufferedReader qReader;

    public QuestionManager() {
        questions = new ArrayList<>();
    }
    
    /**
     *      Loads all questions from specified file.
     * 
     * @param fileName the name of the txt file to be loaded
     */
    public void loadQuestions(String fileName) { 
        try {
             qReader = new BufferedReader(new FileReader(fileName));
             String q; // a var that holds the question
             String cat; // a var that holds the category
             HashMap<String, Boolean> ans; // a HashMap that holds the answers
             String url;
             
             int count = 0;
              while((q = qReader.readLine()) != null) {
                 cat = qReader.readLine();
                 ans = new HashMap<>();
                 for(int i=0; i<4; i++) {
                     String parts[] = qReader.readLine().split(",");
                     ans.put(parts[0], Boolean.parseBoolean(parts[1]));
                 }
                 // check if picture also comes with image:
                 url = qReader.readLine();
                if(url.equals("")) {
                     addQuestion(new Question(q,cat,ans));
                     //qReader.readLine();
                 } else {
                     addQuestion(new PicQuestion(q,cat,ans,url));
                } 
                 
             }
        } catch (IOException e) {
            System.out.println("Could not open questions file. " + e);
        } finally {
            if(qReader != null) try {
                qReader.close();
            } catch(IOException e) {
                System.out.println("Error! Could not close questions file. " + e);
            }   
        }
    }

    /**
     *  Adds a question to the array list.
     *
     * @param q a question
     */
    public void addQuestion(Question q) {
        questions.add(q);
    }

    /**
     *     Fetches a random question from the question 's array list.
     *
     * @return a random question
     */
    public Question fetchRandomQuestion() {
        
        Random rq = new Random(System.currentTimeMillis());
        int size = questions.size();
        Question q = null;
        // check wether array is empty
        if(size > 0) {
            int index = rq.nextInt(size);
             q = questions.get(index);
        }
        return q;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }

}
