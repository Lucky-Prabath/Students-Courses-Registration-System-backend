package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.StudentDAO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    @Autowired
    private EntityDTOMapper mapper;
    @Autowired
    private StudentDAO studentDAO;

    public StudentBOImpl() {
    }

    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        studentDAO.save(mapper.getStudent(dto));
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        studentDAO.save(mapper.getStudent(dto));
    }

    @Override
    public void deleteStudent(Integer studentId) throws Exception {
        studentDAO.deleteById(studentId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDTO> findAllStudents() throws Exception {
        List<StudentDTO> studentDTOS = mapper.getStudentDTOs(studentDAO.findAll());
        return studentDTOS;
    }

    @Override
    public StudentDTO findStudent(Integer studentId) throws Exception {
        StudentDTO studentDTO = mapper.getStudentDTO(studentDAO.findById(studentId).get());
        return studentDTO;
    }
}
