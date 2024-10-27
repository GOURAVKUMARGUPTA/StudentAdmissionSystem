
package com.servlet;

import com.dataOperation.StudentDataOperation;
import com.entities.StudentRecord;
import com.helper.ConnectionProvider;
import com.helper.Message;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SaveApplicationFormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
//            Fetch All Records
            int studentId=Integer.parseInt(request.getParameter("studentId"));
            String dob=request.getParameter("dob");
            String fatherName=request.getParameter("fatherName");
            String motherName=request.getParameter("motherName");
            String gender=request.getParameter("gender");
            String city=request.getParameter("city");
            String post=request.getParameter("post");
            String policeStation=request.getParameter("policeStation");
            String state=request.getParameter("state");
            String district=request.getParameter("district");
            int pinCode=Integer.parseInt(request.getParameter("pinCode"));
            boolean applicationForm=true;
            StudentRecord student=new StudentRecord(studentId, dob, fatherName, motherName, gender, city, post, policeStation, state, district, pinCode, applicationForm);
            StudentDataOperation studentData=new StudentDataOperation(ConnectionProvider.getConnection());
            boolean save=studentData.saveApplicationForm(student);
            HttpSession session=request.getSession();
            Message myMessage;
            if(save)
            {
//                Application Form Successfully Saved
                String content="Application Form Submitted Successfully";
                String color="green";
                String icon="fa-check";
                myMessage=new Message(content, color, icon);
                session.setAttribute("myMsg", myMessage);
                response.sendRedirect("home.jsp");
                
            }
            else{
//                Saving Application Form Failled
                String content="Application Form Submiting Failled";
                String color="red";
                String icon="fa-times";
                myMessage=new Message(content, color, icon);
                session.setAttribute("myMsg", myMessage);
                response.sendRedirect("home.jsp");
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
