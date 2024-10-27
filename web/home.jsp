<%-- 
    Document   : home
    Created on : 16 Aug, 2021, 6:32:56 PM
    Author     : URL INSTITUTE
--%>

<%@page import="com.entities.StudentRecord"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dataOperation.StudentDataOperation"%>
<%@page import="com.entities.Register"%>
<%@page import="com.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String applicationFormTextColor = "text-danger";
    String applicationFormText = "Incompleted";
    String imageUploadTextColor = "text-danger";
    String imageUploadText = "Incompleted";
    String paymentTextColor = "text-danger";
    String paymentText = "Incompleted";
    String applicationMessage = "You have completed <b>Registration Form</b> . Please Fill the Application Form";
    StudentRecord student = null;
    Register register = (Register) session.getAttribute("loginStudent");
    if (register == null) {
        response.sendRedirect("studentLogin.jsp");
    } else {
        StudentDataOperation studentData = new StudentDataOperation(ConnectionProvider.getConnection());
        student = studentData.getStudentRecordByStudentId(register.getStudentId());

        if (student != null) {
            if (student.isApplicationForm()) {
                applicationFormTextColor = "text-success";
                applicationFormText = "Completed";
            }
            if (student.isImageUpload()) {
                imageUploadTextColor = "text-success";
                imageUploadText = "Completed";
            }
            if (student.isPayment()) {
                paymentTextColor = "text-success";
                paymentText = "Completed";
            }
            if (student.isPayment()) {
                applicationMessage = "You have completed <b>Payment</b> . Please Download Confirmation Page";
            } else if (student.isImageUpload()) {
                applicationMessage = "<p style='text-align:justify'><b>You have completed image upload step.The processing of application form will be completed only after the payment of examination fee.After payment of fee , you will not be able to edit the filled application form data</b></p>"
                        + "             <br><p style='font-weight:bold' class='text-danger text-center'>You are required to pay Rs. 500/-</p>";
            } else if (student.isApplicationForm()) {
                applicationMessage = "You have completed <b>Application Form</b> . Please Upload Images";
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!--Bootstrap CSS Start-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Bootstrap CSS Stop-->
        <link href="MyCSS/myCSS.css" rel="stylesheet" type="text/css"/>
        <!--Fontawaasome CDn Start-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--Fontawaasome CDn Stop-->
    </head>
    <body>
        <!--Navbar Start-->
        <%@include file="loginHeader.jsp" %>
        <!--Navbar Stop-->
        <!--hOME pAGE cONTENT START-->
        <div id="outerDiv">
            <div id="innerDiv">
                <%
                    if (register != null) {
                %>
                <h6 style="padding-left: 50px">Welcome : <%=register.getStudentName()%></h6>
                <%
                    }
                %>
            </div>
            <div class="container mt-3 text-center">
                <%
                    if (student != null) {
                        if (student.isPayment()) {
                %>
                <img src="Images/applicationCompleted.png" class="img-fluid">
                <%
                } else if (student.isImageUpload()) {
                %>
                <img src="Images/payment.png" class="img-fluid">
                <%
                } else if (student.isApplicationForm()) {
                %>
                <img src="Images/imageUpload.png" class="img-fluid">
                <%
                } else {
                %>
                <img src="Images/applicationForm.png" class="img-fluid">
                <%
                    }
                } else {
                %>
                <img src="Images/applicationForm.png" class="img-fluid">
                <%
                    }
                %>

            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="card mt-5">
                            <!--Message Start-->
                            <%
                                Message message = (Message) session.getAttribute("myMsg");
                                if (message != null) {
                            %>
                            <div class="alert alert-warning alert-dismissible fade show text-white" role="alert" style="background-color: <%=message.getColor()%>">
                                <strong><i class="fa <%=message.getIcon()%>" aria-hidden="true"></i> <%=message.getContent()%></strong>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div> 
                            <%
                                }
                                session.removeAttribute("myMsg");
                            %>
                            <!--Message Stop-->
                            <div class="card-header bg-primary text-center text-white">
                                <h6>Application Status</h6>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr class="text-success">
                                            <th scope="col">Registration Form</th>
                                            <th scope="col">Completed</th>
                                        </tr>
                                        <tr class="<%=applicationFormTextColor%>">
                                            <th scope="col">Application Form</th>
                                            <th scope="col"><%=applicationFormText%></th>
                                        </tr>
                                        <tr class="<%=imageUploadTextColor%>">
                                            <th scope="col">Image Upload</th>
                                            <th scope="col"><%=imageUploadText%></th>
                                        </tr>
                                        <tr class="<%=paymentTextColor%>">
                                            <th scope="col">Application Fee</th>
                                            <th scope="col"><%=paymentText%></th>
                                        </tr>
                                    </thead>
                                </table>
                                <p>
                                    <%=applicationMessage%>
                                </p>
                            </div>
                        </div>
                        <div class="text-center text-white">
                            <%
                                if (student != null) {
                                    if (student.isPayment()) {
                            %>
                            <a href="#" class="btn btn-primary">Download Confirmation Page</a>
                            <%
                            } else if (student.isImageUpload()) {
                            %>
                            <div class="container mt-3">
                                <div class="row">
                                    <div class="col-sm-4 mb-2">
                                        <a href="editApplicationForm.jsp" class="btn btn-primary w-100">Edit Form</a>
                                    </div>
                                    <div class="col-sm-4 mb-2">
                                        <a href="editImage.jsp" class="btn btn-primary w-100">Edit Image</a>
                                    </div>
                                    <div class="col-sm-4">
                                        <a href="#" class="btn btn-danger w-100">Go Payment</a>
                                    </div>
                                </div>
                            </div>
                            <%
                            } else if (student.isApplicationForm()) {
                            %>
                            <div class="mt-3">
                                <a href="editApplicationForm.jsp" class="btn btn-primary">Edit Application Form</a>
                                <a href="imageUpload.jsp" class="btn btn-danger">Go For Image Upload</a>
                            </div>
                            <%
                            } else {
                            %>
                            <div class="mt-3">
                                <a href="applicationForm.jsp" class="btn btn-danger">Complete Application Form</a>
                            </div>
                            <%
                                }
                            } else {
                            %>
                            <div class="mt-3">
                                <a href="applicationForm.jsp" class="btn btn-danger">Complete Application Form</a>
                            </div>
                            <%
                                }
                            %>
                        </div>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
        </div>
        <!--hOME pAGE cONTENT STOP-->


        <!--Footer Start-->
        <%@include file="footer.jsp" %>
        <!--Footer Stop-->
        <!--Bootsstrap JS Start-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--Bootsstrap JS Start-->
        <script src="MyJs/myjs.js" type="text/javascript"></script>
    </body>
</html>

