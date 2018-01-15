public interface IStack {

    /*** Adds an element to the top of the stack*/
    public void push(Object element);

    /*** Removes the element from the top of the stack*/
    public Object pop();

    /*** Looks at the object at the top of this stack without removing it*/
    public Object peek();

    /*** Tests if this stack is empty.*/
    public boolean isEmpty();

}