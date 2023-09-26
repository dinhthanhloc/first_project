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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Shop Giày</title>
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
<link rel="stylesheet" type="text/css" href="<%=url%>/CSS/test.css">
<%
String id = request.getAttribute("id") + "";
%>
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
		<div class="row">
			<!-- Menu left -->
			<div class="col-lg-2">
				<div class="list-group ">
					<ul>
						<li><a href="<%=url%>/sanpham-main/nike-main.jsp"
							class="list-group-item list-group-item-action">Nike</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/nike-af1.jsp">Air
										Force 1</a></li>
								<li><a href="<%=url%>/sanpham-extra/nike-fd1.jsp">Air
										Jordan 1</a></li>
								<li><a href="">Air Max</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/adidas-main.jsp"
							class="list-group-item list-group-item-action">Adidas</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Sneaker</a></li>
								<li><a href="#">Football</a></li>
								<li><a href="#">Running</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/mlb-main.jsp"
							class="list-group-item list-group-item-action">MLB</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Chunny</a></li>
								<li><a href="#">Sandals</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/balenciaga-main.jsp"
							class="list-group-item list-group-item-action">Balenciaga</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Sneakers</a></li>
								<li><a href="#">Boots</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/new-balance-main.jsp"
							class="list-group-item list-group-item-action">New Balance</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Lifestyle</a></li>
								<li><a href="#">Soccer</a></li>
								<li><a href="#">Running</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/puma-main.jsp"
							class="list-group-item list-group-item-action">Puma</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Sneaker</a></li>
								<li><a href="#">Soccer</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/vans-main.jsp"
							class="list-group-item list-group-item-action">Vans</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Vans Old Skool</a></li>
								<li><a href="#">Vans Authentic</a></li>
								<li><a href="#">Vans Sk8-Hi</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/zocker-main.jsp"
							class="list-group-item list-group-item-action">Zocker</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Zocker Inspire</a></li>
								<li><a href="#">Zocker Inspire Pro</a></li>
								<li><a href="#">Zocker Pioneer</a></li>
								<li><a href="#">Zocker Space</a></li>
								<li><a href="#">Zocker 1902</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/kamito-main.jsp"
							class="list-group-item list-group-item-action">Kamito</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Cỏ Nhân Tạo</a></li>
								<li><a href="#">Cỏ tự nhiên</a></li>
								<li><a href="#">Futsal</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/mitre-main.jsp"
							class="list-group-item list-group-item-action">Mitre</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="#">Cỏ Nhân Tạo</a></li>
								<li><a href="#">Cỏ tự nhiên</a></li>
							</ul></li>
					</ul>

				</div>
			</div>
			<!-- End Menu left -->

			<!-- Slider and Products -->
			<div class="col-lg-10">
				<!-- Slider -->
				<div id="carouselExampleIndicators" id="slider"
					class="carousel slide mb-4" data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner" id="slider">
						<div class="carousel-item active">
							<img src="<%=url%>/img/2.png" class="d-block w-100" alt="..."
								id="img-slider">
						</div>
						<div class="carousel-item">
							<img src="<%=url%>/img/0.png" class="d-block w-100" alt="..."
								id="img-slider">
						</div>
						<div class="carousel-item">
							<img src="<%=url%>/img/4.png" class="d-block w-100" alt="..."
								id="img-slider">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Products -->

				<%
				ArrayList<san_pham> list = DAOsanpham.getInstance().selectAll();
				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).getMo_ta() == null) {
						list.get(i).setMo_ta("");
					} else {
						list.get(i).setMo_ta(list.get(i).getMo_ta());
					}
				}
				%>
				<div class="row">
					<%
					if (list.size() > 15) {
						for (int i = 0; i < 15; i++) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href=""><img class="card-img-top" id="img-shoes"
									src="<%=list.get(i).getLink_hinh_anh()%>"></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="<%=url%>/tester"><%=list.get(i).getTen_giay()%></a>
									</h4>
									<h5><%=list.get(i).getGia_ban()%>$
									</h5>
									<input id="id_shoes" name="id_shoes"
										value="<%=list.get(i).getMa_giay()%>">
									<p class="card-text"><%=list.get(i).getMo_ta()%></p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9733;</small>
								</div>
								<div>
									<button type="submit"></button>
								</div>
							</div>
					</div>

					<%
					}
					%>
					<div class="row" id="add-shoes">
						<%
						for (int i = 15; i < list.size(); i++) {
						%>
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top" id="img-shoes"
									src="<%=list.get(i).getLink_hinh_anh()%>"></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#"><%=list.get(i).getTen_giay()%></a>
									</h4>
									<h5><%=list.get(i).getGia_ban()%>$
									</h5>
									<p class="card-text"><%=list.get(i).getMo_ta()%></p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9733;</small>
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<div class="col-12 center">
						<button id="show-shoes" class="btn btn-warning" type="button">Xem
							thêm</button>
					</div>
					<%
					} else {
					for (int i = 0; i < list.size(); i++) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" id="img-shoes"
								src="<%=list.get(i).getLink_hinh_anh()%>"></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#"><%=list.get(i).getTen_giay()%></a>
								</h4>
								<h5><%=list.get(i).getGia_ban()%>$
								</h5>
								<p class="card-text"><%=list.get(i).getMo_ta()%></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9733;</small>
							</div>
						</div>
					</div>
					<%
					}
					}
					%>

					<!-- End Products -->
				</div>
				<!-- End Slider and Products -->
			</div>
		</div>
	</div>
	<!-- End Page content -->
	<!-- Footer -->
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Trang chủ</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Quy định giao hàng</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Quy định trả hàng</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Liên hệ</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Blogs</a></li>
		</ul>
		<p class="text-center text-muted">© 2023 LOC.vn, Inc</p>
	</footer>
	<!-- End footer -->

	<!-- Script -->
	<script>
		const add_shoes = document.getElementById("add-shoes");
		const show_shoes = document.getElementById("show-shoes");
		show_shoes.onclick = function() {
			if (add_shoes.style.display === "none") {
				add_shoes.style.display = "contents";
				show_shoes.innerHTML = "Thu gọn";
			} else {
				add_shoes.style.display = "none";
				show_shoes.innerHTML = "Xem thêm";
			}
		};
	</script>
</body>


</html>