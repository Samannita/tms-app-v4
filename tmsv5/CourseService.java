package com.cg.tms.service;

import java.util.*;

import com.cg.tms.entity.Course;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface CourseService {

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean addCourse(Course course) throws ProgramException;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean deleteCourse(Course course) throws ProgramException;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean modifyCourse(Course course) throws ProgramException;

	/**
	 * @throws DatabaseWriteException
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public Set<Course> getAllCourse() throws ProgramException;

	/**
	 * @throws DatabaseWriteException
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * 
	 */
	public Course getCourseDetails(int courseId) throws ProgramException;

}