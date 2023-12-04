<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-10 offset-1">
	<form method="POST">
		<div class="row">
			<div class="col">
				<label for="soLuongTon">Số lượng tồn</label> <input type="number"
					class="form-control" id="soLuongTon" name="soLuongTon"
					pattern="[0-9]+" />
			</div>
			<div class="col">
				<label for="namBH">Năm BH</label> <input type="number"
					class="form-control" id="namBH" name="namBH" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="giaNhap">Giá nhập</label> <input type="number"
					class="form-control" id="giaNhap" name="giaNhap" />
			</div>
			<div class="col">
				<label for="giaBan">Giá bán</label> <input type="number"
					class="form-control" id="giaBan" name="giaBan" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="moTa">Mô tả</label>
				<textarea class="form-control" id="moTa" name="moTa"> </textarea>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="idSP">Sản phẩm</label> <select class="form-control"
					id="idSP" name="idSP">
					<c:forEach items="${ lsp }" var="sp">
						<option value="${ sp.id }">${ sp.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idMauSac">Màu sắc</label> <select class="form-control"
					id="idMauSac" name="idMauSac">
					<c:forEach items="${ lms }" var="ms">
						<option value="${ ms.id }">${ ms.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idDongSP">Dòng sản phẩm</label> <select
					class="form-control" id="idDongSP" name="idDongSP">
					<c:forEach items="${ ldsp }" var="dsp">
						<option value="${ dsp.id }">${ dsp.ten }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<label for="idDongSP">Nhà sản xuất</label> <select
					class="form-control" id="idNsx" name="idNsx">
					<c:forEach items="${ lnsx }" var="nsx">
						<option value="${ nsx.id }">${ nsx.ten }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col">
				<button
					formaction="${ pageContext.request.contextPath }/admin/chi-tiet-sp/create"
					type="submit" class="btn btn-primary mt-3">Create</button>
			</div>
		</div>
	</form>
</div>
