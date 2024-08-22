package lk.ijse.gdse;

import lk.ijse.gdse.Config.FactoryConfiguration;
import lk.ijse.gdse.Emded.FullName;
import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args){
        Session session = FactoryConfiguration.getInstance().getSession();
        //open transaction
        Transaction transaction = session.beginTransaction();

        //Student save,delete,update
        Student student = new Student(1,new FullName("Paboda","Sanduni"),"Kurunegala");
        session.save(student);
        session.delete(student);
        session.update(student);
        //get
        Student student1 = session.get(Student.class, 1);
        System.out.println(student1.toString());
        //commit
        transaction.commit();

        //Teacher save ,delete,update
        Session session1 = FactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = session1.beginTransaction();
        Teacher teacher = new Teacher(2,"Kamala","Kurunegala",25000);
        session1.save(teacher);
        session1.update(teacher);
        session1.delete(teacher);
        //get
       Teacher teacher1= session1.get(Teacher.class, 1);
        System.out.println(teacher1.getName() + ", " +teacher1.getAddress()+", "+teacher1.getSalary());
        transaction1.commit();
        session1.close();
    }
}
