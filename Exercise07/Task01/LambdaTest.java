package Aufgabe1;

public class LambdaTest {
    public static void main (String[] args) {
        //b
        Function<Double, Double> id = (x) -> x;
        Function<Double, Double> inverse = (x) -> x * -1.0;
        Function<Double, Double> timesTen = (x) -> x * 10.0;
        Function<Double, Double> dividedByPi = (x) -> x / Math.PI;
        //c
        Function<Double, Long> round = Math::round;

        //e
        @SuppressWarnings("unchecked")
        Function<Double, Double> chain = makeChain(new Function[] {inverse, id, timesTen, dividedByPi});
        double roundedResult = round.calculate(chain.calculate(5.5));
        System.out.println(roundedResult);
    }

        //d Dran denken Hilfsmethoden immer private!!!!
        private static Function <Double, Double> makeChain(final Function <Double, Double> [] functions) {
            return x -> {
                for (Function<Double, Double> f : functions) {
                    x = f.calculate(x);
                }
                return x;
            };
        }
}
