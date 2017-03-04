<%-- 
    Document   : searchTeacherByAdmin
    Created on : Dec 16, 2016, 3:56:06 PM
    Author     : nafeedgbhs
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Teacher (Admin)</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1>Search Teacher (Admin)</h1>
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
                System.out.println("Inside searchTeacherByAdmin   userType = " + userType);
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
        
        <form method="post" action="SearchTeacherByRankProcess.do">
            <input type="radio" name="teacherRank" value="lecturer" checked /> Lecturer <br>
            <input type="radio" name="teacherRank" value="assistantProfessor"/>Assistant Professor<br>
            <input type="radio" name="teacherRank" value="associateProfessor"/>Associate Professor<br>
            <input type="radio" name="teacherRank" value="professor"/>Professor<br>
            <input type="submit" value="Search" />
        </form>
        
        <br>
        <br>
        
        <form method="post" action="SearchTeacherByLastNameProcess.do">
            Teacher Last Name <input type="text" name="teacherLastName" /><br>
            <input type="submit" value="Search" />
        </form>
        
        <br>
        <br>
        <h2>Your teacher list</h2>
        <% 
            
            ArrayList<Teacher> teacherList = 
                    (ArrayList<Teacher>) session.getAttribute("teacherListSearchedByAdmin");
            if(teacherList==null)
            {
                out.println("");
            }
            else if( teacherList.size()==0)
            {
                out.println("No teacher with searched criteria");
            }
            else 
            {
                out.println("<table >");
                    out.println("<tr>");
                      out.println("<th>Username</th> ");
                      out.println("<th>Firstname</th> ");
                      out.println("<th>Lastname</th> ");
                      out.println("<th>Address</th> ");
                      out.println("<th>Phone number</th> ");
                      out.println("<th>Email address</th> ");
                      out.println("<th>Department</th> ");
                      out.println("<th>Rank</th> ");
                    out.println("</tr>");
                    for (Teacher teacher : teacherList)
                    {
                        out.println("<tr>");
                        /*out.println( String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td>", teacher.getUsername(), 
                                teacher.getFirstName(), teacher.getLastName(), teacher.getDepartmentName() ) );
                        */
                            out.println( String.format("<td>%s</td>", teacher.getUsername() ) );
                            out.println( String.format("<td>%s</td>", teacher.getFirstName() ) );
                            out.println( String.format("<td>%s</td>", teacher.getLastName() ) );
                            out.println( String.format("<td>%s</td>", teacher.getAddress() ) );
                            out.println( String.format("<td>%s</td>", teacher.getPhoneNumber() ) );
                            out.println( String.format("<td>%s</td>", teacher.getEmailAddress() ) );
                            out.println( String.format("<td>%s</td>", teacher.getDepartmentName() ) );
                            out.println( String.format("<td>%s</td>", teacher.getTeacherRank() ) );
                        out.println("</tr>");
                    }
            }
        %>
        
        
    </body>
</html>
