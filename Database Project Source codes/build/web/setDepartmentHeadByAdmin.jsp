<%-- 
    Document   : setDepartmentHeadByAdmin
    Created on : Dec 19, 2016, 9:40:47 AM
    Author     : nafeedgbhs
--%>

<%@page import="sukarna.models.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set department head</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1>Set department head</h1>
        <%
            
            HttpSession mySession = request.getSession();
            String userType = "";
            if ( mySession == null )
            {
                System.out.println("inside searchTeacherByAdmin    mySession = " + mySession);
            }
            
            try
            {
                userType = (String)(mySession.getAttribute("userType") );
                //System.out.println("Inside searchTeacherByAdmin   userType = " + userType);
                if ( userType.equalsIgnoreCase("admin") )
                {
                    //do nothing
                }
                else
                {                    
                    RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
                    rd.forward(request, response);
                }
            }
            catch (Exception e)
            {
                RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
                rd.forward(request, response);
            }  
        %>
        
        <form method="post" action="setDepartmentHeadProcess.do">
            <%
                out.println("department Name");
                out.println(" <select id=\"departmentName\" name=\"departmentName\" > ");
                    ArrayList<Department> listOfAllDepartments 
                            = (ArrayList<Department>) session.getAttribute("listOfAllDepartments");
                    for (Department department : listOfAllDepartments)
                    {
                        out.println( String.format( " <option  value=\"%s\">%s</option>" , 
                                department.getDepartmentName(), department.getDepartmentName() ) );
                    }
                out.println("</select> <br/>");
            %>
            Username of head <input type="text" name="usernameOfHead" /> <br/>
            <input type="submit" value="Set!" />
        </form>
        <br>
        <br>
        <!-- 
            <form method="post" action="setDepartmentHeadProcess.do">
                Department Name <input type="text" name="departmentName" /> <br/>
                Username of head <input type="text" name="usernameOfHead" /> <br/>
                <input type="submit" value="Set!" />
            </form>
         -->
    </body>
</html>
