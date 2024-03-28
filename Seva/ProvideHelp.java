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
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.lang.invoke.MethodHandles;
import java.security.interfaces.RSAKey;
public class ProvideHelp extends JFrame implements ActionListener{
       Choice cget2;
       List  cget;
        JLabel first,second;
        JButton b,b2,b3,b4,b5,acheck;
         String check,s2,sname,s3,m,oc,oc2,query,query2,query3;
         String statusi="Incomplete";
           String a="Completed";
     public ProvideHelp() {
        setLayout(null);
         setBounds(300, 100, 850, 550);
     
        getContentPane().setBackground(Color.cyan);
       
        cget= new List ();
       cget.addActionListener(this);
         cget.setBounds(260, 80, 150, 20);
          cget2= new Choice ();
           cget2.setBounds(260, 120, 150, 20);
        
          
          
        b=new JButton("GetInfo");
        b.addActionListener(this);
         b.setBounds(260, 170, 150, 20);
       
        acheck=new JButton("Available");
        acheck.addActionListener(this);
         acheck.setBounds(260, 190, 150, 20);

            b5=new JButton("Provide");
        b5.addActionListener(this);
           b5.setBounds(260, 370, 100, 20);
          first=new JLabel();
          first.setBounds(260,210,70,30);
          
       
        
        
         add(cget);
         add(cget2);
         add(b);
         
         
         add(acheck);
         add(first);
         add(b5);
        
        
       
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae){
          // m=ae.getActionCommand();
       oc=cget.getSelectedItem();
          oc2=cget2.getSelectedItem();
         
                  
          
          if(ae.getSource() ==b){
               
         try{
              
                 
                 DatabaseInfo c = new  DatabaseInfo ();
                query = "SELECT name FROM needinfo where sinfo='"+statusi+"'";
               ResultSet rs=c.s.executeQuery(query);
       
                         while(rs.next()){
                   //String s=rs.getString("name");
                   cget.add(rs.getString("name"));
                   
               
              
             
              } 
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
          
          }
          if (ae.getSource() ==cget) {
           
         try{
              
               DatabaseInfo c = new  DatabaseInfo ();
                query2 = "SELECT need FROM needinfo where name='"+oc+"'";
               ResultSet rs=c.s.executeQuery(query2);
      
               if(rs.next()){
                   cget2.removeAll();
                   cget2.add(rs.getString("need"));
                   
               
              
             
              } 
              
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
            }
      
      
    
      
         
         if(ae.getSource()==acheck){
         try{
              
                 String h=cget2.getSelectedItem();
                 DatabaseInfo c=new DatabaseInfo();
                 String info="Select help from helpinfo where help='"+h+"'";
                 ResultSet r=c.s.executeQuery(info);
                 if(r.next()){
                     first.setText(r.getString("help"));
                     second.setText("Available");
                 }
               
          
         }
         catch(Exception e){
         e.printStackTrace();
         }
         }
         
        
         if(ae.getSource() ==b5){
             
              // String oname=cget.getSelectedItem();
         try{
              
                 
                 DatabaseInfo c = new  DatabaseInfo ();
                
                String query="Update needinfo set sinfo='"+a+"' where name='"+cget.getSelectedItem()+"'";
               int rowsUpdated=c.s.executeUpdate(query);
                //String query2 = "UPDATE helpinfo SET ssinfo='"+a+"' WHERE name='"+s2+"'";
              // int RowsUpdated=c.s.executeUpdate(query2);
               
  
               
                  
        }
        catch(Exception e){
          e.printStackTrace();
        }
         }
     }

    
        
    public static void main(String[] args) {
        new ProvideHelp();
    }
    
}
