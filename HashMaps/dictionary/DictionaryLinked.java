public class DictionaryLinked implements Dictionary {
    private Node start;
    private int size;

    private class Node {
        Node next;
        Object key;
        Object value;
    }

    public DictionaryLinked() {
        // Sentinel (tomt listehoved, der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public Object get(Object key) {
        Node temp = start;
        while (temp.next != null && temp.key != key) {
            temp = temp.next;
        }
        if (temp.key == key) return temp.value;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        Node temp = start;
        while (temp.next != null && temp.key != key) {
            temp = temp.next;
        }

        if (temp.key == key) {
            Object oldValue = temp.value;
            temp.value = value;
            return oldValue;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        temp.next = newNode;
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        Node temp = null;
        Node after = start;
        while (after.next != null && after.key != key) {
            temp = after;
            after = after.next;
        }
        if (after.key == key) {
            Object removedValue = after.value;
            temp.next = after.next;
            size--;
            return removedValue;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
