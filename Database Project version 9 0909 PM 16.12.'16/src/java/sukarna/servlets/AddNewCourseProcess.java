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
import sukarna.db.DataAccess;

/**
 *
 * @author nafeedgbhs
 */
public class AddNewCourseProcess extends HttpServlet {

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
        
        System.out.println("Start of processRequest in AddNewCourseProcess ");
        
        String courseNumber = request.getParameter("courseNumber");
        String courseName = request.getParameter("courseName");
        String creditHours = request.getParameter("creditHourse");
        String departmentName = request.getParameter("departmentName");
        
        System.out.println( "courseNumber = " + courseNumber );
        System.out.println( "courseName = " + courseName );
        System.out.println( "creditHours = " + creditHours );
        System.out.println( "departmentName = " + departmentName );
        
        DataAccess db = new DataAccess();
        int count = db.addNewCourse(Integer.parseInt(courseNumber), courseName, 
                Double.parseDouble(creditHours), departmentName);
        //System.out.println( "Nafee debug count =  " + count );
        if(count==1)
        {
            RequestDispatcher rd = request.getRequestDispatcher("adminNavigation.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("addNewCourse.jsp");
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
