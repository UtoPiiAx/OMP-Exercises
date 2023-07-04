package Aufgabe2;

public class Car implements CarComponent{
    protected String name;
    protected CarComponent[] components = new CarComponent[0];

    public Car () { }
    public Car (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarComponent[] getComponents() {
        return components;
    }

    public void setComponents(CarComponent[] components) {
        this.components = components;
    }
}
