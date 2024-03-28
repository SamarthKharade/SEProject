/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;

/**
 *
 * @author samar
 */
import java.util.Set;
import java.util.HashSet;
 import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class HelpProvide extends JFrame implements ActionListener {
       List oinfo;
        Choice hinfo; 
        String status="Incomplete",status2="Completed",a="Completed",a2="Completed",s;
        String query,query2,query3,query4,query5,oname,hname;
        JButton geto,ca,cname,provide;
        JLabel d,dname;
        int rupdate,rupdate2;
    public HelpProvide()  {
        
        setLayout(null);
         setBounds(300, 100, 850, 550);
     
        getContentPane().setBackground(Color.cyan);
         oinfo= new List ();
       oinfo.addActionListener(this);
         oinfo.setBounds(260, 80, 150, 20);
          hinfo= new Choice ();
           hinfo.setBounds(260, 150, 150, 20);
           geto=new JButton("Get ODetails");
           geto.addActionListener(this);
           geto.setBounds(260,180,150,20);
           ca=new JButton("Check Avilable");
           ca.addActionListener(this);
           ca.setBounds(260,210,150,20);
           d=new JLabel();
           d.setBounds(260,270,70,20);
           cname=new JButton("Customer name");
           cname.addActionListener(this);
           cname.setBounds(260,230,150,20);
           cname.setVisible(false);
           dname=new JLabel();
           dname.setBounds(260,290,70,20);
           provide=new JButton("Provide");
           provide.addActionListener(this);
           provide.setBounds(260,330,150,20);
           add(oinfo);
           add(hinfo);
           add(geto);
           add(ca);
           add(d);
           add(cname);
           add(dname);
           add(provide);
           setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        oname=oinfo.getSelectedItem();
        hname=hinfo.getSelectedItem();
        
       if(ae.getSource()==geto){
           try{
              
                 
                 DatabaseInfo c = new  DatabaseInfo ();
                query = "SELECT name FROM needinfo where sinfo='"+status+"'";
               ResultSet rs=c.s.executeQuery(query);
               Set<String> names = new HashSet<>();
                       while(rs.next()){
                   //String s=rs.getString("name");
                   names.add(rs.getString("name"));
                  // oinfo.add(rs.getString("name"));
                   
               
              
             
              } 
                       for (String name : names) {
                oinfo.add(name);
            }
          
        }
        catch(Exception e){
          e.printStackTrace();
        }
       }
       if(ae.getSource()==oinfo){
           try{
              hinfo.removeAll();
                 
                 DatabaseInfo c = new  DatabaseInfo ();
                query = "SELECT need FROM needinfo where name='"+oname+"' and sinfo='"+status+"'";
               ResultSet rs=c.s.executeQuery(query);
       
                         while(rs.next()){
                            
                   //String s=rs.getString("name");
                   hinfo.add(rs.getString("need"));
                   
               
              
             
              } 
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
       }
     if(ae.getSource()==ca){
         
           try{
              
                 
                DatabaseInfo c = new  DatabaseInfo ();
                query2 = "SELECT helpinfo FROM helpinformation where helpinfo='"+hname+"'";
               ResultSet rs=c.s.executeQuery(query2);
       
                        if(rs.next()){
                   //String s=rs.getString("name");
                  
                   d.setText("Available");
                   cname.setVisible(true);
              
             
             } 
                       else{
                         d.setText("Unavailable");
                         }
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
       }
     if(ae.getSource()==cname){
           try{
              
                 
                 DatabaseInfo c = new  DatabaseInfo ();
                query3 = "SELECT name FROM helpinformation where helpinfo='"+hname+"'";
               ResultSet rs=c.s.executeQuery(query3);
       
                         if(rs.next()){
                   //String s=rs.getString("name");
                  
                   dname.setText(rs.getString("name"));
               
              
             
              } 
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
       }
     if(ae.getSource()==provide){
         String nameinfo=dname.getText();
           try{
                String v=d.getText();
                 if(v=="Available"){
                 DatabaseInfo c = new  DatabaseInfo ();
                 query4="Update needinfo set sinfo='"+a+"' where name='"+oname+"' and need='"+hname+"'";
               rupdate=c.s.executeUpdate(query4);
                  query5="Update helpinformation set sdetail='"+a2+"' where name='"+nameinfo+"' and helpinfo='"+hname+"'";
                 rupdate2=c.s.executeUpdate(query5);
             
                JOptionPane.showMessageDialog(null, " Help P!!!");
                hinfo.remove(hname);
                try{
                               
                 DatabaseInfo cc = new  DatabaseInfo ();
                query = "SELECT name FROM needinfo where name='"+oname+"' and sinfo='"+status2+"'";
               ResultSet rs=cc.s.executeQuery(query);
       
                         while(rs.next()){
                            
                   s=rs.getString("name");
                   //hinfo.add(rs.getString("need"));
                   
               
              
             
              } 
                   oinfo.remove(s);
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
                 }
                 else{
                 JOptionPane.showMessageDialog(null, " Help Not Available!!!");
                 }
           
        }
        catch(Exception e){
          e.printStackTrace();
        }
       }
    }
    
    
    public static void main(String[] args) {
        new HelpProvide();
    }
}
