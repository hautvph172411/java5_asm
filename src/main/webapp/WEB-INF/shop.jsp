<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>





	<c:if test="${messageShop != null }">
		<div class="alert alert-danger">${messageShop}</div>
	</c:if>
	<c:if test="${messageShop1 != null }">
		<div class="alert alert-success">${messageShop1}</div>
	</c:if>
<c:if test="${ !empty listLamp }">

	<c:forEach var="l" items="${listLamp}">

		<div class="col-3 mt-3">

			<div class="card" style="">
				<img src="/img/${l.img}" class="card-img-top"
					style="width: 319px; height: 319px">
				<div class="card-body">
					<h5 class="card-title">${l.name}</h5>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">số lượng : ${l.quantity } chiếc</li>
					<li class="list-group-item">giá : <fmt:formatNumber
							pattern="###,### vnđ">${l.price }</fmt:formatNumber> VND/1sp
					</li>
				</ul>
				<div class="card-body">

					<div>
						<a href="/cart/add?id=${l.id_lamp }" class="btn btn-primary">Thêm vào giỏ hàng </a>
					</div>
					<div>
						<a href="/shop/detail?id=${l.id_lamp}" class="btn btn-secondary mt-3">Xem Chi Tiết </a>
					</div>
				</div>

			</div>

		</div>
	</c:forEach>
</c:if>

<!-- Start Script -->
<script src="assets/js/jquery-1.11.0.min.js"></script>
<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/templatemo.js"></script>
<script src="assets/js/custom.js"></script>
<script src="assets/css/bootstrap.min.css"></script>
<!-- End Script -->
