/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;

/**
 *
 * @author samar
 */ 


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class LoginForm extends JFrame implements ActionListener {

    JButton login, signin, cancel;
    JTextField username1, password1;
    Choice choice;
      JLabel msg1,msg2,msg3,msg4;
       String slogin;
      String uvalid,pvalid,susername,spassword,ocname;
     
   // JButton pay, close;

    public LoginForm(String sname) {
        ocname=sname;
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        msg1=new JLabel("Invalid Username!!!");
         add(msg1);
         msg2=new JLabel("Invalid Password!!!");
         add(msg2);
          msg3=new JLabel("Invalid Username!!!");
         add(msg3);
         msg4=new JLabel("Invalid Password!!!");
         add(msg4);
        JLabel title=new JLabel("LOGIN FORM");
        title.setBounds(330,5,200,80);
         title.setFont(new Font("Times new roman", Font.BOLD, 30));
        title.setForeground(Color.RED);
        add(title);
        JLabel loginas = new JLabel("Login As :");
        loginas.setBounds(300, 90, 80, 20);
        loginas.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(loginas);
        choice = new Choice();
        choice.add("Admin");
        choice.add("Organization");
        choice.add("Customer");
        choice.setBounds(400, 90, 150, 20);
        add(choice);
        JLabel username = new JLabel("Username :");
        username.setBounds(300, 140, 100, 20);
        username.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(username);
        username1 = new JTextField();
        username1.setBounds(400, 140, 150, 20);
        add(username1);
        JLabel password = new JLabel("Password :");
        password.setBounds(300, 190, 100, 20);
        password.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(password);
        password1 = new JTextField();
        password1.setBounds(400, 190, 150, 20);
        add(password1);
       
       /* login = new JButton("Login");
        login.setBackground(Color.green);
        login.setBounds(330, 230, 100, 20);
        login.addActionListener(this);*/
   
     ImageIcon il1 = new ImageIcon(ClassLoader.getSystemResource("icon/limage.png"));
        Image ill1 = il1.getImage().getScaledInstance(100, 40, Image.SCALE_DEFAULT);
        ImageIcon illl1 = new ImageIcon(ill1);
        login= new JButton(illl1);
        login.setBounds(330, 250, 100, 20);
        login.addActionListener(this);
        add(login);
        ImageIcon il2 = new ImageIcon(ClassLoader.getSystemResource("icon/simage3.png"));
        Image ill2 = il2.getImage().getScaledInstance(100, 40, Image.SCALE_DEFAULT);
        ImageIcon illl2 = new ImageIcon(ill2);
        signin = new JButton(illl2);
        //signin.setBackground(Color.cyan);
        signin.setBounds(450, 250, 100, 20);
        signin.addActionListener(this);
        add(signin);
        ImageIcon il3 = new ImageIcon(ClassLoader.getSystemResource("icon/cimage2.jpg"));
        Image ill3 = il3.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT);
        ImageIcon illl3 = new ImageIcon(ill3);
        cancel = new JButton(illl3);
        //cancel.setBackground(Color.red);
        cancel.setBounds(380, 300, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image i5 = i4.getImage().getScaledInstance(216, 233, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(5, 25, 300, 260);
        add(image2);
        setSize(640, 400);
        setVisible(true);
  
        setTitle("Login Page");
        setLocation(400, 150);

    }

    public void actionPerformed(ActionEvent ae) {
        int i=1;
       
        if (ae.getSource() == login) {
            susername = username1.getText();
            spassword = password1.getText();
            slogin = choice.getSelectedItem();
          
            JLabel message = new JLabel();
           // JButton check=login.get

           
        // do{
            try {
                  
                
               DatabaseInfo c = new  DatabaseInfo ();
                String query = "Select * from signupdetail where useby='" + slogin + "' and username='" + susername + "' and password='" + spassword + "'";
               ResultSet rs=c.s.executeQuery(query);
           
               if(rs.next()){
                  JOptionPane.showMessageDialog(null, " Login!!!");
                  new AdminDashboard(slogin,ocname);
                   setVisible(false);
                  uvalid=rs.getString("username");
                  pvalid=rs.getString("password");
                  i++;
                  
                // break;
                  
               }
              
           //new Project(slogin, meter);
                //ch++;
         else {
                 
              /*if(susername!=uvalid ){
                    if(spassword!=pvalid){
                msg3.setFont(new Font("Times new roman", Font.BOLD, 14));
                       msg3.setForeground(Color.RED);
                       msg3.setBounds(420, 160, 150, 20);

                       
                       msg4.setFont(new Font("Times new roman", Font.BOLD, 14));
                       msg4.setForeground(Color.RED);
                       msg4.setBounds(420, 210, 150, 20);
                    
                      

                       
                   JOptionPane.showMessageDialog(null, "Invalid Login!!!");
                   msg3.setVisible(false);
                    msg4.setVisible(false);
                    }
                    
                }
                if(susername==uvalid) {
                    if(spassword!=pvalid){
                      msg2.setFont(new Font("Times new roman", Font.BOLD, 14));
                       msg2.setForeground(Color.RED);
                       msg2.setBounds(420, 210, 150, 20);
                       
                       JOptionPane.showMessageDialog(null, "Invalid Login!!!");
                       msg2.setVisible(false); 
                    }
                  }
                else if(spassword==pvalid) {
                    if(susername!=uvalid){
                      msg1.setFont(new Font("Times new roman", Font.BOLD, 14));
                       msg1.setForeground(Color.RED);
                       msg1.setBounds(420, 210, 150, 20);
                       
                       JOptionPane.showMessageDialog(null, "Invalid Login!!!");
                       msg1.setVisible(false); 
                    }
                  }*/
               
                  
                     JOptionPane.showMessageDialog(null, "Invalid Login!!!");
                   
                       
                       
                   
                   
                    //username1.setText(" ");
                   // password1.setText(" ");
                  
                   }
           
       
            }catch (Exception e) {
                e.printStackTrace();
            }
       //  }while(ch!=6);
          
              
        } else if (ae.getSource() == signin) {
            setVisible(false);
            new SignUpPage();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else {
        }
      
    }
     
    public static void main(String[] args) {
        new LoginForm("");
    }
}
