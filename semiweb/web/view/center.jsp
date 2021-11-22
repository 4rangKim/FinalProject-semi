<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			.container{
				margin: 50px;
			}
			.myplant{
				height: 300px;
				border: solid 1px #a9a5a6;
				border-radius: 20px;
				text-align: center;
			}
			.myplantimg{
				margin-top:20px;
				margin-bottom: 20px;
				width: 130px;
				height: 200px;
				display: inline-block;
			}
			.plantname{
				display: inline-block;
				font-size: 15pt;
				font-weight: bold;
				color: #73697c;
				border-bottom: solid 2px #acd5b0;
			}
			a:link {
				text-decoration: none; color: #73697c;
			}
			a:visited {
				text-decoration: none; color: #73697c;
			}
			a:active {
				text-decoration: none; color: #73697c;
			}
			a:hover {
				text-decoration: none; color: #73697c;
			}

		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-sm-2 myplant">
					<div>
						<a  href="plantdetail.mc"><img class="myplantimg" alt="" src="img/myplant.PNG"></a>
					</div>
					<div>
						<p class="plantname"><a href="plantdetail.mc">몬스테라</a></p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

