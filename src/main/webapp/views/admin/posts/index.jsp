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
		<div>
			<jsp:include page="create.jsp"></jsp:include>
		</div>
		</div>
		<div class="col">
			    <label for="status">user id</label>
				<select class="form-control" id="status" name="status">
				<c:forEach items="${ listUser }" var="user">
			      <option value="${ user.id }">${ user.name }</option>
			    </c:forEach>
			    </select>
			  </div>
		<table class="table table-strip mt-3">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Contents</td>
					<td>Images</td>
					<td>Trạng thái</td>
					<td colspan="2">Thao tác</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listPost }" var="posts">
				<tr>
					<td>${ posts.id }</td>
					<td>${ posts.title }</td>
					<td>${ posts.contents }</td>
					<td><img alt="${ posts.images }" src="${pageContext.request.contextPath}/posts/${ posts.images }" width="100px"></td>
					<td>${ posts.status == 1 ? "Đang hoạt động" : "Vô hiệu hóa" }</td>
					<td>
						<a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/posts/edit?id=${ posts.id }">Update</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_confirm_${ posts.id }">Delete</button>
						<div class="modal fade" id="delete_confirm_${ posts.id }" tabindex="-1" role="dialog" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Delete Confirm</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        Xác nhận xóa video ${ posts.title } ?
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
						        <form method="POST" action="${ pageContext.request.contextPath }/admin/posts/delete" >
						        	<input type="hidden" name="id" value="${ posts.id }"/>
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
</body>
</html>