package repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.NhanVien;
import jakarta.persistence.TypedQuery;
import utils.HashUtil;
import utils.HibernateUtil;

public class NhanVienRepository {

	public NhanVien login(String email, String password) {
		NhanVien entity = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			TypedQuery<NhanVien> query = session.createNamedQuery("User.findByEmail", NhanVien.class);
			query.setParameter("email", email);
			entity = query.getSingleResult();

			boolean checkPwd = HashUtil.verify(password, entity.getMatKhau());
			if (checkPwd == false) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public List<NhanVien> findAll() {
		List<NhanVien> entities = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			TypedQuery<NhanVien> query = session.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class);
			entities = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

}
