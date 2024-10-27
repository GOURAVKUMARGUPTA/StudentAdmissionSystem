
package com.entities;

public class Register {
    private int studentId;
    private String studentName;
    private String studentMobile;
    private String studentEmail;
    private String password;

    public Register() {
    }

    
    public Register(int studentId, String studentName, String studentMobile, String studentEmail, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMobile = studentMobile;
        this.studentEmail = studentEmail;
        this.password = password;
    }

    public Register(String studentName, String studentMobile, String studentEmail, String password) {
        this.studentName = studentName;
        this.studentMobile = studentMobile;
        this.studentEmail = studentEmail;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
