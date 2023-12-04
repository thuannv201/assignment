package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.NSX;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class NSXRepository {

    public List<NSX> findAll() {
        List<NSX> entities = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<NSX> query = session.createQuery("SELECT e FROM NSX e", NSX.class);
            entities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public NSX findById(UUID id) {
        NSX entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void create(NSX entity) {
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

    public void update(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NSX NSX) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(NSX);
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
            NSX entity = session.load(NSX.class, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
