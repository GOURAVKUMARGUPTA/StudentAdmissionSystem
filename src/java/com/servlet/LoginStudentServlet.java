
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

public class LoginStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
//            Fetch Email And Password

            String email=request.getParameter("email");
            String password=request.getParameter("password");
            StudentDataOperation stuData=new StudentDataOperation(ConnectionProvider.getConnection());
            Register register=stuData.getStudentByEmailAndPassword(email, password);
            HttpSession session=request.getSession();
            if(register!=null)
            {
//                Login Successful
                session.setAttribute("loginStudent", register);
                response.sendRedirect("home.jsp");
            }
            else
            {
//                Login Failed
                String content="Login Failed!! Either Email OR Password is Worng";
                String color="red";
                String icon="fa-times";
                Message myMessage=new Message(content, color, icon);
                session.setAttribute("myMsg", myMessage);
                response.sendRedirect("studentLogin.jsp");
                
            }
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
