/**
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 * 
 *         This class represents a FullPlannerException that indicates that
 *         there is no more room in the Planner to record an additional course
 * 
 */

public class FullPlannerException extends Exception {

	/**
	 * This constructor is used to create a new FullPlannerException exception
	 * 
	 * @param message
	 *        The message is returned when the exception is thrown
	 */
	public FullPlannerException(String message) {
		super(message);
	}
}
