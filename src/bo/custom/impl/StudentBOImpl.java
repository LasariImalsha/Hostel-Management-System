package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);


    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getDob(),
                studentDTO.getNic(),
                studentDTO.getAddress(),
                studentDTO.getPhoneNo(),
                studentDTO.getEmail()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getDob(),
                studentDTO.getNic(),
                studentDTO.getAddress(),
                studentDTO.getPhoneNo(),
                studentDTO.getEmail()
        ));
    }

    @Override
    public ArrayList<StudentDTO> searchAll() throws Exception {
        List<Student> all = studentDAO.searchAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : all) {
            studentDTOS.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getDob(),
                    student.getNic(),
                    student.getAddress(),
                    student.getPhoneNo(),
                    student.getEmail()
            ));
        }
        return studentDTOS;
    }

    @Override
    public Student searchId(String stuId) {
        Student student= studentDAO.searchId(stuId);
        return new Student(student.getId(),student.getName(),student.getDob(),student.getNic(),student.getAddress(),student.getPhoneNo(),student.getEmail());
    }

    @Override
    public boolean isExists(String id) {
        return studentDAO.isExist(id);
    }


}
