
/**
 * @author Name: Wen Feng Li
 * 
 * This class represents a PlannerManager that is used to combine all the other 
 * classes together to execute operations relating to Courses in a Planner
 */
import java.util.Scanner;

public class PlannerManager {

	/**
	 * The main method runs a menu driven application which first creates an
	 * empty Planner object. The program prompts the user for a command to
	 * execute an operation. Once a command has been chosen, the program may
	 * ask the user for additional information if necessary, and performs the
	 * operation
	 * 
	 * @param args
	 *        args is the array of characters passed into the main method
	 */
	public static void main(String[] args) {
		Planner plan = new Planner();
		Planner backup = new Planner();

		while (true) {
			Scanner scan = new Scanner(System.in);
			menu();
			String selection = scan.nextLine();
			System.out.println();
			if (selection.equalsIgnoreCase("A")) {
				System.out.println("Enter Course Name: ");
				String name = scan.nextLine();
				System.out.println("Enter department: ");
				String department = scan.nextLine();
				System.out.println("Enter Course Code: ");
				int code = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Course Section: ");
				byte section = scan.nextByte();
				scan.nextLine();
				System.out.println("Enter Instructor: ");
				String instructor = scan.nextLine();
				System.out.println("Enter Position: ");
				int position = scan.nextInt();
				try {
					plan.addCourse(new Course(name, department, instructor,
							code, section), position);
					System.out.println("\n" + plan.getCourseNames(position)
							+ " successfully added to planner.");
				} catch (IllegalArgumentException e) {
					System.out.println("\nPosition Not Valid!");
				} catch (FullPlannerException e) {
					System.out.println(
							"\nThere is no more room in the Planner!");
				}
			}
			if (selection.equalsIgnoreCase("G")) {
				System.out.println("Enter Position: ");
				int position = scan.nextInt();
				try {
					plan.getCourse(position);
					Planner.header();
					plan.printCourse(plan.getCourse(position), position);
				} catch (IllegalArgumentException e) {
					System.out.println("\nPosition Not Valid!");
				}
			}
			if (selection.equalsIgnoreCase("R")) {
				System.out.println("Enter Position: ");
				int position = scan.nextInt();
				try {
					System.out.println("\n" + plan.getCourseNames(position)
							+ " has been successfully removed from planner.\n");
					plan.removeCourse(position);
				} catch (IllegalArgumentException e) {
					System.out.println("Position Not Valid!");
				}
			}
			if (selection.equalsIgnoreCase("P")) {
				plan.printAllCourses();
			}
			if (selection.equalsIgnoreCase("F")) {
				System.out.println("Enter department code: ");
				selection = scan.nextLine();
				Planner.filter(plan, selection);
			}
			if (selection.equalsIgnoreCase("L")) {
				System.out.println("Enter Course Name: ");
				String name = scan.nextLine();
				System.out.println("Enter department: ");
				String department = scan.nextLine();
				System.out.println("Enter Course Code: ");
				int code = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Course Section: ");
				byte section = scan.nextByte();
				scan.nextLine();
				System.out.println("Enter Instructor: ");
				String instructor = scan.nextLine();
				Course checkCourse = new Course(name, department, instructor,
						code, section);
				if (plan.exists(checkCourse))
					System.out.println("\n"
							+ plan.getCourseNames(
									plan.getCoursePosition(checkCourse))
							+ " is found in the planner at position "
							+ plan.getCoursePosition(checkCourse));
				else
					System.out.println("\nCourse does not exist!");

			}
			if (selection.equalsIgnoreCase("S")) {
				System.out.println("There are " + plan.size()
						+ " course(s) in the planner.");
			}
			if (selection.equalsIgnoreCase("B")) {
				backup = (Planner) plan.clone();
				System.out
						.println("Created a backup of the current planner.\n");
			}
			if (selection.equalsIgnoreCase("PB")) {
				System.out.println("Planner (Backup):");
				backup.printAllCourses();
			}
			if (selection.equalsIgnoreCase("RB")) {
				plan = (Planner) backup.clone();
				System.out.println("Planner successfully reverted to the "
						+ "backup copy\n");
			}
			if (selection.equalsIgnoreCase("Q")) {
				scan.close();
				System.out.println("Program terminating successfully...");
				break;
			}
		}
		System.out.println();

	}

	/**
	 * The menu method is used to show the menu options letters in which the
	 * user can input
	 */
	public static void menu() {
		System.out.println("(A) Add Course\n(G) Get Course\n"
				+ "(R) Remove Course\n" + "(P) Print Courses in Planner\n"
				+ "(F) Filter by Department Code\n"
				+ "(L) Look For Course\n(S) Size\n(B) Backup\n"
				+ "(PB) Print Courses in Backup\n(RB) " + "Revert to Backup\n"
				+ "(Q) Quit\n\nEnter a Selection: ");
	}
}
