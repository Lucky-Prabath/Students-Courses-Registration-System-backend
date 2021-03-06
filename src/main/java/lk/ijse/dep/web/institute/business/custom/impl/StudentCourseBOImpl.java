package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.StudentCourseDAO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/

@Service
@Transactional
public class StudentCourseBOImpl implements StudentCourseBO {

    @Autowired
    private EntityDTOMapper mapper;
    @Autowired
    private StudentCourseDAO studentCourseDAO;

    public StudentCourseBOImpl() {
    }

    @Override
    public void register(StudentCourseDTO dto) throws Exception {
        studentCourseDAO.save(mapper.getStudentCourse(dto));
    }

    //todo:- check whole class
}
