<%-- 
    Document   : addNewDepartment
    Created on : Dec 13, 2016, 5:13:26 PM
    Author     : nafeedgbhs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1>Add new department.</h1>
        <%
            System.out.println("Going to fetch the session");
            HttpSession mySession = request.getSession();
            System.out.println("Fetched the session successfully");

            String userType = "";
            try
            {
                userType = (String)(mySession.getAttribute("userType") );
                if ( userType.equalsIgnoreCase("admin") )
                {
                    // do nothing
                }
                else
                {                    
                    RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
                    rd.forward(request, response);
                }
            }
            catch (Exception e)
            {
                System.out.println("Can't fetch userType or convert it to String");
                RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
                rd.forward(request, response);
            }
            
            
        %>
        <form method="post" action="AddNewDepartmentV1.do">
            Department Name <input type="text" name="departmentName" /><br>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
