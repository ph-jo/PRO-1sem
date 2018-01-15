/**
 * Created by Jonathan on 08-01-2018.
 */
public class DictionaryHashMapDemo {

    public static void main(String[] args) {
        DictionaryHashMap dictionary = new DictionaryHashMap();
        System.out.println("Er dictionary tomt: " + dictionary.isEmpty() +
                " | Antal elementer i dictionary: " + dictionary.size());
        dictionary.put(1, "Jonathan");
        System.out.println(dictionary.get(1));
        dictionary.put(2, "Jemila");
        System.out.println(dictionary.get(2));
        dictionary.put(3, "Søren");
        dictionary.put(4, "Lars");
        dictionary.put(5, "Mikkel");
        dictionary.put(6, "Triggered");
        dictionary.put(7, "Peder");
        dictionary.put(1001, "Eksamen");
        dictionary.put(8301, "KomNuOver02");
        System.out.println(dictionary);
        System.out.println("Er dictionary tomt: " + dictionary.isEmpty() +
                " | Antal elementer i dictionary: " + dictionary.size());
    }
}
