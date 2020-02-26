/**
 * 
 */
package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.StudentCourseDAO;
import jpa.entitymodels.Course;

/**
 * @author kevinbusch 
 * Filename: StudentCourseService.java 
 * 02/26/2020
 */
public class StudentCourseService implements StudentCourseDAO {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS_Kevin");
	protected static EntityManager em = emf.createEntityManager();

	public static void close() {
		em.close();
		emf.close();
	}

	public List<Course> getAllStudentCourses(String email) {
		Query query = em.createNamedQuery("CoursesByStudent");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Course> course = query.getResultList();
		if (!course.isEmpty()) {

			return course;
		} else {
			System.out.println("Sorry there is no courses by that email");
			return null;
		}
	}

}
