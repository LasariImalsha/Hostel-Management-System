package dao.custom;

import entity.Student;

import java.util.List;

public interface StudentDAO {
    boolean add(Student entity) throws Exception;

    boolean update(Student entity) throws Exception;

    boolean delete(String s) throws Exception;

    Student search(String id) throws Exception;

    List<Student> searchAll() throws Exception;

    boolean isExist(String id);
}
