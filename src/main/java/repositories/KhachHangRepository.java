package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.KhachHang;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class KhachHangRepository {

    public List<KhachHang> findAll() {
        List<KhachHang> entities = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<KhachHang> query = session.createQuery("SELECT e FROM KhachHang e", KhachHang.class);
            entities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public KhachHang findById(UUID id) {
        KhachHang entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(KhachHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void create(KhachHang entity) {
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

    public void update(KhachHang entity) {
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

    public void delete(KhachHang entity) {
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
            KhachHang entity = session.load(KhachHang.class, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
