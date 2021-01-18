<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
<head>
  <meta charset="utf-8">
  <title>Listing Bookings</title>
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

    <!--==========================
      Portfolio Section
    ============================-->
    <br>
    <br>
    <section id="portfolio"  class="section-bg" >
      <div class="container" >
      	<div align="middle">
                <a  class="btn-get-started scrollto" id="intro2"  href="/deleteListing/${product.getId()}" style="background-color:red" align="middle">Delete Listing</a>
				<br><br>
		</div>
        <header class="section-header">
          <h3 class="section-title">bookings for ${product.getName()}</h3>
        </header>

        <div class="row">
          <div class="col-lg-12">
            <ul id="portfolio-flters">
              <li data-filter="*" class="filter-active">All</li>
              <li data-filter=".filter-app">App</li>
              <li data-filter=".filter-card">Card</li>
              <li data-filter=".filter-web">Web</li>
            </ul>
          </div>
        </div>
        <div class="row portfolio-container">
        
        <c:forEach items="${bookings}"  var="book"  >
        <%-- <a href="/listBook/${book.getId()}"> --%>
          <div class="col-lg-12 col-md-12 portfolio-item filter-app wow fadeInUp" style="min-height: 150px;max-height: 180px">
            <div class="portfolio-wrap" >
              <figure class="extra">
                <%-- <img src="data:image/jpeg;base64,${book.getBase64()}" class="img-fluid" alt="" style="width:100%"> --%>
                </figure>

              <div class="portfolio-info" style="min-height: 170px;max-height:180px;padding: 10px">
              <div class="col-lg-6 col-md-6" style="float:left">
                <h4>Booked by: ${userRepo.findByid(book.getRenterid()).getfirstname()} ${userRepo.findByid(book.getRenterid()).getlastname()}</h4>
                <h4><img src="data:image/jpeg;base64,${userRepo.findByid(book.getRenterid()).getBase64()}" style=" width: 70px; height: 70px; border-radius: 50%; margin: 0 auto;border: 4px solid #f4e842;" id="profile-img" alt=""></h4>
                <h4>�${book.getCost()}</h4>
                 <%-- <c:set var = "start" value = "${book.getStartdate()}"/>
                 <c:set var = "end" value = "${book.getEnddate()}"/>
                <p>From: ${fn:substring(start, 0, 10)}</p>
                <p>To:${fn:substring(end, 0, 10)}</p> --%>
                </div>
                <div class="col-lg-6 col-md-6" style="float:right">
                 <c:set var = "start" value = "${book.getStartdate()}"/>
                 <c:set var = "end" value = "${book.getEnddate()}"/>
                <h4>From: ${fn:substring(start, 0, 10)}</h4>
                <h4>To:${fn:substring(end, 0, 10)}</h4> 
                <div id="intro" style="text-align: center;margin: auto;width: 0%; height: 0vh;background:#fff">
			     <c:if test="${book.confirmed()==0}">
			        <a class="btn-get-started scrollto"  style="color:green" href="/accept/${book.getId()}" align="middle">Accept</a>
			        <a class="btn-get-started scrollto"  style="color:red" href="/decline/${book.getId()}" align="middle">Decline</a>
      			 </c:if>
      			 <c:if test="${book.confirmed()==1}">
      			 	<c:if test="${book.getAccepted()==1}"><br>
      			 		<h4 style="color:green">Booking has been Accepted</h4>
      			 	</c:if>
      			 	<c:if test="${book.getAccepted()==0}"><br>
      			 		<h4 style="color:red">Booking has been Declined</h4>
      			 	</c:if>
      			 </c:if>
      			 </div>
                </div>
              </div>
            </div>
          </div>
          </c:forEach>


        </div>

      </div>
    </section><!-- #portfolio -->


  </main>
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