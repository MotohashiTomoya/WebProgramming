<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報更新</title>
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
				<h1>ユーザ情報更新</h1>
			</div>

			<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>
			<form class="form-signin" action="UserUpdateServlet" method="post">
			<div class="row">
				<div class="col-6">ログインID</div>
				<div class="col-6">${user.loginId}</div>
				<input type="hidden" name="loginId" value="${user.loginId}">
			</div>
			<br> <br> <input type="hidden" name="id" value="${user.id}">

			<div class="form-group row">
				<label for="password" class="col-sm-6 col-form-label">パスワード</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						placeholder="" name="password">
				</div>
			</div>
			<br>

				<div class="form-group row">
					<label for="password" class="col-sm-6 col-form-label">パスワード(確認)</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password1"
							placeholder="" name="password1">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="name" class="col-sm-6 col-form-label">ユーザ名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="name"
							value="${user.name}" name="name">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="birthDate" class="col-sm-6 col-form-label">生年月日</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" id="birthDate"
							value="${user.birthDateStr}" name="birthDate">
					</div>
				</div>
				<br>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">更新</button>

				</div>
			</form>
		</div>


		<a href="UserListServlet">戻る</a>


	</div>

</body>
</html>