<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

			<a class="navbar-brand">ユーザ名さん</a> <a class="red" href="#">ログアウト</a>

		</nav>
		<div class="form-group">
			<div class="text-center">
				<h1>ユーザ新規登録</h1>
			</div><br>

			<form>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ログインID</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="inputPassword"
							placeholder="">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード(確認)</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ユーザ名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="inputPassword"
							placeholder="">
					</div>
				</div><br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">生年月日</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" id="inputPassword"
							placeholder="">
					</div>
				</div><br>

			</form>

			<div class="text-center">
				<a type="button" class="btn btn-outline-secondary">登録</a>

			</div>
		</div>


		<a href="#">戻る</a>


	</div>


</body>
</html>