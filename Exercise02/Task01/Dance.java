package Aufgabe2;

public class Dance {
    private String name;
    private String beat;
    private Figure[] figures = new Figure[0];

    public Dance (String name, String beat) {
        this.name = name;
        this.beat = beat;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getBeat () {
        return beat;
    }
    public void setBeat (String s) {
        this.beat = beat;
    }

}
