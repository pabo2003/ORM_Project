package lk.ijse.gdse;

import lk.ijse.gdse.Config.FactoryConfiguration;
import lk.ijse.gdse.Emded.FullName;
import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // Student operations
        Student student = new Student(1, new FullName("Paboda", "Sanduni"), "Kurunegala");
        session.save(student);
        session.delete(student);
        Student student1 = session.get(Student.class, 1);
        if (student1 != null) {
            System.out.println(student1.toString());
        }
        transaction.commit();
        session.close();

        // Teacher operations
        Session session1 = FactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = session1.beginTransaction();
        Teacher teacher = new Teacher(2, "Kamala", "Kurunegala", 25000);
        session1.save(teacher);
        session1.update(teacher);
        session1.delete(teacher);
        Teacher teacher1 = session1.get(Teacher.class, 2);
        if (teacher1 != null) {
            System.out.println(teacher1.getName() + ", " + teacher1.getAddress() + ", " + teacher1.getSalary());
        }
        transaction1.commit();
        session1.close();
    }
}
