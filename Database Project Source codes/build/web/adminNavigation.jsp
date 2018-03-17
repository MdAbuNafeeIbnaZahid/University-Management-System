<%-- 
    Document   : adminNavigation
    Created on : Dec 16, 2016, 11:45:14 AM
    Author     : nafeedgbhs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin navigation</title>
    </head>
    <body>
        <%
            //System.out.println("Going to fetch the session");
            HttpSession mySession = request.getSession();
            //System.out.println("Fetched the session successfully");

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
        <h1>Admin navigation</h1>
        <a href="addNewDepartment.jsp">Add new department</a>
        <br>
        <a href="LogOutProcess.do">Log Out</a>
        <br>
        <a href="searchTeacherByAdmin.jsp">Search teacher</a>
        <br>
        <a href="setDepartmentHeadShow.do">Set department head</a>
        <br>
        <a href="addNewCourse.jsp">Add new course</a>
        <br>
        <a href="addNewClass.jsp">Add new class</a>
        <br>
        <br>
        <br>
    </body>
</html>
