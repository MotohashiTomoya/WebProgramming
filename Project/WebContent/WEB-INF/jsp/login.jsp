<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="css/common.css" rel="stylesheet">
</head>
<body>

	<div class="login-form-area">
		<div class="text-center">
			<h1>ログイン画面</h1>
		</div>
		<br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
		<form class="form-signin" action="LoginServlet" method="post">
			<div class="form-group row">
				<label for="inputLoginId" class="col-sm-2 col-form-label">ログインID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="loginId" name="loginId"
						placeholder="">
				</div>
			</div>
			<br>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label">パスワード</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="">
				</div>
			</div>
			<br>

			<div class="text-center">

				<button type="submit" class="btn btn-primary">ログイン</button>
			</div>
		</form>
	</div>

</body>
</html>