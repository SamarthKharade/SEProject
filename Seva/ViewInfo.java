/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;
import Seva.*;
import com.mysql.cj.x.protobuf.Mysqlx;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.management.modelmbean.ModelMBean;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author samar
 */
public class ViewInfo extends JFrame implements ActionListener {
   JLabel createas, phoneno, uname, name, pass, email,address,rform,heading;
    Choice choice2;
    JButton cancel;
    Vector v;
   JTable table;
 JScrollPane scrollPane;
    JLabel phoneno2, uname2, name2, pass2,email2,address2;
    public ViewInfo(String s) {
         setLayout(null);
        setBounds(350, 100, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        
      String odetail="Organization";
        try {
            
            DatabaseInfo c = new DatabaseInfo();
            if(s=="Organization"){
                  ResultSet rs = c.s.executeQuery("select * from signupdetail where useby='"+s+"'");
                       
            
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
                
            }
            else{
                
            ResultSet rs = c.s.executeQuery("select * from signupdetail where useby='"+s+"'");
                       
            
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
            table = new JTable(tableModel);
           // table.setBounds(300,340,240,300);
                scrollPane = new JScrollPane(table);
            
            }
      
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollPane.setBounds(150,10,500,400);
         add(scrollPane);
          //this.pack();
           // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(340, 450, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(Color.cyan);
        setVisible(true);
       
       
        
    }
    
    public void actionPerformed(ActionEvent ae) {
                setVisible(false);
    }
    public static void main(String[] args) {
        new ViewInfo("");
    }
    
}
