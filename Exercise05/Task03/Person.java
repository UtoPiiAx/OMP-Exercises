package Aufgabe3;

public class Person implements Older <Person> {
    private String name;
    private int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public boolean isOlder (Person other) {
        return age > other.age;
    }

}
