package com.cg.tms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entity.Course;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.service.CourseService;


@RestController
public class CoordinatorController {

	
	@Autowired
	private CourseService courseOperation;



	public void setCourseOperation(CourseService courseOperation) {
		this.courseOperation = courseOperation;
	}

	//this will add courses
	@PostMapping(value = "/addCourse", consumes = "application/json ", produces = "application/json")
	public Course course(@RequestBody Course course) throws ProgramException {

		
		course.setCourseName(course.getCourseName());
		course.setCourseDesc(course.getCourseDesc());
		course.setCourseCharges(course.getCourseCharges());
		courseOperation.addCourse(course);
		return course;
	}

	//this will delete the course from database by giving id
	@DeleteMapping(value = "/deleteCourse", consumes = "application/json ", headers = "accept=application/json")
	public String courses(@RequestBody Course course) throws ProgramException {
		
		boolean response = false;
		response = courseOperation.deleteCourse(course);
		if (response == true)
			return "Success";
		else
			return "Deletion UnSuccessful";
	}

	//this method will retrieve all the data present in the database 
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Course> getAllCourseDetails() throws ProgramException {
		
		Set<Course> course = courseOperation.getAllCourse();
		System.out.println("Get All Course ACCESSED");

		return course;

	}

	//this will get the course details by giving id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Course getCourseById(@PathVariable("id") Integer courseId) throws ProgramException {
		System.out.println(courseId);
		Course course = courseOperation.getCourseDetails(courseId);
		return course;
	}
	
	@PutMapping(value = "/updateCourse", consumes="application/json", produces = "application/json")
	public String updateCourse(@RequestBody Course course) throws ProgramException {
		boolean result=false;
		result = courseOperation.modifyCourse(course);
		if(result==true)
			return "Updated";
		else
		return "Cant update";
	}

}
