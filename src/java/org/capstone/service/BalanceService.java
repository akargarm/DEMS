/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.service;

import static com.googlecode.charts4j.Color.*;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.capstone.info.Expense;
import org.capstone.info.Income;
import org.capstone.info.User;

/**
 *
 * @author Afshin
 */
public class BalanceService {

    ArrayList<BigDecimal> expenseList;
    ArrayList<BigDecimal> incomeList;
    ResultSet rsExpenses;
    ResultSet rsIncome;
    int inputCount;

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

    public void addIncome(User user, Income income) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
        ResultSet rs = null;
        PreparedStatement pstatement;
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "INSERT INTO income(user_id, description, amount) VALUES (?, ?, ?)";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, user.getDatabaseID());
            pstatement.setString(2, income.getIncomeDescription());
            pstatement.setBigDecimal(3, income.getAmountIncome());
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

    public BigDecimal balance(User user) {
        String connectionURL = "jdbc:mysql://localhost:3306/dems";
        Connection connection;
        rsExpenses = null;
        rsIncome = null;
        inputCount = 0;
        PreparedStatement pstatement;

        expenseList = new ArrayList<BigDecimal>();
        incomeList = new ArrayList<BigDecimal>();
        int rowCount = 0;
        BigDecimal totalExpenditures = new BigDecimal(0);
        BigDecimal totalIncome = new BigDecimal(0);
        BigDecimal balance = new BigDecimal(0);
//        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            String queryString = "SELECT * FROM expenditures WHERE user_id = ?";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, user.getDatabaseID());
            rsExpenses = pstatement.executeQuery();
            queryString = "SELECT * FROM income WHERE user_id = ?";
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, user.getDatabaseID());
            rsIncome = pstatement.executeQuery();

            while (rsExpenses.next()) {
                expenseList.add(rsExpenses.getBigDecimal("amount"));
            }
//            for(BigDecimal d : expenseList) {
//                System.out.println(d);
//            }
            for (int i = 0; i < expenseList.size(); i++) {
                totalExpenditures = totalExpenditures.add(expenseList.get(i));
                inputCount++;
            }

            while (rsIncome.next()) {
                incomeList.add(rsIncome.getBigDecimal("amount"));
            }

            for (int i = 0; i < incomeList.size(); i++) {
                totalIncome = totalIncome.add(incomeList.get(i));
                inputCount++;
            }
//            System.out.println(totalExpenditures);
//            rsExpenses.next();
//            String expense = rsExpenses.getString("expenseSum");

//            rsIncome.next();
//            totalIncome = rsIncome.getBigDecimal("incomeSum");
//            if (rsExpenses.last()) {
//                rowCount = rsExpenses.getRow();
//                rsExpenses.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
//            }
//            while (rsExpenses.next()) {
//                int i = 1;
//                while(i < rowCount) {
//                    expenseList.add(rsExpenses.getBigDecimal(i));
//                    i++;
//                }
////                for (int i = 1; i < rowCount; i++) {
////                    expenseList.add(rsExpenses.getBigDecimal(i));
////                }
//            }
//
//            for (int i = 0; i < expenseList.size(); i++) {
//                totalExpenditures.add(expenseList.get(i));
//            }
//            if (rsIncome.last()) {
//                rowCount = rsIncome.getRow();
//                rsIncome.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
//            }
//            while (rsIncome.next()) {
//                for (int i = 1; i < rowCount; i++) {
//                    totalIncome.add(rsIncome.getBigDecimal(i));
//                }
//            }
            balance = balance.add(totalIncome);
            balance = balance.subtract(totalExpenditures);
//            if (rs.next()) {
//                return true;
//            }
//            st = connection.createStatement();
        } catch (Exception ex) {
            System.err.println("Database issues...");
        }
        return balance;
    }
    
    public String getChartData() {
        double expenditureSlicePercentage = ((double)expenseList.size() / inputCount) * 100.0;
        double incomeSlicePercentage = ((double)incomeList.size() / inputCount) * 100.0;
        
        Slice expenditures = Slice.newSlice((int)expenditureSlicePercentage, RED, "Expenditures");
        Slice income = Slice.newSlice((int)incomeSlicePercentage, GREEN, "Income");

        PieChart chart = GCharts.newPieChart(expenditures, income);
        chart.setTitle("Balances", BLACK, 16);
        chart.setSize(500, 200);
//        chart.setThreeD(true);
        String url = chart.toURLForHTML();
        return url;
    }
}
