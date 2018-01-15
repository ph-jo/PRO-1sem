import java.util.NoSuchElementException;

public class DropOutStackLinkedList implements IStack {

    private Node first;
    private final static int MAXIMUM_SIE = 6;
    private int currentSize;

    public DropOutStackLinkedList() {
        this.first = null;
        this.currentSize = 0;
    }

    @Override
    public void push(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        if (currentSize== MAXIMUM_SIE) {
            pop();
        }
        newNode.next = first;
        first = newNode;
        currentSize++;
    }

    @Override
    public Object pop() {
        if (first == null) throw new NoSuchElementException();
        Object poppedElement = first.data;
        first = first.next;
        currentSize--;
        return poppedElement;
    }

    @Override
    public Object peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    class Node {
        public Object data;
        public Node next;
    }
}
