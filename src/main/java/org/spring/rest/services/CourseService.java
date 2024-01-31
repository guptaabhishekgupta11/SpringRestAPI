package org.spring.rest.services;

import java.util.List;

import org.spring.rest.entity.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long coursId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);

}
