public class Amalgamation extends Figure {
    private Figure[] figures = new Figure[0];


    public Amalgamation(String name) {
        super(name);
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public boolean add(Figure figure) {
        if (figure.equals(this) || (figure instanceof Amalgamation && ((Amalgamation) figure).contains(this))) {
            return false;
        }
        Figure[] tmp = new Figure[figures.length + 1];
        for(int i = 0; i<figures.length;i++){
            tmp[i] = figures[i];
        }
        tmp[figures.length]=figure;
        figures =tmp;
        return true;
    }

    private boolean contains(Figure ref) {
        for (Figure fig: figures) {
            if (fig.equals(ref)) {
                return true;
            }
            if (fig instanceof Amalgamation) {
                Amalgamation amal = (Amalgamation) fig;
                if (amal.contains(ref)) {
                    return true;
                }
            }
        }
        return false;
    }
}
