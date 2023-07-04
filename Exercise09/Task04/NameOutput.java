package Aufgabe4;

public class NameOutput extends Thread {
    private static int NUMBER_OF_THREADS = 3;

    private static int number = 0; // Variable für Synchronisierung

    private static int next = 0; // Variable für Synchronisierung

    private static Object sync = new Object ();

    private int myNumber;

    public NameOutput() {this.myNumber = number++;}

    public void run () {
        while (true) {
            synchronized (sync) {
                // die aktuelle Zahl entspricht der nächsten Zahl
                if (this.myNumber == next) {
                    System.out.println(this.getName());
                    try {
                        sleep(500);
                    } catch (InterruptedException exc) {

                    }
                    // Berechne welcher Thread als nachstes an der Riehe ist (Modulo runde auf
                    next = (next + 1) % NUMBER_OF_THREADS;
                    System.out.println("Nächster Thread: " + next);
                    sync.notifyAll();
                    // der aktuelle Thread muss mit der Ausgabe der Zahl warten
                } else {
                    try {
                        sync.wait();
                    } catch (InterruptedException exc) { }
                }
            }
        }
    }

    public static void main (String[] args) {
        new NameOutput().start();
        new NameOutput().start();
        new NameOutput().start();
    }
}
