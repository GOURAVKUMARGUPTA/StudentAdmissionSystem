package com.dataOperation;

import com.entities.Register;
import com.entities.StudentRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class StudentDataOperation {

    Connection con;

    public StudentDataOperation(Connection con) {
        this.con = con;
    }

//    Student Registration Start
    public boolean registerStudent(Register regStudent) {
        boolean register = false;

        try {

            String query = "INSERT INTO register(studentName,studentMobile,studentEmail,password) values(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, regStudent.getStudentName());
            pstmt.setString(2, regStudent.getStudentMobile());
            pstmt.setString(3, regStudent.getStudentEmail());
            pstmt.setString(4, regStudent.getPassword());
            pstmt.executeUpdate();
            register = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return register;

    }
//    Student Registration Stop

//    Check Studdent Exist or Not By Email or mobile Number start
    public boolean getStudentByEmailOrMobileNumber(String email, String mobile) {
        boolean register = false;
        try {

            String query = "SELECT * FROM register WHERE studentEmail=? OR studentMobile=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, mobile);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {

                register = true;
            }

        } catch (Exception e) {
        }
        return register;
    }

//    Ccheck Studdent Exist or Not By Email or mobile Number stop
//    Student Login Start
    public Register getStudentByEmailAndPassword(String email, String passsword) {
        Register register = null;
        try {

            String query = "SELECT * FROM register WHERE studentEmail=? AND password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, passsword);
            ResultSet set = pstmt.executeQuery();
            if (set.next()) {
                register = new Register();
                register.setStudentId(set.getInt("studentId"));
                register.setStudentName(set.getString("studentName"));
                register.setStudentEmail(set.getString("studentEmail"));
                register.setStudentMobile(set.getString("studentMobile"));
                register.setPassword(set.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return register;
    }
//    Student Login Stop

//    save Application Form Start
    public boolean saveApplicationForm(StudentRecord student) {
        boolean save = false;
        try {

            String query = "INSERT INTO studentrecord(studentId,dob,fatherName,motherName,gender,city,post,policeStation,state,district,pincode,applicationForm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getDob());
            pstmt.setString(3, student.getFatherName());
            pstmt.setString(4, student.getMotherName());
            pstmt.setString(5, student.getGender());
            pstmt.setString(6, student.getCity());
            pstmt.setString(7, student.getPost());
            pstmt.setString(8, student.getPoliceStation());
            pstmt.setString(9, student.getState());
            pstmt.setString(10, student.getDistrict());
            pstmt.setInt(11, student.getPinCode());
            pstmt.setBoolean(12, student.isApplicationForm());
            pstmt.executeUpdate();
            save = true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return save;
    }
//    save Application Form Stop

//    Fetch Student Record By StudentId Start
    public StudentRecord getStudentRecordByStudentId(int studentId) {
        StudentRecord student = null;

        try {

            String query = "SELECT * FROM studentrecord WHERE studentId=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, studentId);
            ResultSet set=pstmt.executeQuery();
            if(set.next())
            {
                student=new StudentRecord();
                
                student.setStudentRecordId(set.getInt("studentRecordId"));
                student.setStudentId(set.getInt("studentId"));
                student.setDob(set.getString("dob"));
                student.setFatherName(set.getString("fatherName"));
                student.setMotherName(set.getString("motherName"));
                student.setGender(set.getString("gender"));
                student.setPost(set.getString("post"));
                student.setCity(set.getString("city"));
                student.setPoliceStation(set.getString("policeStation"));
                student.setState(set.getString("state"));
                student.setDistrict(set.getString("district"));
                student.setPinCode(set.getInt("pincode"));
                student.setPhotoName(set.getString("photoName"));
                student.setSignatureName(set.getString("signatureName"));
                student.setApplicationForm(set.getBoolean("applicationForm"));
                student.setImageUpload(set.getBoolean("imageUpload"));
                student.setPayment(set.getBoolean("payment"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return student;

    }
//    Fetch Student Record By StudentId Stop
    
//    Update Student Application Form By Student Id Start
    public boolean updateApplicationFormByStudentId(StudentRecord student)
    {
        boolean update=false;
        try {
            
            String query="UPDATE studentrecord SET dob=? ,fatherName=?,motherName=?,gender=?,city=?,post=?,policeStation=?,state=?,district=?,pincode=? WHERE studentId=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, student.getDob());
            pstmt.setString(2, student.getFatherName());
            pstmt.setString(3, student.getMotherName());
            pstmt.setString(4, student.getGender());
            pstmt.setString(5, student.getCity());
            pstmt.setString(6, student.getPost());
            pstmt.setString(7, student.getPoliceStation());
            pstmt.setString(8, student.getState());
            pstmt.setString(9, student.getDistrict());
            pstmt.setInt(10, student.getPinCode());
            pstmt.setInt(11, student.getStudentId());
            pstmt.executeUpdate();
            update=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
//    Update Student Application Form By Student Id Stop
    
//    Upload Image Start
    public boolean uploadImagesByStudentId(StudentRecord student)
    {
        boolean upload=false;
        try {
            
            String query="UPDATE studentrecord SET photoName=?,signatureName=?,imageUpload=? WHERE studentId=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, student.getPhotoName());
            pstmt.setString(2, student.getSignatureName());
            pstmt.setBoolean(3, student.isImageUpload());
            pstmt.setInt(4, student.getStudentId());
            pstmt.executeUpdate();
            upload=true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return upload;
    }
//    Upload Image Stop
    
//    Update Image Staart
    public boolean updateImage(StudentRecord student)
    {
        boolean update=false;
        try {
            String query="UPDATE studentrecord SET photoName=?,signatureName=? WHERE studentId=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, student.getPhotoName());
            pstmt.setString(2, student.getSignatureName());
            pstmt.setInt(3, student.getStudentId());
            pstmt.executeUpdate();
            update=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
//    Update Image Stop
}
