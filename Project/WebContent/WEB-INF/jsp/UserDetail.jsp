<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ詳細</title>
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
				<h1>ユーザ情報詳細参照</h1>
			</div>
			<br>

<form class="form-signin" action="UserDetailServlet" method="get">
			<div class="row">
				<div class="col-6">ログインID</div>
				<div class="col-6">
					${user.loginId}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">ユーザ名</div>
				<div class="col-6">
					${user.name}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">生年月日</div>
				<div class="col-6">
					${user.birthDate}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">登録日時</div>
				<div class="col-6">
					${user.createDate}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">更新日時</div>
				<div class="col-6">
					${user.updateDate}
				</div>
			</div>
			<br>
			</form>
			 <a href="UserListServlet">戻る</a>
		</div>
	</div>
</body>
</html>