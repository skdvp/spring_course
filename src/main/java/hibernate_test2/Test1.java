package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();

            Employee emp = session.get(Employee.class,10);

            session.getTransaction().commit();

            System.out.println(emp.getEmpDetail());

        } finally {
            session.close();
            factory.close();
        }

    }
}
