import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 08-01-2018.
 */
public class DictionaryArrayArrayList implements Dictionary {

    private List<Node>[] tabel;
    private int N = 10;

    public DictionaryArrayArrayList() {
        tabel = new List[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new ArrayList<>();
        }
    }

    @Override
    public Object get(Object key) {
        int i = key.hashCode() % N;
        List<Node> tempList = tabel[i];

        for (Node node : tempList) {
            if (node.key.equals(key)) return node;
        }
        return null;
    }

    public Object getValue(Object key) {
        Node newNode = (Node) get(key);
        return newNode.value;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < N; i++) {
            return tabel[i].isEmpty();
        }
        return true;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        int i = key.hashCode() % N;
        List<Node> tempList = tabel[i];

        Node newNode;

        if (get(key) != null) {
            newNode = (Node) get(key);
            Object oldValue = newNode.value;
            newNode.value = value;
            return oldValue;
        }
        newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        tempList.add(newNode);
        return null;
    }

    @Override
    public Object remove(Object key) {
        int i = key.hashCode() % N;
        List<Node> tempList = tabel[i];

        Node removedObject = (Node) get(key);
        if (removedObject != null) {
            Object removedvalue = removedObject.value;
            tempList.remove(removedObject);
            return removedvalue;
        }
        return null;
    }

    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += tabel[i].size();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("Tabel[" + i + "]{");
            for (Node n : tabel[i]) {
                sb.append(" " + n.value + ",");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }

    private class Node {
        public Object key;
        public Object value;
    }
}