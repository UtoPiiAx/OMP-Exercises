package Aufgabe1;

import java.util.Iterator;
// a) Regenwetter als Menge M = {r, e, g, n, w, t}
// als Multimenge: {(r,2), (e,4), (n, 1), (w,1), (t,2)}

// b)
public interface MultiSet <T> extends Iterable <T> {
    void add (T element);
    int count (T element);
}
