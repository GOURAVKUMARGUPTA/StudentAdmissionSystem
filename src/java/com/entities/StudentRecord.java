
package com.entities;

public class StudentRecord {
    private int studentRecordId;
    private int studentId;
    private String dob;
    private String fatherName;
    private String motherName;
    private String gender;
    private String city;
    private String post;
    private String policeStation;
    private String state;
    private String district;
    private int pinCode;
    private String photoName;
    private String signatureName;
    private boolean applicationForm;
    private boolean imageUpload;
    private boolean payment;

    public StudentRecord() {
    }

    public StudentRecord(int studentRecordId, int studentId, String dob, String fatherName, String motherName, String gender, String city, String post, String policeStation, String state, String district, int pinCode, String photoName, String signatureName, boolean applicationForm, boolean imageUpload, boolean payment) {
        this.studentRecordId = studentRecordId;
        this.studentId = studentId;
        this.dob = dob;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.city = city;
        this.post = post;
        this.policeStation = policeStation;
        this.state = state;
        this.district = district;
        this.pinCode = pinCode;
        this.photoName = photoName;
        this.signatureName = signatureName;
        this.applicationForm = applicationForm;
        this.imageUpload = imageUpload;
        this.payment = payment;
    }

    public StudentRecord(int studentId, String dob, String fatherName, String motherName, String gender, String city, String post, String policeStation, String state, String district, int pinCode, boolean applicationForm) {
        this.studentId = studentId;
        this.dob = dob;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.city = city;
        this.post = post;
        this.policeStation = policeStation;
        this.state = state;
        this.district = district;
        this.pinCode = pinCode;
        this.applicationForm = applicationForm;
    }

    public StudentRecord(int studentId, String dob, String fatherName, String motherName, String gender, String city, String post, String policeStation, String state, String district, int pinCode) {
        this.studentId = studentId;
        this.dob = dob;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.city = city;
        this.post = post;
        this.policeStation = policeStation;
        this.state = state;
        this.district = district;
        this.pinCode = pinCode;
    }

    public StudentRecord(int studentId, String photoName, String signatureName, boolean imageUpload) {
        this.studentId = studentId;
        this.photoName = photoName;
        this.signatureName = signatureName;
        this.imageUpload = imageUpload;
    }

    public StudentRecord(int studentId, String photoName, String signatureName) {
        this.studentId = studentId;
        this.photoName = photoName;
        this.signatureName = signatureName;
    }
    

    public int getStudentRecordId() {
        return studentRecordId;
    }

    public void setStudentRecordId(int studentRecordId) {
        this.studentRecordId = studentRecordId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }

    public boolean isApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(boolean applicationForm) {
        this.applicationForm = applicationForm;
    }

    public boolean isImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(boolean imageUpload) {
        this.imageUpload = imageUpload;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }
    
    
}
