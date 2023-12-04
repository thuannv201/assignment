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
				<label for="soLuongTon">Số lượng tồn</label> <input type="number" value="${ ctsp.soLuongTon }"
					class="form-control" id="soLuongTon" name="soLuongTon"
					pattern="[0-9]+" />
			</div>
			<div class="col">
				<label for="namBH">Năm BH</label> <input type="number" value="${ ctsp.namBH }"
					class="form-control" id="namBH" name="namBH" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="giaNhap">Giá nhập</label> <input type="number" value="${ ctsp.giaNhap }"
					class="form-control" id="giaNhap" name="giaNhap" />
			</div>
			<div class="col">
				<label for="giaBan">Giá bán</label> <input type="number" value="${ ctsp.giaBan }"
					class="form-control" id="giaBan" name="giaBan" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="moTa">Mô tả</label>
				<textarea class="form-control" id="moTa" name="moTa">${ ctsp.moTa }</textarea>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="idSP">Sản phẩm</label> <select class="form-control"
					id="idSP" name="idSP">
					<c:forEach items="${ lsp }" var="sp">
						<option value="${ sp.id }"${ sp.id == ctsp.idSP ? "selected" : "" }>${ sp.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idMauSac">Màu sắc</label> <select class="form-control"
					id="idMauSac" name="idMauSac">
					<c:forEach items="${ lms }" var="ms">
						<option value="${ ms.id }" ${ ms.id == ctsp.idMauSac ? "selected" : "" }>${ ms.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idDongSP">Dòng sản phẩm</label> <select
					class="form-control" id="idDongSP" name="idDongSP">
					<c:forEach items="${ ldsp }" var="dsp">
						<option value="${ dsp.id }" ${ dsp.id == ctsp.idDongSP ? "selected" : "" }>${ dsp.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idDongSP">Nhà sản xuất</label> <select
					class="form-control" id="idNsx" name="idNsx">
					<c:forEach items="${ lnsx }" var="nsx">
						<option value="${ nsx.id }" ${ nsx.id == ctsp.idNsx ? "selected" : "" }>${ nsx.ten }</option>
					</c:forEach>
				</select>
			</div>
		</div>
			<div class="row justify-content-center mt-3 mb-3">
				<div class="col">
					<button
						formaction="${ pageContext.request.contextPath }/admin/chi-tiet-sp/update?id=${ ctsp.id }"
						type="submit" class="btn btn-primary">Update</button>
					<a href="${pageContext.request.contextPath}/admin/chi-tiet-sp/"
						class="btn btn-secondary">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>