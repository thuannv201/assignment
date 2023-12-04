<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<header>
			<h3>Quản lý chi tiết sản phẩm</h3>
		</header>
		<div>
	        <jsp:include page="create.jsp"></jsp:include>
	      </div>
		<h4>Danh sách chi tiết sản phẩm</h4>
		<table class="table table-strip mt-3">
			<thead>
				<tr>
					<td>STT</td>
					<td>Năm BH</td>
					<td>Số lượng tồn</td>
					<td>Giá nhập</td>
					<td>Giá bán</td>
					<td colspan="2">Thao tác</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ lctsp }" var="ctsp" varStatus="status">
				<tr>
					<td>${ status.index + 1 }</td>
					<td>${ ctsp.namBH }</td>
					<td>${ ctsp.soLuongTon }</td>
					<td>${ ctsp.giaNhap }</td>
					<td>${ ctsp.giaBan }</td>
					<td>
						<a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/chi-tiet-sp/detail?id=${ ctsp.id }">Update</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_confirm_${ ctsp.id }">Delete</button>
						<div class="modal fade" id="delete_confirm_${ ctsp.id }" tabindex="-1" role="dialog" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Delete Confirm</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        Xác nhận xóa chi tiết sản phẩm ?
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
						        <form method="POST" action="${ pageContext.request.contextPath }/admin/chi-tiet-sp/delete" >
						        	<input type="hidden" name="id" value="${ ctsp.id }"/>
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