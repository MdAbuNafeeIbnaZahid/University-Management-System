package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sukarna.models.Teacher;

public final class teacherViewAndChangeInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View and change info for teacher</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "teacherNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>View and change info for teacher</h1>\n");
      out.write("        ");

            try
            {
                Teacher signedInTeacher = (Teacher)session.getAttribute("signedInTeacher");
                out.println( " <form method=post action=successful.jsp> " );
                    out.println( String.format("Address <input type=text name=address value=%s /><br>", signedInTeacher.getAddress() ) );
                    /*
                    Username <input type="text" name="username" /> <br/>
                    Password <input type="password" name="password" /> <br/>
                    First Name <input type="text" name="firstName" /><br>
                    Last Name <input type="text" name="lastName" /> <br/>
                    Address <input type="text" name="address" /><br>
                    Phone Number <input type="text" name="phoneNumber" /> <br/>
                    Email Address <input type="text" name="emailAddress" /> <br/>
                    Join Date <input type="text" name="joinDate" value="DD/MM/YYYY" /> <br/>
                    Department Name <input type="text" name="departmentName" /> <br/>
                    */
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
                          out.println("<th>Firstname</th> ");
                          out.println("<th>Lastname</th> ");
                          out.println("<th>Phone number</th> ");
                          out.println("<th>Email address</th> ");
                          out.println("<th>Rank</th> ");
                        out.println("</tr>");

                        out.println("<tr>");
                            out.println( String.format("<td>%s</td>", signedInTeacher.getFirstName() ) );
                            out.println( String.format("<td>%s</td>", signedInTeacher.getLastName() ) );
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
        
      out.write("\n");
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
