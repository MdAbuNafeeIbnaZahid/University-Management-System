package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Sign In!</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            
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
            
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "commonNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>Sign In!</h1>\n");
      out.write("        <form method=\"post\" action=\"SignInProcess.do\">\n");
      out.write("            Username <input type=\"text\" name=\"username\" /> <br/>\n");
      out.write("            Password <input type=\"password\" name=\"password\" /> <br/>\n");
      out.write("            <input type=\"radio\" name=\"userType\" value=\"admin\" checked /> Admin <br>\n");
      out.write("            <input type=\"radio\" name=\"userType\" value=\"teacher\"/>Teacher<br>\n");
      out.write("            <input type=\"radio\" name=\"userType\" value=\"student\"/>Student<br>\n");
      out.write("            <input type=\"submit\" value=\"Sign In!\" />\n");
      out.write("        </form> \n");
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
