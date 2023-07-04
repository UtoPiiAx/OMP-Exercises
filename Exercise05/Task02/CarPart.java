package Aufgabe2;

public abstract class CarPart implements CarComponent {
    protected String name;
    protected CarComponent [] components = new CarComponent[0];

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

    public static class Motor extends CarPart {
        public Motor () {
            name = "Motor";
        }
    }
    public static class Wheel extends CarPart {
        public Wheel () {
            name = "Wheel";
        }
    }
    public static class Seat extends CarPart {
        public Seat () {
            name = "Seat";
        }
    }
}
