<%@page import="java.util.ArrayList"%>
<%@page import="database.DAOsanpham"%>
<%@page import="model.khach_hang"%>
<%@page import="model.san_pham"%>
<%@page import="model.chi_tiet_san_pham"%>
<%@page import="database.DAOchitietsanpham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Buy Conplete</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/a610a0c4b9.js"
	crossorigin="anonymous"></script>

</head>

<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=url%>/CSS/style-index.css">
<link rel="stylesheet" type="text/css"
	href="<%=url%>/CSS/style-buy-shoes.css">
<link rel="stylesheet" type="text/css"
	href="<%=url%>/CSS/style-buy-complete.css">


<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="" href="<%=url%>/index.jsp"> <img src="img/logo.png"
				alt="Bootstrap" height="55px">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=url%>/index.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="<%=url%>/sanpham-main/sneaker.jsp">Sneaker</a></li>
							<li><a class="dropdown-item"
								href="<%=url%>/sanpham-main/soccer.jsp">Soccer Shoes</a></li>
							<li><a class="dropdown-item"
								href="<%=url%>/sanpham-main/running.jsp">Running Shoes</a></li>
							<li><a class="dropdown-item"
								href="<%=url%>/sanpham-main/sandals.jsp">Sandal</a></li>
							<li><a class="dropdown-item" href="#"></a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-warning" type="submit">Tìm</button>
					<%
					Object obj = session.getAttribute("khach_hang");
					khach_hang khach_hang = null;
					if (obj != null)
						khach_hang = (khach_hang) obj;

					if (khach_hang == null) {
					%>
					<a class="btn btn-warning" id="nowrap"
						href="<%=url%>/khachhang/Login.jsp"> Đăng nhập </a>
					<%
					} else {
					%>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i
								class="fa-regular fa-user"></i></a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khachhang/Profile.jsp">Thay đổi thông tin</a></li>
								<li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khach-hang?action=log-out">Đăng xuất</a></li>
							</ul></li>
					</ul>
					>
					<%
					}
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->

	<!-- Page content -->
	<div id="container">
		<form action="">
			<div class="row infor-page">

				<!-- Products -->

				<%
				String id_shoes = request.getAttribute("id_shoes") + "";
				chi_tiet_san_pham ketqua = new chi_tiet_san_pham();
				ketqua.setMa_giay(id_shoes);

				san_pham kq = new san_pham();
				kq.setMa_giay(id_shoes);

				String option_shoes = request.getAttribute("option_base") + "";

				san_pham san_pham = DAOsanpham.getInstance().selectById(kq);
				chi_tiet_san_pham chi_tiet_san_pham = DAOchitietsanpham.getIntance().selectById(ketqua);
				%>

				<!-- Buy Address -->
				<div class="col-lg-8">
					<!-- img logo -->
					<div class="img-logo">
						<img alt="Logo Page" src="<%=url%>/img/logo.png">
					</div>

					<div class="row">
						<!-- Thông tin đơn hang -->
						<div class="col-6 infor-order">
							<h5 class="center">Thông tin đơn hàng</h5>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>
							<div class="form-floating mt-3">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="name@example.com" required> <label
									for="floatingInput" style="color: #E0BC41">Email
									address<span class="error">*</span>
								</label>
							</div>

						</div>

						<div class="col-6">
							<!-- Phương thức giao hàng -->
							<div class="transport-order">
								<h5 class="center">Vận chuyển</h5>
								<ul>
									<li>
										<div class="form-check flex">
											<input class="form-check-input mt-2 border-color"
												type="radio" name="flexRadioDefault" id="flexRadioDefault1">
											<div class="form-transport ml-2">
												<label class="form-check-label mt-1" for="flexRadioDefault1">
													Giao hàng tận nơi - COD tiêu chuẩn 1-2 ngày. </label>
											</div>
											<div class="price-transpport">
												<label class="form-check-label mt-1 ml-2"
													for="flexRadioDefault1"> miễn phí </label>
											</div>
										</div>
									</li>
									<li>
										<div class="form-check flex">
											<input class="form-check-input mt-2" type="radio"
												name="flexRadioDefault" id="flexRadioDefault2">
											<div class="form-transport ml-2">
												<label class="form-check-label mt-1" for="flexRadioDefault2">
													Ship Grab trong ngày (Chỉ áp dụng cho HCM và HN). </label>
											</div>
											<div class="price-transpport">
												<label class="form-check-label mt-1 ml-2"
													for="flexRadioDefault1"> 35.000₫ </label>
											</div>
										</div>
									</li>
								</ul>

							</div>
							<!-- Phương thức thanh toán -->
							<div class="method-order"></div>
						</div>
					</div>

				</div>

				<!-- End Buy Address -->

				<!-- Pay -->
				<div class="col-lg-4"></div>
				<!-- End Pay -->
			</div>
		</form>

	</div>
	<!-- End Page content -->
	<!-- Footer -->



</body>
</html>