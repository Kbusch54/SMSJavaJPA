/**
 * 
 */
package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

/**
 * @author kevinbusch Filename: 
 * CourseService.java 
 * 02/26/2020
 *
 */
public class CourseService implements CourseDAO {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS_Kevin");
	protected static EntityManager em = emf.createEntityManager();

	public static void close() {
		em.close();
		emf.close();
	}

	public List<Course> getAllCourses() {
		Query query = em.createNamedQuery("Find all Courses");
		@SuppressWarnings("unchecked")
		List<Course> course = query.getResultList();
		if (!course.isEmpty()) {

			return course;
		} else {
			System.out.println("Sorry there are no courses");
			return null;
		}
	}

	public Course GetCourseById(int number) {
		Query query = em.createNamedQuery("Find Course by id");
		query.setParameter("id", number);
		@SuppressWarnings("unchecked")
		List<Course> course = query.getResultList();
		if (!course.isEmpty()) {
			for (Course cr : course) {
				return cr;
			}
		} else {
			System.out.println("Sorry there are no courses by that id");
			return null;
		}
		return null;
	}

}
