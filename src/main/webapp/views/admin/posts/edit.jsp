<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<form method="POST" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="name">title</label>
		    <input type="text" class="form-control" value="${ posts.title }" id="title" name="title">
		  </div>
		  
		  <div class="form-group">
		    <label for="email">contents</label>
		    <input type="text" class="form-control" value="${ posts.contents }" id="contents" name="contents">
		  </div>
		  
		  <div class="form-group">
		    <label for="avatar">Image</label>
		    <input type="file" class="form-control" id="images" name="images" />
		  </div>
		  <div class="form-group">
		    <label for="status">Trạng thái</label>
			<select class="form-control" id="status" name="status">
		      <option value="1" ${ posts.status == 1 ? "selected" : "" }>Đang hoạt động</option>
		      <option value="2" ${ posts.status == 0 ? "selected" : "" }>Vô hiệu hóa</option>
		    </select>
		  </div>
		  
		  <button type="submit" class="btn btn-primary" formaction="${ pageContext.request.contextPath }/admin/posts/update?id=${ posts.id }">Submit</button>
		</form>
	</div>
</body>
</html>