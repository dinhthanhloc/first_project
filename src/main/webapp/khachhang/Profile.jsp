<%@page import="database.DAOsanpham"%>
<%@page import="model.khach_hang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProFile</title>
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

</head>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%=url%>/CSS/style-profile.css">

<body>
	<%
	String errorSdt = request.getAttribute("errorSdt") + "";
	errorSdt = (errorSdt.equals("null")) ? "" : errorSdt;

	String update = request.getAttribute("update") + "";
	update = (update.equals("null")) ? "" : update;

	Object obj = session.getAttribute("khach_hang");
	khach_hang khach_hang = null;
	if (obj != null) {
		khach_hang = (khach_hang) obj;
	}
	if (khach_hang == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ</h1>
	<%
	} else {
	String username = khach_hang.getHo_ten();
	String email = khach_hang.getEmail();
	String dia_chi = khach_hang.getDia_chi()+"";
	String so_dien_thoai = khach_hang.getSo_dien_thoai()+"";
	String gioi_tinh = khach_hang.getGioi_tinh()+"";
	Boolean dang_ki = khach_hang.getDang_ki();
	String dob = khach_hang.getDob() + "";
	
	dia_chi = (dia_chi.equals("null")) ? "" : dia_chi;
	gioi_tinh = (gioi_tinh.equals("null")) ? "" : gioi_tinh;
	so_dien_thoai = (so_dien_thoai.equals("null")) ? "" : so_dien_thoai;
	%>
	<!-- Profile -->
	<form action="<%=url%>/khach-hang" method="post">
		<input name="action" type="hidden" value="save-profile">
		<div class="container form-signin">
			<h2 class="center" id="title">Profile</h2>
			<div class="row form-signin mt-2">

				<!-- username -->
				<div class="col-12 mt-3">
					<label for="username">Họ và tên<span class="error">*</span></label>
					<input type="text" class="form-control" id="username"
						name="username" placeholder="Full name" value="<%=username%>"
						required="required">

					<div class="error" id="errorUsername"></div>
				</div>

				<!-- Gioi tinh -->
				<div class="col-12 mt-1">
					<label for="gioitinh" class="form-label" style="margin: 0">Giới
						tính</label> <select class="form-control" name="gioi_tinh" id="gioi_tinh">
						<option value="" <%=(gioi_tinh == null) ? "selected='selected'" : "" %>></option>
						<option value="Nam"
							<%=(gioi_tinh.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
						<option value="Nữ"
							<%=(gioi_tinh.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
						<option value="Khác"
							<%=(gioi_tinh.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
					</select>
				</div>

				<!-- Địa chỉ -->
				<div class="col-12 mt-1">
					<label for="dia_chi">Địa chỉ</label> <input type="text"
						class="form-control" id="dia_chi" name="dia_chi"
						placeholder="Address" value="<%=dia_chi%>">
				</div>

				<!-- dob -->
				<div class="col-12 mt-1">
					<label for="dob">Ngày sinh</label> <input type="date"
						class="form-control" id="dob" name="dob"
						placeholder="Date of birth" value="<%=dob%>">
				</div>

				<!-- Số điện thoại -->
				<div class="col-12 mt-1">
					<label for="so_dien_thoai">Số điện thoại</label> <input type="text"
						class="form-control" id="so_dien_thoai" name="so_dien_thoai"
						placeholder="Phone number" value="<%=so_dien_thoai%>"
						autocomplete="off">

					<div class="error"><%=errorSdt%></div>
				</div>
				<!-- Đăng kí -->
				<div class="col-12 mt-1">
					<input type="checkbox" class="form-check-input" name="dang_ki"
						id="dang_ki"> Đồng ý nhận tin nhắn qua Email
				</div>
				<div class="col-12" id="text-right">
				<a href="<%=url%>/index.jsp" id="link-color">Quay lại trang chủ</a>
				</div>
				<div class="center mt-2">
					<button class="btn btn-warning" type="submit">Update</button>
				</div>
				<div class="center error"><%=update%></div>
			</div>
		</div>
	</form>
	<%
	}
	%>
</body>
</html>