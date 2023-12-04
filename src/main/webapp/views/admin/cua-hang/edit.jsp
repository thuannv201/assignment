<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<div class="col-10 offset-1">
		<form method="POST">
			<div class="row">
				<div class="col">
					<label for="ma">Mã</label> <input type="text" value="${ store.ma }"
						class="form-control" id="ma" name="ma" />
				</div>
				<div class="col">
					<label for="ten">Tên</label> <input type="text"
						value="${ store.ten }" class="form-control" id="ten" name="ten" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="quocGia">Quốc Gia</label> <input type="text"
						class="form-control" id="quocGia" name="quocGia"
						value="${ store.quocGia }" />
				</div>
				<div class="col">
					<label for="thanhPho">Thành Phố</label> <input type="text"
						class="form-control" id="thanhPho" name="thanhPho"
						value="${ store.thanhPho }" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="diaChi">Địa chỉ</label>
					<textarea class="form-control" id="diaChi" name="diaChi">${ store.diaChi }</textarea>
				</div>
			</div>

			<div class="row justify-content-center mt-3 mb-3">
				<div class="col">
					<button
						formaction="${ pageContext.request.contextPath }/admin/cua-hang/update?id=${ store.id }"
						type="submit" class="btn btn-primary">Update</button>
					<a href="${pageContext.request.contextPath}/admin/cua-hang/"
						class="btn btn-secondary">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
