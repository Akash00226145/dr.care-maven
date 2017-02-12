<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<!-- Website Title & Description for Search Engine purposes -->
		<title></title>
		<meta name="description" content="">
		
		<!-- Mobile viewport optimized -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- Bootstrap CSS -->
		<link href="asset/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="asset/includes/css/bootstrap-glyphicons.css" rel="stylesheet">
		<link href="asset/includes/css/signin.css" rel="stylesheet">
		<link href="asset/includes/css/sticky-footer.css" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="asset/includes/css/styles.css" rel="stylesheet">
		
		<script type="text/javascript" src="asset/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="asset/js/custom.js"></script>

	</head>
	<body>
	
		<div class="container" id="main">

			<div class="navbar navbar-fixed-top">
				<div class="container" style="padding: 0;">
					
					<button class="navbar-toggle" data-target=".navbar-responsive-collapse" data-toggle="collapse" type="button">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>

					<a class="navbar-brand" href="/"><img src="asset/images/logo.png" alt="Your Logo"></a>

					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav navbar-nav">
							<li>
								<a href="index.jsp">Home</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Services<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="adminlogin.jsp">Admin Login</a>
										</li>
										<li>
											<a href="#">GP Login</a>
										</li>
										<li>
											<a href="#">Pharmacist Login</a>
										</li>
										<li>
											<a href="OtherStaffLogin.jsp">Other Staff Login</a>
										</li>
										<li>
											<a href="#">Patient Login</a>
										</li>
										<li class="divider"></li>

										<li class="dropdown-header">More Services</li>
										<li>
											<a href="#">About Us</a>
										</li>
										<li>
											<a href="#">Social Media</a>
										</li>
									</ul>
							</li>
						</ul>

						<form class="navbar-form pull-left"  >
							<input type="text" class="form-control" placeholder="Search product..." id="searchInput">
							<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
						</form><!-- end navbar-form -->
						
						<ul class="nav navbar-nav pull-right">
							<li>
								<a href="#"><span class="glyphicon glyphicon-user"></span>My Account</a>
							</li>
						</ul><!-- end nav pull-right -->

					</div><!-- end nav-collapse -->
				</div><!-- end container -->
				
			</div><!-- end navbar-->

			<div class="row" id="featuresHeading">
				<div class="col-12">
					
				</div>
				
			</div>


			<div class="container">
			 <form class="form-signin"  method="post" action="GPRegisterServlet" enctype="multipart/form-data" >
			       
			        <h2 class="form-signin-heading"   style="font-family: cursive;">Add a GP:</h2><br>
			        
			        <label for="GPName" class="sr-only">GP Name</label>
			        <input type="text" id="inputGPName" class="form-control" placeholder="GP Name" name="gpusername" required autofocus><br>
			        
			        <label for="gpEmail" class="sr-only">GP email</label>
			        <input type="text" id="inputEmail" class="form-control" placeholder="GP email" name="gpemail" required autofocus><br>
			        
			        <label for="gpAddress" class="sr-only">GP Address</label>
			        <input type="text" id="inputGPAddress" class="form-control" placeholder="GP Address" name="gpaddress" required autofocus><br>
			        
			        <label for="gpPhone" class="sr-only">GP PhoneNumber</label>  
			        <input type="text" id="inputGPPhone" class="form-control" placeholder="GP Phone" name="gpphone" required autofocus><br>
    			    
    			    <input type="file" name="fileName"><br>
    			       
			        <jsp:useBean id="uuid" class="controller.GenerateUUIDBean" />
			        <label for="UUIDPassword" class="sr-only">Generate Unique Password</label>
			        <input type="text" value='<jsp:getProperty property="UUID" name="uuid"/>' id="UUIDPassword" class="form-control" placeholder="UUIDPassword" name="UUIDpassword" disabled> 
			       
			       
			        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Upload">Create GP</button><br><br>
			      </form>
				
			</div>


			<div class="row" id="moreInfo">
					
			</div>


			<div class="row" id="moreCources">
				
			</div>

		</div><!-- end container -->

		<footer class="footer">
			<div class="container">
				<div class="row">
						<img src="asset/images/HTML5White.png" 
					width="63" height="64" alt="HTML5 Powered" title="HTML5 Powered">
					<p>&copy; copyright 2016 AIT SRI Web Society</p>
				</div>
			</div>
		</footer>
	

	<!-- All Javascript at the bottom of the page for faster page loading -->
		
	<!-- First try for the online version of jQuery-->
	<script src="https://code.jquery.com/jquery.js"></script>
	
	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>window.jQuery || document.write('<script src="includes/js/jquery-1.8.2.min.js"><\/script>')</script>
	
	<!-- Bootstrap JS -->
	<script src="asset/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Custom JS -->
	<script src="asset/includes/js/script.js"></script>
	
	</body>