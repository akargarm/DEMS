<%-- 
    Document   : register
    Created on : Aug 1, 2017, 1:38:03 AM
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
                    <div class="col-xs-12 col-xs-push-4"> 
                        <div class="navbar-header">
                            <h1>DEMS Registration</h1>
                        </div>
                    </div>
                    <!--                    <div class="nav navbar-nav navbar-right">
                                            <a href="register.jsp">Register</a>
                                        </div>-->
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-xs-offset-2">
                    <p class="text-primary">Password must include at least one uppercase letter, one lowercase letter, a number, and have a minimum length of 8 characters.</p>
                    <form class="form-horizontal" id="register" action="RegistrationServlet" method="post">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-2 control-label">First name</label> 
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon glyphicon-user"></span>
                                <input class="form-control" id="firstName" type="text" name="firstname" required placeholder="Enter first name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-sm-2 control-label">Last name</label>
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon glyphicon-user"></span>
                                <input class="form-control" id="lastName" type="text" name="lastname" required placeholder="Enter last name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon-envelope"></span>
                                <input class="form-control" id="email" type="email" name="email" required placeholder="Enter email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-3 input-group">
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                                <input class="form-control" id="password" type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required placeholder="Enter password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-push-2">
                                <input class="btn btn-default" type="submit" name="submit" value="Submit">
                            </div>
                        </div>
                    </form>
                    <p class="col-sm-offset-2 text-danger">${errorMessage}</p>
                </div>
            </div>
        </div>
    </body>
</html>
