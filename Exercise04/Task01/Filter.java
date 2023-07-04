package Aufgabe1;

import Aufgabe1.Sequence;

//1c
public abstract class Filter implements Sequence {
    Sequence sequence;

    Filter(Sequence seq) {
        this.sequence = seq;
    }
}
