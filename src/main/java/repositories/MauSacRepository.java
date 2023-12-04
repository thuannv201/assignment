package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.MauSac;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class MauSacRepository {

    public List<MauSac> findAll() {
        List<MauSac> entities = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<MauSac> query = session.createQuery("SELECT e FROM MauSac e", MauSac.class);
            entities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public MauSac findById(UUID id) {
        MauSac entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void create(MauSac MauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(MauSac);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac MauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(MauSac);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac MauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(MauSac);
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
            MauSac entity = session.load(MauSac.class, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

}
