package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import sukarna.models.Teacher;

public final class seeDepartmentPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>See department page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>See department page</h1>\n");
      out.write("        <form method=\"post\" action=\"SeeDepartmentPageProcess.do\">\n");
      out.write("            Department Name <input type=\"text\" name=\"departmentName\" /><br>\n");
      out.write("            <input type=\"submit\" value=\"See\" />\n");
      out.write("        </form>\n");
      out.write("        ");
 
            int departmentID = (Integer)session.getAttribute("departmentIDOfDepartmentPage");
            if ( departmentID < 1000 ) // No department is found
            {
                out.println("No department is found");
            }
            else // department is found
            {
                out.println("<h2> Head of the department  </h2>");
                //out.println(" Need to do the work  ");
                
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

                }
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
