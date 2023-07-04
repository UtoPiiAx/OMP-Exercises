package Aufgabe3;

import java.util.ArrayList;
public class Group <T extends Older <T>> {
    private ArrayList<T> listmember = new ArrayList<>();

    public Group() {
        listmember = new ArrayList<>();
    }

    public void add(T member) {
        listmember.add(member);
    }

    public T getOldest () {
        if (listmember.isEmpty()){
            return null;
        }
        T oldest = listmember.get(0);
        for (int i = 1; i < listmember.size(); i++) {
            if (listmember.get(i).isOlder(oldest)){
                oldest = listmember.get(i);
            }
        }
        return oldest;
    }
}
