public class Stack implements IStack{

    private Queue elementsOne;
    private Queue elementsTwo;

    public Stack() {
        this.elementsOne = new Queue();
        this.elementsTwo = new Queue();
    }

    @Override
    public void push(Object element) {
        elementsTwo.enqueue(element);
        while (!elementsOne.isEmpty()) {
            elementsTwo.enqueue(elementsOne.getFront());
            elementsOne.dequeue();
        }
        Queue q = elementsOne;
        elementsOne = elementsTwo;
        elementsTwo = q;
    }

    @Override
    public Object pop() {
        return elementsOne.dequeue();
    }

    @Override
    public Object peek() {
        return elementsOne.getFront();
    }

    @Override
    public boolean isEmpty() {
        return elementsOne.isEmpty();
    }
}
