<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
<head>
  <meta charset="utf-8">
  <title>BizPage Bootstrap Template</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">

  <!-- =======================================================
    Theme Name: BizPage
    Theme URL: https://bootstrapmade.com/bizpage-bootstrap-business-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>

  <!--==========================
    Header
  ============================-->
  <header id="header" class="header-scrolled">
  <jsp:include page="header.jsp"/>
  </header><!-- #header -->
  <br><br>
 <main id="main">

    <section id="services">
      <div class="container">

        <header class="section-header wow fadeInUp">
          <h3><img src="data:image/jpeg;base64,${user.getBase64()}" style=" width: 90px; height: 90px; border-radius: 50%; margin: 0 auto;border: 4px solid #f4e842;" id="profile-img" alt=""> Profile</h3>
          <p></p>
        </header>

        <div class="row">

          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-contact-outline"></i></div>
            <h4 class="title"><a href="">First Name</a></h4>
            <p class="description">${user.getfirstname()}</p>
          </div>
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-contact-outline"></i></div>
            <h4 class="title"><a href="">Last Name</a></h4>
            <p class="description">${user.getlastname()}</p>
          </div>
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-email-outline"></i></div>
            <h4 class="title"><a href="">Email</a></h4>
            <p class="description">${user.getemail()}</p>
          </div>
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-calendar-outline"></i></div>
            <h4 class="title"><a href="">Birth Date</a></h4>
            <c:set var = "birth" value = "${user.getbirthdate()}"/>
            <p class="description">${fn:substring(birth, 0, 10)}</p>
          </div>
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-android-call"></i></div>
            <h4 class="title"><a href="">Phone Number</a></h4>
            <p class="description">${user.getphonenumber()}</p>
          </div>
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-code-working"></i></div>
            <h4 class="title"><a href="">Password</a></h4>
            <p class="description">${user.getpassword()}</p>
          </div>

        </div>
        <center id="intro" style="height:5vh;background:#fff">
        <a class="btn-get-started scrollto" id="popup" onclick="div_show()">Edit</a>
        </center>
        
      </div>
      <div id="abc" style="display:none">
<!-- Popup Div Starts Here -->
<div class="form">
<!-- Contact Us Form -->
<form:form   modelAttribute="user" method="POST" action="/editUser" >

First Name:<form:input path="firstname" type="text" name="firstname" class="form-control" id="firstname"  placeholder="" data-rule="firstname"/><br>
Last Name:<form:input path="lastname" type="text" class="form-control" name="lastname" id="lastname" placehoder="" data-rule="lastname" /><br>
Date of Birth:<form:input path="birthdate" type="text" class="form-control" value="${fn:substring(birth, 5, 7)}/${fn:substring(birth, 8, 10)}/${fn:substring(birth, 0, 4)}" name="birthdate" id="birthdate" placehoder="" data-rule="birthdate" /><br>
Phone Number:<form:input path="phonenumber" type="text" name="phonenumber"  class="form-control" id="phonenumber" /><br>
Email:<form:input path="Email" type="text" name="Email"  class="form-control" id="Email" /><br>
Password:<form:input path="password" type="text" name="password"  class="form-control" id="password" />
Confirm Password:<form:input path="password2" type="text" name="password2" value="" class="form-control" id="password2" />
<input style="position:centre" type="submit" value="Save" name="Save">
</form:form>
</div>
<!-- Popup Div Ends Here -->
</div>
                <script type="text/javascript">
                	//Function To Display Popup
                	function div_show() {
                	document.getElementById('abc').style.display = "block";
                	document.getElementById('popup').innerHTML = "Cancel";
                	document.getElementById('popup').onclick = div_hide;
                	}
                	//Function to Hide Popup
                	function div_hide(){
                	document.getElementById('abc').style.display = "none";
                	document.getElementById('popup').innerHTML = "Edit";
                	document.getElementById('popup').onclick = div_show;
                	}

                </script>
    </section><!-- #services -->

  </main>
<footer id="footer">
 <jsp:include page="footer.jsp"/>
  </footer><!-- #footer -->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/isotope/isotope.pkgd.min.js"></script>
  <script src="lib/lightbox/js/lightbox.min.js"></script>
  <script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>