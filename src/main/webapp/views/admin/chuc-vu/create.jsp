<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-10 offset-1">
  <form method="POST">
    <div class="row">
      <div class="col">
        <label for="ma">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma" />
      </div>
      <div class="col">
        <label for="ten">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten" />
      </div>
    </div>
    <button
      formaction="${ pageContext.request.contextPath }/admin/chuc-vu/create"
      type="submit"
      class="btn btn-primary mt-3"
    >
      Create
    </button>
  </form>
</div>
