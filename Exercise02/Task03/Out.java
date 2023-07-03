public class Out {
    public static void out (boolean a) {
        System.out.println(a);
    }

    public static void out (int b) {
        System.out.println(b);
    }

    public static void out (double c) {
        System.out.println(c);
    }

    public static void out (char d) {
        System.out.println(d);
    }

    public static void out (String e) {
        System.out.println(e);
    }

    public static void out (Object object) {
        System.out.println(object);
    }

    public static void main (String[] args) {
        out(true);
        out(5);
        out(5.3);
        out('a');
        out("OUT");
        out(new Object());
    }
}
