package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.load(Student.class, s);
        session.delete(student);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Student search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.load(Student.class, id);


        transaction.commit();
        session.close();

        return student;
    }

    @Override
    public List<Student> searchAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Student");
        List <Student> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    public Student searchId(String stuId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, stuId);

        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public boolean isExist(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM Student WHERE id=:id");
        String sId = String.valueOf(query.setParameter("id", id).uniqueResult());
        if (sId != null) {
            return true;
        }


        //  return session.createNativeQuery("SELECT * FROM Student WHERE id= :id").setParameter(1, id).uniqueResult() != null;


        transaction.commit();
        session.close();
        return false;




    }


}
