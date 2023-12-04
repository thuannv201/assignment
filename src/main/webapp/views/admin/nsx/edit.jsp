<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
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
            <label for="ma">Mã</label>
            <input
              type="text"
              value="${ nsx.ma }"
              class="form-control"
              id="ma"
              name="ma"
            />
          </div>
          <div class="col">
            <label for="ten">Tên</label>
            <input
              type="text"
              value="${ nsx.ten }"
              class="form-control"
              id="ten"
              name="ten"
            />
          </div>
        </div>
        <button
          formaction="${ pageContext.request.contextPath }/admin/cua-hang/update?id=${ nsx.id }"
          type="submit"
          class="btn btn-primary mt-3"
        >
          Update
        </button>
      </form>
    </div>
  </body>
</html>
