/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;

/**
 *
 * @author samar
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class OrganizationStatus extends JFrame implements ActionListener {
    String orgname;
     Vector v;
     JButton cancel;
   JTable table;
    JScrollPane scrollPane;
    public OrganizationStatus(String oname) {
        orgname=oname;
         setLayout(null);
         setBounds(300, 100, 850, 550);

         
         try {
            
            DatabaseInfo c = new DatabaseInfo();
            
                  ResultSet rs = c.s.executeQuery("select * from needinfo where name='"+orgname+"'");
                       
            
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
           getContentPane().setBackground(Color.LIGHT_GRAY);
            setVisible(true);
            
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new OrganizationStatus("");
    }
}
