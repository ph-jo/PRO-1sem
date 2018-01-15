import java.util.Arrays;

public class SearchableArrayBin<E extends Comparable<E>> extends SearchPattern<E> {

    private E[] list;
    private int left;
    private int right;
    private int middle;

    public SearchableArrayBin(E[] list) {
        this.list = list;
    }

    @Override
    protected void init() {
        Arrays.sort(list);
        left = 0;
        right = list.length-1;
        middle = -1;
    }

    @Override
    protected boolean isEmpty() {
        return !(left <= right);
    }

    @Override
    protected E select() {
        middle = (left + right) / 2;
        return list[middle];
    }

    @Override
    protected void split(E m) {
        if (select().compareTo(m) > 0) {
            right = middle - 1;
        }
        else {
            left = middle + 1;
        }
    }
}
