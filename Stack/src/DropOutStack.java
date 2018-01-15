public class DropOutStack implements IStack {

    private final static int INITIAL_SIZE = 6;
    private Object[] dStack;
    private int currentSize;

    public DropOutStack() {
        this.dStack = new Object[INITIAL_SIZE];
        this.currentSize = 0;
    }

    @Override
    public void push(Object element) {
        if (currentSize == dStack.length) {
            for (int i = 0; i < dStack.length-1; i++) {
                dStack[i] = dStack[i+1];
            }
            currentSize--;
        }
        dStack[currentSize] = element;
        currentSize++;
    }

    @Override
    public Object pop() {
        Object poppedElement = dStack[currentSize-1];
        dStack[currentSize-1] = null;
        currentSize--;
        return poppedElement;
    }

    @Override
    public Object peek() {
        return dStack[currentSize-1];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
