<%-- 
    Document   : imageUpload
    Created on : 31 Aug, 2021, 6:50:02 PM
    Author     : URL INSTITUTE
--%>
<%@page import="com.entities.StudentRecord"%>
<%@page import="com.dataOperation.StudentDataOperation"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.entities.Register"%>
<%@page import="com.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Register register = (Register) session.getAttribute("loginStudent");
    if (register == null) {
        response.sendRedirect("studentLogin.jsp");
    } else {
        StudentDataOperation studentData = new StudentDataOperation(ConnectionProvider.getConnection());
        StudentRecord student = studentData.getStudentRecordByStudentId(register.getStudentId());
        if (!student.isApplicationForm()) {
            response.sendRedirect("home.jsp");
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Upload</title>

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
                <h6 style="padding-left: 50px">Welcome : <%=register.getStudentName()%></h6>
            </div>
            <div class="container mt-3 text-center">
                <img src="Images/imageUpload.png" class="img-fluid">
            </div>
            <div class="container mt-3">

                <form action="UploadImageServlet?studentId=<%=register.getStudentId()%>" method="POST" enctype="multipart/form-data" class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col-md-8">
                            <div class="form-group">
                                <label>Select PhotoGraph</label>
                                <input type="file" name="photo" accept="image/x-png,image/jpg,image/jpeg" onchange="ValidatePhoto(this);" id="photo" class="form-control" required>
                                <div class="invalid-feedback" id="photoMsg">
                                    Please Choose PhotoGraph
                                </div>
                            </div>
                            <div class="form-group">
                                <a id="uploadPhoto" class="btn btn-primary text-white">Upload</a>
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="text-center">
                                <img height="100px" width="100px" id="showPhoto" src="Images/dummyPhoto.jpg">
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-8">
                            <div class="form-group">
                                <label>Select Signature</label>
                                <input type="file" name="signature" id="signature" accept="image/x-png,image/jpg,image/jpeg" class="form-control" onchange="ValidateSignature(this);" required>
                                <div class="invalid-feedback" id="signatureMsg">
                                    Please Choose Signature
                                </div>
                            </div>
                            <div class="form-group">
                                <a class="btn btn-primary text-white" id="uploadSign">Upload</a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="text-center">
                                <img height="50px" id="showSignature" width="150px" src="Images/dummySignature.png">
                            </div>
                        </div>
                    </div>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-primary w-50" disabled>Upload Image</button>
                    </div>
                </form>
                <br>
                <br>
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
<%
    }
%>