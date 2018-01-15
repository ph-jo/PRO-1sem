import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

    public static void main(String[] args) {
        Person jonathanNavn = new Person(new Navn("Jonathan", "Birch"));
        Person mikkelNavn = new Person(new Navn("Mikkel", "Holmgaard"));
        Person andersNavn = new Person(new Navn("Anders", "Jørgensen"));

        Person jonathanString = new Person("Jonathan Birch");
        Person mikkelString = new Person("Mikkel Holmgaard");
        Person andersString = new Person("Anders Jørgensen");
        Person pederString = new Person("Peder");

        ArrayList<Person<Navn>> personliste = new ArrayList<>();
        personliste.add(jonathanNavn);
        personliste.add(mikkelNavn);
        personliste.add(andersNavn);

        ArrayList<Person> personliste2 = new ArrayList<>();
        personliste2.add(jonathanString);
        personliste2.add(mikkelString);
        personliste2.add(andersString);
        personliste2.add(pederString);


        System.out.println("Unsorted list of persons with the name class:");
        for (Person person : personliste) {
            System.out.println(person);
        }
        System.out.println("\nSorted list of persons with the name class:");
        Collections.sort(personliste);
        for (Person person : personliste) {
            System.out.println(person);
        }
        System.out.println("\nUnsorted list of persons without the name class:");
        for (Person person : personliste2) {
            System.out.println(person);
        }
        Collections.sort(personliste2);
        System.out.println("\nSorted list of persons without the name class:");
        for (Person person : personliste2) {
            System.out.println(person);
        }
    }
}