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
		  <div class="row">
			  <div class="col">
			    <label for="name">Họ tên</label>
			    <input type="text" class="form-control"  value="${ user.name }"  id="name" name="name">
		  	</div>
			  <div class="col">
			    <label for="email">Email</label>
			    <input type="email" class="form-control"  value="${ user.email }"   id="email" name="email">
			  </div>
		  </div>
		  <div class="row">
		  		<div class="col">
				    <label for="password">Password</label>
				    <input type="password" class="form-control"  value="${ user.password }"  id="password" name="password" disabled="disabled">
				  </div>
				  <div class="col">
				    <label for="gender">Giới tính</label>
					<select class="form-control" id="gender" name="gender">
				      <option value="1" ${ user.gender == 1 ? "selected" : "" } >Nam</option>
		      			<option value="0" ${ user.gender == 0 ? "selected" : "" }>Nữ</option>
				    </select>
				  </div>
		  </div>
		  <div class="row">
			  
			  <div class="col">
			    <label for="avatar">Avatar</label>
			    <input type="file" class="form-control" id="avatar" name="avatar" />
			  </div>
			  	  <div class="col">
		    <label for="role">Phân quyền</label>
			<select class="form-control" id="role" name="role">
		      <option value="1" ${ user.role == 1 ? "selected" : "" }>Sinh Viên</option>
		      <option value="2" ${ user.role == 0 ? "selected" : "" }>Giảng viên</option>
		    </select>
		  </div>
		  
		  <div class="col">
		    <label for="status">Trạng thái</label>
			<select class="form-control" id="status" name="status">
		      <option value="1" ${ user.status == 1 ? "selected" : "" }>Đang hoạt động</option>
		      <option value="2" ${ user.status == 0 ? "selected" : "" }>Vô hiệu hóa</option>
		    </select>
		  </div>
		  </div>
		  <div class="col">
		  	<img alt="anh" src="${pageContext.request.contextPath}/avatar/${ user.avatar }" width="100px">
		  </div>

		  <button formaction="${ pageContext.request.contextPath }/admin/users/update?id=${ user.id }" type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</body>
</html>