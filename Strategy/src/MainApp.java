import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Jonathan", 1);
        Customer customer2 = new Customer("Mikkel", 2);
        Customer customer3 = new Customer("Lars", 3);
        Customer customer4 = new Customer("Søren", 4);
        Customer customer5 = new Customer("Peter", 5);
        Customer customer6 = new Customer("Niklas", 6);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);

        for (Customer c : customers) {
            System.out.println(c);
        }

        customers.sort(new CompareName());
        System.out.println();
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
