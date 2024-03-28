/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seva;

/**
 *
 * @author samar
 */

import java.sql.*;

public class DatabaseInfo {

    Connection c;
    Statement s;

    DatabaseInfo() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///sevainfodetails", "root", "Samarth@2004");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DatabaseInfo();
 
  
    }
}
