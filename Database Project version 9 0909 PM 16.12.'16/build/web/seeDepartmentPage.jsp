<%-- 
    Document   : seeDepartmentPage
    Created on : Dec 15, 2016, 9:51:03 AM
    Author     : nafeedgbhs
--%>

<%@page import="sukarna.models.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See department page</title>
    </head>
    <body>
        <jsp:include page="commonNavigation.jsp" /> 
        <h1>See department page</h1>
        <form method="post" action="SeeDepartmentPageProcess.do">
            Department Name <input type="text" name="departmentName" /><br>
            <input type="submit" value="See" />
        </form>
        <%
            try
            {
                int departmentID = (Integer)session.getAttribute("departmentIDOfDepartmentPage");
                if ( departmentID < 1000 ) // No department is found
                {
                    out.println("No department is found");
                }
                else // department is found
                {
                    out.println("<h2> Head of the department  </h2>");
                    Teacher headTeacher = (Teacher)session.getAttribute("headTeacherOfDepartmentPage");
                    if (headTeacher == null)
                    {
                        out.println("");
                    }
                    else
                    {
                        out.println("<table >");

                            out.println("<tr>");                  
                              out.println("<th>Firstname</th> ");
                              out.println("<th>Lastname</th> ");
                              out.println("<th>Phone number</th> ");
                              out.println("<th>Email address</th> ");
                              out.println("<th>Rank</th> ");
                            out.println("</tr>");
                            
                            out.println("<tr>");
                                out.println( String.format("<td>%s</td>", headTeacher.getFirstName() ) );
                                out.println( String.format("<td>%s</td>", headTeacher.getLastName() ) );
                                out.println( String.format("<td>%s</td>", headTeacher.getPhoneNumber() ) );
                                out.println( String.format("<td>%s</td>", headTeacher.getEmailAddress() ) );
                                out.println( String.format("<td>%s</td>", headTeacher.getTeacherRank() ) );
                            out.println("</tr>");

                            out.println("<table >");
                    }

                    out.println("<h2> List of teachers  </h2>");
                    ArrayList<Teacher> teacherListOfDepartment = 
                        (ArrayList<Teacher>) session.getAttribute("teacherListSearchedByDepartmentName");
                    if(teacherListOfDepartment == null)
                    {
                        out.println("");
                    }
                    else if( teacherListOfDepartment.size()==0)
                    {
                        out.println("No teacher in this department");
                    }
                    else 
                    {
                        out.println("<table >");
                            out.println("<tr>");                  
                              out.println("<th>Firstname</th> ");
                              out.println("<th>Lastname</th> ");
                              out.println("<th>Phone number</th> ");
                              out.println("<th>Email address</th> ");
                              out.println("<th>Rank</th> ");
                            out.println("</tr>");
                            for (Teacher teacher : teacherListOfDepartment)
                            {
                                out.println("<tr>");
                                //out.println( String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td>", teacher.getFirstName(), 
                                //        teacher.getLastName(), teacher.getPhoneNumber(), teacher.getEmailAddress() ) );
                                out.println( String.format("<td>%s</td>", teacher.getFirstName() ) );
                                out.println( String.format("<td>%s</td>", teacher.getLastName() ) );
                                out.println( String.format("<td>%s</td>", teacher.getPhoneNumber() ) );
                                out.println( String.format("<td>%s</td>", teacher.getEmailAddress() ) );
                                out.println( String.format("<td>%s</td>", teacher.getTeacherRank() ) );
                                out.println("</tr>");
                            }
                        out.println("</table >");
                    }
                    
                    out.println("<h2> List of courses  </h2>");
                    ArrayList<Course> courseListOfDepartment = 
                        (ArrayList<Course>) session.getAttribute("courseListSearchedByDepartmentName");
                    if(courseListOfDepartment == null)
                    {
                        out.println("");
                    }
                    else if( courseListOfDepartment.size()==0)
                    {
                        out.println("No course in this department");
                    }
                    else 
                    {
                        out.println("<table >");
                            out.println("<tr>");                  
                              out.println("<th>Course number</th> ");
                              out.println("<th>Course name</th> ");
                              out.println("<th>Credit hours</th> ");
                              out.println("<th>Department name</th> ");
                            out.println("</tr>");
                            for (Course course : courseListOfDepartment)
                            {
                                out.println("<tr>");                                
                                out.println( String.format("<td>%d</td>", course.getCourseNumber() ) );
                                out.println( String.format("<td>%s</td>", course.getCourseName() ) );
                                out.println( String.format("<td>%f</td>", course.getCreditHours() ) );
                                out.println( String.format("<td>%s</td>", course.getDepartmentName() ) );
                                out.println("</tr>");
                            }
                        out.println("</table >");
                    }
                }
            }
            catch(Exception e)
            {
                out.println("No department is found");
            }
        %>
    </body>
</html>
