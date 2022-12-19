/**
 * @author Name: Wen Feng Li 
 * 
 *         This class represents a Course which has a name, department,
 *         instructor, code, and section
 * 
 */
public class Course {
	private String name;
	private String department;
	private String instructor;
	private int code;
	private byte section;

	/**
	 * This is a constructor that is used to create a new Course object
	 * 
	 * @param name
	 *        The name of the Course
	 * @param department
	 *        The department of the Course
	 * @param instructor
	 *        The instructor of the Course
	 * @param code
	 *        The code number for the Course
	 * @param section
	 *        The section number for the Course
	 */
	public Course(String name, String department, String instructor, int code,
			byte section) {
		this.name = name;
		this.department = department;
		this.instructor = instructor;
		this.code = code;
		this.section = section;
	}

	/**
	 * @return The name of the Course
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *        Changes the name of the Course
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The department of the Course
	 */
	public String getDepartment() {
		return this.department;
	}

	/**
	 * @param department
	 *        Changes the department of the Course
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return The instructor of the Course
	 */
	public String getInstructor() {
		return this.instructor;
	}

	/**
	 * @param instructor
	 *        Changes the instructor of the Course
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return The code of the Course
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * @param code
	 *        Changes the code of the Course
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return The section of the Course
	 */
	public byte getSection() {
		return this.section;
	}

	/**
	 * @param section
	 *        Changes the section of the Course
	 */
	public void setSection(byte section) {
		this.section = section;
	}

	/**
	 * @param obj
	 *        the obj that the current course is comparing to
	 * @return true indicates that obj refers to a Course object with the same
	 *         attributes as this Course. Otherwise, the return value is false.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course compareCourse = (Course) obj;
			return (this.name == compareCourse.getName()
					&& this.department == compareCourse.getDepartment()
					&& this.instructor == compareCourse.getInstructor()
					&& this.code == compareCourse.getCode()
					&& this.section == compareCourse.getSection());
		}
		return false;
	}

	/**
	 * @return a copy of this course
	 */
	public Object clone() {
		Course newCourse = new Course(this.name, this.department,
				this.instructor, this.code, this.section);
		return newCourse;
	}

}
