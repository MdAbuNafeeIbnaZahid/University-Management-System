<%-- 
    Document   : searchTeacherByLastName
    Created on : Dec 14, 2016, 6:11:08 PM
    Author     : nafeedgbhs
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search teacher by last name.</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
        <h1>Search teacher by last name.</h1>
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
                    RequestDispatcher rd = request.getRequestDispatcher("addNewDepartment.jsp");
                    rd.forward(request, response);
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
        
        <form method="post" action="SearchTeacherByLastNameProcess.do">
            Teacher Last Name <input type="text" name="teacherLastName" /><br>
            <input type="submit" value="Search" />
        </form>
        
        <h2>Your teacher list</h2>
        <% 
            
            ArrayList<Teacher> teacherList = 
                    (ArrayList<Teacher>) session.getAttribute("teacherListSearchedByLastName");
            if(teacherList==null)
            {
                out.println("");
            }
            else if( teacherList.size()==0)
            {
                out.println("No teacher with this last name");
            }
            else 
            {
                out.println("<table >");
                    out.println("<tr>");
                      out.println("<th>Username</th> ");
                      out.println("<th>Firstname</th> ");
                      out.println("<th>Lastname</th> ");
                      out.println("<th>Department</th> ");
                    out.println("</tr>");
                    for (Teacher teacher : teacherList)
                    {
                        out.println("<tr>");
                        out.println( String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td>", teacher.getUsername(), 
                                teacher.getFirstName(), teacher.getLastName(), teacher.getDepartmentName() ) );
                        out.println("</tr>");
                    }
                    /*
                    <tr>
                      <td>Jill</td>
                      <td>Smith</td>
                      <td>50</td>
                    </tr>
                    <tr>
                      <td>Eve</td>
                      <td>Jackson</td>
                      <td>94</td>
                    </tr>
                    <tr>
                      <td>John</td>
                      <td>Doe</td>
                      <td>80</td>
                    </tr>
                  </table>
                    */
                
                /*
                out.println("<table>");
                out.println("<hr><td>Sl.</td><td>Amount</td><td>Datetime</td></tr>");
                int count=0;
                for(BankTransaction trans: transactions)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d.</td><td>%10.2f</td><td>%s</td>", count, trans.getAmount(), trans.getDatetime()) );
                    out.println("</tr>");
                }
                out.println("</table>");
                */
            }
        %>
        
    </body>
</html>
