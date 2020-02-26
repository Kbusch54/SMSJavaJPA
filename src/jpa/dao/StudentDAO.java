/**
 * 
 */
package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

/**
 * @author kevinbusch
 *
 */
public interface StudentDAO{
	
	List<Student> getAllStudents();
	List<Student> getStudentByEmail(String email);
	Boolean validateStudent(String email, String password);
	void registerStudentToCourse(String email, int id);
	List<Course> getStudentCourses(String email);
	

}
