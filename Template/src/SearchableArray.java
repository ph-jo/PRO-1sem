public class SearchableArray<E extends Comparable<E>> extends SearchPattern<E> {

    private E[] list;
    private int i;

    public SearchableArray(E[] list) {
        this.list = list;
    }

    @Override
    protected void init() {
        i = 0;
    }

    @Override
    protected boolean isEmpty() {
        return i > list.length - 1;
    }

    @Override
    protected E select() {
        return list[i];
    }

    @Override
    protected void split(E m) {
        i++;
    }
}
