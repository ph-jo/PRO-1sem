import java.util.NoSuchElementException;

public class QueueLinkedList implements IQueue {

    private Node first;

    public QueueLinkedList() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(Object newElement) {
        Node newNode = new Node();
        newNode.data = newElement;
        if (first == null) {
            first = newNode;
        }
        else {
            Node currentPosition = first;
            while (currentPosition.next != null) {
                currentPosition = currentPosition.next;
            }
            currentPosition.next = newNode;
        }
    }

    @Override
    public Object dequeue() {
        if (first == null) throw new NoSuchElementException();
        Object toBeRemoved = first.data;
        first = first.next;
        return toBeRemoved;
    }

    @Override
    public Object getFront() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    @Override
    public int size() {
        if (first == null) return 0;
        int sum = 0;
        Node currentPosition = first;
        while (currentPosition != null) {
            currentPosition = currentPosition.next;
            sum++;
        }
        return sum;
    }

    class Node {
        public Object data;
        public Node next;
    }
}
