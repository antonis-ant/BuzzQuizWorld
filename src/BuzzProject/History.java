/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * A class that implements the archiving of the players' score for the 
 * single-player game and the players' total wins in the multi-player game.
 * This implementation provides methods that update player statistics and save 
 * them permanently to a file on the disk. It also provides methods to get the 
 * players' statistics in a presentable form.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class History {
    
    private final HashMap<String,Double[]> playerStats;
    private Double stats[];
    
    public History() {
        playerStats = new HashMap<>();
    }
    
    /**
     * This method increments wins of given player name. 
     * 
     * @param p a player object.
     */
    public void updateWins(Player p) {
        String name = p.getName();
        // check if name is already registered
        if(playerStats.containsKey(name)) {
           Double s[] = playerStats.get(name);
           s[0]++;
           playerStats.put(name, s);
        // if name does not exist, add it and initialize its stats
        } else {
            stats = new Double[2];
            stats[0] = 1.0;
            stats[1] = 0.0;
            playerStats.put(name,stats);
        }
    }
    /**
     * This function updates the given players high-score.
     * 
     * @param p a player object
     */
    public void updateScore(Player p) {
       String name = p.getName();
       Double score = p.getScore();
       if(playerStats.containsKey(name)) {
           if(playerStats.get(name)[1] < score) {
               Double s[] = playerStats.get(name);
               s[1] = score;
               playerStats.put(name, s);
           }
        // if name does not exist, add it and create its stats
        } else {
            stats = new Double[2];
            stats[0] = 0.0;
            stats[1] = score;
            playerStats.put(name,stats);
        }
        
    }
    
    /**
     * This function saves the 1player and 2player game statistics to the 
     * "stats.bin" file.
     * 
     * @throws java.io.IOException
     */
    public void saveStatistics() throws IOException {
        // check if file was opened successfuly.
        try (DataOutputStream statsOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("stats.bin")))) {
            for(String name : playerStats.keySet()) {
                statsOut.writeUTF(name);
                statsOut.writeDouble(playerStats.get(name)[0]);
                statsOut.writeDouble(playerStats.get(name)[1]);
            }    
        }
    }
    
    /**
     * This function loads all saved statistics from a data file to a hash map.
     * 
     * @throws IOException 
     */
    public void loadStatistics() throws IOException {
        try (DataInputStream statsIn = new DataInputStream(new BufferedInputStream(new FileInputStream("stats.bin")))) {
            while(true) {
                String name = statsIn.readUTF();
                Double[] sts = new Double[2];
                sts[0] = statsIn.readDouble();
                sts[1] = statsIn.readDouble();
                playerStats.put(name,sts);
            }
        } catch(EOFException e) {
            
        }
    }
    
    /**
     * This method converts the players data to a 2 dimensional table in order
     * to present them in a gui table.
     * 
     * @return 
     */
    public Object[][] toTable() {
        Object[][] statsTable = new Object[playerStats.size()][3];
        int i = 0;
        for(String name : playerStats.keySet()) {
            statsTable[i][0] = name;
            statsTable[i][1] = playerStats.get(name)[1].intValue();
            statsTable[i][2] = playerStats.get(name)[0].intValue();
            i++;
        }
       return statsTable;
       
    }
    
} 
        

