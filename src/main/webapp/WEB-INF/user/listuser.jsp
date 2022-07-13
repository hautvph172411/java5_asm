<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Danh sách</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
a.hidden {
	pointer-events: none;
	background-color: gray;
}
</style>
</head>
<body >
	<div class="container">
		<form action="" method="get">
			<div class="card">
				<div class="card-header">
					<div class="row d-flex justify-content-between">
						<div class="col-3 fs-5">User</div>
						<div class="col-7">
						</div>
						<div class="col-2">
							
							<a class="btn btn-success" href="/user/add">Add</a>
							<!-- Modal -->
							
				
						</div>
					</div>
				</div>
				<div class="card-body">
					<table class="table table-hover m-0 p-0">
						<thead>
							<th>Tên</th>
							<th>Gmail</th>
							<th>Password</th>
							<th>Role</th>
							
							<th colspan="2">Activity</th>
						</thead>
						<tbody>
							<c:forEach items="${listUser}" var="lg">
								<tr>
									<td>${lg.fullname}</td>									
									<td>${lg.gmail}</td>
									<td>${lg.pass}</td>
									<td>${lg.role == true ? 'Admin' : 'User'}</td>
									<td><a class="btn" href="/user/edit?id=${lg.id_user}"><i
											class="fa-solid fa-pencil"></i></a></td>
									<td><a class="btn" href="/user/delete?id=${lg.id_user}"><i
											class="fa-solid fa-trash"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				 
			</div>
		</form>
	</div>


	
</body>
</html>