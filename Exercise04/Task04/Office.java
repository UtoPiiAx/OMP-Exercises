class Office extends Room{
    protected Desk[] desks;
    protected Chair[] chairs;
    private Furniture[] getDesks;

    public Desk[] getDesks() {
        return desks;
    }
    public void setDesks(Desk[] desks) {
        this.desks = desks;
    }
    public Chair[] getChairs() {
        return chairs;
    }
    public void setChairs(Chair[] chairs) {
        this.chairs = chairs;
    }

    public static void main (String[] args) {
        Office office = new Office ();
        office.setDesks(new Desk[] {new Desk()});
        office.setChairs(new Chair[] {new Chair ()});
        office.setFurniture(new Furniture[] { office.getChairs()[0], office.getDesks()[0], new Chair ()});
    }
}

class Room {
    protected Furniture[] furniture;

    public Furniture[] getFurniture() {
        return furniture;
    }
    public void setFurniture(Furniture[] furniture) {
        this.furniture = furniture;
    }
}
interface Furniture {
}
class Chair implements Furniture{
}
class Table implements Furniture{
}
class Desk extends Table{
}
