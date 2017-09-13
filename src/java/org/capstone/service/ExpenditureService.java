/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.capstone.info.Expense;
import org.capstone.info.User;

/**
 *
 * @author Afshin
 */
public class ExpenditureService {

    public void addExpense(User user, Expense expense) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
        ResultSet rs = null;
        PreparedStatement pstatement;
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "INSERT INTO expenditures(user_id, description, amount) VALUES (?, ?, ?)";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, user.getDatabaseID());
            pstatement.setString(2, expense.getExpenseDescription());
            pstatement.setBigDecimal(3, expense.getAmountExpense());
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
