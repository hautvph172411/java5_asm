
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<!-- Start Content Page -->
	<div class="container-fluid bg-light py-5">
		<div class="col-md-6 m-auto text-center">
			<h1 class="h1">Liên Hệ</h1>
			<hr>
			<p>
				CÔNG TY CỔ PHẦN THƯƠNG MẠI VÀ XUẤT NHẬP KHẨU APOLOPH17241 </br> Hotline -
				Zalo: 0922632691 </br> Showroom 1:  </br> Điện thoại: (024) 2324 6999 </br> Showroom 2: Số 9
				ngõ 35 phố Kim Mã Thượng, Ba Đình, Hà Nội ( khu vực Liễu Giai, ô tô
				đỗ trước cửa Showroom ) </br> Điện thoại: 00918237627 </br> Liên hệ Đối
				tác&CSKH: 19008198 </br> Email: hautvph1724@fpt.edu.vn
				</br> Website: http://localhost:8080/home </br> Người phụ
				trách: Trần Văn Hậu </br>
			</p>
		</div>
	</div>



	<!-- Start Contact -->
	<div class="container py-5">
		<div class="row py-5">
			<form class="col-md-9 m-auto" method="post" role="form">
				<div class="row">
					<div class="form-group col-md-6 mb-3">
						<label for="inputname">Tên</label> <input type="text"
							class="form-control mt-1" id="name" name="name"
							placeholder="Tên">
					</div>
					<div class="form-group col-md-6 mb-3">
						<label for="inputemail">Email</label> <input type="email"
							class="form-control mt-1" id="email" name="email"
							placeholder="Email">
					</div>
				</div>
				<div class="mb-3">
					<label for="inputsubject">Nội Dung</label> <input type="text"
						class="form-control mt-1" id="subject" name="subject"
						placeholder="Nội Dung">
				</div>
				<div class="mb-3">
					<label for="inputmessage">Góp Ý</label>
					<textarea class="form-control mt-1" id="message" name="message"
						placeholder="Góp Ý" rows="8"></textarea>
				</div>
				<div class="row">
					<div class="col text-end mt-2">
						<button type="submit" class="btn btn-success btn-lg px-3">Gửi</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- End Contact -->
