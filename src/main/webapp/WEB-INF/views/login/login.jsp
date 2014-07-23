<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
</head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/lib/bootstrap/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="/css/lib/bootstrap/bootstrap-theme.min.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="/js/lib/bootstrap/bootstrap.min.js"></script>
<script src="/js/login/login.js"></script>

<body>

<div class="container">
	<div class="page-header">
	  <h3>로그인</h3>
	</div>
	
	<div class="jumbotron">
		<div class="form-group">
			<label for="exampleInputEmail1">아이디</label> <input type="email" class="form-control loginId" id="exampleInputEmail1" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">비밀번호</label> <input type="password" class="form-control loginPassword" id="exampleInputPassword1" placeholder="Password">
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> 아이디 저장</label>
		</div>
		
		<p class="text-right">
			<button type="submit" class="btn btn-success btnLogin">로그인</button>
		</p>
	</div>
</div>

</body>
</html>