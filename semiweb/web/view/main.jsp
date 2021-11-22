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
<style type="text/css">
	.plantimg{
		width: 100px; 
		height: 100px;
	}
	.mainname{
		font-size: 25pt;
		font-weight: bold;
		color: #73a853;
		margin-top: 20px;
	}
	.mainchar{
		font-size: 40pt;
		font-weight: bold;
		color: #446431;
		margin-top: 20px;
	}
</style>
<body>
	<header>
		<!-- top -->
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<a href="main.mc"><img class="plantimg" alt="" src="img/plant.png"></a>
			<div>
				<span class="mainchar">G</span>
				<span class="mainname">rowing</span>&nbsp;&nbsp;&nbsp;
				<span class="mainchar">P</span>
				<span class="mainname">lants</span>
			</div>
		</div> <!-- End top -->
		<!-- nav -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="#">My plant</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#"></a></li>
					<li class="nav-item"><a class="nav-link" href="#"></a></li>
					<li class="nav-item"><a class="nav-link" href="#"></a></li>
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
				<jsp:include page="${center}.jsp" />
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<div class="jumbotron text-center footer">
		  <p>@Final Project - Gruop1</p>
		</div>
	</footer>
</body>
</html>




