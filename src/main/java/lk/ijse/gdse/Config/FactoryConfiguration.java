package lk.ijse.gdse.Config;

import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory();

        Configuration configuration1 = new Configuration().configure().addAnnotatedClass(Teacher.class);
        sessionFactory = configuration1.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null)?
                factoryConfiguration= new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }

}
