package com.cg.tms.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.tms.entity.Course;

import com.cg.tms.exception.ProgramException;

@Repository
@Transactional
public class CourseDaoImpl implements CrudService<Course> {

	@PersistenceContext
	private EntityManager entityManager;

//This method will add the course
	public boolean create(Course course) {

		entityManager.persist(course);

		return true;
	}

	// this will get the course details by giving id
	public Course retrieve(int courseId) throws ProgramException {
		Course course = entityManager.find(Course.class, courseId);
		if (course == null) {
			throw new ProgramException("CourseId is not present");
		}
		return course;
	}

	// this will delete the course from database by giving id
	public boolean delete(Course course) throws ProgramException {

		Course courses = entityManager.find(Course.class, course.getCourseId());
		if (courses == null) {
			throw new ProgramException("Given course id is not present");
		}
		entityManager.remove(courses);
		return true;

	}

	// this method will retrieve all the data present in the database
	public Set<Course> retrieveAll() {

		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> results = query.getResultList();
		Set<Course> hSet = new HashSet<Course>();
		hSet.addAll(results);
		return (Set<Course>) hSet;
	}

	public boolean update(Course course) throws ProgramException {
		
		Course courseTemp = entityManager.find(Course.class, course.getCourseId());
		
		if(courseTemp!=null) {
			course.setCourseCharges(course.getCourseCharges());
			
		}
		else {
			throw new ProgramException("Given course id is not present");
		}
		
		return true;
	}

}