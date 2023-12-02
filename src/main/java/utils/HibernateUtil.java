package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory FACTORY;
    private static Session hibernateSession;

    static {
        Configuration conf = new Configuration();

        conf.configure("hibernate.cfg.xml");

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static Session getHibernateSession() {
        if (hibernateSession == null || !hibernateSession.isOpen()) {
            hibernateSession = getFACTORY().openSession();
        }

        return hibernateSession;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
