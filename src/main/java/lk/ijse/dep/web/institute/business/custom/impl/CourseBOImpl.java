package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.CourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.CourseDAO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Component
public class CourseBOImpl implements CourseBO {

    @Autowired
    private CourseDAO courseDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CourseBOImpl() {

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        courseDAO.setEntityManager(em);
    }

    @Override
    public void saveCourse(CourseDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.save(mapper.getCourse(dto));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCourse(CourseDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.update(mapper.getCourse(dto));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCourse(String courseId) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.delete(courseId);
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        try {
            em.getTransaction().begin();
            mapper.getCourseDTOs(courseDAO.getAll());
            List<CourseDTO> courseDTOS = mapper.getCourseDTOs(courseDAO.getAll());
            em.getTransaction().commit();
            return courseDTOS;
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}
