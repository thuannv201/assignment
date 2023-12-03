<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div class="col-10 offset-1">
  <form method="POST" enctype="multipart/form-data">
    <div class="row">
      <div class="col">
        <label for="ma">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma" />
      </div>
      <div class="col">
        <label for="matKhau">Mật Khẩu</label>
        <input
          type="password"
          class="form-control"
          id="matKhau"
          name="matKhau"
        />
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="ten">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten" />
      </div>
      <div class="col">
        <label for="tenDem">Họ</label>
        <input type="text" class="form-control" id="tenDem" name="tenDem" />
      </div>
      <div class="col">
        <label for="ho">Tên Đệm</label>
        <input type="text" class="form-control" id="ho" name="ho" />
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="sdt">SĐT</label>
        <input type="number" class="form-control" id="sdt" name="sdt" />
      </div>
      <div class="col">
        <label for="ngaySinh">Ngày Sinh</label>
        <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" />
      </div>
      <div class="col">
        <label for="gender">Giới tính</label>
        <select class="form-control" id="gender" name="gender">
          <option value="1">Nam</option>
          <option value="0">Nữ</option>
          <option value="2">Khác</option>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="diaChi">Địa chỉ</label>
        <textarea class="form-control" id="diaChi" name="diaChi"> </textarea>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="idCH">Cửa Hàng</label>
        <select class="form-control" id="idCH" name="idCH">
          <c:forEach items="${ listStore }" var="store">
            <option value="${ store.id }">${ store.ten }</option>
          </c:forEach>
        </select>
      </div>
	  <div class="col">
        <label for="idCV">Chức Vụ</label>
        <select class="form-control" id="idCV" name="idCV">
          <c:forEach items="${ listRole }" var="role">
            <option value="${ role.id }">${ role.ten }</option>
          </c:forEach>
        </select>
      </div>
      <div class="col">
        <label for="trangThai">Trạng thái</label>
        <select class="form-control" id="trangThai" name="trangThai">
          <option value="1">Đang hoạt động</option>
          <option value="2">Vô hiệu hóa</option>
        </select>
      </div>
    </div>
    <button
      formaction="${ pageContext.request.contextPath }/admin/users/store"
      type="submit"
      class="btn btn-primary mt-3"
    >
      Create
    </button>
  </form>
</div>
