/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sukarna.db.DataAccess;
import sukarna.models.Teacher;

/**
 *
 * @author nafeedgbhs
 */
public class SignInProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String userType = request.getParameter("userType");
        
        
        System.out.println("username = " + username);
        System.out.println("pass = " + pass);
        System.out.println("userType = " + userType);
       
        HttpSession session = request.getSession();
        
        DataAccess db = new DataAccess();
        
        int ifExist = db.doUsernamePasswordExist(username, pass, userType);
        if( (userType.equalsIgnoreCase("admin") && username.equals("sys") && pass.equals("1234") ) )
        {
            session.setAttribute("username", username);
            session.setAttribute("userType", userType);
            RequestDispatcher rd = request.getRequestDispatcher("adminNavigation.jsp");
            rd.forward(request, response);
        }
        else if ( ifExist==1 && userType.equalsIgnoreCase("teacher") )
        {
            Teacher signedInTeacher = db.getTeacherByUsername(username);
            
            session.setAttribute("username", username);
            session.setAttribute("userType", userType);
            session.setAttribute("signedInTeacher", signedInTeacher);
            
            RequestDispatcher rd = request.getRequestDispatcher("teacherNavigation.jsp");
            rd.forward(request, response);
        }
        else if ( ifExist==1 && userType.equalsIgnoreCase("student") )
        {
            session.setAttribute("username", username);
            session.setAttribute("userType", userType);
            RequestDispatcher rd = request.getRequestDispatcher("studentNavigation.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
