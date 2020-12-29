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
            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
            Detail detail = new Detail("New-York", "147852369", "nikolaj@gmail.com");

            detail.setEmployee(employee); // нужно добавить связи в двух направлениях
            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }

    }
}
