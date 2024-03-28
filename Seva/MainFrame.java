

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Seva;

/**
 *
 * @author samar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame implements Runnable {

    
    
    /**
     * @param args the command line arguments
     */
     Thread t;

    public MainFrame() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/mainframe.png"));
        Image i2 = i1.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        add(image);
        setVisible(true);
        for (int i = 1; i <= 600; i++) {
            setSize(i, i);
            setLocation(400, 50);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start();
        setVisible(true);
    }
public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            new LoginForm("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new MainFrame();
    }
    
}
