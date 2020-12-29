package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//             List<Employee> emps = session.createQuery("from Employee") // имя класса
//                     .getResultList();

            List<Employee> emps = session.createQuery("from Employee where name = 'Aleksandr' AND salary>1000")
                    .getResultList();

            for (Employee e : emps) {
                System.out.println(e);
            }


            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
