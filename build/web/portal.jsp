<%-- 
    Document   : portal
    Created on : Aug 1, 2017, 12:56:08 AM
    Author     : Afshin
--%>

<%@page import="org.capstone.info.User"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <%
        User user = (User) session.getAttribute("user");
        session.getAttribute("balance");
        session.getAttribute("pieChart");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src='js/bootstrap.min.js'></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>DEMS</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="navbar-header">
                            <ul class="nav navbar-left nav-pills">
                                <li><a href="#" class="navbar-brand">DEMS</a></li>
                                <!--<li><a href="#">Home</a></li>-->
                                <li><a href="#">Balance History</a></li>
                                <!--                                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Account<span class="caret"></span></a>
                                                                    <ul class="dropdown-menu">
                                                                        <li><a href="#">Settings</a></li>
                                                                        <li><a href="#">Add Expense</a></li>
                                                                        <li><a href="#">Expense History</a></li>
                                                                    </ul>
                                                                </li>-->
                                <li><a href="#" class="glyphicon glyphicon-cog"> Settings</a></li>
                                <!--<li><a href="logout.jsp">Logout</a></li>-->
                            </ul>
                        </div>
                        <div class="nav navbar-nav navbar-right">
                            <ul class="nav navbar-right nav-pills">
                                <li>
                                    <a href="logout.jsp">Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <%
            try {
                String greeting = "Hello " + user.getFirstName();
                session.setAttribute("greeting", greeting);
            } catch (NullPointerException ex) {
                response.sendRedirect("index.jsp");
            }
        %>
        <h1 class="col-xs-offset-5">${greeting}</h1>
        <div class="container">
            <div class="row">
                <div class="col-xs-6">
                    <!-- Expenses form -->
                    <h1 class="col-sm-offset-1">Add Expenses</h1>
                    <form class="form-horizontal" id="addExpense" action="BalanceServlet" method="post">
                        <div class="form-group">
                            <label for="expenseDescription" class="col-sm-3 control-label">Expense Description</label>
                            <div class="col-sm-6">
                                <input class="form-control" id="expenseDescription" type="text" name="expenseDescription" required placeholder="What is the expense for?"><br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amountExpense" class="col-sm-3 control-label">Amount</label>
                            <div class="col-sm-6 input-group"> 
                                <span class="input-group-addon">$</span>
                                <input id="amountExpense" type="number" name="amountExpense" required placeholder="0.00" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-push-3">
                                <input class="btn btn-default" type="submit" name="submitExpense" value="Submit">
                            </div>
                        </div>
                    </form>
                </div>

                <%
//                    if (request.getParameter("submitExpense") != null) {
////                        int pk = session.getAttribute("primaryKey");
//                        String expenseDescription = request.getParameter("expenseDescription");
//                        BigDecimal amountExpense = new BigDecimal(request.getParameter("amountExpense"));
//                        queryString = "INSERT INTO expenditures(user_id, description, amount) VALUES (?, ?, ?)";
//                        pstatement = connection.prepareStatement(queryString);
//                        pstatement.setInt(1, primaryKey);
//                        pstatement.setString(2, expenseDescription);
//                        pstatement.setBigDecimal(3, amountExpense);
//                        pstatement.executeUpdate();
////                        rs = pstatement.getGeneratedKeys();
//                    }
                %>

                <!-- Income form -->
                <div class="col-xs-6">
                    <h1 class="col-sm-offset-1">Add Income</h1>
                    <form class="form-horizontal" id="addIncome" action="BalanceServlet" method="post">
                        <div class="form-group">
                            <label for="incomeDescription" class="col-sm-3 control-label">Income Description</label>
                            <div class="col-sm-6">
                                <input class="form-control" id="incomeDescription" type="text" name="incomeDescription" required placeholder="What is the income for?"><br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amountIncome" class="col-sm-3 control-label">Amount</label>
                            <div class="col-sm-6 input-group"> 
                                <span class="input-group-addon">$</span>
                                <input id="amountIncome" type="number" name="amountIncome" required placeholder="0.00" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-push-3">
                                <input class="btn btn-default" type="submit" name="submitIncome" value="Submit">
                            </div>
                        </div>
                    </form>
                </div>

                <%//                    if (request.getParameter("submitIncome") != null) {
////                        int pk = session.getAttribute("primaryKey");
//                        String incomeDescription = request.getParameter("incomeDescription");
//                        BigDecimal amountIncome = new BigDecimal(request.getParameter("amountIncome"));
//                        queryString = "INSERT INTO income(user_id, description, amount) VALUES (?, ?, ?)";
//                        pstatement = connection.prepareStatement(queryString);
//                        pstatement.setInt(1, primaryKey);
//                        pstatement.setString(2, incomeDescription);
//                        pstatement.setBigDecimal(3, amountIncome);
//                        pstatement.executeUpdate();
////                        rs = pstatement.getGeneratedKeys();
//                    }
%>
                <h2 class="col-xs-offset-4">${balance}</h2>
                <div class="col-xs-offset-3"><img src="${pieChart}"/></div>
            </div>
        </div>
    </body>
</html>
