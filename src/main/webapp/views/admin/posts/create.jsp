<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<form method="POST"
			enctype="multipart/form-data">
			
			<div class="row">
				<div class="col">
			    <label for="name">Title</label>
			    <input type="text" class="form-control" id="title" name="title">
			  </div>
			  
			  <div class="col">
			    <label for="email">contents</label>
			    <input type="text" class="form-control" id="contents" name="contents">
			  </div>
			</div>
		  	<div class="row" >
			  	<div class="col">
			    <label >images</label>
			    <input type="file" class="form-control" id="images" name="images">
			  </div>
			  <div class="col">
			    <label for="status">Trạng thái</label>
				<select class="form-control" id="status" name="status">
			      <option value="1">Đang hoạt động</option>
			      <option value="2">Vô hiệu hóa</option>
			    </select>
			  </div>
			  <input name="user_id" id="user_id" type="hidden" value="${ userid }">
		  	</div>
		  <button formaction="${ pageContext.request.contextPath }/admin/posts/store" type="submit" class="btn btn-primary">Create</button>
		</form>
	</div>
</body>
</html>