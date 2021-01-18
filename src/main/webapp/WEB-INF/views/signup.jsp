<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="/img/favicon.png" rel="icon">
  <link href="/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="/lib/animate/animate.min.css" rel="stylesheet">
  <link href="/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="/css/style.css" rel="stylesheet">
</head>
<body>
  <header id="header" class="header-scrolled">

  <div class="container-fluid">

      <div id="logo" class="pull-left">
        <h1><a href="/#intro" class="scrollto">Odia</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="/#intro"><img src="/img/logo.png" alt="" title="" /></a>-->
      </div>

    </div>
     </header><!-- #header -->
     <main id="main">   
 <br><br><br><br>

<form:form method="POST" modelAttribute="user" action="/signup/add" enctype="multipart/form-data">
<table>
                <tr>
                    <td><form:label path="firstname">First name:</form:label></td>
                    <td><form:input path="firstname"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastname">Last name:</form:label></td>
                    <td><form:input path="lastname"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email" name="email" id="email" type="email" 
                    onkeyup="CheckEmailAvailability()"/><span id="emailmessage"></span></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password:</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="password2">Password (verification):</form:label></td>
                    <td><form:input path="password2"/></td>
                </tr>
                <tr>
                    <td><form:label path="Birthdate">Birth Date:</form:label></td>
                    <td><form:input path="Birthdate" placeholder="DD/MM/YYYY" /></td>
                </tr>
                <tr>
                    <td><form:label path="phonenumber">Phone Number:</form:label></td>
                    <td><form:input path="phonenumber" name="phonenumber" id="phonenumber" type="number"
                    onkeyup="CheckPhoneAvailability()"/><span id="phonemessage"></span></td>
                </tr>
                <tr>
                    <td><form:label path="file">Profile Picture:</form:label></td>
                    <td><form:input path="file" type="file" name="file"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add" name="add" id="add"/>
       
            <input type="submit" value="Cancel" name="cancel" /></td>
                </tr>
            </table>

</form:form>
</main>
</body>
<script type="text/javascript">
function CheckEmailAvailability() {
    var email = $("#email").val();
    console.log("hello");
    $.ajax({
        type: "GET",
        url: "/signup/ajax/"+email,
        success: function (result) {
            var message = $("#emailmessage");
            if ($.trim(result)=="itExists") {
                //Email available.
                $("#add").prop('disabled',false);
                message.css("color", "green");
                message.html("     email is available");
            }
            else if ($.trim(result)=="No"){
                //Email not available.
                
                $("#add").prop('disabled',true);
                message.css("color", "red");
                message.html("     email NOT available");
            }
        }
    });
};

function CheckPhoneAvailability() {
    var phonenumber = $("#phonenumber").val();
    console.log("hello");
    $.ajax({
        type: "GET",
        url: "/signup/ajaxphone/"+phonenumber,
        success: function (result) {
            var message = $("#phonemessage");
            if ($.trim(result)=="itExists") {
                //Email available.
                $("#add").prop('disabled',false);
                message.css("color", "green");
                message.html("     Phone number is available");
            }
            else if ($.trim(result)=="No"){
                //Email not available.
                
                $("#add").prop('disabled',true);
                message.css("color", "red");
                message.html("     Phone number is NOT available");
            }
        }
    });
};
</script>

<script src="/lib/jquery/jquery.min.js"></script>
  <script src="/lib/jquery/jquery-migrate.min.js"></script>
  <script src="/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/lib/easing/easing.min.js"></script>
  <script src="/lib/superfish/hoverIntent.js"></script>
  <script src="/lib/superfish/superfish.min.js"></script>
  <script src="/lib/wow/wow.min.js"></script>
  <script src="/lib/waypoints/waypoints.min.js"></script>
  <script src="/lib/counterup/counterup.min.js"></script>
  <script src="/lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="/lib/isotope/isotope.pkgd.min.js"></script>
  <script src="/lib/lightbox/js/lightbox.min.js"></script>
  <script src="/lib/touchSwipe/jquery.touchSwipe.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="/contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="/js/main.js"></script>
</html>