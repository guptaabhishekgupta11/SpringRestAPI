package org.spring.rest.dao;

import org.spring.rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long>{

}
