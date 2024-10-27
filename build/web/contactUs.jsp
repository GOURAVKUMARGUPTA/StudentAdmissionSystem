<%-- 
    Document   : contactUs
    Created on : 8 Sep, 2021, 1:26:24 PM
    Author     : URL INSTITUTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        <!--Bootstrap CSS Start-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Bootstrap CSS Stop-->
        <link href="MyCSS/myCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Navbar Start-->
        <%@include file="header.jsp" %>
        <!--Navbar Stop-->

        <!--Contact US Content Start-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <h3 style="text-align: center;margin-top: 20px;text-decoration: underline">Contact Us</h3>
                    <p style="text-align: justify;margin-top: 30px" class="text-center">
                        URL INSTITUTE<br>
                       Zabra Road,Korrah<br>
                       Hazaribag , 825301<br>
                       Email : urlinstitute@gmail.com<br>
                       Mob. No. : 7004890883
                       
                    </p>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-body">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3644.9857446045207!2d85.38502521430193!3d23.996280485257092!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39f49ddc8708011b%3A0x4c83d14bf69b03b7!2sURL%20INSTITUTE!5e0!3m2!1sen!2sin!4v1631088516092!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--Contact Us Content Stop
        
        
        <!--Footer Start-->
        <%@include file="footer.jsp" %>
        <!--Footer Stop-->
        <!--Bootsstrap JS Start-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--Bootsstrap JS Start-->
    </body>
</html>

