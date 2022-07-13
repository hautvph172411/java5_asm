<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-8">
		<form action="/order/add" method="post">
			<div class="card text-dark">
				<div class="card-body">
					<div class="row mb-3">
						<div class="col-6">
							<label for="fullname">Họ và tên</label>
							<input type="text" name="fullname" id="fullname" class="form-control">
						</div>
						<div class="col-6">
							<Email for="email">Email</label>
							<input type="text" name="gmail" id="gmail" class="form-control">
						</div>
					</div>
					
				</div>
			</div>
			<div class="mt-3">
				<a href="/shop"><button type="button" class="btn btn-success col-2 ms-2">Back </button></a>
				<a><button class="btn btn-success col-2 ms-2">Pay now</button></a>
			</div>
		</form>
	</div>
	<div class="col-4">
		<table class="table text-white">
			<thead>
				<tr>
					<td>Name Lamp</td>
					<td>Quantity</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.lamp.name}</td>
						<td>${c.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="mt-3">
			<div class="justify-content-between d-flex mb-3">
				<div class="col-6">
					Tổng sản phẩm
				</div>
				<div class="col-6 text-end">
					${tongsp}
				</div>
			</div>
			<div class="justify-content-between d-flex mb-3">
				<div class="col-6">
					Tổng tiền hàng
				</div>
				<div class="col-6 text-end">
					<fmt:formatNumber type="number" pattern="###,### VNĐ" value="${tongth}" />
				</div>
			</div>
			<hr>
			<div class="justify-content-between d-flex mb-3">
				<div class="col-6">
					Tổng tiền
				</div>
				<div class="col-6 text-end">
					<fmt:formatNumber type="number" pattern="###,### VNĐ" value="${tamtinh}" />
				</div>
			</div>
		</div>
	</div>
</div>
