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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoGUI extends JFrame {
    private JTextField nameField, mobileField, emailField, addressField, usernameField, passwordField;

    public CustomerInfoGUI() {
        setTitle("Update Customer Information");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        JLabel nameLabel = new JLabel("Name:");
        JLabel mobileLabel = new JLabel("Mobile Number:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        
        nameField = new JTextField(20);
        mobileField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20); // Use JPasswordField for password input

        
        JButton updateButton = new JButton("Update");
        JButton cancelButton = new JButton("Cancel");

        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(mobileLabel);
        formPanel.add(mobileField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);

        
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        nameLabel.setFont(labelFont);
        mobileLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        nameField.setFont(fieldFont);
        mobileField.setFont(fieldFont);
        emailField.setFont(fieldFont);
        addressField.setFont(fieldFont);
        usernameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);

        updateButton.setFont(labelFont);
        cancelButton.setFont(labelFont);

        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String email = emailField.getText();
                String address = addressField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();

                
                System.out.println("Name: " + name);
                System.out.println("Mobile: " + mobile);
                System.out.println("Email: " + email);
                System.out.println("Address: " + address);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                
            }
        });

        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
            }
        });

        
        setVisible(true);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerInfoGUI();
            }
        });
    }
}
