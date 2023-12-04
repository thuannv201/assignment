<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>home</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>

</head>
<body>
	<!-- Header -->
		<jsp:include page="_menu.jsp"></jsp:include>
		<!-- End Header -->
	<div class="container">
		<div class="row">
		    <!-- Content -->
		    <div class="col-10">
		    	<jsp:include page="${ view }"></jsp:include>
		    </div>
		    <!-- End Content -->
		</div>
		<jsp:include page="_footer.jsp"></jsp:include>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</div>
</body>
</html>