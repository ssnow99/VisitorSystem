<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="resources/images/favicon.png" type="image/png"/>
        <title>Welcome to Visitor System</title>
        
        <link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="resources/css/animate.css" type="text/css"/>
        <link rel="stylesheet" href="resources/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="resources/css/colors/black.css" type="text/css"/>
    </head>
    <body class="mini-sidebar fix-header">
    	<div class="preloader">
    		<div class="cssload-speeding-wheel"></div>
    	</div>
    	<div id="wrapper">
    		<nav class="navbar navbar-default navbar-static-top m-b-0">
    			<div class="navbar-header">
    				<a class="navbar-toggle font-20 hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
	                    <i class="fa fa-bars"></i>
	                </a>
	                <ul class="nav navbar-top-links navbar-left">
	                	<li class="dropdown">
	                		<a class="dropdown-toggle waves-effect waves-light font-20">Visitor History</a>
	                	</li>
	                </ul>
	                <ul class="nav navbar-top-links navbar-left hidden-xs"></ul>
	                <ul class="nav navbar-top-links navbar-right pull-right">
	                	<li class="dropdown">
	                		<a class="dropdown-toggle waves-effect waves-light font-20" href="${pageContext.servletContext.contextPath}/history">History</a>
	                	</li>
	                </ul>
    			</div>
    		</nav>
    		
    		<div class="page-wrapper">
    			<div class="container-fluid">
    				<div class="row">
    					<div class="col-sm-12">
    						<div class="white-box">
    							<h3>
    								Visitor system is recording visitor that are visiting to this <a href="${pageContext.servletContext.contextPath}/">page</a> and displaying the <a href="${pageContext.servletContext.contextPath}/history">history</a>
    							</h3>
    						</div>
    					</div>
    				</div>
    			</div>
    			<footer class="footer t-a-c">
    				<p class="mb-0">This site or product includes IP2Location LITE data available from <a href="https://lite.ip2location.com">https://lite.ip2location.com</a>.</p>
    			</footer>
    		</div>
    	</div>
        
        <script src="resources/jquery/dist/jquery.min.js"></script>
        <script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="resources/js/sidebarmenu.js"></script>
        <script src="resources/js/jquery.slimscroll.js"></script>
        <script src="resources/js/waves.js"></script>
        <script src="resources/js/custom.js"></script>
    </body>
</html>
