package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.DongSP;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class DongSPRepository {

    public List<DongSP> findAll() {
        List<DongSP> entities = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<DongSP> query = session.createQuery("SELECT e FROM DongSP e", DongSP.class);
            entities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public DongSP findById(UUID id) {
        DongSP entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void create(DongSP entity) {
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

    public void update(DongSP entity) {
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

    public void delete(DongSP entity) {
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
            DongSP entity = session.load(DongSP.class, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
