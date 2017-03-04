/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sukarna.db.DataAccess;
import sukarna.models.Course;
import sukarna.models.Teacher;

/**
 *
 * @author nafeedgbhs
 */
public class SeeDepartmentPageProcess extends HttpServlet {

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
        String departmentName = request.getParameter("departmentName");
        
        DataAccess db = new DataAccess();
        HttpSession session = request.getSession();
        
        int departmentID = db.getDeptIDFromDeptName(departmentName);
        session.setAttribute("departmentIDOfDepartmentPage", departmentID);
        
        Teacher headTeacher = db.getHeadTeacherByDepartmentName(departmentName);
        session.setAttribute("headTeacherOfDepartmentPage", headTeacher);
        
        ArrayList<Teacher> teacherListSearchedByDepartmentName = db.getTeachersByDepartmentName(departmentName);
        session.setAttribute("teacherListSearchedByDepartmentName", teacherListSearchedByDepartmentName);
        
        ArrayList<Course> courseListSearchedByDepartmentName = db.getCoursesByDepartmentName(departmentName);
        session.setAttribute("courseListSearchedByDepartmentName", courseListSearchedByDepartmentName);
        
        
//        for (Teacher teacher : teacherListSearchedByDepartmentName)
//        {
//            System.out.println( teacher );
//        }

        RequestDispatcher rd = request.getRequestDispatcher("seeDepartmentPage.jsp");
        rd.forward(request, response);
        
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
