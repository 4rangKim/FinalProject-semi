<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<body>
	<header>
		<!-- top -->
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<h1>My First Bootstrap 4 Page</h1>
			<p>Resize this responsive page to see the effect!</p>
		</div> <!-- End top -->
		<!-- nav -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				</ul>
			</div>
		</nav> <!-- End nav -->
	</header>
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="center.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp" />
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<div class="jumbotron text-center" style="margin-bottom:0">
		  <p>Footer</p>
		</div>
	</footer>
</body>
</html>




