<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<div class="row mx-auto">
	<div class="row  mx-auto">
	<c:if test="${messageCart != null }">
		<div class="badge bg-danger">${messageCart}</div>
	</c:if>
		<table class="table table-light ">
			<thead>
				<tr>
					<th>Name</th>
					<th>Giá</th>
					<th>Số Lượng</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.lamp.name }</td>
						<td><fmt:formatNumber type="number" pattern="###,### VNĐ"
								value="${c.lamp.price}" /></td>
						<td>
						<a href="/cart/decrease/${c.id_order_detail}" style="display: inline-block;padding: 0px 15px;border: 1px solid black;text-decoration:none;">-</a>
						
						<span>${c.quantity }</span>
						<a href="/cart/increase/${c.id_order_detail}" style="display: inline-block;padding: 0px 15px;border: 1px solid black;text-decoration:none;">+</a>
						</td>
						<td><a href="/cart/delete?id=${c.id_order_detail}">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	
	<div class="row mx-auto">
		<div class=" mt-3">
			<div class="col-6">Tổng sản phẩm</div>
			<div class="col-6 text-end">${tongsp }</div>
		</div>
		<div class="d-flex justify-content-between mt-3">
			<div class="col-6">Tổng tiền hàng</div>
			<div class="col-6 text-end">
				<fmt:formatNumber type="number" pattern="###,### VNĐ"
					value="${tongth }" />
			</div>
		</div>
		<hr>
		<div class="d-flex justify-content-between mt-3">
			<div class="col-6">Tạm tính</div>
			<div class="col-6 text-end">
				<fmt:formatNumber type="number" pattern="###,### VNĐ"
					value="${tamtinh }" />
			</div>
		</div>
		<div class="mt-3">
			<a href="/shop">
				<button class="btn btn-success">Back </button>
			</a> <a href="/order/index" class="ms-2">
				<button class="btn btn-success">Thanh Toán</button>
			</a>
		</div>
	</div>
</div>
