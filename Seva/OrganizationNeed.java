/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author samar
 */
public class OrganizationNeed extends JFrame implements ActionListener {
    String s="Incomplete";
   Vector v;
     JButton cancel;
   JTable table;
    JScrollPane scrollPane;
    public OrganizationNeed() {
        
        setLayout(null);
         setBounds(300, 100, 850, 550);

         
         try {
            
            DatabaseInfo c = new DatabaseInfo();
            
                  ResultSet rs = c.s.executeQuery("select useby,name,need from needinfo where sinfo='"+s+"'");
                       
            
             ResultSetMetaData metaData = rs.getMetaData();
                int count = metaData.getColumnCount();

          DefaultTableModel tableModel = new DefaultTableModel();
           for (int columnIndex = 1; columnIndex <= count; columnIndex++) {
                    tableModel.addColumn(metaData.getColumnLabel(columnIndex));
                }
            while (rs.next()) {
              Object[] row = new Object[count];
             // v=new Vector();
                    for (int i = 0; i < count; i++) {
                       row[i] = rs.getObject(i + 1);
                      
                    }
                    tableModel.addRow(row);
            }
            table= new JTable(tableModel);
           // table.setBounds(300,340,240,300);
                scrollPane = new JScrollPane(table);
                
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
          scrollPane.setBounds(150,10,500,400);
         add(scrollPane);
     cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(340, 450, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    
    public static void main(String[] args) {
        new OrganizationNeed();
    }
}
