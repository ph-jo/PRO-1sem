public interface IDeque {

    public void addFirst(Object element);

    public void addLast(Object element);

    public Object removeFirst();

    public Object removeLast();

    public Object getFirst();

    public Object getLast();

    public int size();

    public boolean isEmpty();

}