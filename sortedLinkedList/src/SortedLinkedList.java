import java.util.NoSuchElementException;

public class SortedLinkedList {

    private Node first;

    public SortedLinkedList() {
        first = null;
    }

    public void addElement(String element) {
        Node newNode = new Node();
        newNode.data = element;

        if (first == null || element.compareToIgnoreCase(first.data) < 0) {
            newNode.next = first;
            first = newNode;
        }
        else {
            Node current = first, before = null;
            while (current.next != null && element.compareToIgnoreCase(current.data) > 0) {
                before = current;
                current = current.next;
            }
            if (element.compareToIgnoreCase(current.data) < 0) {
                newNode.next = current;
                before.next = newNode;
            }
            else {
                current.next = newNode;
            }
        }
    }

    public boolean removeElement(String element) {
        if (first == null) throw new NoSuchElementException();

        if (first.data == element) {
            if (first.next == null) {
                first = null;
                return true;
            }
            else {
                first = first.next;
                return true;
            }
        }
        Node current = first, before = null;
        while (current.next != null && current.data != element) {
            before = current;
            current = current.next;
        }
        if (current.data == element) {
            before.next = current.next;
            return true;
        }
        return false;
    }

    public int countElements() {
        if (first == null) throw new NoSuchElementException();
        int sum = 1;
        Node current = first;
        while (current.next != null) {
            sum++;
            current = current.next;
        }
        return sum;
    }

    @Override
    public String toString() {
        if (first == null) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        Node current = first;

        sb.append("List[");

        while (current != null) {
            sb.append(current.data + ", ");
            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }

    class Node {
        public String data;
        public Node next;
    }
}