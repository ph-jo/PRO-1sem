package counterPackage;

public class AnvendCounter {

    public static void main(String[] args) {
        Counter counter = Counter.getInstance();

        System.out.println(counter.getValue());
        counter.count();
        counter.times2();
        counter.count();
        counter.times2();
        System.out.println(counter.getValue());

        Counter counter2 = Counter.getInstance();

        System.out.println(counter.getValue());

        System.out.println(counter2.getValue());
    }
}
