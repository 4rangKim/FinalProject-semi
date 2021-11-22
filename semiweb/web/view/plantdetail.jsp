<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			.box{
				text-align: center;
			}
			.container{
				margin: 50px;
				display: inline-block;
			}
			.plantname{
				font-size: 30pt;
				font-weight: bold;
				border: solid 3px #99bd7d; 
				border-radius: 30px;
				padding: 10px;
				margin-right: 200px;
				margin-left: 200px;
			}
			.row{
				margin: 50px;
			}
			#head{
				font-size: 20pt;
				font-weight: bold;
				color: #888b81;
			}
			table{
				height: 300px;
			}
			.icon{
				width: 30px;
				height: 30px;
				margin: 10px;
			}
			.property {
				font-size: 20pt;
				font-weight: bold;
				color: #010101;
			}
		</style>
	</head>
	<body>
		<div class="box">
		<div class="container">
			<div>
				<p class="plantname">���׶�</p>
			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<img class="myplantimg" alt="" src="img/myplant.PNG">
				</div>
				<div class="col-sm-7">
					<table>
						<tr>
							<td id="head" class="col-sm-3">�µ�<img class="icon" alt="" src="img/temp.png"></td>
							<td class="col-sm-4 temp property">��</td>
						</tr>
						<tr>
							<td id="head" class="col-sm-3">����<img class="icon" alt="" src="img/humi.png"></td>
							<td class="col-sm-4 humi property">%</td>
						</tr>
						<tr>
							<td id="head" class="col-sm-3">����<img class="icon" alt="" src="img/light.png"></td>
							<td class="col-sm-4 light property">lux</td>
						</tr>
					</table>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
		</div>
	</body>
</html>