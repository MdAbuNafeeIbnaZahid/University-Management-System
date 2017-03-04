<%-- 
    Document   : teacherViewAndChangeInfo
    Created on : Dec 17, 2016, 9:17:35 PM
    Author     : nafeedgbhs
--%>

<%@page import="sukarna.models.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View and change info for teacher</title>
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
                if ( userType.equalsIgnoreCase("teacher") )
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
        <jsp:include page="teacherNavigation.jsp" /> 
        <h1>View and change info for teacher</h1>
        <%
            try
            {
                Teacher signedInTeacher = (Teacher)session.getAttribute("signedInTeacher");
                out.println( " <form method=post action=EditTeacherInfo.do> " );
                    out.println( String.format("First Name <input type=text name=firstName value=\"%s\" /><br>", signedInTeacher.getFirstName() ) );
                    out.println( String.format("Last Name <input type=text name=lastName value=\"%s\" /><br>", signedInTeacher.getLastName() ) );
                    out.println( String.format("Address <input type=text name=address value=\"%s\" /><br>", signedInTeacher.getAddress() ) );
                    out.println( String.format("Phone Number <input type=text name=phoneNumber value=\"%s\" /><br>", signedInTeacher.getPhoneNumber() ) );
                    out.println( String.format("Email Address <input type=text name=emailAddress value=\"%s\" /><br>", signedInTeacher.getEmailAddress() ) );
                    out.println( "<input type=submit value=Edit />" );
                out.println( "</form>" );
                
                out.println("<h2> My Info  </h2>");
                
                if ( signedInTeacher == null)
                {
                    out.println("");
                }
                else
                {
                    out.println("<table >");

                        out.println("<tr>");
                            out.println("<th>Usrname</th> ");
                            out.println("<th>Firstname</th> ");
                            out.println("<th>Lastname</th> ");
                            out.println("<th>Address</th> ");
                            out.println("<th>Phone number</th> ");
                            out.println("<th>Email address</th> ");
                            out.println("<th>Rank</th> ");
                        out.println("</tr>");

                        out.println("<tr>");
                            out.println( String.format("<td>%s</td>", signedInTeacher.getUsername() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getFirstName() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getLastName() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getAddress() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getPhoneNumber() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getEmailAddress() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getTeacherRank() ) );
                        out.println("</tr>");

                        out.println("<table >");
                }
            }
            catch (Exception e )
            {
                System.out.println("Exception caught in printing signed in teacher info");
            }
        %>
    </body>
</html>
