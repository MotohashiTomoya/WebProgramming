<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>Insert title here</title>
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
				<h1>ユーザ新規登録</h1>
			</div><br>

			<form class="form-signin" action="NewUserServlet" method="post">

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ログインID</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="loginId"
							placeholder="" name="loginId">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password"
							placeholder="" name="password">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード(確認)</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password"
							placeholder="" name="password">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ユーザ名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="name"
							placeholder="" name="name">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">生年月日</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" id="birthDate"
							placeholder="" name="birthDate">
					</div>
				</div><br>

			</form>

			<div class="text-center">
				<a type="button" class="btn btn-outline-secondary">登録</a>

			</div>
		</div>


		<a href="UserListServlet">戻る</a>


	</div>


</body>
</html>