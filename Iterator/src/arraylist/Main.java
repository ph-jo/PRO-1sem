package arraylist;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayedList<String> list = new ArrayedList<>();
        list.add("Banan");
        list.add("Æble");
        list.add("Tomat");
        list.add("Jordbær");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}