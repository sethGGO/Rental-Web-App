<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Booking</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
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

  

  <main id="main">
<section id="intro" class="section-bg wow fadeInUp">
      <div class="intro-container">
      <div id="introCarousel" class="carousel  slide carousel-fade" data-ride="carousel">

        <ol class="carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <div class="carousel-item active">
            <div class="carousel-background" ><img style="height:100%" src="data:image/jpeg;base64,${product.getBase64()}" alt=""></div>
            <div class="carousel-container"  style="color:#fff">
              <div class="carousel-content">
          <h3>Make a booking for- ${product.getName()}</h3>
          <h3>${product.getDescription()}</h3>
          <!-- <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque</p> -->
        </div>


        <div>
          <form:form method="POST" modelAttribute="booking" action="/addBooking">
          <div style="text-align: center;margin: auto" >
          <h3>Lister - ${userRepo.findByemail(product.getLister()).getfirstname()} ${userRepo.findByemail(product.getLister()).getlastname()}</h3>
           <h3><img src="data:image/jpeg;base64,${userRepo.findByemail(product.getLister()).getBase64()}" style=" width: 120px; height: 120px; border-radius: 50%; margin: 0 auto;border: 4px solid #f4e842;" id="profile-img" alt=""></h3>
            <h3>Cost per day - £${product.getPrice()}</h3>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
              Start Date
                <form:input path="startdate" type="text" name="startdate" class="form-control" id="startdate" placeholder="MM/DD/YYYY" onclick="this.select()" onkeyup="CheckDateAvailability()" data-rule="startdate"/>
                <div class="validation"></div>
              </div>
              <div class="form-group col-md-6">
              End Date
                <form:input path="enddate" type="text" class="form-control" name="enddate" id="enddate" placeholder="MM/DD/YYYY" data-rule="enddate" onclick="this.select()" onkeyup="CheckDateAvailability()" data-msg="Please enter a valid price" />
                <div class="validation"></div>
              </div>
              <span id="datemessage"></span>
              <form:input type="hidden" value="${product.getId()}" path="productid"  name="productid" id="productid" />
              <form:input type="hidden" value="${user.getid()}" path="renterid"  name="renterid" id="renterid" />
            </div>
            <div class="text-center"><input type="submit" value="Book" name="Book" id="Book"></div>
          </form:form>
        </div> 
	  </div>
	  </div>
	</div>
	</div>
      </div>
    </section>
<script>

function CheckDateAvailability() {
    var startdate = $("#startdate").val();
    var enddate = $("#enddate").val();
    console.log("hello");
    $.ajax({
        type: "GET",
        url: "/ajax/"+startdate+"/"+enddate,
        success: function (result) {
            var message = $("#datemessage");
            if ($.trim(result)=="itExists") {
                //Email available.
                $("#Book").prop('disabled',false);
                message.css("color", "green");
                message.html("     Product is available on these dates");
            }
            else if ($.trim(result)=="No"){
                //Email not available.
                
                $("#Book").prop('disabled',true);
                message.css("color", "red");
                message.html("     Product is NOT available on these dates");
            }
        }
    });
};
</script>
  </main>

  <!--==========================
    Footer
  ============================-->
<footer id="footer">
 <jsp:include page="footer.jsp"/>
  </footer><!-- #footer -->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- JavaScript Libraries -->
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

</body>
</html>