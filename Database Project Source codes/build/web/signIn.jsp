<%-- 
    Document   : signIn
    Created on : Dec 14, 2016, 10:03:38 AM
    Author     : nafeedgbhs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In!</title>
    </head>
    <body>
        <%
            
            try
            {
                HttpSession mySession = request.getSession();
                String userType = ""; 
                
                userType = (String)(mySession.getAttribute("userType") );
                
                System.out.println("inside signIn.jsp  userType = " + userType);
                if ( userType == null )
                {
                    // do nothing
                }
                else if ( userType.equalsIgnoreCase("admin") )
                {
                    RequestDispatcher rd = request.getRequestDispatcher("adminNavigation.jsp");
                    rd.forward(request, response);
                }
                else if ( userType.equalsIgnoreCase("teacher") )
                {                    
                    RequestDispatcher rd = request.getRequestDispatcher("teacherNavigation.jsp");
                    rd.forward(request, response);
                }
                else if ( userType.equalsIgnoreCase("student") )
                {                    
                    RequestDispatcher rd = request.getRequestDispatcher("studentNavigation.jsp");
                    rd.forward(request, response);
                }
                    
            }
            catch (Exception e)
            {
                // do nothing
            }
            
        %>
        <jsp:include page="commonNavigation.jsp" /> 
        <h1>Sign In!</h1>
        <form method="post" action="SignInProcess.do">
            Username <input type="text" name="username" /> <br/>
            Password <input type="password" name="password" /> <br/>
            <input type="radio" name="userType" value="admin" checked /> Admin <br>
            <input type="radio" name="userType" value="teacher"/>Teacher<br>
            <input type="radio" name="userType" value="student"/>Student<br>
            <input type="submit" value="Sign In!" />
        </form> 
    </body>
</html>
