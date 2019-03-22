<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="css/common.css" rel="stylesheet">
</head>
<body>
	<div class="login-form-area">
		<nav class="navbar navbar-dark bg-secondary">

			<div class="navbar-text">${userInfo.name}さん</div>


			<a class="red" href="LogoutServlet">ログアウト</a>

		</nav>
		<div class="form-group">
			<div class="text-center">
				<h1>ユーザ削除確認</h1>
			</div>
			<br>
			<div class="delete">
				ログインID:${user.loginId}<br> を本当に削除してよろしいでしょうか。
			</div>
		</div>
		<br>
		<br>
		<br>

		<div class="row">
		<div class="col-sm-6 text-center">
			<a type="button" class="btn btn-outline-secondary"href="UserListServlet">キャンセル</a>
		</div>
		<form class="form-signin" action="UserDeleteServlet" method="post">
		<input type="hidden" name="id" value="${user.id}">
		<div class="col-sm-6 text-center">
			<button type="submit" class="btn btn-primary">OK</button>

		</div>
		</form>
		</div>

	</div>

</body>
</html>