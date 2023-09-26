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
<title>Buys Shoes</title>
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
			<div class="col-lg-3">
				<div class="list-group ">
					<ul>
						<li><a href="<%=url%>/sanpham-main/nike-main.jsp"
							class="list-group-item list-group-item-action">Nike </a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/nike-af1.jsp">Air
										Force 1</a></li>
								<li><a href="<%=url%>/sanpham-extra/nike-fd1.jsp">Air
										Jordan 1</a></li>
								<li><a href="<%=url%>/sanpham-extra/nike-air.jsp">Air
										Max</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/adidas-main.jsp"
							class="list-group-item list-group-item-action">Adidas</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/adidas-sneaker.jsp">Sneaker</a></li>
								<li><a href="<%=url%>/sanpham-extra/adidas-football.jsp">Football</a></li>
								<li><a href="<%=url%>/sanpham-extra/adidas-running.jsp">Running</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/mlb-main.jsp"
							class="list-group-item list-group-item-action">MLB</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/mlb-chunny.jsp">Chunny</a></li>
								<li><a href="<%=url%>/sanpham-extra/mlb-sandals.jsp">Sandals</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/balenciaga-main.jsp"
							class="list-group-item list-group-item-action">Balenciaga</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/balenciaga-sneaker.jsp">Sneakers</a></li>
								<li><a href="<%=url%>/sanpham-extra/balenciaga-boots.jsp">Boots</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/new-balance-main.jsp"
							class="list-group-item list-group-item-action">New Balance</a>
							<ul class="dropdown" id="dropdown">
								<li><a
									href="<%=url%>/sanpham-extra/new-balance-sneaker.jsp">Sneaker</a></li>
								<li><a href="<%=url%>/sanpham-extra/new-balance-soccer.jsp">Soccer</a></li>
								<li><a
									href="<%=url%>/sanpham-extra/new-balance-running.jsp">Running</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/puma-main.jsp"
							class="list-group-item list-group-item-action">Puma</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/puma-sneaker">Sneaker</a></li>
								<li><a href="<%=url%>/sanpham-extra/puma-soccer.jsp">Soccer</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/vans-main.jsp"
							class="list-group-item list-group-item-action">Vans</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/vans-old-skool.jsp">Vans
										Old Skool</a></li>
								<li><a href="<%=url%>/sanpham-extra/vans-authentic.jsp">Vans
										Authentic</a></li>
								<li><a href="<%=url%>/sanpham-extra/vans-sk8-hi.jsp">Vans
										Sk8-Hi</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/zocker-main.jsp"
							class="list-group-item list-group-item-action">Zocker</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/zocker-inpire.jsp">Zocker
										Inspire</a></li>
								<li><a href="<%=url%>/sanpham-extra/zocker-inpire-pro.jsp">Zocker
										Inspire Pro</a></li>
								<li><a href="<%=url%>/sanpham-extra/zocker-pioneer.jsp">Zocker
										Pioneer</a></li>
								<li><a href="<%=url%>/sanpham-extra/zocker-space.jsp">Zocker
										Space</a></li>
								<li><a href="<%=url%>/sanpham-extra/zocker-1902.jsp">Zocker
										1902</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/kamito-main.jsp"
							class="list-group-item list-group-item-action">Kamito</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/kamito-nhan-tao.jsp">Cỏ
										Nhân Tạo</a></li>
								<li><a href="<%=url%>/sanpham-extra/kamito-tu-nhie.jsp">Cỏ
										tự nhiên</a></li>
								<li><a href="<%=url%>/sanpham-extra/kamito-futsal.jsp">Futsal</a></li>
							</ul></li>
						<li><a href="<%=url%>/sanpham-main/mitre-main.jsp"
							class="list-group-item list-group-item-action">Mitre</a>
							<ul class="dropdown" id="dropdown">
								<li><a href="<%=url%>/sanpham-extra/mitre-nhan-tao.jsp">Cỏ
										Nhân Tạo</a></li>
								<li><a href="<%=url%>/sanpham-extra/mitre-tu-nhie.jsp">Cỏ
										tự nhiên</a></li>
							</ul></li>
					</ul>

				</div>
			</div>
			<!-- End  Menu left -->

			<!-- Products -->

			<%
			String id_shoes = request.getAttribute("id_shoes") + "";
			chi_tiet_san_pham ketqua = new chi_tiet_san_pham();
			ketqua.setMa_giay(id_shoes);
			san_pham kq = new san_pham();
			kq.setMa_giay(id_shoes);

			san_pham san_pham = DAOsanpham.getInstance().selectById(kq);
			chi_tiet_san_pham chi_tiet_san_pham = DAOchitietsanpham.getIntance().selectById(ketqua);
			%>

			<div class="col-lg-9">
				<div class="row mt-5">
					<!-- Img detail -->
					<div class="col-lg-2">
						<ul id="img-detail">
							<li><img class="img-detail-shoes" id="img-detail-1" alt=""
								src="<%=chi_tiet_san_pham.getTong_quan()%>"></li>
							<li><img class="img-detail-shoes" id="img-detail-2" alt=""
								src="<%=chi_tiet_san_pham.getTong_quan_1()%>"></li>
							<li><img class="img-detail-shoes" id="img-detail-3" alt=""
								src="<%=chi_tiet_san_pham.getTong_quan_2()%>"></li>
							<li><img class="img-detail-shoes" id="img-detail-4" alt=""
								src="<%=chi_tiet_san_pham.getDe_giay()%>"></li>
						</ul>
					</div>

					<!-- img main -->
					<div class="col-lg-6">
						<img id="img-main-shoes" alt=""
							src="<%=chi_tiet_san_pham.getTong_quan()%>">
					</div>

					<!-- Thông tin giày -->
					<div class="col-lg-4 infor-shoes">
						<form action="<%=url%>/khach-hang" method="get">
							<!-- Tên và đánh giá -->
							<div class="name-shoes">
								<h3><%=san_pham.getTen_giay()%></h3>
								<input name="id-shoes" value="<%=san_pham.getMa_giay()%>"
									type="hidden"> <input name="action" value="buy-shoes"
									type="hidden"> <small class="text-muted">&#9733;
									&#9733; &#9733; &#9733; &#9733;</small> <a href="#">Đánh giá sản
									phẩm này</a>
							</div>

							<!-- Thương hiệu and Mã giày -->
							<div class="row mt-2">
								<div class="col-6">
									<h6>
										Thương hiệu:
										<%=san_pham.getHang_giay()%></h6>
								</div>
								<div class="col-6">
									<h6>
										Mã giày:
										<%=san_pham.getMa_giay()%></h6>
								</div>
							</div>

							<!-- Giá giày -->
							<div class="price-shoes">
								<h1><%=san_pham.getGia_ban()%>$
								</h1>
							</div>

							<!-- Size giày -->
							<div class="item-radio">
								<h4>Chọn size</h4>
								<input type="radio" class="btn-check" name="options-base"
									id="option1" autocomplete="off" checked value="36"><label
									class="btn" for="option1">Size 36</label> <input type="radio"
									class="btn-check" name="options-base" id="option2"
									autocomplete="off" value="37"> <label class="btn"
									for="option2">Size 37</label> <input type="radio"
									class="btn-check" name="options-base" id="option3"
									autocomplete="off" value="38"> <label class="btn"
									for="option3">Size 38</label> <input type="radio"
									class="btn-check" name="options-base" id="option4"
									autocomplete="off" value="39"> <label class="btn"
									for="option4">Size 39</label> <input type="radio"
									class="btn-check" name="options-base" id="option5"
									autocomplete="off" value="40"> <label class="btn"
									for="option5">Size 40</label> <input type="radio"
									class="btn-check" name="options-base" id="option6"
									autocomplete="off" value="41"> <label class="btn"
									for="option6">Size 41</label> <input type="radio"
									class="btn-check" name="options-base" id="option7"
									autocomplete="off" value="42"> <label class="btn"
									for="option7">Size 42</label> <input type="radio"
									class="btn-check" name="options-base" id="option8"
									autocomplete="off" value="43"> <label class="btn"
									for="option8">Size 43</label> <input type="radio"
									class="btn-check" name="options-base" id="option9"
									autocomplete="off" value="44"> <label class="btn"
									for="option9">Size 44</label>
							</div>

							<!-- Số lượng -->
							<div class="amount-shoes mt-3">
								<input name="amount" id="amount" type="text" value="1">
								<ul>
									<li><button type="button" id="plus-item" name="plus-item"
											onclick="handlePlus()">
											<i class="fa-solid fa-plus" id="icon-size"></i>
										</button></li>
									<li><button type="button" id="minus-item"
											name="minus-item" onclick="handleMinus()">
											<i class="fa-solid fa-minus" id="icon-size"></i>
										</button></li>
								</ul>
							</div>

							<!-- Mua hang -->
							<div class="buy mt-3">
								<button id="add-item" class="btn">Thêm vào giỏ hàng</button>
								<button type="submit" id="buy-item" class="btn">Mua
									hàng</button>
							</div>
						</form>
					</div>
					<!-- End Thông tin giày -->
				</div>

				<!-- End Products -->
			</div>
		</div>
		<!-- End Menu left -->
	</div>
	<!-- End Page content -->
	<!-- Footer -->


	<!-- Script -->
	<script>
	let amountElement = document.getElementById("amount");
	let amount = amountElement.value;
	
	let render = (amount) =>{
		amountElement.value = amount;
	}

	let handlePlus = () =>{
		amount++;
		render(amount);
	}	
	let handleMinus = () =>{
		if(amount > 1) amount--;
		render(amount);
	}
	
	amountElement.addEventListener('input', () =>{
		amount = amountElement.value;
		amount = parseInt();
		amount = isNaN(amount)? 1 : amount;
		render(amount);
	});
	
	let img_detail_1_element = document.getElementById('img-detail-1');
	let img_detail_2_element = document.getElementById('img-detail-2');
	let img_detail_3_element = document.getElementById('img-detail-3');
	let img_detail_4_element = document.getElementById('img-detail-4');
	let img_main_shoes_element = document.getElementById('img-main-shoes');
	
	img_detail_1_element.addEventListener('click', () => { 
		let img_detail_1 = img_detail_1_element.src;
		img_main_shoes_element.src = img_detail_1;
		
	});
	img_detail_2_element.addEventListener('click', () => { 
		let img_detail_2 = img_detail_2_element.src;
		img_main_shoes_element.src = img_detail_2;		
	});
	img_detail_3_element.addEventListener('click', () => { 
		let img_detail_3 = img_detail_3_element.src;
		img_main_shoes_element.src = img_detail_3;		
	});
	img_detail_4_element.addEventListener('click', () => { 
		let img_detail_4 = img_detail_4_element.src;
		img_main_shoes_element.src = img_detail_4;		
	});
	
	</script>
</body>
</html>