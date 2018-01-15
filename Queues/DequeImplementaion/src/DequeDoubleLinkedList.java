import java.util.LinkedList;

public class DequeDoubleLinkedList implements IDeque {

    LinkedList<Object> elements;

    public DequeDoubleLinkedList() {
        this.elements = new LinkedList<>();
    }

    @Override
    public void addFirst(Object element) {
        elements.addFirst(element);
    }

    @Override
    public void addLast(Object element) {
        elements.addLast(element);
    }

    @Override
    public Object removeFirst() {
        return elements.removeFirst();
    }

    @Override
    public Object removeLast() {
        return elements.removeLast();
    }

    @Override
    public Object getFirst() {
        return elements.getFirst();
    }

    @Override
    public Object getLast() {
        return elements.getLast();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
