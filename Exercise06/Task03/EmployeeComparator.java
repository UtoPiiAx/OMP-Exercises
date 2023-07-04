package Aufgabe3;
import java.util.Comparator;
import Aufgabe3.DuplicateIdException;
import Aufgabe3.InvalidIdException;
import Aufgabe3.UnknownIdException;
import Aufgabe3.EmployeeComparator;
import Aufgabe3.ProjectComparator;
import Aufgabe3.StarkEnterprises;
public class EmployeeComparator implements Comparator <Integer> {
    private Company company;
    
    public EmployeeComparator(Company company) {
        this.company = company;
    }

    @Override
    public int compare(Integer id1, Integer id2) {
        String n1 = company.getEmployeeName(id1);
        String n2 = company.getEmployeeName(id2);
        if (n1 == null) {
            if (n2 == null) {
                return 0;
            } else {
                return -1;
            }
        } else if(n2 == null) {
            return 1;
        }
        return n1.compareTo(n2);
    }
}
