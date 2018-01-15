public class Queue implements IQueue {

    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;
    private final static int INITIAL_SIZE = 6;

    public Queue() {
        this.elements = new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public void enqueue(Object element) {
        growIfNecessary();
        elements[tail] = element;
        tail++;
        currentSize++;
    }

    @Override
    public Object dequeue() {
        Object removedElement = elements[head];
        for (int i = 1; i < elements.length-1; i++) {
            elements[i-1] = elements[i];
        }
        currentSize--;
        tail--;
        return removedElement;
    }

    @Override
    public Object getFront() {
        return elements[head];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Grows the element array if the current size equals the capacity.
     */
    public void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newObjectList = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newObjectList[i] = elements[head + i];
            }
            elements = newObjectList;
            head = 0;
            tail = currentSize;
        }
    }
}
