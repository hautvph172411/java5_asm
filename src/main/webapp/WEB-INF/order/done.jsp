<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row text-black mx-auto">

	<div class="row fs-2 fw-bold">Cảm ơn quý khách đã mua hàng! Mã đơn hàng của quý khách là: ${mdh}</div>
	<p class="fs-2 fw-bold text-align-center">Đơn Hàng Của Bạn Đang Được Giao</p>
	<div class="row mt-3" >
		<a href="/shop" class="col-2"><button class="btn btn-success">Back </button></a>
		<a href="/order/detail?mdh=${mdh}" class="col-2"><button class="btn btn-success">Chi tiết đơn hàng</button></a>
	</div>
</div>
