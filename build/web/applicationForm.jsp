<%-- 
    Document   : applicationForm
    Created on : 17 Aug, 2021, 6:47:56 PM
    Author     : URL INSTITUTE
--%>

<%@page import="com.dataOperation.StateDataOperation"%>
<%@page import="com.entities.State"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.entities.Register"%>
<%@page import="com.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Register register = (Register) session.getAttribute("loginStudent");
    if (register == null) {
        response.sendRedirect("studentLogin.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Application Form</title>

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
                <img src="Images/applicationForm.png" class="img-fluid">
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8 offset-md-2">

                        <form action="SaveApplicationFormServlet?studentId=<%=register.getStudentId() %>" method="POST" class="needs-validation" novalidate>
                            <div class="form-group">
                                <label>Student Name</label>
                                <input type="text" class="form-control" value="<%=register.getStudentName()%>" disabled>
                            </div>
                            <div class="form-group">
                                <label>Student Email</label>
                                <input type="text" class="form-control" value="<%=register.getStudentEmail()%>" disabled>
                            </div>
                            <div class="form-group">
                                <label>Student Mobile No.</label>
                                <input type="text" class="form-control" value="<%=register.getStudentMobile()%>" disabled>
                            </div>
                            <div class="form-group">
                                <label>Select DOB</label>
                                <input type="date" name="dob" class="form-control"  placeholder="Select DOB" required>
                                <div class="invalid-feedback">
                                    Please Select DOB
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Father's Name</label>
                                <input type="text" name="fatherName" class="form-control" placeholder="Enter Father's Name" required>
                                <div class="invalid-feedback">
                                    Please Enter Father's Name
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Mother's Name</label>
                                <input type="text" name="motherName" class="form-control" placeholder="Enter Mother's Name" required>
                                <div class="invalid-feedback">
                                    Please Enter Mother's Name
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Select Gender</label><br>
                                <select name="gender" class="form-control" required>
                                    <option selected disabled value="">---Select Gender---</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Other">Other</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please Select Gender
                                </div>
                            </div>
                            <div class="form-group">
                                <label>City/Town/Village</label>
                                <input type="text" name="city" class="form-control" placeholder="Enter City/Town/Village" required>
                                <div class="invalid-feedback">
                                    Please Enter City/Town/Village Name
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Post</label>
                                <input type="text" name="post" class="form-control" placeholder="Enter Post" required>
                                <div class="invalid-feedback">
                                    Please Enter Post
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Police Station</label>
                                <input type="text" name="policeStation" class="form-control" placeholder="Enter Police Station" required>
                                <div class="invalid-feedback">
                                    Please Enter Police Station
                                </div>
                            </div>
                            <%
                                StateDataOperation stateData=new StateDataOperation(ConnectionProvider.getConnection());
                                ArrayList<State> stateList=stateData.getAllState();
                            %>
                            <div class="form-group">
                                <label>Select State</label>
                                <select name="state" class="form-control" required id="state">
                                    <option selected disabled value="">---Select State---</option>
                                    <%
                                        for (State state : stateList) {
                                           
                                    %>
                                    <option data-othervalue="<%=state.getStateId() %>"><%=state.getState() %></option>
                                    <%
                                        }
                                    %>
                                </select>
                                <div class="invalid-feedback">
                                    Please Select State
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Select District</label>
                                <select name="district" id="district" class="form-control" required>
                                    <option selected disabled value="">---Select District---</option>
                                    
                                </select>
                                <div class="invalid-feedback">
                                    Please Select District
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Enter Pin Code</label>
                                <input type="number" name="pinCode" class="form-control" placeholder="Enter Pin Code" required>
                                <div class="invalid-feedback">
                                    Please Enter Pin Code
                                </div>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary w-50" disabled>Submit</button>
                            </div>
                        </form>
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
