package repositories;

import entities.NhanVien;
import jakarta.persistence.TypedQuery;
import utils.HashUtil;

public class NhanVienRepository extends BaseRepository {

	public NhanVien login(String email, String password) {
		TypedQuery<NhanVien> query = this.hSession.createNamedQuery("User.findByEmail", NhanVien.class);
		query.setParameter("email", email);
		NhanVien entity = query.getSingleResult();

		boolean checkPwd = HashUtil.verify(password, entity.getMatKhau());
		if (checkPwd == false) {
			return null;
		}

		return entity;
	}

}
