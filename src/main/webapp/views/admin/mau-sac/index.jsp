<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<header>
			<h3>Quản lý màu sắc</h3>
		</header>
		<div>
	        <jsp:include page="create.jsp"></jsp:include>
	      </div>
		<h4>Danh sách màu sắc</h4>
		<table class="table table-strip mt-3">
			<thead>
				<tr>
					<td>STT</td>
					<td>Mã</td>
					<td>Tên</td>
					<td colspan="2">Thao tác</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ lms }" var="ms" varStatus="status">
				<tr>
					<td>${ status.index + 1 }</td>
					<td>${ ms.ma }</td>
					<td>${ ms.ten }</td>
					<td>
						<a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/mau-sac/detail?id=${ ms.id }">Update</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_confirm_${ ms.id }">Delete</button>
						<div class="modal fade" id="delete_confirm_${ ms.id }" tabindex="-1" role="dialog" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Delete Confirm</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        Xác nhận xóa màu sắc ${ ms.ten } ?
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
						        <form method="POST" action="${ pageContext.request.contextPath }/admin/mau-sac/delete" >
						        	<input type="hidden" name="id" value="${ ms.id }"/>
						        	<button type="submit" class="btn btn-danger">Xóa</button>
						        </form>
						      </div>
						    </div>
						  </div>
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>