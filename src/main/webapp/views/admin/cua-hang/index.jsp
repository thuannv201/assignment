<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="utf-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    <div class="col-10 offset-1">
      <header>
        <h3>Quản lý Cửa hàng</h3>
      </header>
      <div>
        <jsp:include page="create.jsp"></jsp:include>
      </div>
      <h4>Danh sách Của hàng</h4>
      <table class="table table-strip mt-3">
        <thead>
          <tr>
            <td>STT</td>
            <td>Mã</td>
            <td>Tên</td>
            <td>Quốc Gia</td>
            <td>Thành Phố</td>
            <td>Địa Chỉ</td>
            <td colspan="2">Thao tác</td>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ stores }" var="store" varStatus="status">
            <tr>
              <td>${ status.index + 1 }</td>
              <td>${ store.ma }</td>
              <td>${ store.ten }</td>
              <td>${ store.quocGia }</td>
              <td>${ store.thanhPho }</td>
              <td>${ store.diaChi }</td>
              <td>
                <a
                  class="btn btn-primary"
                  href="${ pageContext.request.contextPath }/admin/cua-hang/detail?id=${ store.id }"
                  >Update</a
                >
              </td>
              <td>
                <button
                  type="button"
                  class="btn btn-danger"
                  data-toggle="modal"
                  data-target="#delete_confirm_${ store.id }"
                >
                  Delete
                </button>
                <div
                  class="modal fade"
                  id="delete_confirm_${ store.id }"
                  tabindex="-1"
                  role="dialog"
                  aria-hidden="true"
                >
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">
                          Delete Confirm
                        </h5>
                        <button
                          type="button"
                          class="close"
                          data-dismiss="modal"
                          aria-label="Close"
                        >
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                        Xác nhận xóa Cửa Hàng ${ store.ten } ?
                      </div>
                      <div class="modal-footer">
                        <button
                          type="button"
                          class="btn btn-default"
                          data-dismiss="modal"
                        >
                          Hủy
                        </button>
                        <form
                          method="POST"
                          action="${ pageContext.request.contextPath }/admin/cua-hang/delete"
                        >
                          <input
                            type="hidden"
                            name="id"
                            value="${ store.id }"
                          />
                          <button type="submit" class="btn btn-danger">
                            Xóa
                          </button>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
