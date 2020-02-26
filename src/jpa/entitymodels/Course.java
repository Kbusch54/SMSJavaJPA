/**
 * 
 */
package jpa.entitymodels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author kevinbusch Filename: Course.java 02/26/2020
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
@NamedQueries(value = { @NamedQuery(query = "SELECT c FROM Course c", name = "Find all Courses"),
		@NamedQuery(query = "SELECT c FROM Course c where c.id = :id", name = "Find Course by id") })
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "Instructor")
	private String instructorName;

	/**
	 * 
	 */
	public Course() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param instrucotr
	 */
	public Course(int id, String name, String instrucotr) {
		super();
		this.id = id;
		this.name = name;
		this.instructorName = instrucotr;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the instrucotr
	 */
	public String getInstrucotr() {
		return instructorName;
	}

	/**
	 * @param instrucotr the instrucotr to set
	 */
	public void setInstrucotr(String instrucotr) {
		this.instructorName = instrucotr;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((instructorName == null) ? 0 : instructorName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		if (instructorName == null) {
			if (other.instructorName != null)
				return false;
		} else if (!instructorName.equals(other.instructorName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instrucotr=" + instructorName + "]";
	}

}
