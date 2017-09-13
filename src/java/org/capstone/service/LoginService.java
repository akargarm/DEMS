/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.service;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.capstone.info.User;

/**
 *
 * @author Afshin
 */
public class LoginService {

    ResultSet rs = null;

    public boolean authenticate(String idEmail, String pass) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
//        ResultSet rs;
        PreparedStatement pstatement;
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "SELECT * FROM user WHERE username = ? AND password = ?";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setString(1, idEmail);
            pstatement.setString(2, pass);
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

    public User getUserDetails(String idEmail) {
        User user = new User();
        try {
            if (rs != null) {
                rs.first();
                user.setDatabaseID(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setIdEmail(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (Exception ex) {
            System.err.println("ResultSet issue...");
        }
        return user;
    }
}
