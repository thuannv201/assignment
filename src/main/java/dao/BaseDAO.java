package dao;

import org.hibernate.Session;

import utils.HibernateUtil;

public class BaseDAO {
	protected Session hSession;
	
	public BaseDAO() {
		this.hSession = HibernateUtil.getHibernateSession();
	}
}
