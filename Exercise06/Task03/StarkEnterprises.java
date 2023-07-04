package Aufgabe3;

import java.util.*;

public class StarkEnterprises implements Company{
    private Map <Integer, String> projectNames = new HashMap<>();
    private Map <Integer, String> employeeNames = new HashMap<>();
    private Map <Integer, Set <Integer>> employeeProjects = new HashMap<>();

    @Override
    public void addEmployee(int id, String name) throws DuplicateIdException {
        if (employeeNames.containsKey(id)) {
            throw new DuplicateIdException(id);
        }
        employeeNames.put(id, name);
    }

    @Override
    public String getEmployeeName(int id) {
        if (employeeNames.get(id) != null) {
            return employeeNames.get(id);
        }
        return null;
    }

    @Override
    public void addProject(int id, String name) throws DuplicateIdException {
        if (projectNames.containsKey(id)) {
            throw new DuplicateIdException(id);
        }
        projectNames.put(id, name);
    }

    @Override
    public String getProjectName(int id) {
        return projectNames.get(id);
    }

    @Override
    public void assignEmployeeToProject(int employeeId, int projectId) throws UnknownIdException {
        if (!employeeNames.containsKey(employeeId)) {
            throw new UnknownIdException(employeeId);
        }
        if(!projectNames.containsKey(projectId)) {
            throw new UnknownIdException(employeeId);
        }
        if (!employeeProjects.containsKey(employeeId)) {
            employeeProjects.put(employeeId, new HashSet<>());
        }
        employeeProjects.get(employeeId).add(projectId);
    }

    @Override
    public void removeEmployeeFromProject (int employeeId, int projectId) throws UnknownIdException {
        if (!employeeNames.containsKey(employeeId)) {
            throw new UnknownIdException(employeeId);
        }
        if(!projectNames.containsKey(projectId)) {
            throw new UnknownIdException(employeeId);
        }
        if (employeeProjects.containsKey(employeeId)) {
            employeeProjects.get(employeeId).remove(projectId);
        }
    }

    @Override
    public Collection<Integer> getEmployees() {
        List<Integer> result = new ArrayList<>();
        result.addAll(employeeNames.keySet());
        result.sort(new EmployeeComparator(this));
        return result;
    }
    
    @Override
    public Collection<Integer> getProjectsForEmployee(int employeeId) throws UnknownIdException {
        if (!employeeNames.containsKey(employeeId)) {
            throw new UnknownIdException(employeeId);
        }
        List<Integer> result = new ArrayList<>();
        if (employeeProjects.containsKey(employeeId)) {
            result.addAll(employeeProjects.get(employeeId));
            result.sort(new ProjectComparator(this));
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        Collection<Integer> employees = getEmployees();
        for (int id : employees) {
            result += getEmployeeName(id) + "[" + id + "]: ";
            try {
                Collection<Integer> projects = getProjectsForEmployee(id);
                for (int pid : projects) {
                    result += getProjectName(pid) + "[" + pid + "] ";
                }
            } catch (UnknownIdException e) {
                throw new RuntimeException("Inconsistent database!");
            }
            result += "\n";
        }
        return result;
    }
}
