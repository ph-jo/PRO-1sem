import java.util.ArrayList;

public class MainDictionary<K, V> implements Dictionary<K, V> {

    private ArrayList<Pair> bucket;

    public MainDictionary() {
        this.bucket = new ArrayList<>();
    }

    @Override
    public V get(K key) {
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return (V) pair.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return bucket.size() == 0;
    }

    @Override
    public V put(K key, V value) {
        boolean found = false;
        Pair tempPair = null;
        V valueInserted = null;
        Pair newPair = new Pair(key, value);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                valueInserted = (V) pair.value;
                tempPair = pair;
                found = true;
            }
        }

        if (found) {
            tempPair.value = value;
        }
        else {
            bucket.add(newPair);
        }
        return valueInserted;
    }

    @Override
    public V remove(K key) {
        V valueRemoved = null;
        for (Pair pair : bucket) {
            if (pair.key == key) {
                valueRemoved = (V) pair.value;
                bucket.remove(pair);
                break;
            }
        }
        return valueRemoved;
    }

    @Override
    public int size() {
        int size = 0;
        for (Pair pair : bucket) {
            if (pair.key != null) {
                size++;
            }
        }
        return size;
    }

    class Pair<T,S> {
        private T key;
        private S value;

        public Pair(T first, S second) {
            this.key = first;
            this.value = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
