<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Board</title>
</head>

<link rel="stylesheet" href="/css/lib/bootstrap/bootstrap.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/lib/bootstrap/bootstrap-theme.min.css">
<!-- Optional theme -->

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/js/lib/bootstrap/bootstrap.min.js"></script>
<!-- Latest compiled and minified JavaScript -->

<body>

	<div class="container">

		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">SpringTest </a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">DashBoard</a></li>
						<li class="active"><a href="#">Board</a></li>
						<!-- 
				        <li><a href="#">Link</a></li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#">Action</a></li>
				            <li><a href="#">Another action</a></li>
				            <li><a href="#">Something else here</a></li>
				            <li class="divider"></li>
				            <li><a href="#">Separated link</a></li>
				            <li class="divider"></li>
				            <li><a href="#">One more separated link</a></li>
				          </ul>
				        </li>
				        -->
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="검색어 입력">
						</div>
						<button type="submit" class="btn btn-default">검색</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">${loginSession.userName } <span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">정보수정</a></li>
								<li class="divider"></li>
								<li><a href="/login.do">로그아웃</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>