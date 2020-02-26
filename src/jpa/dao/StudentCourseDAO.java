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
public interface StudentCourseDAO {
	
	
	List<Course> getAllStudentCourses(String email);

}
