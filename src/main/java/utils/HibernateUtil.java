package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;
	private static Session hibernateSession;

	protected static SessionFactory getHibernateSessionFactory()
	{
		if (factory == null || !factory.isOpen()) {
			Configuration config = new Configuration();
			
			config.configure("hibernate.cfg.xml");
			
			factory = config.buildSessionFactory();
		}

		return factory;
	}
	
	public static Session getHibernateSession() {
		if (hibernateSession == null || !hibernateSession.isOpen()) {
			hibernateSession = getHibernateSessionFactory().openSession();
		}

		return hibernateSession;
	}
}
