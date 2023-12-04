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
						value="${ kh.ma }" id="ma" name="ma" />
				</div>
				<div class="col">
					<label for="matKhau">Mật Khẩu</label> <input type="password"
						class="form-control" id="matKhau" name="matKhau" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="ho">Họ</label> <input type="text" value="${ kh.ho }"
						class="form-control" id="ho" name="ho" />
				</div>
				<div class="col">
					<label for="tenDem">Tên Đệm</label> <input type="text"
						value="${ kh.tenDem }" class="form-control" id="tenDem"
						name="tenDem" />
				</div>
				<div class="col">
					<label for="ten">Tên</label> <input type="text"
						class="form-control" value="${ kh.ten }" id="ten" name="ten" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="sdt">SĐT</label> <input type="text" value="${ kh.sdt }"
						class="form-control" id="sdt" name="sdt" />
				</div>
				<div class="col">
					<label for="ngaySinh">Ngày Sinh</label> <input type="date"
						value="<fmt:formatDate value='${kh.ngaySinh}' pattern='yyyy-MM-dd' />"
						class="form-control" id="ngaySinh" name="ngaySinh" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="quocGia">Quốc Gia</label> <input type="text"
						class="form-control" id="quocGia" name="quocGia"
						value="${ kh.quocGia }" />
				</div>
				<div class="col">
					<label for="thanhPho">Thành Phố</label> <input type="text"
						class="form-control" id="thanhPho" name="thanhPho"
						value="${ kh.thanhPho }" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="diaChi">Địa chỉ</label>
					<textarea class="form-control" id="diaChi" name="diaChi">${ kh.diaChi }</textarea>
				</div>
			</div>
			</div>
			<div class="row justify-content-center mt-3 mb-3">
				<div class="col">
					<button
						formaction="${ pageContext.request.contextPath }/admin/khach-hang/update?id=${ kh.id }"
						type="submit" class="btn btn-primary">Update</button>
					<a href="${pageContext.request.contextPath}/admin/khach-hang/"
						class="btn btn-secondary">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>