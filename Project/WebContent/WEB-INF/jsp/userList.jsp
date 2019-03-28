<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧画面</title>
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
				<h1>ユーザ一覧</h1>
			</div>
			<div align="right">
				<a href="NewUserServlet">新規登録</a>
			</div>
			<form method="post" action="UserListServlet" class="form-horizontal">

				<div class="form-group row">
					<label for="inputLoginId" class="col-sm-2 col-form-label">ログインID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="login-id"
							placeholder="" name="loginId">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputName" class="col-sm-2 col-form-label">ユーザ名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="user-name"
							placeholder="" name="name">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputBirthDate" class="col-sm-2 col-form-label">生年月日</label>
					<div class="col-sm-4">
						<input type="date" class="form-control" id="date-start"
							placeholder="" name="birthDate">
					</div>
					<div class="col-sm-1 offset-sm-1">～</div>
					<div class="col-sm-4 ">
						<input type="date" class="form-control" placeholder="">

					</div>
				</div>
				<div class="text-right">
					<a type="button" class="btn btn-outline-secondary">検索</a>
				</div>

				<hr>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ログインID</th>
							<th scope="col">ユーザ名</th>
							<th scope="col">生年月日</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${userList}">
							<tr>

									<td>${user.loginId}</td>
									<td>${user.name}</td>
									<td>${user.birthDate}</td>

								<td><c:choose>
										<c:when test="${userInfo.loginId=='admin'and user.loginId!='admin'}">
											<a class="btn btn-primary"
												href="UserDetailServlet?id=${user.id}">詳細</a>
											<a class="btn btn-success"
												href="UserUpdateServlet?id=${user.id}">更新</a>
											<a class="btn btn-danger"
												href="UserDeleteServlet?id=${user.id}">削除</a>
										</c:when>
										<c:when
											test="${userInfo.loginId!='admin'and user.loginId!='admin'and user.name==userInfo.name}">
											<a class="btn btn-primary"
												href="UserDetailServlet?id=${user.id}">詳細</a>
											<a class="btn btn-success"
												href="UserUpdateServlet?id=${user.id}">更新</a>
										</c:when>

										<c:when test="${userInfo.loginId!='admin'and user.loginId!='admin'}">
											<a class="btn btn-primary"
												href="UserDetailServlet?id=${user.id}">詳細</a>
										</c:when>
									</c:choose></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>

		</div>
	</div>

</body>
</html>