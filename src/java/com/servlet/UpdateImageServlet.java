
package com.servlet;

import com.dataOperation.StudentDataOperation;
import com.entities.StudentRecord;
import com.helper.ConnectionProvider;
import com.helper.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import javax.swing.JOptionPane;
@MultipartConfig
public class UpdateImageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //           Fetching Photo and signature
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            Part photoPart = request.getPart("photo");
            String photoName = photoPart.getSubmittedFileName();
            Part signaturePart = request.getPart("signature");
            String signatureName = signaturePart.getSubmittedFileName();
            //             Creating New Photo NAme Start
            String newPhotoName = "img" + new Date(System.currentTimeMillis()).toString() + studentId + photoName;
//                Creating New Photo NAme Stop
//                Creating New Photo NAme Start
            String newSignatureName = "img" + new Date(System.currentTimeMillis()).toString() + studentId + signatureName;
//                Creating New Photo NAme Stop
            StudentRecord student=new StudentRecord(studentId,newPhotoName, newSignatureName);
            StudentDataOperation studentData=new StudentDataOperation(ConnectionProvider.getConnection());
            StudentRecord oldStudent=studentData.getStudentRecordByStudentId(studentId);
            boolean update=studentData.updateImage(student);
            HttpSession session=request.getSession();
            Message message;
            if(update)
            {
//                Success
//                Deleting Old Photo Start
                String oldPhotoPath = request.getRealPath("/") + "UploadImage" + File.separator + "UploadPhoto" + File.separator + oldStudent.getPhotoName();
                File file=new File(oldPhotoPath);
                file.delete();
//                Deleting Old Photo Stop
//                Deleting Old Signature Start
                String oldSignaturePath = request.getRealPath("/") + "UploadImage" + File.separator + "UploadSignature" + File.separator + oldStudent.getSignatureName();
                File file1=new File(oldSignaturePath);
                file1.delete();
//                Deleting Old Signature Stop
                //                Uploading Images in the folder             
                InputStream photoStream = photoPart.getInputStream();
                byte[] photo = new byte[photoStream.available()];
                photoStream.read(photo);
                String photoPath = request.getRealPath("/") + "UploadImage" + File.separator + "UploadPhoto" + File.separator + newPhotoName;
                FileOutputStream fos1 = new FileOutputStream(photoPath);
                fos1.write(photo);
                fos1.close();
                InputStream signatureStream = signaturePart.getInputStream();
                byte[] signature = new byte[signatureStream.available()];
                signatureStream.read(signature);
                String signaturePath = request.getRealPath("/") + "UploadImage" + File.separator + "UploadSignature" + File.separator + newSignatureName;
                FileOutputStream fos2 = new FileOutputStream(signaturePath);
                fos2.write(signature);
                fos2.close();
                String content = "Image Updated Successfully";
                String color = "green";
                String icon = "fa-check";
                message = new Message(content, color, icon);
                session.setAttribute("myMsg", message);
                response.sendRedirect("home.jsp");
            }
            else{
//                Error
                String content = "Updating Image Failed";
                String color = "red";
                String icon = "fa-times";
                message = new Message(content, color, icon);
                session.setAttribute("myMsg", message);
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
