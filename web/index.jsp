<%-- 
    Document   : index
    Created on : Aug 1, 2017, 12:15:34 AM
    Author     : Afshin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>DEMS</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12"> 
                        <div class="navbar-header">
                            <h1>Welcome to the CMSC495 Daily Expense Management System</h1>
                        </div>
                    </div>
                    <!--                    <div class="nav navbar-nav navbar-right">
                                            <a href="register.jsp">Register</a>
                                        </div>-->
                </div>
            </div>
        </nav>
        <!--<h2>Please login below or <a href="register.jsp">register</a> to access your portal</h2>-->
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-xs-offset-2"> 
                    <h1 class="col-sm-offset-1">Login Below or <a href="register.jsp">Register</a></h1>
                    <form class="form-horizontal" id="login" action="LoginServlet" method="post">
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon-envelope"></span>
                                <input class="form-control" id="email" type="email" name="email" required placeholder="Enter email"><br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                                <input class="form-control" id="password" type="password" name="password" required placeholder="Enter password"><br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="checkbox-inline col-sm-push-2"><input type="checkbox" name="rememberMe" value="">Remember me?</label>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-push-2">
                                <input class="btn btn-default" type="submit" name="submit" value="Submit">
                            </div>
                        </div>
                    </form>
                    <!--                    <div class="alert alert-danger" role="alert">
                                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                            <span class="sr-only">Error:</span>
                                            Enter a valid email address
                                        </div>-->
                    <p class="col-sm-offset-2 text-danger">${errorMessage}</p>
                </div>
            </div>
        </div>
    </body>
</html>
