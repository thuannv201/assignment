<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div class="col-12">
		<label class="col-2 font-weight-bold">Họ Tên</label>
		<label class="col-4">${ user.name }</label>
	</div>
	<div class="col-12">
		<label class="col-2 font-weight-bold">Email</label>
		<label class="col-4">${ user.email }</label>
	</div>
	<div class="col-12">
		<label class="col-2 font-weight-bold">Giới tính</label>
		<label class="col-4">${ user.gender }</label>
	</div>
	<div class="col-12">
		<label class="col-2 font-weight-bold">Tài khoản</label>
		<label class="col-4">${ user.role == 2 ? "Admin" : "User" }</label>
	</div>
</div>
