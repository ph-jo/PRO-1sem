package counterPackage;

public class Counter {

    private int value;
    private static Counter counter;

    private Counter() {
        this.value = 0;
    }

    public static Counter getInstance() {
        if (counter == null) {
            counter = new Counter();
        }
        return counter;
    }

    public void count() {
        value++;
    }

    public void times2() {
        value = value * 2;
    }

    public void zero() {
        value = 0;
    }

    public int getValue() {
        return this.value;
    }
}