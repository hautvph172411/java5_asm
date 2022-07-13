<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="section-title">
	<h2>Chi tiết sản phẩm</h2>

	<div class="row mt-3">
		<div class="col-2"></div>
		<div class="col-6">
			<img alt="" src="/img/${l.img }" style="width: 319px; height: 319px">
		</div>
		<div class="col-3">
			<br>
			<h2>${l.name }</h2>
			</br> Xuất Xứ: ${l.origin }</br> Gía Tiền :
			<fmt:formatNumber type="number" pattern="###,### VNĐ"
				value="${l.price}" />
			</br> Số Lượng : ${l.quantity }</br> Brand : ${l.brand }</br> Màu sản phẩm :${l.color }
			</br>
			<div class="pt-5">
				<a href="/cart/buynow?id=${l.id_lamp }" type="button"
					class="btn btn-primary">Mua ngay</a> <a
					href="/cart/add?id=${l.id_lamp }" type="button"
					class="btn btn-warning">Thêm vào giỏ hàng</a>
			</div>
		</div>
	</div>


</div>