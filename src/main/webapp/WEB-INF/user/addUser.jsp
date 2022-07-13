<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
a.disabled {
	pointer-events: none;
	background-color: gray;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row mt-0">
			<div class="col-12 mx-auto">
				<form action="/user/add" method="post">
					<div class="card">
						<h5 class="card-header">Add User</h5>
						<c:if test="${messageAdd !=null }">
							<p class="alert alert-danger">${messageAdd}</p>
						</c:if>
						<div class="card-body">
							<div class="mt-2">
								<label>Name</label> <input type="text" name="fullname"
									class="form-control" required="required">
							</div>
							<div class="mt-2">
								<label>Gmail</label> <input type="email" name="gmail"
									class="form-control" required="required">
							</div>
							<div class="mt-2">
								<label>Password</label> <input type="password" name="pass"
									class="form-control" required="required">
							</div>
							<div class="mt-2">
							<label class="labels">Role</label>
							
									<div class="form-check form-check-inline">
										<input class="form-check-input" name="role" type="radio"
											id="inlineCheckbox1" value="true"
											> <label
											class="form-check-label" for="inlineCheckbox1">Admin</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" name="role" type="radio"
											id="inlineCheckbox2" value="false"
											> <label
											class="form-check-label" for="inlineCheckbox2">User</label>
									</div>
								
							</div>
								
					</div>
					<div class="card-footer">
						<div>
							<button class="btn btn-success">Add</button>
							<button type="reset" class="btn btn-secondary">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>