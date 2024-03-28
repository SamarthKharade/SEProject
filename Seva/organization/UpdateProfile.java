package Seva.organization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


public class UpdateProfile extends JFrame {

    Connection con;
    Statement st;
    ResultSet rs=null;
    JLabel profile;
    JLabel usrImg,un;
    JLabel contactImg,co;
    JLabel mailImg,ml;
    JLabel addrImg,ad;
    JLabel passImg,passImg1,ps;
    JLabel saveImg;
    JPanel usr,prof,cont,mail,addr,pass,sve;
    JTextField name,username,contact,email;
    JTextArea address;
    JPasswordField password;
    Boolean flag=true;

    String nameD,usernameD="abc123",contactD,emailD,addressD,passwordD;


    public UpdateProfile(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization","root","password");
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Class.forName("com.mysql.cj.jdbc.Driver");
        setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        this.setVars();
        this.initialize();
        this.events();
        this.createTable();

        //setSize(500,700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setBounds((screenWidth/2)-250,(screenHeight/2)-375,500,750);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                new About();
            }
        });
    }
    public void initialize(){
        prof = new JPanel();
        prof.setLayout(new FlowLayout(FlowLayout.LEFT,7,30));
        prof.setBackground(Color.CYAN);
        profile = new JLabel(new ImageIcon("organization/icons/profile.png"));
        name = new JTextField(nameD,16);
        name.setFont(new Font("Serif",Font.BOLD,26));

        usr = new JPanel();
        usr.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        usrImg = new JLabel(new ImageIcon("organization/icons/username.png"));
        un = new JLabel("  Username : ");
        un.setFont(new Font("Mono",Font.BOLD,20));
        username = new JTextField(usernameD,15);
        username.setFont(new Font("Mono",Font.PLAIN,15));

        cont = new JPanel();
        cont.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        contactImg = new JLabel(new ImageIcon("organization/icons/contact.png"));
        co = new JLabel("  Contact : ");
        co.setFont(new Font("Mono",Font.BOLD,20));
        contact = new JTextField(contactD,10);
        contact.setFont(new Font("Mono",Font.PLAIN,15));

        mail = new JPanel();
        mail.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        mailImg = new JLabel(new ImageIcon("organization/icons/email.png"));
        ml = new JLabel("  E-Mail : ");
        ml.setFont(new Font("Mono",Font.BOLD,20));
        email = new JTextField(emailD,15);
        email.setFont(new Font("Mono",Font.PLAIN,15));

        addr = new JPanel();
        addr.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        addrImg = new JLabel(new ImageIcon("organization/icons/address.png"));
        ad = new JLabel("  Address : ");
        ad.setFont(new Font("Mono",Font.BOLD,20));
        address = new JTextArea(addressD,3,20);
        JScrollPane js = new JScrollPane(address);
        js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        address.setFont(new Font("Mono",Font.PLAIN,15));

        pass = new JPanel();
        pass.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        passImg1 = new JLabel(new ImageIcon("organization/icons/password1.png"));
        passImg = new JLabel(new ImageIcon("organization/icons/eye.png"));
        ps = new JLabel("  PASSWORD : ");
        ps.setFont(new Font("Mono",Font.BOLD,20));
        password = new JPasswordField(passwordD,15);
        password.setFont(new Font("Mono",Font.PLAIN,17));

        sve = new JPanel(new FlowLayout(FlowLayout.CENTER,160,30));
        saveImg = new JLabel(new ImageIcon("organization/icons/save.png"));

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
        addr.add(js);

        add(pass);
        pass.add(passImg1);
        pass.add(ps);
        pass.add(password);
        pass.add(passImg);
        showPassword();

        add(sve);
        sve.add(saveImg);
    }
    protected void createTable(){
            String sql = "CREATE TABLE organization.organization_registration " +
                    "(id INTEGER not NULL, " +
                    " username VARCHAR(30), " +
                    " name VARCHAR(50), " +
                    " contact INT(10), " +
                    " email VARCHAR(30), " +
                    " address VARCHAR(100), " +
                    " password VARCHAR(20), " +
                    " PRIMARY KEY ( id ))";
            try {
                st.executeUpdate(sql);//System.out.println("Table Created");
            }catch (Exception e){
                //System.out.println("Table is already exist");
            }
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
                passwordD=rs.getString(7);
            }
        } catch (Exception e) {
            //System.out.println("unable to fetch data");
        }
    }
    private void showPassword(){
        passImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag){
                    passImg.setIcon(new ImageIcon("organization/icons/eye2.png"));
                    password.setEchoChar((char)0);
                    flag=false;
                }
                else {
                    passImg.setIcon(new ImageIcon("organization/icons/eye.png"));
                    password.setEchoChar('*');
                    flag=true;
                }
            }
        });
    }
    private void events(){
        saveImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int res =JOptionPane.showConfirmDialog(UpdateProfile.this,
                        "Are You sure that all Details Are Valid","Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (res==JOptionPane.YES_OPTION){
                    String sql="UPDATE organization.organization_registration " +
                            "SET username='" +username.getText()+
                            "',name='" +name.getText()+
                            "',email='" +email.getText()+
                            "',contact='" +contact.getText()+
                            "',address='" +address.getText()+
                            "',password1='" +password.getText()+
                            "' WHERE username='"+usernameD+"';";
                    try {
                        st.executeUpdate(sql);//System.out.println("Data Updated");
                    } catch (Exception ex) {
                        //System.out.println("exp");
                    }
                    setVisible(false);
                    new About();
                }


            }
        });
    }

    public static void main(String[] args) {
        new UpdateProfile();
    }

}
