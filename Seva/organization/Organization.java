package Seva.organization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Organization extends JFrame {
    JMenuBar jb;
    JMenu view,needs,status;
    JMenuItem about,update,help;

    JPanel dashboard;
    JLabel orphanImg;

    Organization(){
        this.initialize();
        this.events();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void initialize(){
        //Menu
        jb = new JMenuBar();
        jb.setPreferredSize(new Dimension(200,40));

        jb.setMargin(new Insets(50,20,40,20));
        jb.setBackground(new Color(3, 252, 215));
        jb.setLayout(new FlowLayout(FlowLayout.LEFT,30,8));

        view = new JMenu("PROFILE");
        needs = new JMenu("ORGANIZATION NEEDS");
        status = new JMenu("STATUS");
        about = new JMenuItem("Get Your Information",new ImageIcon("organization/icons/about.png"));
        update = new JMenuItem("Update Your Information",new ImageIcon("organization/icons/update.png"));
        help = new JMenuItem("Organization Need",new ImageIcon("organization/icons/need.png"));

        //Dashboard
        dashboard = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        orphanImg = new JLabel(new ImageIcon("organization/icons/orphan.png"));


        setJMenuBar(jb);
        jb.add(view);
        jb.add(needs);
        jb.add(status);
        view.add(about);
        view.add(update);

        needs.add(help);
        dashboard.add(orphanImg);
        add(dashboard);

    }

    public void events(){
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProfile();
            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Need();
            }
        });
    }

    public static void main(String[] args) {
        new Organization();
    }

}
