package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.BigDecimal;
import java.sql.*;

public final class portal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src='js/bootstrap.min.js'></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <title>DEMS</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <ul class=\"nav navbar-left nav-pills\">\n");
      out.write("                                <li><a href=\"#\" class=\"navbar-brand\">DEMS</a></li>\n");
      out.write("                                <!--<li><a href=\"#\">Home</a></li>-->\n");
      out.write("                                <li><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Expenses<span class=\"caret\"></span></a>\n");
      out.write("                                    <ul class=\"dropdown-menu\">\n");
      out.write("                                        <li><a href=\"#\">View Expenses</a></li>\n");
      out.write("                                        <li><a href=\"#\">Add Expense</a></li>\n");
      out.write("                                        <li><a href=\"#\">Expense History</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\">Account</a></li>\n");
      out.write("                                <!--<li><a href=\"logout.jsp\">Logout</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <ul class=\"nav navbar-right nav-pills\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"logout.jsp\">Logout</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            ResultSet rs = null;
                            Integer primaryKey = null;
                            String idEmail = request.getParameter("email");
                            String pass = request.getParameter("password");
                            String connectionURL = "jdbc:mysql://localhost:3306/dems";
                            Connection connection = null;
                            PreparedStatement pstatement = null;
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            //            int updateQuery = 0;
                            connection = DriverManager.getConnection(connectionURL, "root", "");
                            String queryString = "SELECT * FROM user WHERE username = ? AND password = ?";
                            pstatement = connection.prepareStatement(queryString);
                            pstatement.setString(1, idEmail);
                            pstatement.setString(2, pass);
                            rs = pstatement.executeQuery();
                            if (rs.next()) {
                                primaryKey = rs.getInt("user_id");
                                session.setAttribute("user", idEmail);
//                                out.print("<h1>Hi " + session.getAttribute("user") + " welcome to your DEMS portal</h1>");
                            } else {
                                if (request.getParameter("submit") != null) {
                                String errorMessage = "Invalid username or password";
                                request.setAttribute("errorMessage", errorMessage);
                                request.getRequestDispatcher("/index.jsp").forward(request, response);
                                //                response.sendRedirect("register.jsp");
                                }
                            }
                        
      out.write("\n");
      out.write("                <!--        <h1>Hi \"");
      out.print( idEmail);
      out.write(", welcome to your DEMS portal</h1>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-6\">\n");
      out.write("                    <!-- Expenses form -->\n");
      out.write("                    <h1 class=\"col-sm-offset-1\">Add Expenses</h1>\n");
      out.write("                    <form class=\"form-horizontal\" id=\"addExpense\" action=\"\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"expenseDescription\" class=\"col-sm-3 control-label\">Expense Description</label>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <input class=\"form-control\" id=\"expenseDescription\" type=\"text\" name=\"expenseDescription\" required placeholder=\"What is the expense for?\"><br>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"amountExpense\" class=\"col-sm-3 control-label\">Amount</label>\n");
      out.write("                            <div class=\"col-sm-6 input-group\"> \n");
      out.write("                                <span class=\"input-group-addon\">$</span>\n");
      out.write("                                <input id=\"amountExpense\" type=\"number\" name=\"amountExpense\" required placeholder=\"0.00\" min=\"0\" step=\"0.01\" data-number-to-fixed=\"2\" data-number-stepfactor=\"100\" class=\"form-control currency\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"col-sm-10 col-sm-push-3\">\n");
      out.write("                                <input class=\"btn btn-default\" type=\"submit\" name=\"submitExpense\" value=\"Submit\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");

                    if (request.getParameter("submitExpense") != null) {
                        String expenseDescription = request.getParameter("expenseDescription");
                        BigDecimal amountExpense = new BigDecimal(request.getParameter("amountExpense"));
                        queryString = "INSERT INTO expenditures(user_id, description, amount) VALUES (?, ?, ?)";
                        pstatement = connection.prepareStatement(queryString);
                        pstatement.setInt(1, primaryKey);
                        pstatement.setString(2, expenseDescription);
                        pstatement.setBigDecimal(3, amountExpense);
                        pstatement.executeUpdate();
//                        rs = pstatement.getGeneratedKeys();
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Income form -->\n");
      out.write("                <div class=\"col-xs-6\">\n");
      out.write("                    <h1 class=\"col-sm-offset-1\">Add Income</h1>\n");
      out.write("                    <form class=\"form-horizontal\" id=\"addExpense\" action=\"\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"incomeDescription\" class=\"col-sm-3 control-label\">Income Description</label>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <input class=\"form-control\" id=\"incomeDescription\" type=\"text\" name=\"incomeDescription\" required placeholder=\"What is the income for?\"><br>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"amountIncome\" class=\"col-sm-3 control-label\">Amount</label>\n");
      out.write("                            <div class=\"col-sm-6 input-group\"> \n");
      out.write("                                <span class=\"input-group-addon\">$</span>\n");
      out.write("                                <input id=\"amountIncome\" type=\"number\" name=\"amountIncome\" required placeholder=\"0.00\" min=\"0\" step=\"0.01\" data-number-to-fixed=\"2\" data-number-stepfactor=\"100\" class=\"form-control currency\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"col-sm-10 col-sm-push-3\">\n");
      out.write("                                <input class=\"btn btn-default\" type=\"submit\" name=\"submit\" value=\"Submit\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
