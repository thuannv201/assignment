package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.NhanVien;
import jakarta.persistence.TypedQuery;
import utils.HashUtil;
import utils.HibernateUtil;

public class NhanVienRepository {

	public NhanVien login(String ma, String password) {
		NhanVien entity = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			TypedQuery<NhanVien> query = session.createQuery("SELECT e FROM NhanVien e WHERE e.ma = :ma",
					NhanVien.class);
			query.setParameter("ma", ma);
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

	public NhanVien findById(UUID id) {
		NhanVien entity = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			entity = session.get(NhanVien.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public void create(NhanVien NhanVien) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(NhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	public void update(NhanVien NhanVien) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(NhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	public void delete(NhanVien NhanVien) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(NhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	public void deleteById(UUID id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			NhanVien entity = session.load(NhanVien.class, id);
			session.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
