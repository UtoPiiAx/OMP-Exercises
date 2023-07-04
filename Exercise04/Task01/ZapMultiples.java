package Aufgabe1;

// 1d
public class ZapMultiples extends Filter {
    int basicNumber;
    int value;

    ZapMultiples(int basic, Sequence seq) {
        super(seq);
        this.basicNumber = basic;
        this.calcNextValue();
    }

    @Override
    public int getNext() {
        int result = this.value;
        this.calcNextValue();
        return result;
    }

    private void calcNextValue () {
        while (true) {
            this.value = this.sequence.getNext();
            if (this.value % this.basicNumber != 0) {
                break;
            }
        }
    }
}
