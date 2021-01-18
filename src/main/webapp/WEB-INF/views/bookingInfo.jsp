<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
  <section id="intro">
    <div class="intro-container">
      <div id="introCarousel" class="carousel  slide carousel-fade" data-ride="carousel">

        <ol class="carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <div class="carousel-item active">
            <div class="carousel-background" ><img style="width:100%" src="data:image/jpeg;base64,${products.findByid(book.getProductid()).getBase64()}" alt=""></div>
            <div class="carousel-container">
              <div class="carousel-content" >
                <h2>Booking for ${products.findByid(book.getProductid()).getName()}</h2>
                <p>${products.findByid(book.getProductid()).getDescription()}</p>                
                <p>Total Cost: £${book.getCost()}</p>                
                <c:set var = "start" value = "${book.getStartdate()}"/>
                 <c:set var = "end" value = "${book.getEnddate()}"/>
                <p>From: ${fn:substring(start, 0, 10)}</p>
                <p>To:${fn:substring(end, 0, 10)}</p>
                <c:choose>
                		<c:when test="${date.getTime()<book.getStartdate().getTime()}">
                		<p>This booking starts in ${days} days</p>
   				 	</c:when>
   				 	<c:when test="${date.getTime()>=book.getStartdate().getTime() && date.getTime()<book.getEnddate().getTime()}">
                		<p>This booking has started and ends in ${days2} days</p>
   				 	</c:when>
   				 	<c:otherwise>
   				 	<p>This booking has ended</p>
   				 	</c:otherwise> 
                </c:choose>
                <a  class="btn-get-started scrollto" id="popup" href="/deleteBooking" style="background-color:red">Delete</a>
                <c:if test="${date.getTime()<book.getStartdate().getTime()}">
                		<a  class="btn-get-started scrollto" id="popup" onclick="div_show()">Edit</a>
                </c:if >
<div id="abc" style="display:none">
<!-- Popup Div Starts Here -->
<div >
<!-- Contact Us Form -->
<form:form   modelAttribute="booking" method="POST" action="/editBooking" >

From:<form:input path="startdate" type="text" onclick="this.select()" name="startdate" class="form-control" id="startdate"  placeholder="${fn:substring(start, 5, 7)}/${fn:substring(start, 8, 10)}/${fn:substring(start, 0, 4)}" data-rule="startdate"/><br>
To:<form:input path="enddate" type="text" onclick="this.select()" name="enddate" class="form-control" id="enddate" placeholder="${fn:substring(end, 5, 7)}/${fn:substring(end, 8, 10)}/${fn:substring(end, 0, 4)}" data-rule="enddate" /><br>
<form:input type="hidden" path="productid"  name="productid" value="${book.getProductid()}" id="productid" />
<form:input type="hidden" path="renterid"  name="renterid" value="${book.getRenterid()}" id="renterid" />
<input type="submit" value="Save" name="Save">
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
              </div>
            </div>
          </div>

      </div>
    </div>
    </div>
  </section><!-- #intro -->
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