package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.ChucVu;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class ChucVuRepository {

	 public List<ChucVu> findAll() {
	        List<ChucVu> entities = new ArrayList<>();
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            TypedQuery<ChucVu> query = session.createQuery("SELECT ch FROM ChucVu ch", ChucVu.class);
	            entities = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return entities;
	    }

	    public ChucVu findById(UUID id) {
	    	ChucVu entity = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            entity = session.get(ChucVu.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return entity;
	    }

	    public void create(ChucVu entity) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(entity);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	    }

	    public void update(ChucVu entity) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.update(entity);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	    }

	    public void delete(ChucVu entity) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.delete(entity);
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
	            ChucVu entity = session.load(ChucVu.class, id);
	            session.delete(entity);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	    }
	    
	    public boolean checkExist(String ma) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            TypedQuery<ChucVu> query = session.createQuery("SELECT ch FROM ChucVu ch WHERE ch.ma = :ma", ChucVu.class);
	            query.setParameter("ma", ma);
	            ChucVu exist = query.getSingleResult();
	            if (exist != null) {
	            	return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}
