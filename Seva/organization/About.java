package Seva.organization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


public class About extends JFrame {
      Connection con;
       Statement st;
        ResultSet rs=null;
        JLabel profile,name;
        JLabel usrImg,un,username;
        JLabel contactImg,co,contact;
        JLabel mailImg,ml,email;
        JLabel addrImg,ad,address;

        JButton update,close;
        JPanel prof,usr,cont,mail,addr,updt;
        String nameD,usernameD="abc123",contactD,emailD,addressD;


    About(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization","root","password");
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        this.setVars();
        this.initialize();
        this.events();

        setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setSize(500,600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setBounds((screenWidth/2)-250,(screenHeight/2)-300,500,600);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }
    private void setVars(){
        try {
            String sql="SELECT * FROM organization.organization_registration WHERE username='"+usernameD+"'";
            rs= st.executeQuery(sql);
            while (rs.next()){
                usernameD=rs.getString(2);
                nameD=rs.getString(3);
                contactD=rs.getString(4);
                emailD=rs.getString(5);
                addressD=rs.getString(6);
            }
        } catch (Exception e) {
            //System.out.println("unable to fetch data");
        }
    }
    void initialize(){
        prof = new JPanel(new FlowLayout(FlowLayout.LEFT,8,30));
        prof.setBackground(Color.CYAN);
        profile = new JLabel(new ImageIcon("organization/icons/profile.png"));
        name = new JLabel(nameD);
        name.setPreferredSize(new Dimension(352,40));
        name.setFont(new Font("Serif",Font.BOLD,26));

        usr = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        usrImg = new JLabel(new ImageIcon("organization/icons/username.png"));
        un = new JLabel("  Username : ");
        un.setFont(new Font("Mono",Font.BOLD,20));
        username = new JLabel(usernameD);
        username.setPreferredSize(new Dimension(200,30));
        username.setFont(new Font("Mono",Font.PLAIN,20));

        cont = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        contactImg = new JLabel(new ImageIcon("organization/icons/contact.png"));
        co = new JLabel("  Contact : ");
        co.setFont(new Font("Mono",Font.BOLD,20));
        contact = new JLabel(contactD);
        contact.setPreferredSize(new Dimension(200,30));
        contact.setFont(new Font("Mono",Font.PLAIN,20));

        mail = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        mailImg = new JLabel(new ImageIcon("organization/icons/email.png"));
        ml = new JLabel("  E-Mail : ");
        ml.setFont(new Font("Mono",Font.BOLD,20));
        email = new JLabel(emailD);
        email.setPreferredSize(new Dimension(200,30));
        email.setFont(new Font("Mono",Font.PLAIN,20));

        addr = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        addrImg = new JLabel(new ImageIcon("organization/icons/address.png"));
        ad = new JLabel("  Address : ");
        ad.setFont(new Font("Mono",Font.BOLD,20));
        address = new JLabel(addressD);
        address.setPreferredSize(new Dimension(300,30));
        address.setFont(new Font("Mono",Font.PLAIN,20));

        updt = new JPanel(new FlowLayout(FlowLayout.CENTER,85,20));
        update = new JButton("UPDATE");
        update.setFont(new Font("Serif",Font.PLAIN,20));
        update.setBackground(new Color(255,255,0));
        close = new JButton("CLOSE");
        close.setFont(new Font("Serif",Font.PLAIN,20));
        close.setBackground(new Color(255,0,0));

        add(prof);
        prof.add(profile);
        prof.add(name);

        add(usr);
        usr.add(usrImg);
        usr.add(un);
        usr.add(username);

        add(cont);
        cont.add(contactImg);
        cont.add(co);
        cont.add(contact);

        add(mail);
        mail.add(mailImg);
        mail.add(ml);
        mail.add(email);

        add(addr);
        addr.add(addrImg);
        addr.add(ad);
        addr.add(address);

        add(updt);
        updt.add(update);
        updt.add(close);

    }
    void events(){
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProfile();
                setVisible(false);
            }
        });
    }


    public static void main(String[] args) {
        new About();
    }

}
