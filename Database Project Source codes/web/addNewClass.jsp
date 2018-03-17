<%-- 
    Document   : addNewClass
    Created on : Dec 20, 2016, 9:53:03 AM
    Author     : nafeedgbhs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new class</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
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
        <h1>Add new class</h1>
        <form method="post" action="AddNewClassProcess.do">
            Month of class <input type="text" name="monthOfClass" /><br>
            Year of class <input type="text" name="yearOfClass" /><br>
            Department Name <input type="text" name="departmentName" /><br>
            Course number <input type="text" name="courseNumber" /><br>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
