/**
 * 
 */
package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourses;

/**
* @author kevinbusch
*  Filename: StudentService.java
* 02/26/2020 
 */
public class StudentService implements StudentDAO{
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS_Kevin");
	protected static EntityManager em = emf.createEntityManager();
	
	public static void close() {
		em.close();
		emf.close();
	}

	@Override
	public List<Student> getAllStudents() {
		Query query = em.createNamedQuery("Find all Students");
		@SuppressWarnings("unchecked")
		List<Student> student = query.getResultList();
		if (!student.isEmpty()) {
			
				return student;
		} else {
			System.out.println("Sorry there are no students");
			return null;
		}
	}

	@Override
	public List<Student> getStudentByEmail(String email) {
		Query query = em.createNamedQuery("Find Student by Email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Student> student = query.getResultList();
		if (!student.isEmpty()) {
			
				return student;
		} else {
			System.out.println("Sorry there is no student by that email");
			return null;
		}
	}

	@Override
	public Boolean validateStudent(String email, String password) {
		Query query = em.createQuery("Select s from Student s where s.email = :email AND s.password= :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<Student> student = query.getResultList();
		if (!student.isEmpty()) {
			return true;
		} else {
			return false;
		}
	
	}

	@Override
	public void registerStudentToCourse(String email, int id) {
		StudentCourses sc = new StudentCourses(email, id);
		em.getTransaction().begin();
		em.persist(sc);
		em.getTransaction().commit();
		System.out.println("Course succesfully added");
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Query query = em.createQuery("Select c from Course c "
				+ "left join StudentCourses sc on "
				+ "c.id = sc.courseID "
				+ "left join Student s on "
				+ "sc.eMail = s.email "
				+ "where s.email = :email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Course> courses = query.getResultList();
		if (!courses.isEmpty()) {
			return courses;
		} else {
			return null;
		}

	}
	
	

}
