<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<form method="POST">
			<div class="row">
				<div class="col">
					<label for="ma">Mã</label> <input type="text" class="form-control"
						value="${ nv.ma }" id="ma" name="ma" />
				</div>
				<div class="col">
					<label for="matKhau">Mật Khẩu</label> <input type="password"
						class="form-control" id="matKhau" name="matKhau" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="ho">Họ</label> <input type="text" value="${ nv.ho }"
						class="form-control" id="ho" name="ho" />
				</div>
				<div class="col">
					<label for="tenDem">Tên Đệm</label> <input type="text"
						value="${ nv.tenDem }" class="form-control" id="tenDem"
						name="tenDem" />
				</div>
				<div class="col">
					<label for="ten">Tên</label> <input type="text"
						class="form-control" value="${ nv.ten }" id="ten" name="ten" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="sdt">SĐT</label> <input type="text" value="${ nv.sdt }"
						class="form-control" id="sdt" name="sdt" />
				</div>
				<div class="col">
					<label for="ngaySinh">Ngày Sinh</label> <input type="date"
						value="<fmt:formatDate value='${nv.ngaySinh}' pattern='yyyy-MM-dd' />"
						class="form-control" id="ngaySinh" name="ngaySinh" />
				</div>
				<div class="col">
					<label for="gioiTinh">Giới tính</label> <select
						class="form-control" id="gioiTinh" name="gioiTinh">
						<option value="1" ${ nv.gioiTinh == 1 ? "selected" : "" }>Nam</option>
						<option value="0" ${ nv.gioiTinh == 0 ? "selected" : "" }>Nữ</option>
						<option value="2" ${ nv.gioiTinh == 2 ? "selected" : "" }>Khác</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="diaChi">Địa chỉ</label>
					<textarea class="form-control" id="diaChi" name="diaChi">${ nv.diaChi }</textarea>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="idCH">Cửa Hàng</label> <select class="form-control"
						id="idCH" name="idCH">
						<option value=""></option>
						<c:forEach items="${ listStore }" var="store">
							<option value="${ store.id }"
								${ store.ma == nv.cuaHang.ma ? "selected" : "" }>${ store.ten }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col">
					<label for="idCV">Chức Vụ</label> <select class="form-control"
						id="idCV" name="idCV">
						<option value=""></option>
						<c:forEach items="${ listRole }" var="role">
							<option value="${ role.id }"
								${ role.ma == nv.chucVu.ma ? "selected" : "" }>${ role.ten }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col">
					<label for="trangThai">Trạng thái</label> <select
						class="form-control" id="trangThai" name="trangThai">
						<option value="1" ${ nv.trangThai == 1 ? "selected" : "" }>Đang
							hoạt động</option>
						<option value="2" ${ nv.trangThai == 1 ? "selected" : "" }>Vô
							hiệu hóa</option>
					</select>
				</div>
			</div>
			<div class="row justify-content-center mt-3 mb-3">
				<div class="col">
					<button
						formaction="${ pageContext.request.contextPath }/admin/nhan-vien/update?id=${ user.id }"
						type="submit" class="btn btn-primary">Update</button>
					<a href="${pageContext.request.contextPath}/admin/nhan-vien/"
						class="btn btn-secondary">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>