package Aufgabe2;

public class VersatileLinkedList extends LinkedStringList{
    //a
    public void add (int value) {
        add(Integer.toString(value));
    }
    //b
    public void add (boolean value) {
        if (value) {
            add("yes");
        } else {
            add("no");
        }
    }
    //c
    public void add (LinkedStringList values) {
        for (int i = 0; i < values.size(); i++) {
            add(values.get(i));
        }
    }
    //d
    public void add (LinkedStringList values, int start, int end) {
        if (start >= 0 && end <= values.size()) {
            for (int i = start; i < end; i++) {
                add(values.get(i));
            }
        }
    }
    //e
    public VersatileLinkedList reverse () {
        VersatileLinkedList result = new VersatileLinkedList();
        for (int i = size() - 1; i >= 0; i--) {
            result.add(get(i));
        }
        return result;
    }
    //f
    public boolean equals (VersatileLinkedList other) {
        int size = size();
        if (size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }
    //g
    public static void main (String [] args) {
        VersatileLinkedList list = new VersatileLinkedList();
        list.add(1);
        list.add(true);
        list.add(false);
        list.add(list.reverse());

        boolean error = false;

        if (!list.get(3).equals("1")) {
            System.out.println("Error!");
            error = true;
        }

        if (!list.get(4).equals("no")) {
            System.out.println("Error!");
            error = true;
        }

        if (!list.get(5).equals("yes")) {
            System.out.println("Error!");
            error = true;
        }

        if (!list.reverse().reverse().equals(list)) {
            System.out.println("Error!");
            error = true;
        }

        if (!error) {
            System.out.println("All OK!");
        }
    }
}
