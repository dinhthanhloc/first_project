<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-up</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
	crossorigin="anonymous"></script>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<script src="<%=url%>/JavaScript/error.js"></script>

<style>
.error {
	color: red;
}

.center {
	text-align: center;
}

.form-signin {
	max-width: 400px;
}

.form {
	max-width: 900px;
}

.center-div {
	margin: 0 auto;
}

body, html {
	color: #ffeba7;
	background-color: #1f2029;
	background: radial-gradient(ellipse at bottom, #1B2735 0%, #12141d 100%);
	height: 100%;
}
</style>

</head>

<body>

	<%
	String errorUsername = request.getAttribute("errorUsername") + "";
	errorUsername = (errorUsername.equals("null")) ? "" : errorUsername;

	String errorEmail = request.getAttribute("errorEmail") + "";
	errorEmail = (errorEmail.equals("null")) ? "" : errorEmail;

	String errorPassword = request.getAttribute("errorPassword") + "";
	errorPassword = (errorPassword.equals("null")) ? "" : errorPassword;

	String errorPasswordAgain = request.getAttribute("errorPasswordAgain") + "";
	errorPasswordAgain = (errorPasswordAgain.equals("null")) ? "" : errorPasswordAgain;

	

	String value_username = request.getAttribute("value_username") + "";
	String value_email = request.getAttribute("value_email") + "";

	value_username = (value_username.equals("null")) ? "" : value_username;
	value_email = (value_email.equals("null")) ? "" : value_email;
	%>

	<h2 class="center">Sign-up</h2>
	<div class="container mt-3">
		<form action="<%=url%>/khach-hang" method="post" id="my_form">
			<input name="action" type="hidden" value="save-signup">
			<div class="row form-signin center-div">
				<!-- email -->
				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="name@example.com" value="<%=value_email%>"
							required="required" autocomplete="off"> <label
							for="email" style="color: #E0BC41">Email address<span
							class="error">*</span>
						</label>
					</div>
					<div class="error" id="errorEmail"></div>
					<div class="error"><%=errorEmail%></div>
				</div>

				<!-- Họ và tên -->
				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="12456789" required="required">
						<label for="username" style="color: #E0BC41">Họ và tên<span
							class="error">*</span></label>
					</div>
					<div class="error" id="errorUsername"></div>
				</div>

				<!-- password -->
				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="12456789" required="required">
						<label for="password" style="color: #E0BC41">Password<span
							class="error">*</span></label>
					</div>
					<div class="error" id="errorPassword"></div>
					<div class="error"><%=errorPassword%></div>
				</div>

				<!-- password again -->
				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="password" class="form-control" id="password_again"
							name="password_again" placeholder="12456789" required="required">
						<label for="password" style="color: #E0BC41">Password
							Again<span class="error">*</span>
						</label>
					</div>
					<div class="error" id="errorPasswordAgain"></div>
					<div class="error"><%=errorPasswordAgain%></div>
				</div>

				<div class="col-12 mt-3">
					<input type="checkbox" class="form-check-input"> Show
					password
				</div>
				<div class="col-12">
					<input type="checkbox" class="form-check-input" name="dang_ki"
						id="dang_ki"> Đồng ý nhận tin nhắn qua Email
				</div>
				<div class="col-12 ">
					<input type="checkbox" class="form-check-input" name="dong_y"
						id="dong_y" required="required"><span class="error">*</span>Tôi
					đã đọc, hiểu rõ và đồng ý với Quy chế hoạt động, điều khoản và
					Chính sách bảo mật thông tin.
				</div>
			</div>



			<div class="center">
				<button class="btn btn-warning mt-3" type="submit" id="submit"
					name="submit" onclick="submit_signup()">Sign-up</button>
			</div>
			<div class="center">
				<p>
					Bạn đã có tài khoản?<a href="<%=url%>/khachhang/Login.jsp"
						style="color: #ffeba7"> Login </a>
				</p>
			</div>
		</form>

	</div>
</body>

</html>