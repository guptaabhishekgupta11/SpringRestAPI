package org.spring.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

import org.spring.rest.dao.CourseDao;
import org.spring.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImple implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public CourseServiceImple() {

	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		Optional<Course> optionalCourse = courseDao.findById(courseId);
		return optionalCourse.orElse(null); // Return null if course is not found
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// Check if course exists before updating
		if (courseDao.existsById(course.getId())) {
			return courseDao.save(course);
		} else {
			return null; // Course with the given ID not found
		}
	} 

	@Override
	public void deleteCourse(long parseLong) {
		
		courseDao.deleteById(parseLong);

	}

//	private List<Course> list;
//
//	public CourseServiceImple() {
//		list = new ArrayList<>();
//		list.add(new Course(1, "java", "This is java course"));
//		list.add(new Course(2, "React js", "This is React js course"));
//		list.add(new Course(3, "C++", "This is C++ course"));
//		list.add(new Course(5, "java", "This is java course"));
//
//	}
//
//	@Override
//	public List<Course> getCourses() {
//		return list;
//	}
//
//	@Override
//	public Course getCourse(long courseId) {
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c; // Return the found Course object instead of null
//	}
//
//	@Override
//	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
//	}
//
//	@Override
//	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
//	}
//
//	@Override
//	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
//	}

}
