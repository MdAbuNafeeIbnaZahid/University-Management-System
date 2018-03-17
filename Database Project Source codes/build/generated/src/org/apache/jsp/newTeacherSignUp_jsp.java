package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newTeacherSignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>New Teacher Sign Up</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "commonNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>New Teacher Sign Up</h1>\n");
      out.write("        <form method=\"post\" action=\"NewTeacherSignUp.do\">\n");
      out.write("            Username <input type=\"text\" name=\"username\" /> <br/>\n");
      out.write("            Password <input type=\"password\" name=\"password\" /> <br/>\n");
      out.write("            First Name <input type=\"text\" name=\"firstName\" /><br>\n");
      out.write("            Last Name <input type=\"text\" name=\"lastName\" /> <br/>\n");
      out.write("            Address <input type=\"text\" name=\"address\" /><br>\n");
      out.write("            Phone Number <input type=\"text\" name=\"phoneNumber\" /> <br/>\n");
      out.write("            Email Address <input type=\"text\" name=\"emailAddress\" /> <br/>\n");
      out.write("            Join Date <input type=\"text\" name=\"joinDate\" value=\"DD/MM/YYYY\" /> <br/>\n");
      out.write("            Department Name <input type=\"text\" name=\"departmentName\" /> <br/>\n");
      out.write("            Rank : \n");
      out.write("            <select id=\"teacherRank\" name=\"teacherRank\" >\n");
      out.write("                <option  value=\"lecturer\">Lecturer</option>\n");
      out.write("                <option  value=\"assistantProfessor\">Assistant Professor</option>\n");
      out.write("                <option  value=\"associateProfessor\">Associate Professor</option>\n");
      out.write("                <option  value=\"Professor\">Professor</option>\n");
      out.write("            </select> <br/>\n");
      out.write("            <input type=\"submit\" value=\"Sign Up!\" />\n");
      out.write("        </form>\n");
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
