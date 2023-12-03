package repositories;

import java.util.List;

import org.hibernate.Session;

import entity.ChucVu;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class ChucVuRepository {

	public List<ChucVu> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TypedQuery<ChucVu> query = session.createQuery("SELECT cv FROM ChucVu cv", ChucVu.class);
		List<ChucVu> entities = query.getResultList();
		session.close();
		return entities;
	}
}
