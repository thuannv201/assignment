package repositories;

import org.hibernate.Session;

import utils.HibernateUtil;

public class BaseRepository {
	protected Session hSession;

	public BaseRepository() {
		this.hSession = HibernateUtil.getHibernateSession();
	}

	public void close() {
		if (this.hSession != null) {
			this.hSession.close();
		}
	}

	public void beginTransaction() {
		if (this.hSession != null) {
			this.hSession.beginTransaction();
		}
	}

	public void commit() {
		if (this.hSession != null) {
			this.hSession.getTransaction().commit();
		}
	}

	public void rollback() {
		if (this.hSession != null) {
			this.hSession.getTransaction().rollback();
		}
	}

	// có dang <T>
	public Object get(Class<?> clazz, int id) {
		Object obj = null;
		try {
			this.beginTransaction();
			obj = this.hSession.get(clazz, id);
			this.commit();
		} catch (Exception e) {
			this.rollback();
			e.printStackTrace();
		} finally {
			this.close();
		}
		return obj;
	}

	public <T> T save(String className, T obj) {
		try {
			this.beginTransaction();
			this.hSession.persist(className, obj);
			this.commit();
		} catch (Exception e) {
			this.rollback();
			e.printStackTrace();
		} finally {
			this.close();
		}
		return obj;
	}

	public void update(Object obj) {
		try {
			this.beginTransaction();
			this.hSession.merge(obj);
			this.commit();
		} catch (Exception e) {
			this.rollback();
			e.printStackTrace();
		} finally {
			this.close();
		}
	}

	public void delete(Object obj) {
		try {
			this.beginTransaction();
			this.hSession.remove(obj);
			this.commit();
		} catch (Exception e) {
			this.rollback();
			e.printStackTrace();
		} finally {
			this.close();
		}
	}
}
