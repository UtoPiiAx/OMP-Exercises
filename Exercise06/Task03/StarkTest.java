import Aufgabe3.DuplicateIdException;
import Aufgabe3.InvalidIdException;
import Aufgabe3.UnknownIdException;
import Aufgabe3.EmployeeComparator;
import Aufgabe3.ProjectComparator;
import Aufgabe3.StarkEnterprises;

public class StarkTest {

	public static void main(String[] args) {
		Company stark = new StarkEnterprises();
		try {
			stark.addEmployee(0, "Tony");
			stark.addEmployee(1, "Pepper");
			stark.addEmployee(2, "Jarvis");
			stark.addProject(0, "Suit");
			stark.addProject(1, "Jarvis");
			stark.addProject(2, "Jarvis");
			stark.addProject(3, "Finances");
			stark.assignEmployeeToProject(0, 0);
			stark.assignEmployeeToProject(0, 1);
			stark.assignEmployeeToProject(1, 3);
			stark.assignEmployeeToProject(2, 0);
			stark.assignEmployeeToProject(2, 2);
			System.out.println(stark);
		} catch (InvalidIdException e) {
			System.out.println("Invalid ID: " + e.getId());
		}
	}
  
}
