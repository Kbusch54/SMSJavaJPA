/**
 * 
 */
package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

/**
 * @author kevinbusch
 *
 */
public interface CourseDAO {
	List<Course> getAllCourses();
	Course GetCourseById(int number);
	

}	
