package com.hibernate.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.service.ServiceRegistryBuilder;


@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
        Laptop laptop = new Laptop();
        laptop.setlId(101);
        laptop.setName("Dell");

        Student s = new Student();
        s.setName("Hamdamboy");
        s.setRollno(1);
        s.setMarks(50);
        s.getLaptopList().add(laptop);



        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(s);

        session.getTransaction().commit();






    }

}
