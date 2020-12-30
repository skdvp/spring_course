package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
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


            //TODO
            // удалить детали отдельно возможно только,
            // если разорвать связь с внешим ключом,
            // способ через Java - засетить полность строку null,
            // затерев тем самым связь, которая бросает Exception

            Detail detail = session.get(Detail.class, 5);
            detail.getEmployee().setEmpDetail(null);
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
