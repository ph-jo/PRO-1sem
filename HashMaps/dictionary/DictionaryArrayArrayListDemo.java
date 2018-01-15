import java.util.Arrays;

/**
 * Created by Jonathan on 08-01-2018.
 */
public class DictionaryArrayArrayListDemo {

    public static void main(String[] args) {
        DictionaryArrayArrayList dictionary = new DictionaryArrayArrayList();
        dictionary.put(100, "Jonathan");
        dictionary.put(200, "Lars");
        System.out.println(dictionary.getValue(100));
        System.out.println(dictionary.getValue(200));
        System.out.println(dictionary);
        dictionary.put(103, "Jemila");
        dictionary.put(102, "Søren");
        dictionary.put(11, "Torben");
        dictionary.put(188, "Jonas");
        dictionary.put(1337, "Henrik");
        dictionary.put(1104, "Asbjørn");
        dictionary.put(4, "Jep");
        System.out.println(dictionary);
        dictionary.put(4, "Jesper");
        System.out.println(dictionary);
        System.out.println(dictionary.size());
        System.out.println(dictionary.remove(4));
        System.out.println(dictionary.remove(1337));
        System.out.println(dictionary.size());
        System.out.println(dictionary);
    }
}
