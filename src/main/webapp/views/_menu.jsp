<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="utf-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    <header
      class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom"
    >
      <a
        href="/"
        class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
      >
      </a>
      <c:if test="${ sessionScope['user'] != null }">
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li>
            <a
              href="/assignment/admin/cua-hang/"
              class="nav-link px-2 link-dark"
              >Của hàng</a
            >
          </li>
          <li>
            <a href="/assignment/admin/chuc-vu/" class="nav-link px-2 link-dark"
              >Chức vụ</a
            >
          </li>
          <li>
            <a
              href="/assignment/admin/nhan-vien/"
              class="nav-link px-2 link-dark"
              >Nhân viên</a
            >
          </li>
          <li>
            <a
              href="/assignment/admin/khach-hang/"
              class="nav-link px-2 link-dark"
              >Khách hàng</a
            >
          </li>
          <li>
            <a href="/assignment/admin/nsx/" class="nav-link px-2 link-dark"
              >Nhà sản xuất</a
            >
          </li>
          <li>
            <a href="/assignment/admin/dong-sp/" class="nav-link px-2 link-dark"
              >Dòng sản phẩm</a
            >
          </li>
          <li>
            <a href="/assignment/admin/mau-sac/" class="nav-link px-2 link-dark"
              >Màu sắc</a
            >
          </li>
          <li>
            <a
              href="/assignment/admin/san-pham/"
              class="nav-link px-2 link-dark"
              >Sản phẩm</a
            >
          </li>
          <li>
            <a
              href="/assignment/admin/chi-tiet-sp/"
              class="nav-link px-2 link-dark"
              >Chi tiết sản phẩm</a
            >
          </li>
        </ul>

        <div class="col-md-3 text-end">
          <a
            href="${ pageContext.request.contextPath }/logout"
            class="btn btn-outline-primary me-2"
            >Logout</a
          >
        </div>
      </c:if>
    </header>
  </body>
</html>
