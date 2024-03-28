package Seva.organization;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Need extends JFrame {
    Connection con;
    Statement st;
    ResultSet rs=null;
    JLabel name,ned,other;
    JTextField otherR;
    JComboBox needs;
    JPanel mainPanel,help,otherP;
    JButton submit;


    Need(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization","root","password");
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.initialize();
        this.checkNeed();
        this.setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
        //setSize(500,600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setBounds((screenWidth/2)-300,(screenHeight/2)-250,600,500);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    void initialize(){
        mainPanel  = new JPanel(new FlowLayout(FlowLayout.CENTER,100,30));
        mainPanel.setPreferredSize(new Dimension(600,500));
        mainPanel.setBackground(new Color(255, 255, 255));
        name = new JLabel("Riddhi Siddhi Charitable Trust");
        name.setFont(new Font("Helvetica Bold",Font.BOLD,30));
        name.setForeground(new Color(2, 103, 255, 255));

        help = new JPanel(new FlowLayout(FlowLayout.LEFT,20,13));
        help.setPreferredSize(new Dimension(470,120));
        help.setBackground(new Color(239, 239, 239, 255));
        ned=new JLabel("Select Needful Resources");
        ned.setFont(new Font("Serif",Font.BOLD,20));
        String[] needsD={"Select Resources","Cloths","Money","Other.."};
        needs = new JComboBox<>(needsD);
        needs.setPreferredSize(new Dimension(430,40));
        needs.setFont(new Font("Romen",Font.PLAIN,15));

        otherP = new JPanel(new FlowLayout(FlowLayout.LEFT,30,20));
        otherP.setPreferredSize(new Dimension(470,120));
        otherP.setBackground(new Color(239, 239, 239, 255));
        other = new JLabel("Any Other :");
        other.setFont(new Font("Serif",Font.BOLD,20));
        otherR = new JTextField(33);
        otherR.setFont(new Font("Normal",Font.PLAIN,15));

        submit = new JButton("Submit");
        submit.setBackground(new Color(2, 103, 255, 255));
        submit.setFont(new Font("Normal",Font.PLAIN,20));
        submit.setForeground(new Color(255, 255, 255));
        add(mainPanel);

        mainPanel.add(name);
        mainPanel.add(help);
        help.add(ned);
        help.add(needs);

        mainPanel.add(otherP);
        otherP.add(other);
        otherP.add(otherR);
        otherP.setVisible(false);

        mainPanel.add(submit);

    }
    void checkNeed(){
        needs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getItem()=="Other.."){
                    otherP.setVisible(true);
                }
                else {
                    otherP.setVisible(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Need();
    }

}
