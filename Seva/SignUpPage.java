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
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpPage extends JFrame implements ActionListener {

    JButton register, cancel2, backtologin;
    JLabel createas, phoneno, uname, name, pass, email,address,rform;
    Choice choice2;
    JTextField phoneno2, uname2, name2, pass2,email2,address2;
    String nameinfo;
    public SignUpPage() {

        getContentPane().setBackground(Color.PINK);
        /* JPanel p1=new JPanel();
      p1.setBounds(40,40,600,300);
      p1.setBackground(Color.pink);*/

        //p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230,2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230))));
        //add(p1);
       rform = new JLabel("REGISTRATION FORM");
         rform.setForeground(Color.RED);
          rform.setBounds(100, 20, 380, 50);
          rform.setFont(new Font("Times new roman", Font.BOLD, 30));
        add(rform);

        createas = new JLabel("Create Account As:");
        createas.setBounds(100, 80, 140, 20);
        createas.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(createas);

        choice2 = new Choice();
        choice2.add("Admin");
        choice2.add("Organization");
        choice2.add("Customer");
        choice2.setBounds(260, 80, 150, 20);
        add(choice2);
        
        
        name = new JLabel("Name :");
        name.setBounds(100, 130, 140, 20);
        name.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(name);

        name2 = new JTextField();
        name2.setBounds(260, 130, 150, 20);
        add(name2);

        phoneno = new JLabel("Phone no :");
        phoneno.setBounds(100, 180, 140, 20);
        phoneno.setFont(new Font("Times new roman", Font.BOLD, 14));
        add( phoneno);

        phoneno2 = new JTextField();
         phoneno2.setBounds(260, 180, 150, 20);
        add(phoneno2);
        
        email= new JLabel("Email :");
        email.setBounds(100, 230, 140, 20);
       email.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(email);

        email2= new JTextField();
        email2.setBounds(260, 230, 150, 20);
        add(email2);

        address= new JLabel("Address :");
        address.setBounds(100, 280, 140, 20);
        address.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(address);

        address2= new JTextField();
        address2.setBounds(260, 280, 150, 20);
        add(address2);
        
        uname = new JLabel("Username :");
        uname.setBounds(100, 330, 140, 20);
        uname.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(uname);

        uname2 = new JTextField();
        uname2.setBounds(260, 330, 150, 20);
        add(uname2);


       /* mnumber.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {

            }

            public void focusLost(FocusEvent fe) {
                try {
                     Database c = new Database();
                    ResultSet rs = c.s.executeQuery("Select * from login where meter_no='" + mnumber.getText() + "'");
                    while (rs.next()) {
                        name2.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/

        pass = new JLabel("Password :");
        pass.setBounds(100, 380, 140, 20);
        pass.setFont(new Font("Times new roman", Font.BOLD, 14));
        add(pass);

        pass2 = new JTextField();
        pass2.setBounds(260, 380, 150, 20);
        add(pass2);

       /* choice2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String user = choice2.getSelectedItem();
                if (user.equals("Customer")) {
                    meter.setVisible(true);
                    mnumber.setVisible(true);
                    name2.setEditable(false);
                } else {
                    meter.setVisible(false);
                    mnumber.setVisible(false);
                    name2.setEditable(true);
                }
            }

        });*/

       ImageIcon is1 = new ImageIcon(ClassLoader.getSystemResource("icon/simage3.png"));
        Image iss1 = is1.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT);
        ImageIcon isss1 = new ImageIcon(iss1);
        register = new JButton(isss1);
        //register.setBackground(Color.green);
        register.setBounds(120, 430, 100, 20);
        register.addActionListener(this);
        add(register);
        
        ImageIcon is2 = new ImageIcon(ClassLoader.getSystemResource("icon/cimage2.jpg"));
        Image iss2 = is2.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT);
        ImageIcon isss2 = new ImageIcon(iss2);
        cancel2 = new JButton(isss2);
       // cancel2.setBackground(Color.red);
        cancel2.setBounds(280, 430, 100, 20);
        cancel2.addActionListener(this);
        add(cancel2);
        
       
        

        backtologin = new JButton("Back To Login");
        backtologin.setBackground(Color.yellow);
        backtologin.setBounds(180, 480, 150, 20);
        backtologin.addActionListener(this);
        add(backtologin);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/sign.png"));
        Image i8 = i7.getImage().getScaledInstance(257, 246, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(420, 50, 257, 380);
        add(image3);

        setLayout(null);
        //setSize(640,300);
        setBounds(150, 150, 700, 550);
        setVisible(true);
        setTitle("Regesteration Page");
        setLocation(400, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {
            String atype = choice2.getSelectedItem();
            String sname = name2.getText();
            String sphoneno = phoneno2.getText();
            String semail = email2.getText();
            String saddress = address2.getText();
            String susername = uname2.getText();
            nameinfo=name2.getText();
            String spassword = pass2.getText();
            //String smeter = mnumber.getText();

            try{
                DatabaseInfo c = new DatabaseInfo();
                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into signupdetail  values('"+atype+"','" + sname + "','" + sphoneno + "','" + semail + "','" + saddress + "','" + susername+ "','"+spassword+"')";
                }
                else if(atype.equals("Organization")){
                query = "insert into signupdetail values('"+atype+"','" + sname + "','" + sphoneno + "','" + semail + "','" + saddress + "','" + susername+ "','"+spassword+"')";
                }
                else if (atype.equals("Customer")){
                    query = "insert into signupdetail values('"+atype+"','" + sname + "','" + sphoneno + "','" + semail + "','" + saddress + "','" + susername+ "','"+spassword+"')";
                }
                
                int i=c.s.executeUpdate(query);
                
     
                JOptionPane.showMessageDialog(null, "Account Created Successfully!!!");
                setVisible(false);
                new LoginForm(nameinfo);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel2) {
            setVisible(false);
        } else if (ae.getSource() == backtologin) {

            //new LoginPage();
            setVisible(false);
            new LoginForm(nameinfo);
        } else {

        }
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
