/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;
import Seva.*;
import Seva.organization.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author samar
 */
public class AdminDashboard extends JFrame implements ActionListener{
             String msg;
             JMenu admin,Oneed,Chelp,Hstatus,cd,org,orgNeedInfo,Ostatus,customerD,cHelpInfo,CStatus;
              String slogin,ocname;
    public AdminDashboard(String slogin,String name){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         ocname=name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seva2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        admin = new JMenu("View Information");
        admin.setForeground(Color.BLUE);
        
        JMenuItem newCustomer = new JMenuItem("Organization");
        newCustomer.setFont(new Font("Times new roman", Font.PLAIN, 12));
        newCustomer.setBackground(Color.WHITE);
        newCustomer.addActionListener(this);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image1);
        newCustomer.setIcon(icon2);
        admin.add(newCustomer);

        JMenuItem customerDetails = new JMenuItem("Customer");
        customerDetails.setFont(new Font("Times new roman", Font.PLAIN, 12));
        customerDetails.setBackground(Color.WHITE);
        customerDetails.addActionListener(this);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image2 = icon3.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(image2);
        customerDetails.setIcon(icon4);
        admin.add(customerDetails);
        
        Oneed = new JMenu("Organization Need");
        
        Oneed.setForeground(Color.BLUE);
        JMenuItem seeNeed = new JMenuItem("Need Details");
        seeNeed.setFont(new Font("Times new roman", Font.PLAIN, 12));
        seeNeed.setBackground(Color.WHITE);
        seeNeed.addActionListener(this);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image6 = icon11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon12 = new ImageIcon(image6);
        seeNeed.setIcon(icon12);
        Oneed.add(seeNeed);
        
        JMenuItem phelp = new JMenuItem("Provide Need");
        phelp.setFont(new Font("Times new roman", Font.PLAIN, 12));
        phelp.setBackground(Color.WHITE);
        phelp.addActionListener(this);
        ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image5 = icon9.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon10 = new ImageIcon(image5);
        phelp.setIcon(icon10);
        Oneed.add(phelp);
        
        Chelp = new JMenu("Customer Help");
        Chelp.setForeground(Color.BLUE);
        JMenuItem vhelp = new JMenuItem("Help Details");
        vhelp.setFont(new Font("Times new roman", Font.PLAIN, 12));
        vhelp.setBackground(Color.WHITE);
        vhelp.addActionListener(this);
        ImageIcon icon13= new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image7 = icon13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon14 = new ImageIcon(image7);
        vhelp.setIcon(icon14);
        Chelp.add(vhelp);
        
        Hstatus=new JMenu("Status");
        Hstatus.setForeground(Color.BLUE);
        
          JMenuItem ostatus = new JMenuItem("Organization Status");
        ostatus.setFont(new Font("Times new roman", Font.PLAIN, 12));
        ostatus.setBackground(Color.WHITE);
        ostatus.addActionListener(this);
        ImageIcon icon15= new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image8 = icon15.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon16 = new ImageIcon(image8);
        ostatus.setIcon(icon16);
        Hstatus.add(ostatus);
        
          JMenuItem cstatus = new JMenuItem("Customer Status");
        cstatus.setFont(new Font("Times new roman", Font.PLAIN, 12));
        cstatus.setBackground(Color.WHITE);
        cstatus.addActionListener(this);
        ImageIcon icon17= new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image9= icon17.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon18 = new ImageIcon(image9);
        cstatus.setIcon(icon18);
        Hstatus.add(cstatus);
        
        cd=new JMenu("Close");
        cd.setForeground(Color.BLUE);
        JMenuItem cpage = new JMenuItem("Close Page");
        cpage.setFont(new Font("Times new roman", Font.PLAIN, 12));
        cpage.setBackground(Color.WHITE);
        cpage.addActionListener(this);
        ImageIcon icon19= new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image10= icon19.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon20 = new ImageIcon(image10);
        cpage.setIcon(icon20);
        cd.add(cpage);
        
        
        

      

        org = new JMenu("Organization Details");
        org.setForeground(Color.BLUE);
        
        JMenuItem orgviewInfo = new JMenuItem("View Organization Information");
        orgviewInfo.setFont(new Font("Times new roman", Font.PLAIN, 12));
        orgviewInfo.setBackground(Color.WHITE);
        orgviewInfo.addActionListener(this);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image3 = icon5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(image3);
        orgviewInfo.setIcon(icon6);
        org.add(orgviewInfo);

        JMenuItem orgupdateInfo = new JMenuItem("Update Organization Information");
        orgupdateInfo.setFont(new Font("Times new roman", Font.PLAIN, 12));
        orgupdateInfo.setBackground(Color.WHITE);
        orgupdateInfo.addActionListener(this);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image4 = icon7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon8 = new ImageIcon(image4);
        orgupdateInfo.setIcon(icon8);
        org.add(orgupdateInfo);
        
        orgNeedInfo = new JMenu("OrganizationNeed");
        orgNeedInfo.setForeground(Color.BLUE);
        
         JMenuItem orgNeed = new JMenuItem("Need Detail");
        orgNeed.setFont(new Font("Times new roman", Font.PLAIN, 12));
        orgNeed.setBackground(Color.WHITE);
        orgNeed.addActionListener(this);
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image11 = icon21.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon22 = new ImageIcon(image11);
        orgNeed.setIcon(icon22);
        orgNeedInfo.add(orgNeed);
        
        Ostatus=new JMenu("Status");
         Ostatus.setForeground(Color.BLUE);
          JMenuItem osCheck = new JMenuItem("View Organization Status");
        osCheck.setFont(new Font("Times new roman", Font.PLAIN, 12));
        osCheck.setBackground(Color.WHITE);
        osCheck.addActionListener(this);
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image12 = icon23.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon24 = new ImageIcon(image12);
        osCheck.setIcon(icon24);
        Ostatus.add(osCheck);
         
        
        
       customerD = new JMenu("Customer Details");
        customerD.setForeground(Color.BLUE);
        
        JMenuItem cviewInfo = new JMenuItem("View Customer Information");
        cviewInfo.setFont(new Font("Times new roman", Font.PLAIN, 12));
        cviewInfo.setBackground(Color.WHITE);
        cviewInfo.addActionListener(this);
        ImageIcon icon25 = new ImageIcon(ClassLoader.getSystemResource("icon/odetail2.png"));
        Image image13 = icon25.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon26 = new ImageIcon(image13);
        cviewInfo.setIcon(icon26);
        customerD.add(cviewInfo);

        JMenuItem cupdateInfo = new JMenuItem("Update Customer  Information");
        cupdateInfo.setFont(new Font("Times new roman", Font.PLAIN, 12));
        cupdateInfo.setBackground(Color.WHITE);
        cupdateInfo.addActionListener(this);
        ImageIcon icon27 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image14 = icon27.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon28 = new ImageIcon(image14);
        cupdateInfo.setIcon(icon28);
        customerD.add(cupdateInfo);
        
         cHelpInfo = new JMenu("CustomerHelp");
        cHelpInfo.setForeground(Color.BLUE);
        
         JMenuItem CNeed = new JMenuItem("Help Detail");
        CNeed.setFont(new Font("Times new roman", Font.PLAIN, 12));
        CNeed.setBackground(Color.WHITE);
        CNeed.addActionListener(this);
        ImageIcon icon29 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image15 = icon29.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon30= new ImageIcon(image15);
        CNeed.setIcon(icon30);
        cHelpInfo.add(CNeed);
        
        CStatus=new JMenu("Status");
         CStatus.setForeground(Color.BLUE);
          JMenuItem chCheck = new JMenuItem("View Customer Status");
        chCheck.setFont(new Font("Times new roman", Font.PLAIN, 12));
        chCheck.setBackground(Color.WHITE);
        chCheck.addActionListener(this);
        ImageIcon icon31 = new ImageIcon(ClassLoader.getSystemResource("icon/cdetail.png"));
        Image image16 = icon31.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon icon32 = new ImageIcon(image16);
        chCheck.setIcon(icon32);
        CStatus.add(chCheck);
        
        if(slogin=="Admin"){
          mb.add(admin);
        mb.add(Oneed);
        mb.add(Chelp);
        mb.add(Hstatus);
        mb.add(cd);
        //mb.setBackground(Color.lightGray);
       }
        else if(slogin=="Organization"){
           mb.add(org);
           mb.add(orgNeedInfo);
           mb.add(Ostatus);
          mb.add(cd);
       }
       else{
            mb.add(customerD);
            mb.add(cHelpInfo);
            mb.add(CStatus);
            mb.add(cd);
       }
       
      
        
         this.setLayout(new FlowLayout());
        setTitle("Welcome to Orphanage Management System Portal");

        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae2){
         msg = ae2.getActionCommand();
        if (msg.equals("Organization")) {
            
         new ViewInfo(msg);
        
        }
        else if(msg.equals("Customer")){
              new ViewInfo(msg);
        }
        else if(msg.equals("Need Details")){
             new OrganizationNeed();
        }
        
         else if(msg.equals("Provide Need")){
           new HelpProvide();
        }
         else if(msg.equals("Help Details")){
             new CustomerHelp();
         }
        else if(msg.equals("Organization Status")){
                 new NeedStatus();
         }
         else if(msg.equals("Customer Status")){
                   new HelpStatus();
         }
         else if(msg.equals("View Organization Information")){
             
          }
         else if(msg.equals("Update Organization Information")){
                
         }
         else if(msg.equals("Need Detail")){
                 
         }
         
         else if(msg.equals("View Organization Status")){
                  new OrganizationStatus(ocname);
         }
         else if(msg.equals("View Customer Information")){
                 
         }
         else if(msg.equals("Update Customer  Information")){
                 
         }
         else if(msg.equals("Help Detail")){
                
         }
          else if(msg.equals("View Customer Status")){
                  new CustomerStatus(ocname);
         }
         
         else if(msg.equals("Close Page")){
                  setVisible(false);
         }
         
    }
   
    
    
    
     public static void main(String[] args) {
        new AdminDashboard("","");
    }

   
}
