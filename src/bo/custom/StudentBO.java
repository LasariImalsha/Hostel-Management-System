package bo.custom;

import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;

public interface StudentBO {
    boolean add(StudentDTO studentDTO) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    ArrayList<StudentDTO> searchAll() throws Exception;

    Student searchId(String stuId);

    boolean isExists(String id);
}
