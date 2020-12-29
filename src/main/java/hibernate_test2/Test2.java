package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {

            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class,4);

            session.delete(detail);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }

    }
}
