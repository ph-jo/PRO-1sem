import java.util.Comparator;

/**
 * Created by Jonathan on 20-09-2017.
 */
public interface comparator extends Comparator<Customer> {
    int compare(Customer c1, Customer c2);
}

class CompareNumber implements comparator {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.getNumber(), c2.getNumber());
    }
}

class CompareName implements comparator {
    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.getName().compareTo(c2.getName());
    }
}