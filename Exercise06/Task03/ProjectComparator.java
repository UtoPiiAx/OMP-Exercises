package Aufgabe3;

import java.util.Comparator;
public class ProjectComparator implements Comparator <Integer> {
    private Company company;

    public ProjectComparator(Company company) {
        this.company = company;
    }

    @Override
    public int compare(Integer id1, Integer id2) {
        String n1 = company.getProjectName(id1);
        String n2 = company.getProjectName(id2);
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
