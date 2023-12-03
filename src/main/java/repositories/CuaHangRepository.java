package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.CuaHang;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class CuaHangRepository {

    public List<CuaHang> findAll() {
        List<CuaHang> entities = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<CuaHang> query = session.createQuery("SELECT ch FROM CuaHang ch", CuaHang.class);
            entities = query.getResultList();
            System.out.println(entities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public CuaHang findById(UUID id) {
        CuaHang entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void create(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
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
            CuaHang entity = session.load(CuaHang.class, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

}
