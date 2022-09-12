/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuzzProject.GUI1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * This class implements a graphical window that only contains a table designed
 * to present the players' statistics to the user.
 * 
 * @author Αντωνιάδης Αντώνης 2718
 * @author Ανδρεάδης Ανδρέας 2729
 * @version 2.0
 */
public class StatsFrame extends JFrame {
    
    JTable statsTable;
    TableModel model;
    JScrollPane jsp;
    
    Object[][] rows;
    String[] colsTitles = {"Name", "SinglePlayer HighScore", "Multiplayer Wins"};
    
    
    
    public StatsFrame(Object[][] stats) {
        rows = stats;
        initComponents();
        
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setSize(600,400);
        setLocationRelativeTo(null);
        buildTable();
        jsp = new JScrollPane(statsTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(jsp,BorderLayout.CENTER);
        setVisible(true);
    }
    
    private void buildTable() {
        model = new DefaultTableModel(rows, colsTitles);
        statsTable = new JTable(model);
        // load the table
        
    }
}
