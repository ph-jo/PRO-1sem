import java.util.HashSet;

public class MainApp {

    public static void main(String[] args) {
        HashSet<Bil> bilSet = new HashSet<>();
        bilSet.add(new Bil(123456789, "Toyota", "2", "Grøn"));
        bilSet.add(new Bil(12345678, "Mercedes", "Benz", "Sort"));
        bilSet.add(new Bil(12345, "Toyota", "Corolla", "Blå"));
        bilSet.add(new Bil(123456789, "Toyota", "2", "Grøn"));
        bilSet.add(new Bil(12345678, "Mercedes", "Benz", "Sort"));
        bilSet.add(new Bil(12345678, "Mercedes", "Benz", "Sort"));
        bilSet.add(new Bil(12345, "Toyota", "Corolla", "Blå"));

        for (Bil b : bilSet) {
            System.out.println(b);
        }
    }

}
