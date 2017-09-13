<%-- 
    Document   : logout
    Created on : Aug 6, 2017, 7:50:14 PM
    Author     : Afshin
--%>

<%@page import="org.capstone.info.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            try {
                User user = (User) session.getAttribute("user");
                out.print("<h1>Thanks for visiting " + user.getFirstName() + "</h1>");
                session.setAttribute("user", null);
                session.invalidate();
                out.println("<br><a href='index.jsp'>Return to login</a>");
            } catch (NullPointerException ex) {
//                String errorMessage = "You must login to access portal features";
//                request.setAttribute("errorMessage", errorMessage);
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
                response.sendRedirect("index.jsp");
            }
        %>
                </div>
            </div>
        </div>
    </body>
</html>
