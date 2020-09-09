import model.Laptop;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @Author: apple
 * @created on 09/09/2020
 * @Project is Hibernate-Implementation
 */

public class AppOneToOne {
    public static void main(String[]args) {

        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setName("Dell");

        Student student = new Student();
        student.setName("Urunov");
        student.setRollno(1);
        student.setMark(90);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(student);

        session.getTransaction().commit();
    }
}
