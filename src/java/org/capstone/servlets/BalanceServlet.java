/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.capstone.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.capstone.info.Expense;
import org.capstone.info.Income;
import org.capstone.info.User;
import org.capstone.service.BalanceService;
import org.capstone.service.ExpenditureService;

/**
 *
 * @author Afshin
 */
@WebServlet(name = "BalanceServlet", urlPatterns = {"/BalanceServlet"})
public class BalanceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BalanceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BalanceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ExpenditureService expenditureService = new ExpenditureService();
        BalanceService balanceService = new BalanceService();
        User user = (User) request.getSession().getAttribute("user");
        Expense expense = new Expense();
        Income income = new Income();

        if (request.getParameter("submitExpense") != null) {
            String expenseDescription = request.getParameter("expenseDescription");
            BigDecimal amountExpense = new BigDecimal(request.getParameter("amountExpense"));

            expense.setExpenseDescription(expenseDescription);
            expense.setAmountExpense(amountExpense);

            balanceService.addExpense(user, expense);
            BigDecimal updatedBalance = balanceService.balance(user);
            String balance = "Balance: " + updatedBalance.toString();
            request.getSession().setAttribute("balance", balance);
            request.getSession().setAttribute("pieChart", balanceService.getChartData());
            request.getRequestDispatcher("/portal.jsp").forward(request, response);
        }
        
        if (request.getParameter("submitIncome") != null) {
            String incomeDescription = request.getParameter("incomeDescription");
            BigDecimal amountIncome = new BigDecimal(request.getParameter("amountIncome"));

            income.setIncomeDescription(incomeDescription);
            income.setAmountIncome(amountIncome);

            balanceService.addIncome(user, income);
            BigDecimal updatedBalance = balanceService.balance(user);
            String balance = "Balance: " + updatedBalance.toString();
            request.getSession().setAttribute("balance", balance);
            request.getSession().setAttribute("pieChart", balanceService.getChartData());
            request.getRequestDispatcher("/portal.jsp").forward(request, response);
        }
        
        response.sendRedirect("portal.jsp");
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
