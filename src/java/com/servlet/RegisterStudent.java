package com.servlet;

import com.dataOperation.StudentDataOperation;
import com.entities.Register;
import com.helper.ConnectionProvider;
import com.helper.Message;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author URL INSTITUTE
 */
public class RegisterStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//          Fetching Data
            String studentName = request.getParameter("studentName");
            String studentMobile = request.getParameter("studentMobile");
            String studentEmail = request.getParameter("studentEmail");
            String password = request.getParameter("password");

            Register reg = new Register(studentName, studentMobile, studentEmail, password);
            StudentDataOperation studentData = new StudentDataOperation(ConnectionProvider.getConnection());

//            Check email or mobile is register or not start
            boolean registeredStudent = studentData.getStudentByEmailOrMobileNumber(studentEmail, studentMobile);
            Message msg = null;
            HttpSession session = request.getSession();
            if (registeredStudent) {
//                Email or Mobile Already Registered
                String content = "Registration Failed!!! Either Email OR Mobile is Already Registered";
                String color = "red";
                String icon = "fa-times";
                msg = new Message(content, color, icon);
                session.setAttribute("myMsg", msg);
                response.sendRedirect("studentSignUp.jsp");

            } else {
//                Email or Mobile Already Not Registered
                boolean register = studentData.registerStudent(reg);
                if (register) {
//                out.println("Registration Successful");
                    String content = "You Are Registered Successfully";
                    String color = "green";
                    String icon = "fa-check";
                    msg = new Message(content, color, icon);
                    session.setAttribute("myMsg", msg);
                    response.sendRedirect("studentSignUp.jsp");
                } else {
//                out.println("Registration Failed");
                    String content = "Your Registration is Failed!!!";
                    String color = "red";
                    String icon = "fa-times";
                    msg = new Message(content, color, icon);
                    session.setAttribute("myMsg", msg);
                    response.sendRedirect("studentSignUp.jsp");
                }
            }
//            Check email or mobile is register or not stop

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
