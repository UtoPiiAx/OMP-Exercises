package Aufgabe3;

import java.util.Collection;
import Aufgabe3.DuplicateIdException;
import Aufgabe3.InvalidIdException;
import Aufgabe3.UnknownIdException;
import Aufgabe3.EmployeeComparator;
import Aufgabe3.ProjectComparator;
import Aufgabe3.StarkEnterprises;
public interface Company {

	/**
	 * Adds a new employee to the company.
	 * @param id The id that uniquely identifies the employee
	 * @param name The name of the employee
	 * @throws DuplicateIdException If the given id is already in use
	 */
	void addEmployee(int id, String name) throws DuplicateIdException;
	
	/**
	 * Returns the name of an employee identified by the given id,
	 * or null if the id is not known
	 * @param id The id of the employee
	 * @return The name of the employee or null if the id is unknown
	 */
	String getEmployeeName(int id);
	
	/**
	 * Adds a new project to the company.
	 * @param id The id that uniquely identifies the project
	 * @param name The name of the project
	 * @throws DuplicateIdException If the given id is already in use
	 */
	void addProject(int id, String name) throws DuplicateIdException;
	
	/**
	 * Returns the name of a project identified by the given id,
	 * or null if the id is not known
	 * @param id The id of the project
	 * @return The name of the project or null if the id is unknown
	 */
	String getProjectName(int id);
	
	/**
	 * Assigns an employee to a project. An employee can be assigned to multiple projects,
	 * but not to a single project twice (ignore duplicate assignments).
	 * @param employeeId The id of the employee
	 * @param projectId The id of the project
	 * @throws UnknownIdException If either the employee or the project id is unknown
	 */
	void assignEmployeeToProject(int employeeId, int projectId) throws UnknownIdException;
	
	/**
	 * Removes an assigned employee from a project. Does nothing if the employee was
	 * not assigned to the given project in the first place.
	 * @param employeeId The id of the employee
	 * @param projectId The id of the project
	 * @throws UnknownIdException If either the employee or the project id is unknown
	 */
	void removeEmployeeFromProject(int employeeId, int projectId) throws UnknownIdException;
	
	/**
	 * Returns an ordered collection of employee ids, sorted by the name of the employees
	 * @return A list of employee ids, sorted by name
	 */
	Collection<Integer> getEmployees();
	
	/**
	 * Returns an ordered collection of project ids that a given employee is assigned to,
	 * sorted by the name of the projects
	 * @param employeeId The id of the employee
	 * @return A list of project ids for the given employee, sorted by name
	 * @throws UnknownIdException If the employee id is unknown
	 */
	Collection<Integer> getProjectsForEmployee(int employeeId) throws UnknownIdException;

}
