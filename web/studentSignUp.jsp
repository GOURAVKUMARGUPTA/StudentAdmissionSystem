<%-- 
    Document   : studentSignUp
    Created on : 13 Aug, 2021, 5:28:08 PM
    Author     : URL INSTITUTE
--%>
<%@page import="com.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Here</title>
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
        <%@include file="header.jsp" %>
        <!--Navbar Stop-->

        <!--Registration Form Start-->
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
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
                        <div class="card-header bg-primary text-white text-center">
                            <h4>Register Here</h4>
                        </div>
                        <div class="card-body">
                            <form action="RegisterStudent" method="POST" class="needs-validation" novalidate>
                                <div class="form-group">
                                    <label>Student Name</label>
                                    <input type="text" name="studentName" class="form-control"   placeholder="Enter Student name" required>
                                    <div class="invalid-feedback">
                                        Please Enter Student Name
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Mobile Number</label>
                                    <input type="text" name="studentMobile" class="form-control" maxlength="10"   placeholder="Enter Student name" required>
                                    <div class="invalid-feedback">
                                        Please Enter Mobile Number
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Email address</label>
                                    <input type="email" name="studentEmail" class="form-control"  placeholder="Enter Email" required>
                                    <div class="invalid-feedback">
                                        Please Enter Email Address
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label >Password</label>
                                    <input type="password" name="password" class="form-control" placeholder="Enter Password" required>
                                    <div class="invalid-feedback">
                                        Please Enter Password
                                    </div>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary" disabled>Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Registration Form Stop-->


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
