
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<title>ASM-ph17241</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">

<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">




</head>

<body>
	<!-- Start Top Nav -->
	<nav
		class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
		id="templatemo_nav_top">
		<div class="container text-light">
			<div class="w-100 d-flex justify-content-between">
				<div>
					<i class="fa fa-envelope mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none"
						href="mailto:info@company.com">hautvph17241@fpt.edu.vn</a> <i
						class="fa fa-phone mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none"
						href="tel:010-020-0340">0922632691</a>
				</div>
				<div>
					<a class="text-light" href="https://vi-vn.facebook.com/"
						target="_blank" rel="sponsored"><i
						class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a> <a
						class="text-light"
						href="https://www.instagram.com/accounts/login/" target="_blank"><i
						class="fab fa-instagram fa-sm fa-fw me-2"></i></a> <a
						class="text-light" href="https://twitter.com/" target="_blank"><i
						class="fab fa-twitter fa-sm fa-fw me-2"></i></a> <a class="text-light"
						href="https://www.linkedin.com/" target="_blank"><i
						class="fab fa-linkedin fa-sm fa-fw"></i></a>
				</div>
			</div>
		</div>
	</nav>
	<!-- Close Top Nav -->


	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light shadow">
		<div
			class="container d-flex justify-content-between align-items-center">

			<a class="navbar-brand text-success logo h1 align-self-center"
				href="/home"> LAMP </a>

			<button class="navbar-toggler border-0" type="button"
				data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div
				class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
				id="templatemo_main_nav">
				<div class="flex-fill">
					<ul
						class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
						<li class="nav-item"><a class="nav-link" href="/home">Trang
								Ch???</a></li>
						<li class="nav-item"><a class="nav-link" href="/about">Gi???i
								Thi???u</a></li>
						<li class="nav-item"><a class="nav-link" href="/shop">S???n
								Ph???m</a></li>
						<li class="nav-item"><a class="nav-link" href="/contact">Li??n
								H??? </a></li>
						<c:if test="${sessionScope.role == true }">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">Qu???n
									L??</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="#!">????ng Nh???p</a></li>
									<li><hr class="dropdown-divider" /></li>
									<li><a class="dropdown-item" href="/lamp">Qu???n L?? S???n
											Ph???m </a></li>
									<li><a class="dropdown-item" href="/user/listuser">Qu???n L?? Ng?????i
											D??ng</a></li>
									<li><a class="dropdown-item" href="#!">Qu???n L?? Gi???
											H??ng</a></li>
								</ul></li>
						</c:if>
						<li><a class="nav-link scrollto" href="/user/login">Login</a></li>
						<c:if test="${sessionScope.user !=null }">
							<li><p class="nav-link scrollto">Xin ch??o ${user.fullname}</p></li>
						</c:if>
						<li><a class="nav-link scrollto" href="/user/register">Sign
								up</a></li>
						<c:if test="${sessionScope.user != null }">
							<li><a class="nav-link scrollto" href="/user/logout">Log
									out</a></li>
						</c:if>
					</ul>
				</div>

				<div class="navbar align-self-center d-flex">
				
					<div
						class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
						
					
						<div class="input-group">
							<input type="text"  class="form-control" id="inputMobileSearch"
								placeholder="Nh???p t??n s???n ph???m ...">
							<div class="input-group-text">
								<i class="fa fa-fw fa-search"></i>
							</div>
						</div>
					
					</div>
					<a class="nav-icon d-none d-lg-inline" href="/cart/index"
						data-bs-toggle="modal" data-bs-target="#templatemo_search"> <i
						class="fa fa-fw fa-search text-dark mr-2"></i>
					</a> <a class="nav-icon position-relative text-decoration-none"
						href="/cart/index"> <i
						class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i> <span
						class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
					</a> <a class="nav-icon position-relative text-decoration-none"
						href="/cart/index"> <i class="fa fa-fw fa-user text-dark mr-3"></i>
						<span
						class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
					</a>
				</div>
			</div>

		</div>
	</nav>
	<!-- Close Header -->

	<!-- Modal -->
	<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="w-100 pt-1 mb-5 text-right">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="/home/find" 
				class="modal-content modal-body border-0 p-0">
				<div class="input-group mb-2">
					<input type="text" class="form-control" id="inputModalSearch"
						name="name" placeholder="Nh???p T??n S???n Ph???m">
					<button type="submit"
						class="input-group-text bg-success text-light">
						<i class="fa fa-fw fa-search text-white"></i>
					</button>
				</div>
			</form>
		</div>
	</div>



	<div class="row">
		<jsp:include page="${view}"></jsp:include>
	</div>


	<!-- Start Footer -->
	<footer class="bg-dark" id="tempaltemo_footer">
		<div class="container">
			<div class="row">

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-success border-bottom pb-3 border-light logo">C???a
						H??ng ????n</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><i class="fas fa-map-marker-alt fa-fw"></i> 123 H??ng Qu???y
							,Ch??o L????n ,Ph??? G??nh</li>
						<li><i class="fa fa-phone fa-fw"></i> <a
							class="text-decoration-none" href="tel:010-020-0340">0922632691</a>
						</li>
						<li><i class="fa fa-envelope fa-fw"></i> <a
							class="text-decoration-none" href="mailto:info@company.com">hautvph17241@fpt.edu.vn</a>
						</li> 1

						<iframe class="mt-3"
							src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d7838.684254869503!2d106.70676642475235!3d10.785086936675276!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1svi!2s!4v1547181657956"
							width="300" height="300" frameborder="0" style="border: 0"
							allowfullscreen></iframe>

					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">S???n
						Ph???m</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Cao C???p </a></li>
						<li><a class="text-decoration-none" href="#">????n H???c</a></li>
						<li><a class="text-decoration-none" href="#">????n Gi???ng
								D???y</a></li>
						<li><a class="text-decoration-none" href="#">????n ????? B??n </a></li>
						<li><a class="text-decoration-none" href="#">????n Ch???ng
								C???n </a></li>
						<li><a class="text-decoration-none" href="#">????n Cho B?? </a></li>
						<li><a class="text-decoration-none" href="#">????n Th??ng
								Minh</a></li>
					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">Ch???c
						N??ng</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Trang Ch??? </a></li>
						<li><a class="text-decoration-none" href="#">Gi???i Thi???u</a></li>
						<li><a class="text-decoration-none" href="#">H???i ????p</a></li>
						<li><a class="text-decoration-none" href="#">Li??n H???</a></li>
					</ul>
				</div>

			</div>

			<div class="row text-light mb-4">
				<div class="col-12 mb-3">
					<div class="w-100 my-3 border-top border-light"></div>
				</div>
				<div class="col-auto me-auto">
					<ul class="list-inline text-left footer-icons">
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="http://facebook.com/"><i
								class="fab fa-facebook-f fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.instagram.com/"><i
								class="fab fa-instagram fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://twitter.com/"><i
								class="fab fa-twitter fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.linkedin.com/"><i
								class="fab fa-linkedin fa-lg fa-fw"></i></a>
						</li>
					</ul>
				</div>
				<div class="col-auto">
					<label class="sr-only" for="subscribeEmail">Nh???p ????? ch???
						email</label>
					<div class="input-group mb-2">
						<input type="text" class="form-control bg-dark border-light"
							id="subscribeEmail" placeholder="Email address">
						<div class="input-group-text btn-success text-light">????ng K??</div>
					</div>
				</div>
			</div>
		</div>



	</footer>
	<!-- End Footer -->

	<!-- Start Script -->
	<script src="/assets/js/jquery-1.11.0.min.js"></script>
	<script src="/assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="/assets/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/js/templatemo.js"></script>
	<script src="/assets/js/custom.js"></script>
	<!-- End Script -->
</body>

</html>