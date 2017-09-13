<%-- 
    Document   : confirm
    Created on : Aug 1, 2017, 1:46:38 AM
    Author     : Afshin
--%>

<%@page import="org.capstone.info.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src='js/bootstrap.min.js'></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>DEMS</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12"> 
                    <%
            //            String fName = request.getParameter("firstname");
            //            String lName = request.getParameter("lastname");
            //            String idEmail = request.getParameter("email");
            //            String pass = request.getParameter("password");
            //            String connectionURL = "jdbc:mysql://localhost:3306/dems";
            //            Connection connection = null;
            //            PreparedStatement pstatement = null;
            //            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ////            int updateQuery = 0;
            //            connection = DriverManager.getConnection(connectionURL, "root", "");
            //            String queryString = "INSERT INTO user(username, password, first_name, last_name) VALUES (?, ?, ?, ?)";
            //            pstatement = connection.prepareStatement(queryString);
            //            pstatement.setString(1, idEmail);
            //            pstatement.setString(2, pass);
            //            pstatement.setString(3, fName);
            //            pstatement.setString(4, lName);
            //            pstatement.executeUpdate();
                        User user = (User) session.getAttribute("user");
                    %>
                    <h1>Thank you for registering, <%= user.getFirstName()%>! A confirmation email has
                        been sent to <%= user.getIdEmail()%>
                    </h1>
                    <%
                        session.setAttribute("user", null);
                        session.invalidate();
                    %>
                    <h2>Click <a href="index.jsp">here</a> to return to the login page</h2>
                </div>
            </div>
        </div>
    </body>
</html>
