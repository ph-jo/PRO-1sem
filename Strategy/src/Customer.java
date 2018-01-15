import java.util.Collections;
import java.util.Comparator;

public class Customer implements Comparable<Customer> {

    private String name;
    private int number;
    private Comparator<Customer> comparator;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    sort() {
        Collections.sort()
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return comparator.compare(this, o);
    }
}
