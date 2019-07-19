package com.cg.tms.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.tms.dao.CourseDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.entity.Course;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CrudService<Course> crudOperation;

	// This method will add the course
	public boolean addCourse(Course course) throws ProgramException {

		boolean flag = crudOperation.create(course);
		return flag;
	}

	// this will delete the course from database by giving id
	public boolean deleteCourse(Course course) throws ProgramException {
		
		boolean flag = crudOperation.delete(course);
		return flag;
	}

	// this method will retrieve all the data present in the database
	public Set<Course> getAllCourse() throws ProgramException {
		return crudOperation.retrieveAll();
	}

	// this will get the course details by giving id
	public Course getCourseDetails(final int courseId) throws ProgramException {
		Course course = crudOperation.retrieve(courseId);

		return course;
	}

	public boolean modifyCourse(Course course) throws ProgramException {
		boolean flag= crudOperation.update(course);
		return flag;
	}

}