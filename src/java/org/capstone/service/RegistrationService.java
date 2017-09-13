/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.capstone.info.User;

/**
 *
 * @author Afshin
 */
public class RegistrationService {
    public boolean duplicateCheck(String idEmail) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
        ResultSet rs;
        PreparedStatement pstatement;
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "SELECT * FROM user WHERE username = ?";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setString(1, idEmail);
            rs = null;
            rs = pstatement.executeQuery();
            if (rs.next()) {
                return true;
            }
//            st = connection.createStatement();
        } catch (Exception ex) {
            System.err.println("Database issues...");
        }
        return false;
    }
    public void register(String firstName, String lastName, String idEmail, String pass) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
        ResultSet rs = null;
        PreparedStatement pstatement;
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "INSERT INTO user(username, password, first_name, last_name) VALUES (?, ?, ?, ?)";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setString(1, idEmail);
            pstatement.setString(2, pass);
            pstatement.setString(3, firstName);
            pstatement.setString(4, lastName);
            pstatement.executeUpdate();
//            if (rs.next()) {
//                return true;
//            }
//            st = connection.createStatement();
        } catch (Exception ex) {
            System.err.println("Database issues...");
        }
//        return false;
    }
}
