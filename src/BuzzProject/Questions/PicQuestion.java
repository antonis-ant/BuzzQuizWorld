/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.Questions;

import java.io.IOException;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * This class extends the Question class and can hold an a Question with an image.
 * To load a picture just give the icon url to constructor.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class PicQuestion extends Question{
    //private final BufferedImage image;
    private final ImageIcon img;
    
    public PicQuestion(String question, String category, HashMap<String, Boolean> answers, String url) throws IOException{
        super(question, category, answers);
        img = new ImageIcon(url);

    }
    
    @Override
    public String getQuestion() {
        return super.getQuestion();
    }
    
    @Override
    public String getCategory() {
        return super.getCategory();
    }
    
    @Override
     public boolean getUsedFlag(){
        return super.getUsedFlag();
    }
    
    @Override
    public void setUsedFlag(boolean used){
        super.setUsedFlag(used);
    }
    
    @Override
    public HashMap<String, Boolean>  getAnswers(){
        return super.getAnswers();
    }
    
    public ImageIcon getImage() {
        return img;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public Boolean checkAnswer(char pA) {
        return super.checkAnswer(pA);
    }
    
    
    
}
