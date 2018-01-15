public class StackQueue implements IQueue {

    private Object[] stack;
    private final static int ARRAY_SIZE = 6;
    private int currentsize;

    public StackQueue() {
        this.stack = new Object[ARRAY_SIZE];
        this.currentsize = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentsize == 0;
    }

    @Override
    public void enqueue(Object newElement) {
        growIfNecessary();
        stack[currentsize] = newElement;
        currentsize++;
    }

    @Override
    public Object dequeue() {
        Object dequeuedElement = stack[0];
        for (int i = 1; i < stack.length; i++) {
            stack[i-1] = stack[i];
        }
        currentsize--;
        return dequeuedElement;
    }

    @Override
    public Object getFront() {
        return stack[0];
    }

    @Override
    public int size() {
        return currentsize;
    }

    private void growIfNecessary() {
        if (currentsize == stack.length) {
            Object[] newStack = new Object[stack.length*2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }
}
