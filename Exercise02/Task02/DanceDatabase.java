package Aufgabe2;

public class DanceDatabase {
    public static void main (String [] args) {
        Dance[] dances = new Dance[6];
        dances[0] = new StandardDance("Waltz", "3/4");
        dances[1] = new StandardDance("Tango", "4/4");
        dances[2] = new StandardDance("Quickstep", "4/4");
        dances[3] = new LatinDance("ChaChaCha", "4/4");
        dances[4] = new LatinDance("Rumba", "4/4");
        dances[5] = new LatinDance("Jive", "4/4");

        Description basicMovement = new Description("Basic Movement", "");
        Description naturalTurn = new Description("Natural Turn", "");
        Description spinTurn = new Description("Spin Turn", "");
        Description promenade = new Description("Promenade", "");
        Description chasse = new Description("Chassé", "");
        Description fan = new Description("Fan", "");

        Amalgamation whisk = new Amalgamation("Whisk");

        whisk.setFigures(new Figure [] {promenade, chasse});


        dances[0].setFigures(new Figure[] {naturalTurn, spinTurn, whisk});
        dances[1].setFigures(new Figure[] {basicMovement, promenade});
        dances[2].setFigures(new Figure[] {basicMovement, spinTurn});
        dances[3].setFigures(new Figure[] {basicMovement, fan});
        dances[4].setFigures(new Figure[] {basicMovement, fan});
        dances[5].setFigures(new Figure[] {basicMovement});
    }
}
