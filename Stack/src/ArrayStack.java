public class ArrayStack implements IStack {

    private Object[] stack;
    private final static int ARRAY_SIZE = 6;
    private int currentsize;

    public ArrayStack() {
        this.stack = new Object[ARRAY_SIZE];
        this.currentsize = 0;
    }

    @Override
    public void push(Object element) {
        growIfNecessary();
        stack[currentsize] = element;
        currentsize++;
    }

    @Override
    public Object pop() {
        Object poppedElement = stack[currentsize-1];
        stack[currentsize-1] = null;
        currentsize--;
        return poppedElement;
    }

    @Override
    public Object peek() {
        return stack[currentsize-1];
    }

    @Override
    public boolean isEmpty() {
        return currentsize == 0;
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
