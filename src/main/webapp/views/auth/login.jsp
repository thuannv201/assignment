<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-10 offset-1">
	<div class="mt-5">
		<c:if test="${ sessionScope.error != null }">
			<div class="alert alert-danger">
				${ sessionScope.error }
			</div>
		</c:if>
		<form method="POST" action="${ pageContext.request.contextPath }/login">
			<div class="mt-3">
				<label for="username">UserName</label>
				<input type="text" name="username" id="username" class="form-control" value="${ username }"/>
			</div>
			<div class="mt-3">
				<label for="password">Password</label>
				<input type="password" name="password" id="password"  class="form-control"/>
			</div>
			<div class="mt-3">
				<label for="chk">remember</label>
				<input type="checkbox" name="chkremeber" id="chkremeber"  />
			</div>
			<div class="mt-3">
				<button class="btn btn-primary">Login</button>
			</div>
		</form>
	</div>
</div>
