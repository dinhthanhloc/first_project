<%@page import="java.util.ArrayList"%>
<%@page import="database.DAOsanpham"%>
<%@page import="model.khach_hang"%>
<%@page import="model.san_pham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
	String errorEmail = request.getAttribute("errorEmail") + "";
	errorEmail = (errorEmail.equals("null")) ? "" : errorEmail;
	
	%>

	<h2 class="center mt-4">Login</h2>
	<div class="container form-signin mt-3">
		<form action="<%=url%>/khach-hang" method="post" id="my_form">
			<input name="action" type="hidden" value="save-login">
			<div class="row">
				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="name@example.com" required> <label
							for="floatingInput" style="color: #E0BC41">Email address<span
							class="error">*</span></label>
					</div>
					<div class="error" id="errorEmail"></div>
					<div class="error"><%=errorEmail%></div>
				</div>

				<div class="col-12 mt-3">
					<div class="form-floating">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="12456789" required> <label
							for="password" style="color: #E0BC41">Password<span
							class="error">*</span></label>
					</div>
					<div class="error" id="errorPassword"></div>

				</div>
				<div class="col-12 mt-3 center">
					<input type="checkbox" id="show_password"> Show password
				</div>
			</div>
			<div class="center">
				<button class="btn btn-warning mt-3 " type="button"
					onclick="submit_login()">Login</button>
			</div>
			<div class="center">
				<p>
					Bạn chưa có tài khoản?<a href="<%=url%>/khachhang/Sign_up.jsp"
						style="color: #ffeba7"> Sign-up </a>
				</p>
			</div>
		</form>
	</div>

</body>

</html>