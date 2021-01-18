  <div class="container-fluid">

      <div id="logo" class="pull-left">
        <h1><a href="#intro" class="scrollto">Odia</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="#intro"><img src="img/logo.png" alt="" title="" /></a>-->
      </div>

      <nav id="nav-menu-container">
        <ul class="nav-menu">
          <li><a href="/home">Home</a></li>
          <li><a href="/bookings">Bookings</a></li>
          <li><a href="/listings">Listings</a></li>
          <li><a href="/profile">Profile (${user.getfirstname()}) <img src="data:image/jpeg;base64,${user.getBase64()}" style=" width: 30px; height: 30px; border-radius: 50%; margin: 0 auto;" alt=""></a></li>
          <li><a href="/">Logout</a></li>
        </ul>
      </nav><!-- #nav-menu-container -->
    </div>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>