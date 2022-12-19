/**
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 * 
 *         This class represents a Planner which has a MAX_COURSES maximum
 *         size, planner list that stores Courses, and the actual size of the
 *         planner list
 */
public class Planner {
	final int MAX_COURSES = 50;
	private Course planner[];
	private int size;

	/**
	 * This is a constructor used to create a new Planner object
	 * 
	 * @custom.Postconditions This Planner has been initialized to an empty
	 *                        list of Courses
	 */
	public Planner() {
		planner = new Course[MAX_COURSES + 1];
		size = 0;
	}

	/**
	 * @custom.Preconditions This Planner has been initialized.
	 * @return the size of this planner
	 */
	public int size() {
		return size;
	}

	/**
	 * @param newCourse
	 *        the new course to add to the list
	 * @param position
	 *        the position(preference) of this course on the list
	 * @custom.Preconditions this Course object has been instantiated and 1<=
	 *                       position <= items_currently_in_list + 1. The
	 *                       number of Course objects in this Planner is less
	 *                       than MAX_COURSES.
	 * @custom.Postconditions the new course is now listed in the correct
	 *                        preference on the list. All Courses that were
	 *                        originally greater than or equal to position are
	 *                        moved back one position
	 * @throws IllegalArgumentException
	 *         thrown when the position is < 1 or > size + 1
	 * @throws FullPlannerException
	 *         thrown when size > MAX_COURSES + 1
	 */
	public void addCourse(Course newCourse, int position)
			throws IllegalArgumentException, FullPlannerException {
		if (position < 1 || position > size + 1)
			throw new IllegalArgumentException("Position not Valid!");
		if (size > MAX_COURSES + 1)
			throw new FullPlannerException("No more room in the Planner!");
		/**
		 * shifts position of courses that are after the position to the right
		 * by 1
		 */
		for (int pos = size + 1; pos > position; pos--) {
			planner[pos] = planner[pos - 1];
		}
		planner[position] = newCourse;
		size++;
	}

	/**
	 * @param newCourse
	 *        the new course to add to the end of the list
	 * @throws IllegalArgumentException
	 * @throws FullPlannerException
	 * 
	 */

	public void addCourse(Course newCourse)
			throws IllegalArgumentException, FullPlannerException {
		this.addCourse(newCourse, this.size() + 1);
	}

	/**
	 * @param position
	 *        the position in the Planner where the Course will be removed from
	 * @custom.Preconditions this planner has been instantiated and
	 *                       1<=position<= items_current_in_list
	 * @custom.Postconditions the course at the desired position has been
	 *                        removed. All Courses that were originally greater
	 *                        than or equal to position are moved backward one
	 *                        position
	 * 
	 * @throws IllegalArgumentException
	 *         thrown when position < 1 or position > size
	 */

	public void removeCourse(int position) throws IllegalArgumentException {
		if (position < 1 || position > size)
			throw new IllegalArgumentException("Positon not Valid!");
		/**
		 * shifts the courses after position in the planner to the left by 1
		 */
		for (int pos = position; pos < size; pos++) {
			planner[pos] = planner[pos + 1];
		}
		/**
		 * makes the last position with a course in planner empty
		 */
		planner[size] = null;
		size--;
	}

	/**
	 * @param position
	 *        position of the Course to retrieve
	 * @custom.Preconditions the Planner object has been instantiated and
	 *                       1<=position<= items_currently_in_list
	 * @return the Course at the specified position in this Planner object
	 * @throws IllegalArgumentException
	 *         thrown when position < 1 or position > size
	 */
	public Course getCourse(int position) throws IllegalArgumentException {
		if (position < 1 || position > size)
			throw new IllegalArgumentException("Position not Valid!");
		return planner[position];
	}

	/**
	 * Looks for the position of the course
	 * 
	 * @param course
	 *        the course's position to retrieve
	 * @return the position of the course
	 */
	public int getCoursePosition(Course course) {
		for (int pos = 1; pos <= size; pos++) {
			if ((planner[pos].getName().equals(course.getName())
					&& planner[pos].getDepartment()
							.equals(course.getDepartment())
					&& planner[pos].getInstructor()
							.equals(course.getInstructor())
					&& planner[pos].getCode() == course.getCode()
					&& planner[pos].getSection() == course.getSection()))
				return pos;
		}
		return -1;
	}

	/**
	 * gets the department, code, and section of the Course in the position of
	 * the Planner in form of string
	 * 
	 * @param position
	 *        position of the Course to retrieve
	 * @return string of department, code, and section of the Course in
	 *         position
	 */
	public String getCourseNames(int position) {
		return (planner[position].getDepartment() + " "
				+ planner[position].getCode() + "." + "0"
				+ planner[position].getSection());
	}

	/**
	 * prints all Courses that are within the specified department
	 * 
	 * @param planner
	 *        the list of courses to search in
	 * @param department
	 *        the 3 letter department code for a Course
	 * @custom.Preconditions this Planner object has been instantiated
	 * @custom.Postconditions displays a neat formatted table of each course
	 *                        filtered from the Planner. The preference numbers
	 *                        are the same
	 */
	public static void filter(Planner planner, String department) {
		header();
		for (int pos = 1; pos <= planner.size; pos++)
			/**
			 * if the course's department is equal to the desired department,
			 * then the course will be printed out
			 */
			if (planner.planner[pos].getDepartment().equals(department)) {
				System.out
						.println(String.format("%-7d%-25s%-12s%-5d%-11s%-25s",
								pos, planner.planner[pos].getName(),
								planner.planner[pos].getDepartment(),
								planner.planner[pos].getCode(),
								"0" + planner.planner[pos].getSection(),
								planner.planner[pos].getInstructor()));
			}
	}

	/**
	 * Checks whether a certain Course is already in the list
	 * 
	 * @param course
	 *        the Course we are looking for
	 * @custom.Precondtions this Planner and Course has both been instantiated
	 * @return true if the Planner contains this Course, false otherwise
	 */
	public boolean exists(Course course) {
		for (int pos = 1; pos <= size; pos++) {
			if (planner[pos].getName().equals(course.getName())
					&& planner[pos].getDepartment()
							.equals(course.getDepartment())
					&& planner[pos].getInstructor()
							.equals(course.getInstructor())
					&& planner[pos].getCode() == course.getCode()
					&& planner[pos].getSection() == course.getSection())
				return true;
		}
		return false;
	}

	public static void header() {
		/**
		 * format the course information labels into a row.
		 */
		System.out.println(String.format("%-7s%-25s%-12s%-7s%-11s%-25s", "No.",
				"Course Name", "Department", "Code", "Section", "Instructor"));
		System.out.println(
				"--------------------------------------------------------------"
						+ "------------------------");
	}

	/**
	 * @param position
	 *        position that the course that will be printed from that position
	 * @custom.Postconditions: displays a neatly formatted row of the course
	 *                         from the position
	 */
	public void printCourse(Course course, int position) {
		System.out.println(String.format("%-7d%-25s%-12s%-7d%-11s%-25s",
				position, course.getName(), course.getDepartment(),
				course.getCode(), "0" + course.getSection(),
				course.getInstructor()));
	}

	/**
	 * Creates a copy of this Planner. Subsequent changes to the copy will not
	 * affect the original and vice versa.
	 * 
	 * @custom.Preconditions: This Planner object has been instantiated.
	 * @return: a copy(backup) of this Planner object
	 * 
	 *          Unit 1 Slides has helped me create this clone method
	 */
	public Object clone() {
		Planner newPlanner = new Planner();
		for (int pos = 1; pos <= size; pos++) {
			newPlanner.planner[pos] = planner[pos];
		}
		newPlanner.size = size;
		return newPlanner;
	}

	/**
	 * @custom.Preconditions: this Planner has been instantiated.
	 * @custom.Postconditions: displays a neatly formatted table of each course
	 *                         from the Planner.
	 */
	public void printAllCourses() {
		header();
		System.out.println(this.toString());
	}

	/**
	 * @return the string representation of this Planner object
	 */
	public String toString() {
		String str = "";
		/**
		 * format the course information into a table. "-" defines left
		 * justification, "s" for strings, "d" for integers
		 */
		for (int position = 1; position <= size; position++) {
			str += ((String.format("%-7d%-25s%-12s%-7d%-11s%-25s", position,
					planner[position].getName(),
					planner[position].getDepartment(),
					planner[position].getCode(),
					"0" + planner[position].getSection(),
					planner[position].getInstructor())) + "\n");
		}
		return str;
	}

	/**
	 * @param obj
	 *        the obj that the current Planner is comparing to
	 * @return true indicates that obj refers to a Planner object with the same
	 *         attributes as this Planner. Otherwise, the return value is
	 *         false.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Planner) {
			Planner comparePlanner = (Planner) obj;
			if (this.size != comparePlanner.size)
				return false;
			for (int pos = 0; pos < size; pos++) {
				if (!this.planner[pos].equals(comparePlanner.planner[pos]))
					return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * @return The course list planner of this Planner
	 */
	public Course[] getPlanner() {
		return planner;
	}

	/**
	 * @param planner
	 *        Changes the planner list of the Planner object
	 */
	public void setPlanner(Course[] planner) {
		this.planner = planner;
	}

	/**
	 * @param size
	 *        Changes the size of the Planner object
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
